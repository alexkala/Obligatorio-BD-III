package obligatorio.grafica.controladores;

import java.io.IOException;
import java.sql.SQLException;

import obligatorio.logica.Fachada;
import obligatorio.logica.exceptions.Due�oException;
import obligatorio.logica.valueObjects.VODue�o;

public class ControladorIngresarDue�o {
    //FIXME: cambiar por IFachada
    private Fachada fachada;
    
    public void ingresarDue�o(int cedula, String nombre, String apellido) throws SQLException, Due�oException, IOException {
        
    	fachada = Fachada.getInstance();
        VODue�o voDue�o = new VODue�o(cedula, nombre, apellido);
    	fachada.nuevoDue�o(voDue�o);
       
    }
        
}