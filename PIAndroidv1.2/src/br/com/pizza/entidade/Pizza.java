package br.com.pizza.entidade;

public class Pizza {
	private Integer id;
	private Integer idBorda;
	private Integer idTamanho;
	private Integer idSabor;

	public Pizza() {
		
	}

	public Pizza(Integer id, Integer idBorda, Integer idTamanho, Integer idSabor) {
		super();
		this.id = id;
		this.idBorda = idBorda;
		this.idTamanho = idTamanho;
		this.idSabor = idSabor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdBorda() {
		return idBorda;
	}

	public void setIdBorda(Integer idBorda) {
		this.idBorda = idBorda;
	}

	public Integer getIdTamanho() {
		return idTamanho;
	}

	public void setIdTamanho(Integer idTamanho) {
		this.idTamanho = idTamanho;
	}

	public Integer getIdSabor() {
		return idSabor;
	}

	public void setIdSabor(Integer idSabor) {
		this.idSabor = idSabor;
	}
	
	
	
}