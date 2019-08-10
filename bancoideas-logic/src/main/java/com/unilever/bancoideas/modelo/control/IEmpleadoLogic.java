package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.modelo.Empleado;
import com.unilever.bancoideas.modelo.Persona;
import com.unilever.bancoideas.modelo.dto.EmpleadoDTO;

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
public interface IEmpleadoLogic {
    public List<Empleado> getEmpleado() throws Exception;

    /**
         * Save an new Empleado entity
         */
    public void saveEmpleado(Empleado entity) throws Exception;

    /**
         * Delete an existing Empleado entity
         *
         */
    public void deleteEmpleado(Empleado entity) throws Exception;

    /**
        * Update an existing Empleado entity
        *
        */
    public void updateEmpleado(Empleado entity) throws Exception;

    /**
         * Load an existing Empleado entity
         *
         */
    public Empleado getEmpleado(Integer emplId) throws Exception;

    public List<Empleado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Empleado> findPageEmpleado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEmpleado() throws Exception;

    public List<EmpleadoDTO> getDataEmpleado() throws Exception;
    
    public void guardarEmpleado(Persona persona, Empleado empleado) throws Exception;
}
