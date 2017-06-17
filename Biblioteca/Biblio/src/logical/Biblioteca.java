package logical;

import java.util.ArrayList;
import java.util.Date;
public class Biblioteca {
	
	private ArrayList <Publicacion> misPublicaciones;
	private ArrayList <Cliente> misClientes;
	private static int idPrestamo;
	
	public Biblioteca(ArrayList<Publicacion> misPublicaciones,
			ArrayList<Cliente> misClientes) {
		super();
		this.misPublicaciones = misPublicaciones;
		this.misClientes = misClientes;
	}
	public void InsertarLibro(Libro libro){
		misPublicaciones.add(libro);
	}
	public String getTituloDadoId(String id){
		String titulo = "";
		for (Publicacion aux : misPublicaciones) {
			if(aux.getCodigo().equalsIgnoreCase(id)){
				titulo = aux.getTitulo();
			}
		}
		return titulo;
	}
	public int getCantdePublicDadoMateria(String materia){
		int cant = 0;
		for (Publicacion aux : misPublicaciones) {
			if(aux.getMateria().equalsIgnoreCase(materia)){
				cant++;
			}
		}
		return cant;
	}
	public Publicacion buscarPublicDadoId(String id){
		Publicacion encontrado = null;
		for (Publicacion aux : misPublicaciones) {
			if(aux.getCodigo().equalsIgnoreCase(id)){
				encontrado = aux;
			}
		}
		return encontrado;
	}
	public Cliente buscarClientDadoId(String id){
		Cliente encontrado = null;
		for (Cliente aux : misClientes) {
			if(aux.getId().equalsIgnoreCase(id)&&aux.getPrestamos().size()!=5){
				encontrado = aux;
			}
		}
		return encontrado;
	}
	
	public boolean hacerPrestamos(String idPublic, String idCliente, Date devol){
		boolean prestamos = false;
		Publicacion encontrado = buscarPublicDadoId(idPublic);
		Cliente cliente = buscarClientDadoId(idCliente);
		if(encontrado!=null && cliente!=null){
			Biblioteca.idPrestamo++;
			Prestamo nuevoPrestamo = new Prestamo(Biblioteca.idPrestamo, new Date(), devol,encontrado,0);
			if(cliente.getPrestamos().size()!=5){
				cliente.crearPrestamo(nuevoPrestamo);
				encontrado.decrementarEjemplar();
				prestamos = true;
			}
		
		}
		return prestamos;
		
	}
	public int cantRevistaDadoMateria(String materia, int anno){
		int cant =0;
		for (Publicacion aux : misPublicaciones) {
			if(aux instanceof Revista && aux.getMateria().equalsIgnoreCase(materia)){
				if(((Revista)aux).getAnno()>anno)
				cant++;
			}
			
		}
		return cant;
		
	}
}
