package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.modelo.DetalleNominaEmpleado;
import com.unilever.bancoideas.modelo.dto.DetalleNominaEmpleadoDTO;

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
public interface IDetalleNominaEmpleadoLogic {
    public List<DetalleNominaEmpleado> getDetalleNominaEmpleado()
        throws Exception;

    /**
         * Save an new DetalleNominaEmpleado entity
         */
    public void saveDetalleNominaEmpleado(DetalleNominaEmpleado entity)
        throws Exception;

    /**
         * Delete an existing DetalleNominaEmpleado entity
         *
         */
    public void deleteDetalleNominaEmpleado(DetalleNominaEmpleado entity)
        throws Exception;

    /**
        * Update an existing DetalleNominaEmpleado entity
        *
        */
    public void updateDetalleNominaEmpleado(DetalleNominaEmpleado entity)
        throws Exception;

    /**
         * Load an existing DetalleNominaEmpleado entity
         *
         */
    public DetalleNominaEmpleado getDetalleNominaEmpleado(Integer dnoeId)
        throws Exception;

    public List<DetalleNominaEmpleado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DetalleNominaEmpleado> findPageDetalleNominaEmpleado(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDetalleNominaEmpleado()
        throws Exception;

    public List<DetalleNominaEmpleadoDTO> getDataDetalleNominaEmpleado()
        throws Exception;
}
