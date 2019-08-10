package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.modelo.Parametros;
import com.unilever.bancoideas.modelo.dto.ParametrosDTO;

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
public interface IParametrosLogic {
    public List<Parametros> getParametros() throws Exception;

    /**
         * Save an new Parametros entity
         */
    public void saveParametros(Parametros entity) throws Exception;

    /**
         * Delete an existing Parametros entity
         *
         */
    public void deleteParametros(Parametros entity) throws Exception;

    /**
        * Update an existing Parametros entity
        *
        */
    public void updateParametros(Parametros entity) throws Exception;

    /**
         * Load an existing Parametros entity
         *
         */
    public Parametros getParametros(Integer paraId) throws Exception;

    public List<Parametros> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Parametros> findPageParametros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberParametros() throws Exception;

    public List<ParametrosDTO> getDataParametros() throws Exception;
}
