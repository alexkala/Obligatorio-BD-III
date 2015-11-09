package obligatorio.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import obligatorio.persistencia.consultas.Consultas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AccesoBD {
	private Consultas consultas;
	
	public ResultSet listarDue�os(Connection con) throws SQLException {
		consultas = new Consultas();
		String query = consultas.listarDue�os();
		Statement stmt = (Statement) con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	public boolean existeDue�o(Connection con, int cedula) throws SQLException {
		boolean existe = false;
		consultas = new Consultas();
		String query = consultas.existeDue�o();
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
		pstmt.setInt (1, cedula);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			existe= true;
		rs.close();
		pstmt.close();
		return existe;
	}
	
	public int insertarDue�o(Connection con, int cedula, String nombre, String apellido) 
			throws SQLException {
		consultas = new Consultas();
		String insert = consultas.insertarDue�o();
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(insert);
		pstmt.setInt(1, cedula);
		pstmt.setString(2, nombre);
		pstmt.setString(3, apellido);
		int rs = pstmt.executeUpdate();
		return rs;
	}
	
	public void insertarMascota(Connection con, int cedulaDue�o, String apodo, String raza) throws SQLException{
		consultas = new Consultas();
		String insert = consultas.insertarMascota();
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(insert);
		pstmt.setInt(1, cedulaDue�o);
		pstmt.setString(2, apodo);
		pstmt.setString(3, raza);
		pstmt.executeUpdate();
		pstmt.close();
		
	}

}
