package br.com.prova.marcos.model.entity;

/**
 * Classe que representa uma entidade cliente.
 * @author Marcos
 *
 */
public class Cliente {
	
	private Integer id = null;
	private Integer idTime = null;
	private String email = null;
	private String dataNascimento = null;
	private String nome = null;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the dataNascimento
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the idTime
	 */
	public Integer getIdTime() {
		return idTime;
	}
	/**
	 * @param idTime the idTime to set
	 */
	public void setIdTime(Integer idTime) {
		this.idTime = idTime;
	}

	
}
