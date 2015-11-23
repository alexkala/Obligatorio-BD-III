package obligatorio.grafica.controladores;

import java.rmi.RemoteException;

import obligatorio.exceptions.Due�oException;
import obligatorio.exceptions.LogicaException;
import obligatorio.exceptions.PersistenciaException;
import obligatorio.logica.IFachada;

public class ControladorBorrarDue�oMascota {
	private IFachada facade;
	
	public void borrarDue�oMascota(int cedula) throws LogicaException,
			PersistenciaException, Due�oException, RemoteException {
		facade.borrarDue�oMascotas(cedula);
	}
}