package obligatorio.persistencia.daos;

import java.sql.SQLException;
import java.util.List;

import obligatorio.logica.Due�o;
import obligatorio.logica.valueObjects.VODue�o;
import obligatorio.util.IConexion;

public interface IDaoDue�os {
	public boolean member (IConexion ic, int ci) throws SQLException;

	public int insert (IConexion ic, Due�o due�o) throws SQLException;

	public Due�o find (IConexion ic, int cedula) throws SQLException;

	public void delete (IConexion ic, int cedula) throws SQLException;

	public List<VODue�o> listarDue�os(IConexion ic) throws SQLException;
}
