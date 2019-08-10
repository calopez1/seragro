package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.modelo.LiquidacionNomina;
import com.unilever.bancoideas.modelo.dto.LiquidacionNominaDTO;

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
public interface ILiquidacionNominaLogic {
    public List<LiquidacionNomina> getLiquidacionNomina()
        throws Exception;

    /**
         * Save an new LiquidacionNomina entity
         */
    public void saveLiquidacionNomina(LiquidacionNomina entity)
        throws Exception;

    /**
         * Delete an existing LiquidacionNomina entity
         *
         */
    public void deleteLiquidacionNomina(LiquidacionNomina entity)
        throws Exception;

    /**
        * Update an existing LiquidacionNomina entity
        *
        */
    public void updateLiquidacionNomina(LiquidacionNomina entity)
        throws Exception;

    /**
         * Load an existing LiquidacionNomina entity
         *
         */
    public LiquidacionNomina getLiquidacionNomina(Integer linoId)
        throws Exception;

    public List<LiquidacionNomina> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<LiquidacionNomina> findPageLiquidacionNomina(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberLiquidacionNomina() throws Exception;

    public List<LiquidacionNominaDTO> getDataLiquidacionNomina()
        throws Exception;
}
