package obligatorio.logica;

public class Mascota {
	private String raza;
	private String apodo;
	private int cedulaDue�o;
	
	public Mascota(String raza, String apodo) {
		super();
		this.raza = raza;
		this.apodo = apodo;
	}
	
	public String getRaza() {
		return raza;
	}
	
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public String getApodo() {
		return apodo;
	}
	
	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
}
