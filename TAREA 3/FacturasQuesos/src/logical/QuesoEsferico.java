package logical;

public class QuesoEsferico extends Quesos {
	
	public QuesoEsferico(int precioBase, int precioUnitario,float radio ,int id) {
		super(precioBase,precioUnitario,radio ,id);
	}
	
	
	public float Volumen() {
	return (float) Math.round((4/3 * Math.PI * Math.pow(getRadio(), 3)));
	
	}
	
}
