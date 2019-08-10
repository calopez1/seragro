package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.dataaccess.dao.*;
import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.LiquidacionNominaDTO;
import com.unilever.bancoideas.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("LiquidacionNominaLogic")
public class LiquidacionNominaLogic implements ILiquidacionNominaLogic {
    private static final Logger log = LoggerFactory.getLogger(LiquidacionNominaLogic.class);

    /**
     * DAO injected by Spring that manages LiquidacionNomina entities
     *
     */
    @Autowired
    private ILiquidacionNominaDAO liquidacionNominaDAO;

    /**
    * DAO injected by Spring that manages NominaEmpleado entities
    *
    */
    @Autowired
    private INominaEmpleadoDAO nominaEmpleadoDAO;

    @Transactional(readOnly = true)
    public List<LiquidacionNomina> getLiquidacionNomina()
        throws Exception {
        log.debug("finding all LiquidacionNomina instances");

        List<LiquidacionNomina> list = new ArrayList<LiquidacionNomina>();

        try {
            list = liquidacionNominaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all LiquidacionNomina failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "LiquidacionNomina");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveLiquidacionNomina(LiquidacionNomina entity)
        throws Exception {
        log.debug("saving LiquidacionNomina instance");

        try {
            if (entity.getCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("codigo");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if (entity.getDiasNomina() == null) {
                throw new ZMessManager().new EmptyFieldException("diasNomina");
            }

            if (entity.getEstadoRegistro() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "estadoRegistro");
            }

            if ((entity.getEstadoRegistro() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEstadoRegistro(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "estadoRegistro");
            }

            if (entity.getFechaCreacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechaCreacion");
            }

            if (entity.getFechaFin() == null) {
                throw new ZMessManager().new EmptyFieldException("fechaFin");
            }

            if (entity.getFechaInicio() == null) {
                throw new ZMessManager().new EmptyFieldException("fechaInicio");
            }

            if (entity.getLinoId() == null) {
                throw new ZMessManager().new EmptyFieldException("linoId");
            }

            if (entity.getUsuCreador() == null) {
                throw new ZMessManager().new EmptyFieldException("usuCreador");
            }

            if ((entity.getUsuCreador() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuCreador(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "usuCreador");
            }

            if ((entity.getUsuModificador() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuModificador(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "usuModificador");
            }

            if (getLiquidacionNomina(entity.getLinoId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            liquidacionNominaDAO.save(entity);

            log.debug("save LiquidacionNomina successful");
        } catch (Exception e) {
            log.error("save LiquidacionNomina failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteLiquidacionNomina(LiquidacionNomina entity)
        throws Exception {
        log.debug("deleting LiquidacionNomina instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "LiquidacionNomina");
        }

        if (entity.getLinoId() == null) {
            throw new ZMessManager().new EmptyFieldException("linoId");
        }

        List<NominaEmpleado> nominaEmpleados = null;

        try {
            nominaEmpleados = nominaEmpleadoDAO.findByProperty("liquidacionNomina.linoId",
                    entity.getLinoId());

            if (Utilities.validationsList(nominaEmpleados) == true) {
                throw new ZMessManager().new DeletingException(
                    "nominaEmpleados");
            }

            liquidacionNominaDAO.delete(entity);

            log.debug("delete LiquidacionNomina successful");
        } catch (Exception e) {
            log.error("delete LiquidacionNomina failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateLiquidacionNomina(LiquidacionNomina entity)
        throws Exception {
        log.debug("updating LiquidacionNomina instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "LiquidacionNomina");
            }

            if (entity.getCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("codigo");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
            }

            if (entity.getDiasNomina() == null) {
                throw new ZMessManager().new EmptyFieldException("diasNomina");
            }

            if (entity.getEstadoRegistro() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "estadoRegistro");
            }

            if ((entity.getEstadoRegistro() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getEstadoRegistro(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "estadoRegistro");
            }

            if (entity.getFechaCreacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechaCreacion");
            }

            if (entity.getFechaFin() == null) {
                throw new ZMessManager().new EmptyFieldException("fechaFin");
            }

            if (entity.getFechaInicio() == null) {
                throw new ZMessManager().new EmptyFieldException("fechaInicio");
            }

            if (entity.getLinoId() == null) {
                throw new ZMessManager().new EmptyFieldException("linoId");
            }

            if (entity.getUsuCreador() == null) {
                throw new ZMessManager().new EmptyFieldException("usuCreador");
            }

            if ((entity.getUsuCreador() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuCreador(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "usuCreador");
            }

            if ((entity.getUsuModificador() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuModificador(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "usuModificador");
            }

            liquidacionNominaDAO.update(entity);

            log.debug("update LiquidacionNomina successful");
        } catch (Exception e) {
            log.error("update LiquidacionNomina failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<LiquidacionNominaDTO> getDataLiquidacionNomina()
        throws Exception {
        try {
            List<LiquidacionNomina> liquidacionNomina = liquidacionNominaDAO.findAll();

            List<LiquidacionNominaDTO> liquidacionNominaDTO = new ArrayList<LiquidacionNominaDTO>();

            for (LiquidacionNomina liquidacionNominaTmp : liquidacionNomina) {
                LiquidacionNominaDTO liquidacionNominaDTO2 = new LiquidacionNominaDTO();

                liquidacionNominaDTO2.setLinoId(liquidacionNominaTmp.getLinoId());
                liquidacionNominaDTO2.setCodigo((liquidacionNominaTmp.getCodigo() != null)
                    ? liquidacionNominaTmp.getCodigo() : null);
                liquidacionNominaDTO2.setDescripcion((liquidacionNominaTmp.getDescripcion() != null)
                    ? liquidacionNominaTmp.getDescripcion() : null);
                liquidacionNominaDTO2.setDiasNomina((liquidacionNominaTmp.getDiasNomina() != null)
                    ? liquidacionNominaTmp.getDiasNomina() : null);
                liquidacionNominaDTO2.setEstadoRegistro((liquidacionNominaTmp.getEstadoRegistro() != null)
                    ? liquidacionNominaTmp.getEstadoRegistro() : null);
                liquidacionNominaDTO2.setFechaCreacion(liquidacionNominaTmp.getFechaCreacion());
                liquidacionNominaDTO2.setFechaFin(liquidacionNominaTmp.getFechaFin());
                liquidacionNominaDTO2.setFechaInicio(liquidacionNominaTmp.getFechaInicio());
                liquidacionNominaDTO2.setFechaModificacion(liquidacionNominaTmp.getFechaModificacion());
                liquidacionNominaDTO2.setUsuCreador((liquidacionNominaTmp.getUsuCreador() != null)
                    ? liquidacionNominaTmp.getUsuCreador() : null);
                liquidacionNominaDTO2.setUsuModificador((liquidacionNominaTmp.getUsuModificador() != null)
                    ? liquidacionNominaTmp.getUsuModificador() : null);
                liquidacionNominaDTO.add(liquidacionNominaDTO2);
            }

            return liquidacionNominaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public LiquidacionNomina getLiquidacionNomina(Integer linoId)
        throws Exception {
        log.debug("getting LiquidacionNomina instance");

        LiquidacionNomina entity = null;

        try {
            entity = liquidacionNominaDAO.findById(linoId);
        } catch (Exception e) {
            log.error("get LiquidacionNomina failed", e);
            throw new ZMessManager().new FindingException("LiquidacionNomina");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<LiquidacionNomina> findPageLiquidacionNomina(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<LiquidacionNomina> entity = null;

        try {
            entity = liquidacionNominaDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "LiquidacionNomina Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberLiquidacionNomina() throws Exception {
        Long entity = null;

        try {
            entity = liquidacionNominaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "LiquidacionNomina Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<LiquidacionNomina> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<LiquidacionNomina> list = new ArrayList<LiquidacionNomina>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = liquidacionNominaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
