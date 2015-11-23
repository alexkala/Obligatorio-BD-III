package obligatorio.persistencia.consultas;

public class Consultas {

	/* CONSULTAS DUE�OS */

	public String listarDue�os() {
		String query = "SELECT * FROM dym.Due�os";
		return query;
	}

	public String existeDue�o() {
		String query = "SELECT d.cedula FROM dym.Due�os d WHERE d.cedula = (?)";
		return query;
	}

	public String obtenerDue�o() {
		String query = "SELECT * FROM dym.Due�os d WHERE d.cedula = (?)";
		return query;
	}

	public String insertarDue�o() {
		String insert = "INSERT INTO dym.Due�os (cedula, nombre, apellido)"
				+ "VALUES (?, ?, ?)";
		return insert;
	}

	public String borrarDue�o() {
		String delete = "DELETE FROM dym.Due�os WHERE cedula = (?)";
		return delete;
	}

	/* CONSULTAS MASCOTAS */

	public String listarMascotas() {
		String query = "SELECT * FROM dym.Mascotas where cedulaDue�o = (?)";
		return query;
	}

	public String existeMascota() {
		String query = "SELECT m.apodo FROM dym.Mascotas m WHERE m.apodo = (?) and m.cedulaDue�o = (?)";
		return query;
	}

	public String insertarMascota() {
		String insert = "INSERT INTO dym.Mascotas (apodo, raza, cedulaDue�o)"
				+ "VALUES (?, ?, ?)";
		return insert;
	}

	public String borrarMascotas() {
		String delete = "Delete from dym.Mascotas where cedulaDue�o = (?)";
		return delete;
	}
}
