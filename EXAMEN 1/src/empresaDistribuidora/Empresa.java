package empresaDistribuidora;

public class Empresa {
	private Almacen almacen;
	private Producto productos;
	private float DescuentoComestible;
	private float DescuentoAtuendo;
	private float DescuentoElectro;
	private float PedidoComestible;
	private float PedidoAtuendo;
	private float PedidoElectro;
	
	
	public float VerCantidadComest(){
		System.out.println("Cantidad Comestible : ");
		return almacen.CantComestible();
	}
	public float VerCantidadAtuendo(){
		System.out.println("Cantidad Atuendos : ");
		return almacen.CantAtuendo();
	}
	public float VerCantidadElect(){
		System.out.println("Cantidad Electronicos : ");
		return almacen.CantElect();
	}
	
	
	public float DescuentoComestibles(){
		productos.setTipo("Comestible");	
		
		if(productos.getDias_vencer() == 60){
			DescuentoComestible = (almacen.CantComestible()*50*productos.getDias_vencer())/100;
		}
		return DescuentoComestible;
	}
	
	public float DescuentoAtuendos(){
		productos.setTipo("Atuendo");
		
		if(productos.getDias_vencer() == 75){
			DescuentoAtuendo = (almacen.CantAtuendo()*35*productos.getDias_vencer())/100;
		}
		return DescuentoAtuendo;
	}
	public float DescuentoElect(){
		productos.setTipo("Electronico");
		
		if(productos.getDias_vencer() == 90){
			DescuentoElectro = (almacen.CantElect()*20*productos.getDias_vencer())/100;
		}
		return DescuentoElectro;
	}
	public void PedidoComestible(){
		productos.getTipo("Comestible");
		
		PedidoComestible = (productos.getCantidadinicial()*10)/100;
		
		if (productos.getCantidadinicial() < PedidoComestible){
		System.out.println("No se puede realizar pedido.");	
		}
		else {
			System.out.println("Pedido Realizado.");
		}
		
	}
	public void PedidoElect(){
		productos.getTipo("Electronico");
		
		PedidoElectro = (productos.getCantidadinicial()*10)/100;
		
		if (productos.getCantidadinicial() < PedidoElectro){
		System.out.println("No se puede realizar pedido.");	
		}
		else {
			System.out.println("Pedido Realizado.");
		}
		
	}
	public void PedidoAtuendo(){
		productos.getTipo("Atuendo");
		
		PedidoAtuendo = (productos.getCantidadinicial()*10)/100;
		
		if (productos.getCantidadinicial() < PedidoAtuendo){
		System.out.println("No se puede realizar pedido.");	
		}
		else {
			System.out.println("Pedido Realizado.");
		}
		
	}
}
