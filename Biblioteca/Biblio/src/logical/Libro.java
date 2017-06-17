package logical;

public class Libro extends Publicacion {
	private String autor;
	private String editorial;
	
	public Libro(String codigo, String titulo, String materia,
			int cantEjemplares, boolean estado, String autor, String editorial) {
		super(codigo, titulo, materia, cantEjemplares, estado);
		this.autor = autor;
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
}

