package com.unilever.bancoideas.dataaccess.dao;

import java.util.Date;
import java.util.List;

import com.unilever.bancoideas.dataaccess.api.Dao;
import com.unilever.bancoideas.modelo.LiquidacionNomina;


/**
* Interface for   LiquidacionNominaDAO.
*
*/
public interface ILiquidacionNominaDAO extends Dao<LiquidacionNomina, Integer> {
	public List<LiquidacionNomina> consultarLiquidacionNominaPeriodo(Date fechaInicial, Date fechaFinal) throws Exception;
}
