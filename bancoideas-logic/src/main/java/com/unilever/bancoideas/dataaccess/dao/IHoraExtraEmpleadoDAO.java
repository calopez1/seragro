package com.unilever.bancoideas.dataaccess.dao;

import java.util.Date;
import java.util.List;

import com.unilever.bancoideas.dataaccess.api.Dao;
import com.unilever.bancoideas.modelo.HoraExtraEmpleado;
import com.unilever.bancoideas.modelo.dto.HoraExtraEmpleadoDTO;


/**
* Interface for   HoraExtraEmpleadoDAO.
*
*/
public interface IHoraExtraEmpleadoDAO extends Dao<HoraExtraEmpleado, Integer> {
	public List<HoraExtraEmpleadoDTO> consultarHorasExtrasPeriodo(String estado, String fechaInicial, String fechaFinal, Integer emplId) throws Exception;
}
