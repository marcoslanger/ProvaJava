package br.com.prova.marcos.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.prova.marcos.model.entity.Campanha;
import br.com.prova.marcos.model.help.DBUtils;

/**
 * Classe de persistencia para campanhas.
 * @author Marcos
 *
 */
public class CampanhaPersistence {

	private static final String queryCampanhaVigente = "select id, nome, ini_vigencia, fim_vigencia, id_time from prova.campanhas where fim_vigencia >= ?";

	private static final String insertCampanhaVigente = "insert into prova.campanhas values (?, ?, ?, ?, ?)";

	private static final String updateCampanhaVigente = "update prova.campanhas set fim_vigencia = ? where id = ?";

	private final List<Campanha> campanhasAlteradas = new ArrayList<Campanha>();

	
	/**
	 * Método responsável por retornar uma campanha.
	 * @return List com lista de campanhas encontradas no banco não vencidas.
	 */
	public List<Campanha> obterCampanhas() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Campanha campanha = null;
		List<Campanha> campanhas = null;		

		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			
			ps = DBUtils.getConexaoMySQL().prepareStatement(queryCampanhaVigente);
			ps.setString(1, sd.format(calendar.getTime()));
			rs = ps.executeQuery();
			campanhas = new ArrayList<Campanha>();

			while (rs.next()) {
				campanha = new Campanha();
				campanha.setId(new Integer(rs.getString(1)));				
				campanha.setNome(rs.getString(2));
				campanha.setIniVigencia(rs.getString(3));
				campanha.setFimVigencia(rs.getString(4));
				campanha.setIdTime(new Integer(rs.getString(5)));
				campanhas.add(campanha);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return campanhas;
	}

	
		
	/**
	 * Método responsável por incluir uma campanha.
	 * @param campanha a ser incluida.
	 * @return lista de campanhas com fim de vigencia ajustadas.
	 */
	public List<Campanha> incluirCampanha(Campanha campanha) {

		//ajusta o fim das vigencias das campanha para não haver conflitos.
		List<Campanha> campanhasAlteradas = ajustarVigencias(campanha.getId(), campanha.getFimVigencia());

		PreparedStatement ps = null;
	
		try {
			ps = DBUtils.getConexaoMySQL().prepareStatement(insertCampanhaVigente);
			ps.setInt(1, campanha.getId().intValue());
			ps.setString(2, campanha.getNome());
			ps.setString(3, campanha.getIniVigencia());
			ps.setString(4, campanha.getFimVigencia());
			ps.setInt(5, campanha.getIdTime().intValue());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return campanhasAlteradas;
	}

	/**
	 * Metodo responsável por alterar a vigencia de uma determinada campanha.
	 * @param id Integer com o id da campanha a ser alterada.
	 * @param fimVigencia novo fim d evigencia da campanha.
	 * @return Lista com as campanhas que tiveram suas vigencias ajustadas.
	 */
	public List<Campanha> alterarVigenciaCampanha(Integer id, String fimVigencia) {

		List<Campanha> campanhas = null;
		PreparedStatement ps = null;	

		try {
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(sd.parse(fimVigencia));
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			System.out.println(sd.format(calendar.getTime()));

			ps = DBUtils.getConexaoMySQL().prepareStatement(updateCampanhaVigente);
			ps.setString(1, sd.format(calendar.getTime()));
			ps.setInt(2, id.intValue());

			ps.executeUpdate();

			campanhas = ajustarVigencias(id, sd.format(calendar.getTime()));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		return campanhas;
	}

	/**
	 * Método responsável por controlar o ajuste das vigencias das campanha para não conflitar
	 * com a campanha que está sendo inclusa.
	 * @param id Integer com id da camapnha sendo inclusa
	 * @param fimVigencia String com o fim da vigencia da campanha sendo inclusa.
	 * @return
	 */
	public List<Campanha> ajustarVigencias(Integer id, String fimVigencia) {

		List<Campanha> campanhas = obterCampanhas();

		if (campanhas.size() > 0) {
			for (Campanha campanha : campanhas) {
				if (Integer.valueOf(campanha.getId()).intValue() != id.intValue()
						&& campanha.getFimVigencia().compareTo(fimVigencia) == 0) {
					alterarVigenciaCampanha(campanha.getId(), campanha.getFimVigencia());

					campanhasAlteradas.add(campanha);
				}
			}
		}

		return campanhasAlteradas;
	}

}
