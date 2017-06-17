package logical;

import java.io.Serializable;
import java.util.ArrayList;


public class Factura implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Clientes clientes;
	private int id;
	private ArrayList<Quesos> ListaQuesos;
	private double montoTotal;
	private Quesos queso;

	
	public Factura(Clientes clientes, int idF){
		super();

		this.clientes = clientes;

	}
	public Clientes getClientes() {
		return clientes;
	}
	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Quesos> getListaQuesos() {
		return ListaQuesos;
	}

	public void setListaQuesos(ArrayList<Quesos> ListaQuesos) {
		this.ListaQuesos = ListaQuesos;
	}
	
	public  void addQueso(Quesos ques){
		this.ListaQuesos.add(ques);
	}
	
	public double getMonto() {
		return montoTotal;
	}


	public void setMonto(double montoTotal) {
		this.montoTotal = montoTotal;
	}


	public Quesos getQueso() {
		return queso;
	}


	public void setQueso(Quesos queso) {
		this.queso = queso;
	}

	public void addQues(Quesos queso){
		ListaQuesos.add(queso);
	}
	
}
