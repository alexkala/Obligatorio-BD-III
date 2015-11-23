package obligatorio.grafica.controladores;

import java.rmi.RemoteException;

import obligatorio.exceptions.Due�oException;
import obligatorio.exceptions.LogicaException;
import obligatorio.exceptions.PersistenciaException;
import obligatorio.logica.IFachada;
import obligatorio.logica.valueObjects.VODue�o;

public class ControladorIngresarDue�o {
	private IFachada facade;

	public void ingresarDue�o(int cedula, String nombre, String apellido)
			throws Due�oException, PersistenciaException, LogicaException,
			RemoteException {
		VODue�o voDue�o = new VODue�o(cedula, nombre, apellido);
		facade.nuevoDue�o(voDue�o);
	}
}