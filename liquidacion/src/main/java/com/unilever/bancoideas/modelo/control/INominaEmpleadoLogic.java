package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.modelo.NominaEmpleado;
import com.unilever.bancoideas.modelo.dto.NominaEmpleadoDTO;

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
public interface INominaEmpleadoLogic {
    public List<NominaEmpleado> getNominaEmpleado() throws Exception;

    /**
         * Save an new NominaEmpleado entity
         */
    public void saveNominaEmpleado(NominaEmpleado entity)
        throws Exception;

    /**
         * Delete an existing NominaEmpleado entity
         *
         */
    public void deleteNominaEmpleado(NominaEmpleado entity)
        throws Exception;

    /**
        * Update an existing NominaEmpleado entity
        *
        */
    public void updateNominaEmpleado(NominaEmpleado entity)
        throws Exception;

    /**
         * Load an existing NominaEmpleado entity
         *
         */
    public NominaEmpleado getNominaEmpleado(Integer noemId)
        throws Exception;

    public List<NominaEmpleado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<NominaEmpleado> findPageNominaEmpleado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberNominaEmpleado() throws Exception;

    public List<NominaEmpleadoDTO> getDataNominaEmpleado()
        throws Exception;
}
