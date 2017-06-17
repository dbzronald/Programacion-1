package bancopopular;

public class Main {

	public static void main(String[] args) {
		Banco mielda = new Banco();
		mielda.AgregarCuentas(Banco.getContador());
		Banco.setContador(Banco.getContador()+1);
	}

}
