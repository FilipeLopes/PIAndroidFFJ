package br.com.pizza.entidade;

public class Sabor {
	private Integer id;
	private String sabor;
	private float preco;
	
	
	
	public Sabor() {
		
	}

	public Sabor(Integer id, String sabor, float preco) {
		this.id = id;
		this.sabor = sabor;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
}