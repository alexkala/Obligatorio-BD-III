package obligatorio.persistencia;

import obligatorio.persistencia.daos.IDaoDue�os;
import obligatorio.persistencia.daos.IDaoMascotas;
import obligatorio.persistencia.daos.MySQL.DaoDue�osSQL;
import obligatorio.persistencia.daos.MySQL.DaoMascotasSQL;

public class SQLFactory implements IAbstractFactory {
	public IDaoDue�os crearDaoDuenios() {
		return new DaoDue�osSQL();
	}

	public IDaoMascotas crearDaoMascotas(int cedulaDue�o) {
		return new DaoMascotasSQL(cedulaDue�o);
	}
}
