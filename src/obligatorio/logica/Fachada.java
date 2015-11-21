package obligatorio.logica;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import obligatorio.exceptions.Due�oException;
import obligatorio.logica.valueObjects.*;
import obligatorio.persistencia.daos.*;
import obligatorio.util.*;
import obligatorio.util.MySQL.PoolConexionesMySQL;

public class Fachada {
   private static Fachada instance = null;
   private IDaoDue�os due�os;
   private IPoolConexiones pool;
   
   protected Fachada() throws IOException {
      due�os = null;
      pool = new PoolConexionesMySQL();
   }
   
   public static Fachada getInstance() throws IOException {
      if(instance == null) {
         instance = new Fachada();
      }
      
      return instance;
   }

   public void nuevoDue�o(VODue�o due�o) throws SQLException,Due�oException {
	   IConexion icon = pool.obtenerConexion(true);
	   int ced = due�o.getCedula();
	   String nom = due�o.getNombre();
	   String ape = due�o.getApellido();
	   
	   try {
			if (!due�os.member(icon, ced)){
				Due�o d = new Due�o(ced, nom, ape);
				due�os.insert(icon, d);
			}else{
				pool.liberarConexion (icon, true);
				throw new Due�oException("Error: ya existe el due�o con el numero de cedula ingresado.");
			}
			pool.liberarConexion (icon, true);
		} catch (Exception e) {
			pool.liberarConexion (icon, true);
		}
	}
	
   public void nuevaMascota(VOMascota pMascota) throws SQLException,Due�oException {
		String apodo = pMascota.getApodo();
		int cedulaDue�o = pMascota.getCedulaDue�o();
		String raza = pMascota.getRaza();
		
		IConexion icon = pool.obtenerConexion(true);
		if(due�os.member(icon, cedulaDue�o))
		{
			Due�o due�o = due�os.find(icon, cedulaDue�o);
			
			Mascota mascota = new Mascota(raza, apodo);
			
			try {
				due�o.addMascota(icon, mascota);
				pool.liberarConexion (icon, true);
			} catch (Exception e) {
				pool.liberarConexion (icon, true);
			}
		}else
		{
			pool.liberarConexion (icon, true);
			throw new Due�oException("Error: no existe due�o");
		}
   }
   
	public List<VODue�o> listarDue�os() throws SQLException {
		IConexion icon = pool.obtenerConexion(true);
		return due�os.listarDue�os(icon);
	}
	
	public List<VOMascota> listarMascotas(int cedulaDue�o) throws SQLException, Due�oException {
		IConexion icon = pool.obtenerConexion(true);
		
		if (due�os.member(icon, cedulaDue�o)) {
			return due�os.find(icon, cedulaDue�o).listarMascotas(icon);			
		} else {
			throw new Due�oException("Error: no existe due�o");
		}
	}
	
	public void borrarDue�oMascotas(int cedulaDue�o) throws SQLException, Due�oException {
		IConexion icon = pool.obtenerConexion(true);
		
		if (due�os.member(icon, cedulaDue�o)) {
			due�os.find(icon, cedulaDue�o).borrarMascotas(icon);
			due�os.delete(icon, cedulaDue�o);
		} else {
			throw new Due�oException("Error: no existe due�o");
		}
	}
}

