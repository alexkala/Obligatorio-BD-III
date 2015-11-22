package obligatorio.logica;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import obligatorio.exceptions.Due�oException;
import obligatorio.exceptions.MascotaException;
import obligatorio.exceptions.PersistenciaException;
import obligatorio.logica.valueObjects.VODue�o;
import obligatorio.logica.valueObjects.VOMascota;

public interface IFachada extends Remote {

	// public void nuevoDue�o(VODue�o due�o) throws Due�oException,
	// PersistenciaException;

	public void nuevaMascota(VOMascota pMascota) throws PersistenciaException,
			Due�oException, RemoteException, MascotaException, IOException;

	public List<VODue�o> listarDue�os() throws PersistenciaException,
			RemoteException;

	public List<VOMascota> listarMascotas(int cedulaDue�o)
			throws Due�oException, RemoteException, PersistenciaException;

	public void borrarDue�oMascotas(int cedulaDue�o) throws Due�oException,
			RemoteException, PersistenciaException;

}
