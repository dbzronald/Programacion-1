package logical;

public class Vino {
private String nombre;
private int cosecha;
private String tipo;
private int disponibilidad;
private float[] ventas;
private Suministrador miSuministrador;

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getCosecha() {
	return cosecha;
}
public void setCosecha(int cosecha) {
	this.cosecha = cosecha;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public int getDisponibilidad() {
	return disponibilidad;
}
public void setDisponibilidad(int disponibilidad) {
	this.disponibilidad = disponibilidad;
}
public float[] getVentas() {
	return ventas;
}
public void setVentas(float[] ventas) {
	this.ventas = ventas;
}
public Suministrador getMiSuministrador() {
	return miSuministrador;
}
public void setMiSuministrador(Suministrador miSuministrador) {
	this.miSuministrador = miSuministrador;
}
public float promedio(int ini, int fin){
	int suma=0;
	for (int i = (ini-1); i < fin; i++) {
		suma+=ventas[i];
		
	}
	return suma/(fin-ini);
}
public boolean hacerOrden(){
	boolean orden = false;
	if(promedio(1,5) < promedio(6,10)&& miSuministrador.getTiempoEntrega() <=30){
		orden = true;
	}
	return orden;
}

	
}
