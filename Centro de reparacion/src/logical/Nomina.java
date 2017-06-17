package logical;

public class Nomina {
private String codigotrabaj;
private double salarioMes;


public Nomina(String codigotrabaj, double salarioMes) {
	super();
	this.codigotrabaj = codigotrabaj;
	this.salarioMes = salarioMes;
}

public String getCodigotrabaj() {
	return codigotrabaj;
}
public void setCodigotrabaj(String codigotrabaj) {
	this.codigotrabaj = codigotrabaj;
}
public double getSalarioMes() {
	return salarioMes;
}
public void setSalarioMes(double salarioMes) {
	this.salarioMes = salarioMes;
}
}
