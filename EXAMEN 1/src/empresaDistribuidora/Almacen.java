package empresaDistribuidora;

public class Almacen {
	//private Producto productos;
	private float Comestible;
	private float Atuendo;
	private float Electro;
	
	public float VentasProductoComest(){
		Producto comestible = new Producto();
		comestible.getTipo("Comestible");
		Comestible =(comestible.getCantidadstock()-comestible.getCantidadinicial())*comestible.getPrecio_comp();
		return Comestible;
	}
	public float VentasProductoAtuendo(){
		Producto atuendo = new Producto();
		atuendo.getTipo("Atuendo");
		Atuendo =(atuendo.getCantidadstock()-atuendo.getCantidadinicial())*atuendo.getPrecio_comp();
		return Atuendo;
	}
	
	public float VentasProductoElect(){
		Producto electro = new Producto();
		electro.getTipo("Electronico");
		Electro =(electro.getCantidadstock()-electro.getCantidadinicial())*electro.getPrecio_comp();
		return Electro;
	}
	public float Ganacias(){
	return VentasProductoComest()+VentasProductoAtuendo()+VentasProductoElect();
	}
	
	public float CantComestible(){
		Producto comestible = new Producto();
		comestible.getTipo("Comestible");
		return comestible.getCantidadstock()-comestible.getCantidadinicial();
	}
	public float CantAtuendo(){
		Producto atuendo = new Producto();
		atuendo.getTipo("Atuendo");
		return atuendo.getCantidadstock()-atuendo.getCantidadinicial();
	}
	public float CantElect(){
		Producto electro = new Producto();
		electro.getTipo("Electronico");
		return electro.getCantidadstock()-electro.getCantidadinicial();
	}

	
}
