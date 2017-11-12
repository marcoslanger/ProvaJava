package br.com.prova.marcos.impl;
import br.com.prova.marcos.iterfaces.Stream;

/**
 * Classe que implementa uma Stream.
 * 
 * @author Marcos
 *
 */
public class StreamImpl implements Stream {

	private String input = null;
	private int pos = 0;

	/**
	 * @return the pos
	 */
	public int getPos() {
		return pos;
	}

	/**
	 * Construtor, recebe uma String a ser avaliada.
	 * @param input string a ser a valiada.
	 */
	public StreamImpl(String input) {
		this.input = input;
	}

	
	@Override
	/**
	 * 
	 * @return char seguinte na sequencia.
	 */
	public char getNext() {
		return input.charAt(pos++);
	}

	@Override
	/**
	 * 
	 * @return teste se existe proximo char no fluxo da stream.
	 */
	public boolean hasNext() {
		String end = input.substring(pos, input.length());

		if (end.length() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}

}
