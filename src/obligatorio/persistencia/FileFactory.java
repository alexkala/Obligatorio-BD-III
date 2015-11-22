package obligatorio.persistencia;

import obligatorio.persistencia.daos.IDaoDue�os;
import obligatorio.persistencia.daos.IDaoMascotas;
import obligatorio.persistencia.daos.Archivos.DaoDue�osArchivo;
import obligatorio.persistencia.daos.Archivos.DaoMascotasArchivo;

public class FileFactory implements IAbstractFactory {
	public IDaoDue�os crearDaoDuenios() {
		return new DaoDue�osArchivo();
	}
	
	public IDaoMascotas crearDaoMascotas(int cedulaDue�o) {
		return new DaoMascotasArchivo(cedulaDue�o);
	}
}
