package br.com.prova.marcos.model.help;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import br.com.prova.marcos.model.entity.Campanha;

/*
 * Classe utilitária para as saidas JSON.
 */
public class JSONUtils {

	@SuppressWarnings("unchecked")
	/**
	 * Rentorna uma lista de camapanhas em no formato JSON.
	 * @param camp lista de emtidades camapanha com dados.
	 * @return lista de objetos JSON com campanhas.
	 */
	public static final List<JSONObject> campanhaToJSON(List<Campanha> camp) {

		List<JSONObject> listaJson = new ArrayList<JSONObject>();

		for (Campanha campanha : camp) {
			// Cria um Objeto JSON
			JSONObject jsonObject = new JSONObject();
			// Armazena dados em um Objeto JSON
			jsonObject.put("nome", campanha.getNome());
			jsonObject.put("id", campanha.getId());
			jsonObject.put("iniVigencia", campanha.getIniVigencia());
			jsonObject.put("fimVigencia", campanha.getFimVigencia());
			jsonObject.put("idTime", campanha.getIdTime());
			listaJson.add(jsonObject);
		}

		return listaJson;
	}

}
