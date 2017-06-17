package alquilerBarcos;

public class Barco {
	private String matricula;
	private float eslora;
	private int aniofab;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public float getEslora() {
		return eslora;
	}
	public void setEslora(float eslora) {
		this.eslora = eslora;
	}
	public int getAniofab() {
		return aniofab;
	}
	public void setAniofab(int aniofab) {
		this.aniofab = aniofab;
	}
	public float obtenerFactor(){
		return  (float) (10*getEslora());	
	}
}
