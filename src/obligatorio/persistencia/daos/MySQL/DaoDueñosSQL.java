package obligatorio.persistencia.daos.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import obligatorio.exceptions.PersistenciaException;
import obligatorio.logica.Due�o;
import obligatorio.logica.valueObjects.VODue�o;
import obligatorio.persistencia.consultas.Consultas;
import obligatorio.persistencia.daos.IDaoDue�os;
import obligatorio.util.IConexion;
import obligatorio.util.MySQL.ConexionMySQL;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DaoDue�osSQL implements IDaoDue�os {
	public DaoDue�osSQL() {
		super();
	}

	public boolean member(IConexion ic, int ci) throws PersistenciaException {
		boolean existe = false;

		try {
			Consultas consultas = new Consultas();
			String query = consultas.existeDue�o();

			PreparedStatement pstmt = (PreparedStatement) ((ConexionMySQL) ic)
					.getCon().prepareStatement(query);
			pstmt.setInt(1, ci);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next())
				existe = true;

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			throw new PersistenciaException(e.getMessage());
		}

		return existe;
	}

	public int insert(IConexion ic, Due�o due�o) throws PersistenciaException {
		Consultas consultas = new Consultas();
		String insert = consultas.insertarDue�o();
		int rs;

		try {
			PreparedStatement pstmt = (PreparedStatement) ((ConexionMySQL) ic)
					.getCon().prepareStatement(insert);
			pstmt.setInt(1, due�o.getCedula());
			pstmt.setString(2, due�o.getNombre());
			pstmt.setString(3, due�o.getApellido());
			rs = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new PersistenciaException(e.getMessage());
		}

		return rs;
	}

	public Due�o find(IConexion ic, int cedula) throws PersistenciaException {
		Consultas consultas = new Consultas();
		String query = consultas.obtenerDue�o();
		Due�o due�o;

		try {
			PreparedStatement pstmt = (PreparedStatement) ((ConexionMySQL) ic)
					.getCon().prepareStatement(query);
			pstmt.setInt(1, cedula);
			ResultSet rs = pstmt.executeQuery();

			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			due�o = new Due�o(cedula, nombre, apellido);

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			throw new PersistenciaException(e.getMessage());
		}

		return due�o;
	}

	public void delete(IConexion ic, int cedula) throws PersistenciaException {
		Consultas consultas = new Consultas();
		String delete = consultas.borrarDue�oMascotas();

		try {
			PreparedStatement pstmt = (PreparedStatement) ((ConexionMySQL) ic)
					.getCon().prepareStatement(delete);
			pstmt.setInt(1, cedula);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			throw new PersistenciaException(e.getMessage());
		}
	}

	public List<VODue�o> listarDue�os(IConexion ic)
			throws PersistenciaException {
		Consultas consultas = new Consultas();
		String queryLista = consultas.listarDue�os();
		List<VODue�o> lista = new ArrayList<VODue�o>();

		try {
			Statement stmt = (Statement) ((ConexionMySQL) ic).getCon()
					.createStatement();
			ResultSet rs = stmt.executeQuery(queryLista);

			while (rs.next()) {
				int ci = rs.getInt("cedula");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");

				VODue�o due�o = new VODue�o(ci, nombre, apellido);
				lista.add(due�o);
			}
		} catch (SQLException e) {
			throw new PersistenciaException(e.getMessage());
		}

		return lista;
	}
}
