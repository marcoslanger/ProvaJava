package br.com.prova.marcos.model.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.prova.marcos.model.entity.Campanha;
import br.com.prova.marcos.model.entity.Cliente;
import br.com.prova.marcos.model.help.DBUtils;

/**
 * Classe de persistencia para clientes.
 * @author Marcos
 *
 */
public class ClientePersistence {

	private static final String queryFindByEmail = "Select id from prova.clientes where email = ?";
	private static final String insertCliente = "insert into prova.clientes values (?, ?, ?, ?, ?)";
	private static final String associarCampanhas = "update prova.clientes set id_time = ? where id = ?";

	/**
	 * Encontra um cliente pelo email.
	 * @param email
	 * @return true se o cliente ja está cadastrado e false caso seja novo.
	 */
	public boolean findByEmail(String email) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = DBUtils.getConexaoMySQL().prepareStatement(queryFindByEmail);
			ps.setString(1, email.trim());
			rs = ps.executeQuery();
			if (rs.next()) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * Inclui um novo cliente no banco.
	 * @param cliente a ser incluso.
	 * @return lista de campanhas disponiveis.
	 */
	public List<Campanha> incluirCliente(Cliente cliente) {

		List<Campanha> campanhasDisponiveis = null;

		PreparedStatement ps = null;

		try {

			if (findByEmail(cliente.getEmail())) {

				ps = DBUtils.getConexaoMySQL().prepareStatement(insertCliente);
				ps.setInt(1, cliente.getId().intValue());
				ps.setString(2, cliente.getNome());
				ps.setString(3, cliente.getEmail());
				ps.setString(4, cliente.getDataNascimento());
				ps.setInt(5, cliente.getIdTime().intValue());
				ps.executeUpdate();

				campanhasDisponiveis = new CampanhaPersistence().obterCampanhas();

			} else {
				associarCampanhas(cliente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return campanhasDisponiveis;
	}

	/**
	 * Associa um cliente novo a campanhas do seu time de coração.
	 * @param cliente a ser associado.
	 */
	public void associarCampanhas(Cliente cliente) {

		PreparedStatement ps = null;

		Connection conn = DBUtils.getConexaoMySQL();

		try {

			ps = conn.prepareStatement(associarCampanhas);
			ps.setInt(1, cliente.getIdTime().intValue());
			ps.setInt(2, cliente.getId().intValue());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
