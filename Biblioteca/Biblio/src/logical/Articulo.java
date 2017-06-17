package logical;

public class Articulo extends Publicacion {
	private String arbitro;

public Articulo(String codigo, String titulo, String materia,
		int cantEjemplares, boolean estado, String arbitro) {
	super(codigo, titulo, materia, cantEjemplares, estado);
	this.arbitro = arbitro;
}

public String getArbitro() {
	return arbitro;
}

public void setArbitro(String arbitro) {
	this.arbitro = arbitro;
}

}
