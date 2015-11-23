package obligatorio.grafica.controladores;

import java.rmi.RemoteException;

import obligatorio.exceptions.Due�oException;
import obligatorio.exceptions.LogicaException;
import obligatorio.exceptions.PersistenciaException;
import obligatorio.logica.IFachada;
import obligatorio.util.ObjetoCliente;

public class ControladorBorrarDue�oMascota {
	private IFachada facade;
	
	public void borrarDue�oMascota(int cedula) throws LogicaException,
			PersistenciaException, Due�oException, RemoteException {
		facade = ObjetoCliente.Inicializar();
		facade.borrarDue�oMascotas(cedula);
	}
}