package obligatorio.persistencia.consultas;

public class Consultas {
	
	/* CONSULTAS DUE�OS */
	 
	public String listarDue�os(){
		String query= "SELECT * FROM Due�os";
		return query;
	}
	
	public String existeDue�o() {
		String query = "SELECT d.cedula FROM Due�os d WHERE d.cedula = (?)";
		return query;
	}
	
	public String obtenerDue�o() {
		String query = "SELECT * FROM Due�os d WHERE d.cedula = (?)";
		return query;
	}
	
	public String insertarDue�o() {
		String insert = "INSERT INTO Due�os (cedula, nombre, apellido)" +
						"VALUES (?, ?, ?)";
		return insert;
	}
	
	public String borrarDue�oMascotas() {
		String delete = "DELETE FROM Mascotas m WHERE m.cedulaDue�o = (?)" +
						"DELETE FROM Due�os d WHERE d.cedula = (?)";
		return delete;
	}
	
	
	/* CONSULTAS MASCOTAS */
	
	public String listarMascotas(){
		String query = "SELECT * FROM Mascotas where cedulaDue�o = (?)";
		return query;
	}
	
	public String existeMascota() {
		String query = "SELECT m.apodo FROM Mascotas m WHERE m.apodo = (?)";
		return query;
	}
	
	public String insertarMascota() {
		String insert = "INSERT INTO Mascotas (apodo, raza, cedulaDue�o)" +
						"VALUES (?, ?, ?)";
		return insert;
	}
	
	public String booMascotas(){
		String boom = "Delete from Mascotas ";
		return boom;
	}
	

}
