package obligatorio.logica;

public class Mascota {
	private String raza;
	private String apodo;
	private int cedulaDue�o;
	
	public Mascota(String raza, String apodo, int cedulaDue�o) {
		super();
		this.raza = raza;
		this.apodo = apodo;
		this.cedulaDue�o = cedulaDue�o;
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
	
	public int getCedulaDue�o() {
		return cedulaDue�o;
	}
	
	public void setCedulaDue�o(int cedulaDue�o) {
		this.cedulaDue�o = cedulaDue�o;
	}
}
