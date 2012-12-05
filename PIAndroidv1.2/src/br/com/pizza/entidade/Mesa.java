package br.com.pizza.entidade;

public class Mesa {
	private Integer id;
	private int numMesa;
	
	public Mesa() {

	}
	
	public Mesa(Integer id, int numMesa) {
		this.id = id;
		this.numMesa = numMesa;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNumMesa() {
		return numMesa;
	}
	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}
	
	
}
