package obligatorio.exceptions;

import java.io.Serializable;

public class Due�oException  extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public Due�oException(String msj)
	{
		super(msj);
	}
}
