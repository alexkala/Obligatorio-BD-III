package obligatorio.logica;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import obligatorio.logica.valueObjects.*;
import obligatorio.persistencia.daos.*;
import obligatorio.util.*;

import com.mysql.jdbc.Connection;

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
	
	public void nuevaMascota(VOMascota mascota) throws SQLException{
		String apodo = mascota.getApodo();
		int ced = mascota.getCedulaDue�o();
		String raza = mascota.getRaza();
		Connection con = (Connection) DriverManager.getConnection
				(url, user, password);
		AccesoBD abd = new AccesoBD ();	
	}
}

