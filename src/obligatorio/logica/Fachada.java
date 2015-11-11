package obligatorio.logica;

import java.io.IOException;
import java.sql.SQLException;

import obligatorio.logica.valueObjects.*;
import obligatorio.persistencia.daos.*;
import obligatorio.util.*;

public class Fachada {
   private static Fachada instance = null;
   private DaoDue�os due�os;
   private IPoolConexiones pool;
   
   protected Fachada() throws IOException {
      due�os = null;
      pool = new PoolConexiones();
   }
   
   public static Fachada getInstance() throws IOException {
      if(instance == null) {
         instance = new Fachada();
      }
      
      return instance;
   }

   public void nuevoDue�o(VODue�o due�o) throws SQLException {
	   IConexion icon = pool.obtenerConexion(true);
	   int ced = due�o.getCedula();
	   String nom = due�o.getNombre();
	   String ape = due�o.getApellido();
	   
	   try {
			if (!due�os.member(icon, ced)){
				Due�o d = new Due�o(ced, nom, ape);
				due�os.insert(icon, d);
			}
			pool.liberarConexion (icon, true);
		} catch (Exception e) {
			pool.liberarConexion (icon, true);
		}
	}
	
   public void nuevaMascota(VOMascota pMascota) throws SQLException {
		String apodo = pMascota.getApodo();
		int cedulaDue�o = pMascota.getCedulaDue�o();
		String raza = pMascota.getRaza();
		
		IConexion icon = pool.obtenerConexion(true);
		
		Due�o due�o = due�os.find(icon, cedulaDue�o);
		Mascota mascota = new Mascota(raza, apodo);
		
		try {
			due�o.addMascota(mascota);
			pool.liberarConexion (icon, true);
		} catch (Exception e) {
			pool.liberarConexion (icon, true);
		}
   }
}

