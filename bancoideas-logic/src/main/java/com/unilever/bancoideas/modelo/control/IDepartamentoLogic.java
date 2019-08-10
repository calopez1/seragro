package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.modelo.Departamento;
import com.unilever.bancoideas.modelo.dto.DepartamentoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IDepartamentoLogic {
    public List<Departamento> getDepartamento() throws Exception;

    /**
         * Save an new Departamento entity
         */
    public void saveDepartamento(Departamento entity) throws Exception;

    /**
         * Delete an existing Departamento entity
         *
         */
    public void deleteDepartamento(Departamento entity)
        throws Exception;

    /**
        * Update an existing Departamento entity
        *
        */
    public void updateDepartamento(Departamento entity)
        throws Exception;

    /**
         * Load an existing Departamento entity
         *
         */
    public Departamento getDepartamento(Integer depaId)
        throws Exception;

    public List<Departamento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Departamento> findPageDepartamento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDepartamento() throws Exception;

    public List<DepartamentoDTO> getDataDepartamento()
        throws Exception;
}
