package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.modelo.HoraExtraEmpleado;
import com.unilever.bancoideas.modelo.dto.HoraExtraEmpleadoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura/
* www.zathuracode.org
*
*/
public interface IHoraExtraEmpleadoLogic {
    public List<HoraExtraEmpleado> getHoraExtraEmpleado()
        throws Exception;

    /**
         * Save an new HoraExtraEmpleado entity
         */
    public void saveHoraExtraEmpleado(HoraExtraEmpleado entity)
        throws Exception;

    /**
         * Delete an existing HoraExtraEmpleado entity
         *
         */
    public void deleteHoraExtraEmpleado(HoraExtraEmpleado entity)
        throws Exception;

    /**
        * Update an existing HoraExtraEmpleado entity
        *
        */
    public void updateHoraExtraEmpleado(HoraExtraEmpleado entity)
        throws Exception;

    /**
         * Load an existing HoraExtraEmpleado entity
         *
         */
    public HoraExtraEmpleado getHoraExtraEmpleado(Integer hexmId)
        throws Exception;

    public List<HoraExtraEmpleado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<HoraExtraEmpleado> findPageHoraExtraEmpleado(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberHoraExtraEmpleado() throws Exception;

    public List<HoraExtraEmpleadoDTO> getDataHoraExtraEmpleado()
        throws Exception;
    
    public List<HoraExtraEmpleadoDTO> consultarHorasExtrasPeriodo(String estado, Date fechaInicial, Date fechaFinal,  Integer emplId) throws Exception;
}
