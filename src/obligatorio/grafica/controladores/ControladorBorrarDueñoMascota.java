package obligatorio.grafica.controladores;

import java.io.IOException;
import java.sql.SQLException;

import obligatorio.logica.Fachada;
import obligatorio.logica.exceptions.Due�oException;

public class ControladorBorrarDue�oMascota {
    
	public void borrarDue�oMascota(int cedula) throws SQLException, Due�oException, IOException {
		
		//FIXME: cambiar por IFachada
		Fachada.getInstance().borrarDue�oMascotas(cedula);

	}

}