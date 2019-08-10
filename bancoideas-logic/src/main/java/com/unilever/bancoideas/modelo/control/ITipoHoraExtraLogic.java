package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.modelo.TipoHoraExtra;
import com.unilever.bancoideas.modelo.dto.TipoHoraExtraDTO;

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
public interface ITipoHoraExtraLogic {
    public List<TipoHoraExtra> getTipoHoraExtra() throws Exception;

    /**
         * Save an new TipoHoraExtra entity
         */
    public void saveTipoHoraExtra(TipoHoraExtra entity)
        throws Exception;

    /**
         * Delete an existing TipoHoraExtra entity
         *
         */
    public void deleteTipoHoraExtra(TipoHoraExtra entity)
        throws Exception;

    /**
        * Update an existing TipoHoraExtra entity
        *
        */
    public void updateTipoHoraExtra(TipoHoraExtra entity)
        throws Exception;

    /**
         * Load an existing TipoHoraExtra entity
         *
         */
    public TipoHoraExtra getTipoHoraExtra(Integer thoeId)
        throws Exception;

    public List<TipoHoraExtra> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoHoraExtra> findPageTipoHoraExtra(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoHoraExtra() throws Exception;

    public List<TipoHoraExtraDTO> getDataTipoHoraExtra()
        throws Exception;
}
