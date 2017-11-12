package br.com.prova.marcos.testes;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import br.com.prova.marcos.model.entity.Campanha;
import br.com.prova.marcos.services.CampanhasJSONService;

/**
 * Classe responsável pelos testes dos metodos da classe view JSONCampanhas.
 * @author Marcos
 *
 */
class CampanhasTeste {

	/**
	 * Testa a consulta de uma determinada campanha.
	 */
	@Test	
	void testObterCampanhasJSON() {
		
		CampanhasJSONService json = new CampanhasJSONService();		
		assertNotNull(json.obterCampanhasJSON());			
	
		List<JSONObject> jsonlist = json.obterCampanhasJSON();	
		
		assert(jsonlist != null);
		
		for (JSONObject jsonObject : jsonlist) {
			System.out.println("Campanhas cadastradas: " + jsonObject.toString());
		}	
	}

	/**
	 * Teste a inclusão de uma nova campanha.
	 */
	@Test
	@SuppressWarnings("unchecked")
	void testIncluirCampanhaJSON() {
		CampanhasJSONService json = new CampanhasJSONService();
		JSONObject campanha = new JSONObject();
		campanha.put("id", "9");	
		campanha.put("idTime", "2");
		campanha.put("nome", "Campanha Gremio");			
		campanha.put("iniVigencia", "2017-10-27");			
		campanha.put("fimVigencia", "2017-11-27");			
	
		JSONObject retorno = json.incluirCampanhaJSON(campanha);
		
		assert(retorno != null);
		
		List<Campanha> camapanhasAlteradas = (List<Campanha>)retorno.get("retorno");
		
		for (Campanha campanhaAlterada : camapanhasAlteradas) {
			System.out.println("ID de campanha ajustada: " + campanhaAlterada.getId());
		}
		
		
	}

}
