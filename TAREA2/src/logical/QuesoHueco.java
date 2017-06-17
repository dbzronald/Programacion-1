package logical;

public class QuesoHueco extends Quesos {
	
	private float radioInterior;
	private float longitud;
	
	public QuesoHueco(int precioBase, int precioUnitario, float radioInterior, float radio, int id,float longitud) {
		super(precioBase, precioUnitario, radio, id);

		this.radioInterior = radioInterior;
		this.longitud = longitud;
	}

	public double getRadioInterior() {
		return radioInterior;
	}

	public void setRadioInterior(float radioInterior) {
		this.radioInterior = radioInterior;
	}
	
	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float Volumen(){
		
		if(radio>radioInterior){
			return (float) Math.round((Math.PI*longitud*(Math.pow(getRadio(), 2)- Math.pow(radioInterior, 2))));
			
		}
		else{
			return -1;
		}
	}
	
}
