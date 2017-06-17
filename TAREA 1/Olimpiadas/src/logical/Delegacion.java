package logical;

import java.util.ArrayList;

public class Delegacion {
	private ArrayList<Deportista> miDeportista;
	private ArrayList<Equipo> miEquipo;
	public static Delegacion deleg;
	private Equipo equip;
	int totalMedOlimPreced;
	
	//InstanceOf
	  public static Delegacion getInstance(){
		   if(deleg == null)
			   deleg = new Delegacion();
			 return deleg; 
		   
	   }
	
	//Constructor generado.
	
	private Delegacion() {
		super();
		this.miDeportista = new ArrayList<Deportista>();
		this.miEquipo = new ArrayList<Equipo>();
	}
	
	//Gets and Sets generado.
	
	public ArrayList<Deportista> getMiDeportista() {
		return miDeportista;
	}
	public void setMiDeportista(ArrayList<Deportista> miDeportista) {
		this.miDeportista = miDeportista;
	}
	public ArrayList<Equipo> getMiEquipo() {
		return miEquipo;
	}
	public void setMiEquipo(ArrayList<Equipo> miEquipo) {
		this.miEquipo = miEquipo;
	}

	
	public float totalPromMedEquipo(){
		return (equip.totalMedallasEquipo()/3);
	}
	public int getMedTotalMedEquip(){
		return equip.totalMedallasEquipo();
	}
	
	public int totalMedOlimpiada(){
		int total=0;
		for (Equipo aux : miEquipo) {
			total+= aux.totalMedallasEquipo();
		}
		return total;
	}
	public Equipo MayorEquipoMedOroColectivo(){
		Equipo mayorEquipo = miEquipo.get(0);
		for (Equipo aux : miEquipo) {
			if(aux.isColectivo()!=false && aux.getCantMedOro() > 0 && aux.getCantMedOro() > mayorEquipo.getCantMedOro()){
				mayorEquipo = aux;
			}
		}
		return mayorEquipo;
	}
	public boolean MedallasAtenas(){
		if(this.totalMedOlimpiada() > this.PromMedOlimPreced() ){
			return true;
		}
		else 
			return false;
	}
	public float PromMedOlimPreced(){
		return (totalMedOlimPreced/5);
	}
	public Equipo buscarNombreDeTeam(String nombre){
		Equipo encontrado = null;
		for (Equipo aux : miEquipo) {
			if(aux.getNombreTeam().equalsIgnoreCase(nombre) && aux.totalMedallasEquipo()>0){
				encontrado = aux;
			}
		}
		return encontrado;
	}
	public void deleteEquipo(Equipo selectDeleg) {
		miEquipo.remove(selectDeleg);
	}
	public void InsertarEquipo(Equipo equipo){
		miEquipo.add(equipo);
}
	public void InsertarDeportista(Deportista deportista){
		miDeportista.add(deportista);
}
	/*public void modificarEquipo(Equipo selectedToModify) {
		int pos = -1;
		Equipo borrar = null;
		for (Equipo aux : miEquipo) {
			if(aux.getNombreTeam().equalsIgnoreCase(selectedToModify.getNombreTeam()))
				borrar = aux;
		}
		miEquipo.remove(borrar);
		miEquipo.add(selectedToModify);
		
	}*/
}