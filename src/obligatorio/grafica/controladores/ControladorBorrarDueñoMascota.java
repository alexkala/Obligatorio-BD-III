package obligatorio.grafica.controladores;

import java.io.IOException;
import java.sql.SQLException;

import obligatorio.logica.Fachada;
import obligatorio.logica.exceptions.ExceptionsDue�os;

public class ControladorBorrarDue�oMascota {
    
	public void borrarDue�oMascota(int cedula) throws SQLException, ExceptionsDue�os, IOException {
		
		//FIXME: cambiar por IFachada
		Fachada.getInstance().borrarDue�oMascotas(cedula);

	}

}