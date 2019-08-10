package com.unilever.bancoideas.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 * 
 */
public class ZMessManager extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(ZMessManager.class);

	public final static String ALL = "All ";
	public final static String ENTCHILD = "related tables(childs)";
	public final static String FOREIGNDATA = "foreign classes data: ";
	public static String ENTITY_SUCCESFULLYSAVED = "Registrado satisfactoriamente";
	public static String ENTITY_SUCCESFULLYDELETED = "Entity succesfully deleted";
	public static String ENTITY_SUCCESFULLYMODIFIED = "Modificado satisfactoriamente";
	public static String ENTITY_WITHSAMEKEY = "Se encontró otra entidad con la misma llave";
	public static String ENTITY_NOENTITYTOUPDATE = "No se ha encontrado la entidad ";

	public ZMessManager() {
	}

	public ZMessManager(String exception) {
		super(exception);
	}

	public class NotValidFieldException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NotValidFieldException(String info) {
			super("El valor del campo: \"" + info + "\" no es válido");
		}
	}
	
	public class NullEntityExcepcion extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NullEntityExcepcion(String info) {
			super("La entidad " + info + " no puede ser nula o vacía");
		}
	}

	public class EmptyFieldException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public EmptyFieldException(String info) {
			super("El valor para el campo: \"" + info
					+ "\" no puede ser nulo o vacío");
		}
	}

	public class NotValidFormatException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NotValidFormatException(String info) {
			super("El formato o tamaño del campo: \"" + info
					+ "\" NO es válido");
		}
	}

	public class DeletingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public DeletingException(String info) {
			super("The Entity you are trying to delete "
					+ "may have related information, "
					+ "please before trying again, "
					+ "check the data on the entity, \"" + info+"\"");
		}
	}
	
	public class ForeignException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public ForeignException(String info) {
			super("No se encontró datos relacionados con \"" + info+ "\"");
		}
	}	

	public class GettingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public GettingException(String info) {
			super("Se encontró una excepción en " + info);
		}
	}

	public class FindingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public FindingException(String info) {
			super("Ocurrió una excepción buscando " + info);
		}
	}

}
