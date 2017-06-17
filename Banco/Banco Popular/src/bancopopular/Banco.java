package bancopopular;

public class Banco {
	private Clientes[] arr_cliente;
	private Cuentas[] arr_cuentas;
	private static int contador = 0;
	private int contador2;
	
	public void AgregarCuentas(int contador){
		
		Clientes cl = new Clientes();
		System.out.println("Abrir Cuenta Nueva:");
		System.out.println("Cedula: ");
		cl.setCedula("72136547235");
		cl.setNombre("Vitoki");
		cl.setDireccion("El Ingenio c/Hood");
		cl.setTelefono("809-223-5420");
		
		Cuentas cn = new Cuentas();
		cn.setCodigo(15401629);
		cn.setComision(2410);
		cn.setInteres_c(500);
		cn.setSaldo(10000);
		cn.setMes_ape(7);
		cn.setDia_corte(29);
		cn.setEstado(true);
		arr_cuentas[contador].setCliente(cl);
		cn = arr_cuentas[contador];
			
	}
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		Banco.contador = contador;
	}
}
