package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.modelo.Persona;
import com.unilever.bancoideas.modelo.dto.PersonaDTO;

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
public interface IPersonaLogic {
    public List<Persona> getPersona() throws Exception;

    /**
         * Save an new Persona entity
         */
    public Persona savePersona(Persona entity) throws Exception;

    /**
         * Delete an existing Persona entity
         *
         */
    public void deletePersona(Persona entity) throws Exception;

    /**
        * Update an existing Persona entity
        *
        */
    public void updatePersona(Persona entity) throws Exception;

    /**
         * Load an existing Persona entity
         *
         */
    public Persona getPersona(Integer persId) throws Exception;

    public List<Persona> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Persona> findPagePersona(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPersona() throws Exception;

    public List<PersonaDTO> getDataPersona() throws Exception;
}
