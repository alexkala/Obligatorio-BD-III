package obligatorio.logica;

import java.sql.DriverManager;
import java.sql.SQLException;

import obligatorio.logica.valueObjects.VODue�o;
import obligatorio.logica.valueObjects.VOMascota;
import obligatorio.persistencia.daos.DaoDue�os;

import com.mysql.jdbc.Connection;

public class Fachada {
	/*
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306";
	private String user = "root";
	private String password = "";

	public void nuevoDue�o(VODue�o due�o) throws SQLException {
		int ced = due�o.getCedula();
		String nom = due�o.getNombre();
		String ape = due�o.getApellido();
				
		DaoDue�os dao = new DaoDue�os();
		
		boolean existe = dao.member(ced);
		if (!existe){
			//crear due�o
			dao.insert(ced, nom, ape);
		}
	}
	
	public void nuevaMascota(VOMascota mascota) throws SQLException{
		String apodo = mascota.getApodo();
		int ced = mascota.getCedulaDue�o();
		String raza = mascota.getRaza();
		Connection con = (Connection) DriverManager.getConnection
				(url, user, password);
		AccesoBD abd = new AccesoBD ();
		
		
		
	}


*/




}

