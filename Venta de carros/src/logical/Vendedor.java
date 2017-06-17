	package logical;
	
	public class Vendedor {
	private Vehiculo[] listaVehiculos;
	private Ventas[] listaVentas;
	private Sum[] listaSum;
	private int cantSum;
	private int cantVehiculos;
	private int cantVentas;
	
	public Vendedor()
	{
		super();
		this.listaSum = new Sum[50];
		this.cantSum = 0;
		this.listaVehiculos = new Vehiculo[50];
		this.cantVehiculos = 0;
		this.listaVentas = new Ventas[50];
		this.cantVentas = 0;
		
	}
	
	public Vehiculo[] getListaVehiculos() {
		return listaVehiculos;
	}
	public void setListaVehiculos(Vehiculo[] listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}
	public Ventas[] getListaVentas() {
		return listaVentas;
	}
	public void setListaVentas(Ventas[] listaVentas) {
		this.listaVentas = listaVentas;
	}
	public int getCantVehiculos() {
		return cantVehiculos;
	}
	public void setCantVehiculos(int cantVehiculos) {
		this.cantVehiculos = cantVehiculos;
	}
	public int getCantVentas() {
		return cantVentas;
	}
	public void setCantVentas(int cantVentas) {
		this.cantVentas = cantVentas;
	}
		
	public Sum[] getListaSum() {
		return listaSum;
	}

	public void setListaSum(Sum[] listaSum) {
		this.listaSum = listaSum;
	}

	public int getCantSum() {
		return cantSum;
	}

	public void setCantSum(int cantSum) {
		this.cantSum = cantSum;
	}


	public void registrarVehiculo(Vehiculo vehiculo) {
		this.listaVehiculos[cantVehiculos] = vehiculo;
		cantVehiculos++;
		
	}
	public void registrarSum(Sum suministrador){
		this.listaSum[cantSum] = suministrador;
		cantSum++;
	}
	public Sum findSum(String nomb){
		Sum sumi = null;
		for (int i = 0; i < cantSum; i++) {
			if(listaSum[i].getNombre().equalsIgnoreCase(nomb)){
				sumi = listaSum[i];
			}
		}
		
		return sumi;
		
	}
	
	
	public void registrarVentas(Ventas venta){
		this.listaVentas[cantVentas] = venta;
		cantVentas++;
	}
	
	public Vehiculo findModelo(String mod){
		Vehiculo veh = null;
		for (int i =0; i < cantVehiculos; i++) {
			if(listaVehiculos[i].getModelo().equalsIgnoreCase(mod)){
				veh = listaVehiculos[i];
			}
		}
		
		return veh;
	}
	
	public Ventas findCedula(String cedu){
		Ventas client = null;
		for(int i=0; i<cantVentas; i++){
			if(listaVentas[i].getClientes().getCedula().equalsIgnoreCase(cedu)){
				client = listaVentas[i];
				
			}
		}
		
		return client;
	}
	
	public void deleteSum(Sum sumi) {
		boolean find = false;
		int i=0;
		int pos=-1;
		while(!find && i < cantSum){
			if(listaSum[i].getNombre().equalsIgnoreCase(sumi.getNombre())){
				find = true;
				pos = i;
			}
			i++;
	   }
		if(pos!=-1){
			i = pos;
			while(pos<cantSum){
				listaSum[i]=listaSum[i+1];
				i++;
				pos++;		
			}
			cantSum--;	
		}
	}
	
	public void deleteVehiculo(Vehiculo veh) {
		boolean find = false;
		int i=0;
		int pos=-1;
		while(!find && i < cantVehiculos){
			if(listaVehiculos[i].getModelo().equalsIgnoreCase(veh.getModelo())){
				find = true;
				pos = i;
			}
			i++;
	   }
		if(pos!=-1){
			i = pos;
			while(pos<cantVehiculos){
				listaVehiculos[i]=listaVehiculos[i+1];
				i++;
				pos++;		
			}
			cantVehiculos--;	
		}
	}
	
	public void modificarVehiculos(Vehiculo veh){
		for(int i = 0; i < cantVehiculos; i++){
			if(listaVehiculos[i].getModelo().equalsIgnoreCase(veh.getModelo())){
				listaVehiculos[i] = veh;
			}
		}
	}
	
	public void deleteCodigoSum(Sum sumi) {
		boolean find = false;
		int i=0;
		int pos=-1;
		while(!find && i < cantSum){
			if(listaSum[i].getCodigo().equalsIgnoreCase(sumi.getCodigo())){
				find = true;
				pos = i;
			}
			i++;
	   }
		if(pos!=-1){
			i = pos;
			while(pos<cantSum){
				listaSum[i]=listaSum[i+1];
				i++;
				pos++;		
			}
			cantSum--;	
		}
	}
	
	public Sum findCodSum(String cod){
		Sum sumi = null;
		for (int i = 0; i < cantSum; i++) {
			if(listaSum[i].getCodigo().equalsIgnoreCase(cod)){
				sumi = listaSum[i];
			}
		}
		
		return sumi;
		
	}
	
	public void modificarSum(Sum sumi){
		for(int i = 0; i < cantSum; i++){
			if(listaSum[i].getCodigo() == sumi.getCodigo()){
				listaSum[i] = sumi;
			}
		}
	}
	
	
}
