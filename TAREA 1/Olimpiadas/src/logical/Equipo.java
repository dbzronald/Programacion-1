package logical;

import java.util.ArrayList;

public class Equipo {
	private String nombreTeam;
	private boolean colectivo;
	private int DepHombres;
	private int DepMujeres;
	private int cantMedOro;
	private int cantMedPlata;
	private int cantMedBronce;
	private ArrayList<Deportista> miDeportista;
	
	//Constructor generado.
	public Equipo() {
		super();
	}
	public Equipo(String nombreTeam, 
			 int cantMedOro, int cantMedPlata,
			int cantMedBronce) {
		super();
		this.nombreTeam = nombreTeam;
		this.colectivo = true;
		this.cantMedOro = cantMedOro;
		this.cantMedPlata = cantMedPlata;
		this.cantMedBronce = cantMedBronce;
		this.miDeportista = new ArrayList<Deportista>();
	}
	
	//Gets and Sets generados.
	
	public String getNombreTeam() {
		return nombreTeam;
	}
	public String setNombreTeam(String nombreTeam) {
		return this.nombreTeam = nombreTeam;
	}
	public boolean isColectivo() {
		return colectivo;
	}
	public void setColectivo(boolean colectivo) {
		this.colectivo = colectivo;
	}
	public int getDepHombres() {
		return DepHombres;
	}
	public void setDepHombres(int depHombres) {
		DepHombres = depHombres;
	}
	public int getDepMujeres() {
		return DepMujeres;
	}
	public void setDepMujeres(int depMujeres) {
		DepMujeres = depMujeres;
	}
	public int getCantMedOro() {
		return cantMedOro;
	}
	public void setCantMedOro(int cantMedOro) {
		this.cantMedOro = cantMedOro;
	}
	public int getCantMedPlata() {
		return cantMedPlata;
	}
	public void setCantMedPlata(int cantMedPlata) {
		this.cantMedPlata = cantMedPlata;
	}
	public int getCantMedBronce() {
		return cantMedBronce;
	}
	public void setCantMedBronce(int cantMedBronce) {
		this.cantMedBronce = cantMedBronce;
	}
	public ArrayList<Deportista> getMiDeportista() {
		return miDeportista;
	}
	public void setMiDeportista(ArrayList<Deportista> miDeportista) {
		this.miDeportista = miDeportista;
	}
	
	//Metodos.
	
	public int cantDeportistas(){
		return this.DepHombres + this.DepMujeres;
	}
	
	public int totalMedallasEquipo(){
		return this.cantMedBronce + this.cantMedOro + this.cantMedPlata;
	}
	public float MayorEstaturaDadoUnValor(float valorEstatura){
		int cont=0;
		for (Deportista aux : miDeportista) {
			if(aux.getEstatura() > valorEstatura)
				cont++;
		}
		return (int)cont;
	}
	
}
