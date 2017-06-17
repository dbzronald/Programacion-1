package logical;

public class Bodega {
	
	private int cantVino=0;
	private int cantSuministradores;
	private Vino[] misVinos = new Vino[100];
	private Suministrador[] misSuminis = new Suministrador[100];
	
	public int getCantVino() {
		return cantVino;
	}
	public void setCantVino(int cantVino) {
		this.cantVino = cantVino;
	}
	public int getCantSuministradores() {
		return cantSuministradores;
	}
	public void setCantSuministradores(int cantSuministradores) {
		this.cantSuministradores = cantSuministradores;
	}
	public Vino[] getMisVinos() {
		return misVinos;
	}
	public void setMisVinos(Vino[] misVinos) {
		this.misVinos = misVinos;
	}
	public Suministrador[] getMisSuminis() {
		return misSuminis;
	}
	public void setMisSuminis(Suministrador[] misSuminis) {
		this.misSuminis = misSuminis;
	}
	public int buscarVino(String nombre){
		int encontrado = -1;
		for (int i = 0; i < cantVino; i++) {
			if(misVinos[i].getNombre().equalsIgnoreCase(nombre)){
				encontrado = 1;
			}
			
		}
		return encontrado;
	}
	public int buscarSuministrador(String nombre){
		int encontrado = -1;
		for (int i = 0; i < cantSuministradores; i++) {
			if(misSuminis[i].getNombre().equalsIgnoreCase(nombre)){
				encontrado = 1;
			}
			
		}
		return encontrado;
	}
	public boolean hacerOrden(String nombre){
		boolean hacer = false;
		int index = buscarVino(nombre);
		if(index != -1){
			hacer = true;
		}
		return hacer;
	}
	public void insertarmisSuminis(Suministrador s1) {
		if(buscarSuministrador(s1.getNombre()) != -1){
			misSuminis[cantSuministradores] = s1;		
		}
	
		
	}
	public void insertarVino(Vino v1) {
		misVinos[cantVino] = v1;
		cantVino++;	
	}
}
