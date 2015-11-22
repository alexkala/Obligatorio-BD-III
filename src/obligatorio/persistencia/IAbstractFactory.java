package obligatorio.persistencia;

import obligatorio.persistencia.daos.IDaoDue�os;
import obligatorio.persistencia.daos.IDaoMascotas;

public interface IAbstractFactory {
	public IDaoDue�os crearDaoDuenios();
	public IDaoMascotas crearDaoMascotas(int cedulaDue�o);
}
