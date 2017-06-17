package bancopopular;

public class Cuentas {
	
	
	private float saldo;
	private float cantidad_ret;
	private float interes_c;
	private float comision;
	private float codigo;
	private boolean estado;
	private int mes_ape;
	private int dia_corte;
	private Clientes cliente;
	
	
	
	public void Cuentas(){
		
	}
	
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public float getInteres_c() {
		return interes_c;
	}
	public void setInteres_c(float interes_c) {
		this.interes_c = interes_c;
	}
	public float getComision() {
		return comision;
	}
	public void setComision(float comision) {
		this.comision = comision;
	}
	public float getCodigo() {
		return codigo;
	}
	public void setCodigo(float codigo) {
		this.codigo = codigo;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getMes_ape() {
		return mes_ape;
	}
	public void setMes_ape(int mes_ape) {
		this.mes_ape = mes_ape;
	}
	public int getDia_corte() {
		return dia_corte;
	}
	public void setDia_corte(int dia_corte) {
		this.dia_corte = dia_corte;
	}
	public float RevisionMensual(float Saldo){
		Saldo = this.saldo + this.interes_c - this.comision;
		return Saldo;
	}
	public float CuentaCorriente(){
		if(cantidad_ret>saldo){
			System.out.println("No tiene el saldo suficiente:");
		}
		estado = true;
		System.out.println("Su saldo actual es:");
		return saldo;
	}
	public void CuentaVivienda(){
		if(cantidad_ret>1){
			System.out.println("No se puede retirar dinero");
		}
	}
	public float FondoInversion( float dinero){
		if(cantidad_ret>500){
			estado = false;
		}
		System.out.println("Su cuenta ha sido bloqueada");
		if(cantidad_ret<500){
		dinero = saldo-cantidad_ret;
		}
		return dinero;
	
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public float getCantidad_ret() {
		return cantidad_ret;
	}

	public void setCantidad_ret(float cantidad_ret) {
		this.cantidad_ret = cantidad_ret;
	}
	
	
}
