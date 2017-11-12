package br.com.prova.marcos.localizador;

import br.com.prova.marcos.impl.StreamImpl;
import br.com.prova.marcos.iterfaces.Stream;

/**
 * Classe com metodos para a localização de bogais unicas não repetidas,
 * antecedidas por uma consoante, posterior a uma vogal.
 * 
 * @author Marcos
 *
 */
public class LocalizarVogal {

	private static final String VOGAIS = "[aAeEiIoOuU]";

	private static final String MENSAGEM = "Nenhuma vogal encontrada dentro da sequencia de entrada que atenda as regras de negócio.";

	private static int beforePos = 2;

	private static int beforeBeforePos = 3;

	/**
	 * Metodo responsável por localizar uma vogal dentro de uma determinada string
	 * segundo a regra de negócio.
	 * 
	 * @param stream Stream de entrada com a String a ser pesquisada.
	 * @return char encontrado na string de entrada correspondente com a regra de
	 *         negócio.
	 */
	private static char firstChar(Stream stream) {

		Character currentChar;
		String input = stream.getInput();

		while (stream.hasNext()) {

			currentChar = new Character(stream.getNext());
			
			int count = input.replaceAll("[^" + currentChar.charValue()  + "]", "").length();

			if (currentChar.toString().matches(VOGAIS) && count == 1) {

				int beforeCharIndex = stream.getPos() - beforePos;
				int beforeBeforeCharIndex = stream.getPos() - beforeBeforePos;

				Character beforeChar = new Character(input.charAt(beforeCharIndex));
				Character beforeBeforeChar = new Character(input.charAt(beforeBeforeCharIndex));

				if (!beforeChar.toString().matches(VOGAIS) && beforeBeforeChar.toString().matches(VOGAIS)) {
					return currentChar.charValue();
				}
			}
		}

		return '0';
	}

	public static String localizar(String input) {

		Stream stream = new StreamImpl(input);
		char retorno = firstChar(stream);

		if (retorno == '0') {
			return MENSAGEM;
		}
		return String.valueOf(retorno);
	}

}
