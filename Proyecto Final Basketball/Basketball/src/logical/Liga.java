package logical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;



public class Liga implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Equipo equipo;
	private ArrayList<Partido> partidos;
	private ArrayList<Equipo> equipos;
	private static Liga liga;
	
	public Liga() {
		super();
	this.partidos = new ArrayList<Partido>();
	this.equipos = new ArrayList<Equipo>();
	
	}
	
public static Liga getInstances(){
		
		if(liga == null){
			liga = new Liga();
		}
		
		return liga;
		
}
public static void setLiga(Liga miLiga){
	Liga.liga = miLiga;
}

public ArrayList<Partido> getPartidos() {
	return partidos;
}

public void setPartidos(ArrayList<Partido> partidos) {
	this.partidos = partidos;
}

public ArrayList<Equipo> getEquipos() {
	return equipos;
}

public void setEquipos(ArrayList<Equipo> equipos) {
	this.equipos = equipos;
}

public void InsertarEquipo(Equipo equipo){
	
	equipos.add(equipo);
}

public void BorrarEquipo(int nombre){
   
	
	for (int i = 0; i < getEquipos().size(); i++) {
	
		
			equipos.remove(nombre);
}
	
}

public void InsertarPartido(Partido partido){
	
	partidos.add(partido);
}

public void setPartido(int index, String date, String home, String away, String locacion, int puntosHome, int puntosAway, String tiempo, boolean jugados){
	partidos.set(index, new Partido(date, home, away, locacion, puntosHome, puntosAway, tiempo, jugados));
}


public int CantJugadores(){

int cant = 0;

for (Equipo aux : equipos) {
	for (int i = 0; i < aux.getJugadores().size(); i++) {
		
		cant++;
	} 
		
	}

  return cant;
}

public int CantEquipo()
{
	int cant=0;
	for(int i=0; i < equipos.size();i++)
	{
		cant++;
	}
	return cant;
}

public void loadLiga(Liga lig) {
	 try {
		    FileInputStream f = new FileInputStream("Datos.dat");
			ObjectInputStream ob = new ObjectInputStream(f);
			Liga li = (Liga)ob.readObject();
			Liga.setLiga(li);
			ob.close();
		 
		} catch (Exception e) {	
			e.printStackTrace();
		}
	
}
public void saveLiga(Liga lig){
 	 File f = new File("Datos.dat");
	 FileOutputStream fo = null;
	 ObjectOutputStream ob = null;
	try {
		 fo = new FileOutputStream(f);
		 ob = new  ObjectOutputStream (fo);
		 ob.writeObject(lig);
		 
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally{
		try{
			if(ob!= null){
				ob.close();
			}
				
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}


}
