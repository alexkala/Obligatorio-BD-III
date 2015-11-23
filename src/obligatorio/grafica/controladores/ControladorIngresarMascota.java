package obligatorio.grafica.controladores;

import java.rmi.RemoteException;

import obligatorio.exceptions.Due�oException;
import obligatorio.exceptions.LogicaException;
import obligatorio.exceptions.MascotaException;
import obligatorio.exceptions.PersistenciaException;
import obligatorio.logica.IFachada;
import obligatorio.logica.valueObjects.VOMascota;
import obligatorio.util.ObjetoCliente;

public class ControladorIngresarMascota {
	private IFachada facade;

	public void ingresarMascota(int cedulaDue�o, String apodo, String raza)
			throws LogicaException, PersistenciaException, Due�oException,
			MascotaException, RemoteException {
		facade = ObjetoCliente.Inicializar();
		VOMascota voMascota = new VOMascota(raza, apodo, cedulaDue�o);
		facade.nuevaMascota(voMascota);
	}
}