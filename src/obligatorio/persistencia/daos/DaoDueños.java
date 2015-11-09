package obligatorio.persistencia.daos;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import obligatorio.logica.valueObjects.*;
import obligatorio.persistencia.consultas.Consultas;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DaoDue�os {
	
	 private String driver = "com.mysql.jdbc.Driver";
	 private String url = "jdbc:mysql://localhost:3306";
	 private String user = "root";
	 private String password = "";
	  
	 public DaoDue�os (){
		 
	 } 
	 
	 public boolean member (int ci) throws SQLException{
		 
		Connection con = (Connection) DriverManager.getConnection(url,user,password);

		boolean existe = false;
		Consultas consultas = new Consultas();
		String query = consultas.existeDue�o();
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
		pstmt.setInt (1, ci);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
			existe= true;
		
		rs.close();
		pstmt.close();
		con.close();
		
		return existe;
		 
	 }
	 
	 
	 public int insert ( int cedula, String nombre, String apellido)throws SQLException {
		//pasarle Due�o	
		Connection con = (Connection) DriverManager.getConnection(url,user,password);
		Consultas consultas = new Consultas();
		String insert = consultas.insertarDue�o();
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(insert);
		pstmt.setInt(1, cedula);
		pstmt.setString(2, nombre);
		pstmt.setString(3, apellido);
		int rs = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
			
		return rs;
		}
	 
	 public VODue�o find (int cedula) throws SQLException {
		Connection con = (Connection) DriverManager.getConnection(url,user,password);
		Consultas consultas = new Consultas();
		
		String query = consultas.obtenerDue�o();
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(query);
		pstmt.setInt(1, cedula);
		
		ResultSet rs = pstmt.executeQuery();
		
		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");
		
		VODue�o due�o = new VODue�o(cedula, nombre, apellido);
		
		rs.close();
		pstmt.close();
		con.close();
		return due�o;

		
	 }
	 
	 public void delete (int cedula) throws SQLException {
		Connection con = (Connection) DriverManager.getConnection(url,user,password);
		Consultas consultas = new Consultas();
			
		String delete = consultas.borrarDue�oMascotas();
		PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(delete);
		pstmt.setInt(1, cedula);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	 }
	 
	 
	 public List <VODue�o> listarDue�os() throws SQLException{
		 Connection con = (Connection) DriverManager.getConnection(url,user,password);
		 Consultas consultas = new Consultas();
		 
		 List <VODue�o> lista = new ArrayList<VODue�o>();
		 
		 
		 String queryLista = consultas.listarDue�os();
		 Statement stmt = (Statement) con.createStatement();
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
