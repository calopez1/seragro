package com.unilever.bancoideas.dataaccess.dao;

import com.unilever.bancoideas.dataaccess.api.Dao;
import com.unilever.bancoideas.modelo.DetalleNominaEmpleado;


/**
* Interface for   DetalleNominaEmpleadoDAO.
*
*/
public interface IDetalleNominaEmpleadoDAO extends Dao<DetalleNominaEmpleado, Integer> {
	
    public void eliminarDetalleLiquidacionNomina(Integer noemId) throws Exception;

}
