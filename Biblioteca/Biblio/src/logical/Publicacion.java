package logical;

public class Publicacion {
	protected String codigo;
	protected String titulo;
	protected String materia;
	protected int cantEjemplares;
	protected boolean estado;
	
	public Publicacion(String codigo, String titulo, String materia,
			int cantEjemplares, boolean estado) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.materia = materia;
		this.cantEjemplares = cantEjemplares;
		this.estado = true;
	}
	public Publicacion(){
		this.cantEjemplares = 0;
		this.estado = false;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public int getCantEjemplares() {
		return cantEjemplares;
	}
	public void setCantEjemplares(int cantEjemplares) {
		this.cantEjemplares = cantEjemplares;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public void decrementarEjemplar() {
		this.cantEjemplares--;
		if(cantEjemplares == 0){
		this.estado = false;
}
	}
	

}
