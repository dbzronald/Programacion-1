package logical;

public class Revista extends Publicacion {
	private int numero;
	private int anno;
	
	public Revista(String codigo, String titulo, String materia,
			int cantEjemplares, boolean estado, int numero, int anno) {
		super(codigo, titulo, materia, cantEjemplares, estado);
		this.numero = numero;
		this.anno = anno;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}
	

}
