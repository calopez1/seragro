package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.dataaccess.dao.*;
import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.TipoHoraExtraDTO;
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
@Service("TipoHoraExtraLogic")
public class TipoHoraExtraLogic implements ITipoHoraExtraLogic {
    private static final Logger log = LoggerFactory.getLogger(TipoHoraExtraLogic.class);

    /**
     * DAO injected by Spring that manages TipoHoraExtra entities
     *
     */
    @Autowired
    private ITipoHoraExtraDAO tipoHoraExtraDAO;

    /**
    * DAO injected by Spring that manages LiquidacionHoraExtra entities
    *
    */
    @Autowired
    private ILiquidacionHoraExtraDAO liquidacionHoraExtraDAO;

    @Transactional(readOnly = true)
    public List<TipoHoraExtra> getTipoHoraExtra() throws Exception {
        log.debug("finding all TipoHoraExtra instances");

        List<TipoHoraExtra> list = new ArrayList<TipoHoraExtra>();

        try {
            list = tipoHoraExtraDAO.findAll();
        } catch (Exception e) {
            log.error("finding all TipoHoraExtra failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "TipoHoraExtra");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTipoHoraExtra(TipoHoraExtra entity)
        throws Exception {
        log.debug("saving TipoHoraExtra instance");

        try {
            if (entity.getCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("codigo");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
            }

            if (entity.getDescripcion() == null) {
                throw new ZMessManager().new EmptyFieldException("descripcion");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
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

            if (entity.getPorcentaje() == null) {
                throw new ZMessManager().new EmptyFieldException("porcentaje");
            }

            if ((entity.getPorcentaje() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getPorcentaje(), 5, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "porcentaje");
            }

            if (entity.getThoeId() == null) {
                throw new ZMessManager().new EmptyFieldException("thoeId");
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

            if (getTipoHoraExtra(entity.getThoeId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            tipoHoraExtraDAO.save(entity);

            log.debug("save TipoHoraExtra successful");
        } catch (Exception e) {
            log.error("save TipoHoraExtra failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTipoHoraExtra(TipoHoraExtra entity)
        throws Exception {
        log.debug("deleting TipoHoraExtra instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("TipoHoraExtra");
        }

        if (entity.getThoeId() == null) {
            throw new ZMessManager().new EmptyFieldException("thoeId");
        }

        List<LiquidacionHoraExtra> liquidacionHoraExtras = null;

        try {
            liquidacionHoraExtras = liquidacionHoraExtraDAO.findByProperty("tipoHoraExtra.thoeId",
                    entity.getThoeId());

            if (Utilities.validationsList(liquidacionHoraExtras) == true) {
                throw new ZMessManager().new DeletingException(
                    "liquidacionHoraExtras");
            }

            tipoHoraExtraDAO.delete(entity);

            log.debug("delete TipoHoraExtra successful");
        } catch (Exception e) {
            log.error("delete TipoHoraExtra failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTipoHoraExtra(TipoHoraExtra entity)
        throws Exception {
        log.debug("updating TipoHoraExtra instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "TipoHoraExtra");
            }

            if (entity.getCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("codigo");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
            }

            if (entity.getDescripcion() == null) {
                throw new ZMessManager().new EmptyFieldException("descripcion");
            }

            if ((entity.getDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getDescripcion(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcion");
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

            if (entity.getPorcentaje() == null) {
                throw new ZMessManager().new EmptyFieldException("porcentaje");
            }

            if ((entity.getPorcentaje() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getPorcentaje(), 5, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "porcentaje");
            }

            if (entity.getThoeId() == null) {
                throw new ZMessManager().new EmptyFieldException("thoeId");
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

            tipoHoraExtraDAO.update(entity);

            log.debug("update TipoHoraExtra successful");
        } catch (Exception e) {
            log.error("update TipoHoraExtra failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TipoHoraExtraDTO> getDataTipoHoraExtra()
        throws Exception {
        try {
            List<TipoHoraExtra> tipoHoraExtra = tipoHoraExtraDAO.findAll();

            List<TipoHoraExtraDTO> tipoHoraExtraDTO = new ArrayList<TipoHoraExtraDTO>();

            for (TipoHoraExtra tipoHoraExtraTmp : tipoHoraExtra) {
                TipoHoraExtraDTO tipoHoraExtraDTO2 = new TipoHoraExtraDTO();

                tipoHoraExtraDTO2.setThoeId(tipoHoraExtraTmp.getThoeId());
                tipoHoraExtraDTO2.setCodigo((tipoHoraExtraTmp.getCodigo() != null)
                    ? tipoHoraExtraTmp.getCodigo() : null);
                tipoHoraExtraDTO2.setDescripcion((tipoHoraExtraTmp.getDescripcion() != null)
                    ? tipoHoraExtraTmp.getDescripcion() : null);
                tipoHoraExtraDTO2.setEstadoRegistro((tipoHoraExtraTmp.getEstadoRegistro() != null)
                    ? tipoHoraExtraTmp.getEstadoRegistro() : null);
                tipoHoraExtraDTO2.setFechaCreacion(tipoHoraExtraTmp.getFechaCreacion());
                tipoHoraExtraDTO2.setFechaModificacion(tipoHoraExtraTmp.getFechaModificacion());
                tipoHoraExtraDTO2.setPorcentaje((tipoHoraExtraTmp.getPorcentaje() != null)
                    ? tipoHoraExtraTmp.getPorcentaje() : null);
                tipoHoraExtraDTO2.setUsuCreador((tipoHoraExtraTmp.getUsuCreador() != null)
                    ? tipoHoraExtraTmp.getUsuCreador() : null);
                tipoHoraExtraDTO2.setUsuModificador((tipoHoraExtraTmp.getUsuModificador() != null)
                    ? tipoHoraExtraTmp.getUsuModificador() : null);
                tipoHoraExtraDTO.add(tipoHoraExtraDTO2);
            }

            return tipoHoraExtraDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TipoHoraExtra getTipoHoraExtra(Integer thoeId)
        throws Exception {
        log.debug("getting TipoHoraExtra instance");

        TipoHoraExtra entity = null;

        try {
            entity = tipoHoraExtraDAO.findById(thoeId);
        } catch (Exception e) {
            log.error("get TipoHoraExtra failed", e);
            throw new ZMessManager().new FindingException("TipoHoraExtra");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<TipoHoraExtra> findPageTipoHoraExtra(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<TipoHoraExtra> entity = null;

        try {
            entity = tipoHoraExtraDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("TipoHoraExtra Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTipoHoraExtra() throws Exception {
        Long entity = null;

        try {
            entity = tipoHoraExtraDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("TipoHoraExtra Count");
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
    public List<TipoHoraExtra> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<TipoHoraExtra> list = new ArrayList<TipoHoraExtra>();
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
            list = tipoHoraExtraDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
