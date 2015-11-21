package obligatorio.persistencia.daos.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import obligatorio.logica.Due�o;
import obligatorio.logica.valueObjects.*;
import obligatorio.persistencia.consultas.Consultas;
import obligatorio.persistencia.daos.IDaoDue�os;
import obligatorio.util.IConexion;
import obligatorio.util.MySQL.ConexionMySQL;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DaoDue�osSQL implements IDaoDue�os {	
	public DaoDue�osSQL (){
		super();
	} 

	public boolean member (IConexion ic, int ci) throws SQLException {
		boolean existe = false;
		Consultas consultas = new Consultas();
		String query = consultas.existeDue�o();

		PreparedStatement pstmt = (PreparedStatement) ((ConexionMySQL)ic).getCon().prepareStatement(query);
		pstmt.setInt (1, ci);

		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			existe = true;

		rs.close();
		pstmt.close();

		return existe;
	}

	public int insert (IConexion ic, Due�o due�o) throws SQLException {		 		 
		Consultas consultas = new Consultas();
		String insert = consultas.insertarDue�o();

		PreparedStatement pstmt = (PreparedStatement) ((ConexionMySQL)ic).getCon().prepareStatement(insert);
		pstmt.setInt(1, due�o.getCedula());
		pstmt.setString(2, due�o.getNombre());
		pstmt.setString(3, due�o.getApellido());

		int rs = pstmt.executeUpdate();

		pstmt.close();

		return rs;
	}

	public Due�o find (IConexion ic, int cedula) throws SQLException {
		Consultas consultas = new Consultas();

		String query = consultas.obtenerDue�o();
		PreparedStatement pstmt = (PreparedStatement) ((ConexionMySQL)ic).getCon().prepareStatement(query);
		pstmt.setInt(1, cedula);

		ResultSet rs = pstmt.executeQuery();

		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");

		Due�o due�o = new Due�o(cedula, nombre, apellido);

		rs.close();
		pstmt.close();

		return due�o;		
	}

	public void delete (IConexion ic, int cedula) throws SQLException {
		Consultas consultas = new Consultas();

		String delete = consultas.borrarDue�oMascotas();
		PreparedStatement pstmt = (PreparedStatement) ((ConexionMySQL)ic).getCon().prepareStatement(delete);
		pstmt.setInt(1, cedula);

		pstmt.executeUpdate();

		pstmt.close();
	}

	public List<VODue�o> listarDue�os(IConexion ic) throws SQLException {

		Consultas consultas = new Consultas();

		List<VODue�o> lista = new ArrayList<VODue�o>();

		String queryLista = consultas.listarDue�os();
		Statement stmt = (Statement) ((ConexionMySQL)ic).getCon().createStatement();
		ResultSet rs = stmt.executeQuery(queryLista);

		while(rs.next()){
			int ci = rs.getInt("cedula");
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");

			VODue�o due�o = new VODue�o(ci, nombre, apellido);
			lista.add(due�o);			 
		}

		return lista;
	}
}
