package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.modelo.LiquidacionHoraExtra;
import com.unilever.bancoideas.modelo.dto.LiquidacionHoraExtraDTO;

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
public interface ILiquidacionHoraExtraLogic {
    public List<LiquidacionHoraExtra> getLiquidacionHoraExtra()
        throws Exception;

    /**
         * Save an new LiquidacionHoraExtra entity
         */
    public void saveLiquidacionHoraExtra(LiquidacionHoraExtra entity)
        throws Exception;

    /**
         * Delete an existing LiquidacionHoraExtra entity
         *
         */
    public void deleteLiquidacionHoraExtra(LiquidacionHoraExtra entity)
        throws Exception;

    /**
        * Update an existing LiquidacionHoraExtra entity
        *
        */
    public void updateLiquidacionHoraExtra(LiquidacionHoraExtra entity)
        throws Exception;

    /**
         * Load an existing LiquidacionHoraExtra entity
         *
         */
    public LiquidacionHoraExtra getLiquidacionHoraExtra(Integer lhoeId)
        throws Exception;

    public List<LiquidacionHoraExtra> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<LiquidacionHoraExtra> findPageLiquidacionHoraExtra(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberLiquidacionHoraExtra() throws Exception;

    public List<LiquidacionHoraExtraDTO> getDataLiquidacionHoraExtra()
        throws Exception;
    
}
