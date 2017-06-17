package logical;

import java.io.Serializable;
import java.util.ArrayList;

public class Liga implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Equipo> listaEquipos;
	private static Liga miLiga;
	
	
	public Liga() {
		super();
		this.listaEquipos = new ArrayList<Equipo>();
	}
	
	public static Liga getLiga()
	{
		if(miLiga == null){
			miLiga = new Liga();
		}
		
		return miLiga;
	}
}
