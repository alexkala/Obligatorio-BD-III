package obligatorio.grafica.controladores;

import java.rmi.RemoteException;

import obligatorio.exceptions.Due�oException;
import obligatorio.exceptions.LogicaException;
import obligatorio.exceptions.PersistenciaException;
import obligatorio.logica.Fachada;

public class ControladorBorrarDue�oMascota {

	public void borrarDue�oMascota(int cedula) throws LogicaException,
			PersistenciaException, Due�oException, RemoteException {

		// FIXME: cambiar por IFachada
		Fachada.getInstance().borrarDue�oMascotas(cedula);
	}
}