package logical;

import java.util.Date;

public class Prestamo {
	private int id;
	private Date solicitud;
	private Date devolucion;
	private Publicacion prestamo;
	private int prorroga;
	
	public Prestamo(int id, Date solicitud, Date devolucion,
			Publicacion prestamo, int prorroga) {
		super();
		this.id = id;
		this.solicitud = solicitud;
		this.devolucion = devolucion;
		this.prestamo = prestamo;
		this.prorroga = prorroga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Date solicitud) {
		this.solicitud = solicitud;
	}

	public Date getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(Date devolucion) {
		this.devolucion = devolucion;
	}

	public Publicacion getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Publicacion prestamo) {
		this.prestamo = prestamo;
	}

	public int getProrroga() {
		return prorroga;
	}

	public void setProrroga(int prorroga) {
		this.prorroga = prorroga;
	}
	
	
}
