package logical;

public class Main {

	public static void main(String[] args) {
		
		Bodega miBodega = new Bodega();
		Suministrador S1 = new Suministrador();
		S1.setNombre("Jose");
		S1.setPais("Espana");
		S1.setTiempoEntrega(21);
		
		Vino V1 = new Vino();
		V1.setCosecha(1920);
		V1.setDisponibilidad(5);
		V1.setNombre("VinoCaro");
		V1.setTipo("Tinto");
		V1.setMiSuministrador(S1);
		
		float ventas[] = new float[10];
		for (int i = 0; i < 10; i++) {
			ventas[i]= i+1000;	
		}
		V1.setVentas(ventas);
		
		miBodega.insertarVino(V1);
		miBodega.insertarmisSuminis(S1);
		
		
		System.out.println(miBodega.getCantVino());
		for (int i = 0; i < miBodega.getCantVino(); i++) {
			System.out.println(miBodega.getMisVinos()[i].getNombre());	
		}
		 
		boolean hacerPedido = miBodega.hacerOrden("VinoCaro");
		System.out.println(hacerPedido);
	}

}
