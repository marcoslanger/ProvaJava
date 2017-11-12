package br.com.prova.marcos.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.json.simple.JSONObject;

import br.com.prova.marcos.model.entity.Campanha;
import br.com.prova.marcos.model.entity.Cliente;
import br.com.prova.marcos.model.help.JSONUtils;
import br.com.prova.marcos.model.persistence.ClientePersistence;

/**
 * Classe responsavel por gerenciar as entradas e saidas JSON de clientes.
 * @author Marcos
 *
 */
public class ClientesJSONService {
	
	/**
	 * Inclui um novo cliente.
	 * @param cliente a ser cadastrado.
	 * @return json lista de campanhas disponiveis caso o cliente seja novo.
	 */
	public List<JSONObject> incluirClienteJSON(JSONObject json) {		
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		Cliente cliente = null;
		List<JSONObject> jsonList = null;

		try {	
			cliente = new Cliente();
			cliente.setId(new Integer((String) json.get("id")));
			cliente.setNome((String) json.get("nome"));
			cliente.setEmail((String) json.get("email"));
			cliente.setDataNascimento(sdf.format(sdf.parse((String) json.get("dataNascimento"))));
			cliente.setIdTime(new Integer((String) json.get("idTime")));

		} catch (ParseException e) {		
			e.printStackTrace();
		}	
		
		List<Campanha> campanhas = new ClientePersistence().incluirCliente(cliente);
		
		if (campanhas != null) {
			jsonList = JSONUtils.campanhaToJSON(campanhas);
		}
		return jsonList;		
	}

}
