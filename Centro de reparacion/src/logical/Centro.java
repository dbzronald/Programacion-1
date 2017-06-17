package logical;

import java.util.ArrayList;

public class Centro {
	
	private ArrayList<Trabajador> misTrabajadores;
	private ArrayList<Nomina> misNominas;
	
	public Centro() {
		super();
		this.misTrabajadores = new ArrayList<Trabajador>();
		this.misNominas = new ArrayList<Nomina>();
	}
	public ArrayList<Trabajador> getMisTrabajadores() {
		return misTrabajadores;
	}
	public void setMisTrabajadores(ArrayList<Trabajador> misTrabajadores) {
		this.misTrabajadores = misTrabajadores;
	}
	public ArrayList<Nomina> getMisNominas() {
		return misNominas;
	}
	public void setMisNominas(ArrayList<Nomina> misNominas) {
		this.misNominas = misNominas;
	}





}
