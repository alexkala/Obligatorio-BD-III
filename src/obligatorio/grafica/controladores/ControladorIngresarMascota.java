package obligatorio.grafica.controladores;

import java.io.IOException;
import java.sql.SQLException;

import obligatorio.logica.Fachada;
import obligatorio.logica.exceptions.Due�oException;
import obligatorio.logica.valueObjects.VOMascota;

public class ControladorIngresarMascota {
    
    //FIXME: cambiar por IFachada
        private Fachada fachada;
        
        public void ingresarMascota(int cedulaDue�o, String apodo, String raza) throws SQLException, Due�oException, IOException {
            
        	fachada = Fachada.getInstance();
        	VOMascota voMascota = new VOMascota(raza, apodo, cedulaDue�o);
        	fachada.nuevaMascota(voMascota);
            
        }
    
}