package com.unilever.bancoideas.utilities;

import java.io.Serializable;

public class Constantes implements Serializable{

	private static final long serialVersionUID = -8637838991173542066L;

	//Estados en la aplicacion
	public static final String ESTADO_ACTIVO = "A";
	public static final String ESTADO_INACTIVO = "I";

	
	//Codigo de errores
	public static final String ERROR_NULL_POINTER_EXCEPTION = "COD001";

	//Estados liquidación de nómina
	public static String ESTADO_LIQUIDACION_CREADA = "CREADA";
	public static String ESTADO_LIQUIDACION_PRE_NOMINA = "PROCESO";
	public static String ESTADO_LIQUIDACION_LIQUIDADA = "APROBADA";
	public static String ESTADO_LIQUIDACION_PAGADA = "PAGADA";
	
	//Periodos nomina
	public static String PRIMERA_QUINCENA = "PRIMERA_QUINCENA";
	public static String SEGUNDA_QUINCENA = "SEGUNDA_QUINCENA";
	public static String MENSUALIDAD = "MENSUALIDAD";
	
	//Sesiones
	public static String SESION_LIQUIDACION_NOMINA = "liquidacionNomina";

	//Parametros
	public static String PARAMETRO_AUXILIO_TRANSPORTE = "AT";
	public static String PARAMETRO_SALARIO_MINIMO = "SM";
	public static String PARAMETRO_CANTIDAD_SALARIOS = "CS";
	public static String PARAMETRO_PORCENTAJE_SALUD = "SA";
	public static String PARAMETRO_PORCENTAJE_PENSION = "PE";

}
