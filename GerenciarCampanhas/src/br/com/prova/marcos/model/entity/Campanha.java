package br.com.prova.marcos.model.entity;

/**
 * Classe que repesenta uma entidade campanha.
 * @author Marcos
 *
 */
public class Campanha {
	
	private String nome;
	private Integer id;
	private Integer idTime;
	private String iniVigencia;
	private String fimVigencia;
	
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
	 * @return the iniVigencia
	 */
	public String getIniVigencia() {
		return iniVigencia;
	}
	/**
	 * @param iniVigencia the iniVigencia to set
	 */
	public void setIniVigencia(String iniVigencia) {
		this.iniVigencia = iniVigencia;
	}
	/**
	 * @return the fimVigencia
	 */
	public String getFimVigencia() {
		return fimVigencia;
	}
	/**
	 * @param fimVigencia the fimVigencia to set
	 */
	public void setFimVigencia(String fimVigencia) {
		this.fimVigencia = fimVigencia;
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
