package alquilerBarcos;

public class Main {

	public static void main(String[] args) {
		Alquiler alquiler = new Alquiler();
		Barco barco = new Barco();
		
		barco.setEslora((float) 10.36);
		alquiler.setNombre("Pedro");
		alquiler.setCedula("402-2264768-3");
		int Dias = alquiler.DiasEntre(20, 30);
		
		
		
		
		System.out.println(alquiler.getNombre());
		System.out.println(alquiler.obtenerAlquiler());
		System.out.println(Dias);
		System.out.println(barco.getEslora());
		System.out.println(barco.obtenerFactor());
	}

}
