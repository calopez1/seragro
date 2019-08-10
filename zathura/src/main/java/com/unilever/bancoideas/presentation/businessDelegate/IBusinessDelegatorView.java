package com.unilever.bancoideas.presentation.businessDelegate;

import com.unilever.bancoideas.modelo.Parametros;
import com.unilever.bancoideas.modelo.control.IParametrosLogic;
import com.unilever.bancoideas.modelo.control.ParametrosLogic;
import com.unilever.bancoideas.modelo.dto.ParametrosDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura/
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Parametros> getParametros() throws Exception;

    public void saveParametros(Parametros entity) throws Exception;

    public void deleteParametros(Parametros entity) throws Exception;

    public void updateParametros(Parametros entity) throws Exception;

    public Parametros getParametros(Integer paraId) throws Exception;

    public List<Parametros> findByCriteriaInParametros(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Parametros> findPageParametros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberParametros() throws Exception;

    public List<ParametrosDTO> getDataParametros() throws Exception;
}
