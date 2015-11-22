package obligatorio.persistencia.daos;

import java.util.List;

import obligatorio.exceptions.LogicaException;
import obligatorio.exceptions.PersistenciaException;
import obligatorio.logica.Due�o;
import obligatorio.logica.valueObjects.VODue�o;
import obligatorio.util.IConexion;

public interface IDaoDue�os {
	public boolean member(IConexion ic, int ci) throws PersistenciaException;

	public void insert(IConexion ic, Due�o due�o) throws PersistenciaException;

	public Due�o find(IConexion ic, int cedula) throws PersistenciaException, LogicaException;

	public void delete(IConexion ic, int cedula) throws PersistenciaException;

	public List<VODue�o> listarDue�os(IConexion ic)
			throws PersistenciaException;
}
