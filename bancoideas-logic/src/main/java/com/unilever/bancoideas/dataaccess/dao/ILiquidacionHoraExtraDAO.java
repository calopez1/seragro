package com.unilever.bancoideas.dataaccess.dao;

import com.unilever.bancoideas.dataaccess.api.Dao;
import com.unilever.bancoideas.modelo.LiquidacionHoraExtra;


/**
* Interface for   LiquidacionHoraExtraDAO.
*
*/
public interface ILiquidacionHoraExtraDAO extends Dao<LiquidacionHoraExtra, Integer> {
	
	public void eliminarDetalleLiquidacionHorasExtras(Integer noemId) throws Exception;
}
