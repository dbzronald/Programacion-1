package logical;

import java.util.ArrayList;

public class Centro {
	
	private ArrayList<Productos> misProductos;

	public Centro() {
		super();
		this.misProductos = new ArrayList<Productos>();
	}

	public ArrayList<Productos> getMisProductos() {
		return misProductos;
	}

	public void setMisProductos(ArrayList<Productos> misProductos) {
		this.misProductos = misProductos;
	}

	public void ListaPrecios(){
		for (Productos aux : misProductos) {
			if(aux instanceof AltaGama){
			((AltaGama) aux).PrecioVentaAltaG();
			}
			if(aux instanceof Escasos){
			((Escasos) aux).PrecioVentaEsca();
			}
			else {
			aux.PrecioVenta();
			}
		}
	}
	public void ListaNombres(){
		for (Productos aux : misProductos) {
			if(aux instanceof AltaGama){
			((AltaGama) aux).getNombre();
			}
			if(aux instanceof Escasos){
			((Escasos) aux).getNombre();
			}
			else {
			aux.getNombre();
			}
		}
	}
	public int ContEscasos(){
		int cont=0;
		for (Productos prod : misProductos) {
			if(prod instanceof Escasos){
				cont++;
			}
		}
		return cont;
	}
	
	public void ProdMayorGanancia(){
		for (Productos pro : misProductos) {
			if(pro instanceof AltaGama){
				if(pro.cantExistencia > 1){
					if(((AltaGama) pro).PrecioVentaAltaG() > pro.PrecioVenta()){
						ListaNombres();
					}
				}
			}
			else if(((AltaGama) pro).PrecioVentaAltaG() > pro.PrecioVenta()){
				pro.getNombre();
			}
				
			
			if(pro instanceof Escasos){
				if(pro.cantExistencia > 1){
					if(((Escasos) pro).PrecioVentaEsca() > pro.PrecioVenta()){
						ListaNombres();
					}
				}
			}
			else if(((Escasos) pro).PrecioVentaEsca() > pro.PrecioVenta()){
				pro.getNombre();
			}
			if(pro.PrecioVenta() > ((Escasos) pro).PrecioVentaEsca() && pro.cantExistencia > 1 ){
				if(pro.PrecioVenta() > ((AltaGama) pro).PrecioVentaAltaG() && pro.cantExistencia > 1 ){
					ListaNombres();
			}
			else{
				pro.getNombre();
			}
		}
	}
}
}
