package obligatorio.grafica.controladores;

import obligatorio.exceptions.LogicaException;
import obligatorio.logica.Fachada;

public class ControladorBorrarDue�oMascota {

	public void borrarDue�oMascota(int cedula) throws LogicaException {

		// FIXME: cambiar por IFachada
		Fachada.getInstance().borrarDue�oMascotas(cedula);

	}

}