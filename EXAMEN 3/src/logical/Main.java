package logical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Main {
	
	private static File fLig = new File("./Liga.dat");
	private static File fEquip = new File("./Equipos.txt");
	
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		

		Jugador jug = new Jugador();
		jug.setNombre("Cristiano");
		jug.setNumero(7);
		jug.setPeso(75);
		jug.setEstatura(175);
		jug.setPosicion('D');
		ArrayList<Jugador> arrJug = new ArrayList<Jugador>();
		arrJug.add(jug);
		Equipo equip = new Equipo(1,1996,"Real Madrid",arrJug);

		Liga.getLiga().listaEquipos.add(equip);
		
		ObjectOutputStream ob = null;

	       if(!fLig.exists()){
	         FileOutputStream fo = new FileOutputStream(fLig);
	         ob = new ObjectOutputStream(fo);
	       }else{
	         ob = new AppendableObjectOutputStream(new FileOutputStream(fLig,true));
	       }
		ob.writeObject(Liga.getLiga());
		
		FileInputStream f = new FileInputStream(fLig);
		ObjectInputStream obi = new ObjectInputStream(f);
		Liga ligfut;
		ligfut = (Liga) obi.readObject();
		int cant = ligfut.listaEquipos.get(0).getListaJugadores().size();
		
		int numero = ligfut.listaEquipos.get(0).getListaJugadores().get(0).getNumero();
		int estat = ligfut.listaEquipos.get(0).getListaJugadores().get(0).getEstatura();
		int peso = ligfut.listaEquipos.get(0).getListaJugadores().get(0).getPeso();
		String nombreEq = ligfut.listaEquipos.get(0).getNombre();
		char pos = ligfut.listaEquipos.get(0).getListaJugadores().get(0).getPosicion();
		int anio = ligfut.listaEquipos.get(0).getAnFund();
		String nombreJ =ligfut.listaEquipos.get(0).getListaJugadores().get(0).getNombre();
		
		String equips = "Equipo: "+nombreEq+". Cantidad de jugadores : "+ String.valueOf(cant)+"\n";
		String jugs = String.valueOf(nombreJ)+": Numero "+String.valueOf(numero)+", juega en la posicion "+pos+".  mide "+String.valueOf(estat)+" cm, pesa:"+String.valueOf(peso)+" kg.";
		FileWriter wr;
		wr = new FileWriter(fEquip);
		
		for(int l =0; l<equips.length(); l++){
			wr.write(equips.charAt(l));
		}
		
		for (int i=0; i<jugs.length(); i++)
        wr.write(jugs.charAt(i));
		
		
		
		wr.close();
		
		
	}
	
	 private static class AppendableObjectOutputStream extends ObjectOutputStream {
	        public AppendableObjectOutputStream(OutputStream out) throws IOException {
	          super(out);
	        }

	        @Override
	        protected void writeStreamHeader() throws IOException {}
	  }
	
}
