package br.com.prova.marcos.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONObject;

import br.com.prova.marcos.model.entity.Campanha;
import br.com.prova.marcos.model.help.JSONUtils;
import br.com.prova.marcos.model.persistence.CampanhaPersistence;

/**
 * Classe responsavel por gerenciar as entradas e saidas JSON de campanhas.
 * @author Marcos
 *
 */
public class CampanhasJSONService {

	/**
	 * Efetua uma consulta na tabela de campanhas e
	 * Retorna um objeto json com uma lista de campanhas.
	 * @return json com uma lista de campanhas
	 */
	public List<JSONObject> obterCampanhasJSON() {
		
		return JSONUtils.campanhaToJSON(new CampanhaPersistence().obterCampanhas());

	}

	@SuppressWarnings("unchecked")
	/**
	 * Inclui uma nova campanha no banco de dados e retorna as campanhas que precisaram
	 * ter suas vigencia ajustadas.
	 * @param json objeto json com uma nova campanha a ser inclusa.
	 * @return lista de campanhas.
	 */
	public JSONObject incluirCampanhaJSON(JSONObject json) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Campanha campanha = null;		

		try {
			campanha = new Campanha();
			campanha.setId(new Integer((String) json.get("id")));
			campanha.setNome((String) json.get("nome"));
			campanha.setIniVigencia(sdf.format(sdf.parse((String) json.get("iniVigencia"))));
			campanha.setFimVigencia(sdf.format(sdf.parse((String) json.get("fimVigencia"))));
			campanha.setIdTime(new Integer((String) json.get("idTime")));

		} catch (ParseException e) {		
			e.printStackTrace();
		}
		
		JSONObject retonorJson = new JSONObject();
		retonorJson.put("retorno", new CampanhaPersistence().incluirCampanha(campanha));
		return retonorJson;

	}

}
