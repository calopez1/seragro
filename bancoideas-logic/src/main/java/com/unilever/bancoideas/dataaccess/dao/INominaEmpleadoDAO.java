package com.unilever.bancoideas.dataaccess.dao;

import java.util.List;

import com.unilever.bancoideas.dataaccess.api.Dao;
import com.unilever.bancoideas.modelo.NominaEmpleado;
import com.unilever.bancoideas.modelo.dto.NominaEmpleadoDTO;


/**
* Interface for   NominaEmpleadoDAO.
*
*/
public interface INominaEmpleadoDAO extends Dao<NominaEmpleado, Integer> {
	public List<NominaEmpleadoDTO> consultarLiquidacionNominaEmpleadoXLiquidacionNomina(Integer linoId) throws Exception ;
	public void eliminarNominaEmpleado(Integer linoId) throws Exception;
}
