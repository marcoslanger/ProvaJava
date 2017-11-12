package br.com.prova.marcos.iterfaces;
/**
 * 
 * @author Marcos
 * 
 * interface padrão para a Stream de entrada.
 *
 */
public interface Stream {

	/**
	 * 
	 * @return char seguinte na sequencia.
	 */
	public char getNext();

	/**
	 * 
	 * @return teste se existe proximo char no fluxo da stream.
	 */
	public boolean hasNext();

	/**
	 * 
	 * @return retorna stream de entrada.
	 */
	public String getInput();

	/**
	 * 
	 * @return retorna posição do char dentro do fluxo.
	 */
	public int getPos();

}
