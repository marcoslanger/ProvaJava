package br.com.prova.marcos.testes;

import java.util.List;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import br.com.prova.marcos.services.ClientesJSONService;

/**
 * Classe de testes para o serviço json de clientes.
 * @author Marcos
 *
 */
class ClienteTeste {

	@Test
	@SuppressWarnings("unchecked")
	/**
	 * testa a inclusão de um cliente.
	 */
	void testIncluirClienteJSON() {
		
		JSONObject cliente = new JSONObject();
		cliente.put("id", "2");	
		cliente.put("idTime", "1");
		cliente.put("nome", "Jorge Luiz Silva");			
		cliente.put("email", "jorge@gmail.com");			
		cliente.put("dataNascimento", "1980-07-22");			
	
		List<JSONObject> retorno = (List<JSONObject>)new ClientesJSONService().incluirClienteJSON(cliente);
		
		assert(retorno != null);
		
		for (JSONObject jsonObject : retorno) {
			System.out.println("Campanhas disponiveis: " + jsonObject.toString());
		}	
	}

}
