package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.dataaccess.dao.*;
import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.NominaEmpleadoDTO;
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
@Service("NominaEmpleadoLogic")
public class NominaEmpleadoLogic implements INominaEmpleadoLogic {
    private static final Logger log = LoggerFactory.getLogger(NominaEmpleadoLogic.class);

    /**
     * DAO injected by Spring that manages NominaEmpleado entities
     *
     */
    @Autowired
    private INominaEmpleadoDAO nominaEmpleadoDAO;

    /**
    * DAO injected by Spring that manages DetalleNominaEmpleado entities
    *
    */
    @Autowired
    private IDetalleNominaEmpleadoDAO detalleNominaEmpleadoDAO;

    /**
    * DAO injected by Spring that manages LiquidacionHoraExtra entities
    *
    */
    @Autowired
    private ILiquidacionHoraExtraDAO liquidacionHoraExtraDAO;

    /**
    * Logic injected by Spring that manages Empleado entities
    *
    */
    @Autowired
    IEmpleadoLogic logicEmpleado1;

    /**
    * Logic injected by Spring that manages LiquidacionNomina entities
    *
    */
    @Autowired
    ILiquidacionNominaLogic logicLiquidacionNomina2;

    @Transactional(readOnly = true)
    public List<NominaEmpleado> getNominaEmpleado() throws Exception {
        log.debug("finding all NominaEmpleado instances");

        List<NominaEmpleado> list = new ArrayList<NominaEmpleado>();

        try {
            list = nominaEmpleadoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all NominaEmpleado failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "NominaEmpleado");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveNominaEmpleado(NominaEmpleado entity)
        throws Exception {
        log.debug("saving NominaEmpleado instance");

        try {
            if (entity.getEmpleado() == null) {
                throw new ZMessManager().new ForeignException("empleado");
            }

            if (entity.getLiquidacionNomina() == null) {
                throw new ZMessManager().new ForeignException(
                    "liquidacionNomina");
            }

            if (entity.getDeducciones() == null) {
                throw new ZMessManager().new EmptyFieldException("deducciones");
            }

            if (entity.getDiasLaborados() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "diasLaborados");
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

            if (entity.getNoemId() == null) {
                throw new ZMessManager().new EmptyFieldException("noemId");
            }

            if (entity.getTotalPagar() == null) {
                throw new ZMessManager().new EmptyFieldException("totalPagar");
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

            if (entity.getEmpleado().getEmplId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "emplId_Empleado");
            }

            if (entity.getLiquidacionNomina().getLinoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "linoId_LiquidacionNomina");
            }

            if (getNominaEmpleado(entity.getNoemId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            nominaEmpleadoDAO.save(entity);

            log.debug("save NominaEmpleado successful");
        } catch (Exception e) {
            log.error("save NominaEmpleado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteNominaEmpleado(NominaEmpleado entity)
        throws Exception {
        log.debug("deleting NominaEmpleado instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("NominaEmpleado");
        }

        if (entity.getNoemId() == null) {
            throw new ZMessManager().new EmptyFieldException("noemId");
        }

        List<DetalleNominaEmpleado> detalleNominaEmpleados = null;
        List<LiquidacionHoraExtra> liquidacionHoraExtras = null;

        try {
            detalleNominaEmpleados = detalleNominaEmpleadoDAO.findByProperty("nominaEmpleado.noemId",
                    entity.getNoemId());

            if (Utilities.validationsList(detalleNominaEmpleados) == true) {
                throw new ZMessManager().new DeletingException(
                    "detalleNominaEmpleados");
            }

            liquidacionHoraExtras = liquidacionHoraExtraDAO.findByProperty("nominaEmpleado.noemId",
                    entity.getNoemId());

            if (Utilities.validationsList(liquidacionHoraExtras) == true) {
                throw new ZMessManager().new DeletingException(
                    "liquidacionHoraExtras");
            }

            nominaEmpleadoDAO.delete(entity);

            log.debug("delete NominaEmpleado successful");
        } catch (Exception e) {
            log.error("delete NominaEmpleado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateNominaEmpleado(NominaEmpleado entity)
        throws Exception {
        log.debug("updating NominaEmpleado instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "NominaEmpleado");
            }

            if (entity.getEmpleado() == null) {
                throw new ZMessManager().new ForeignException("empleado");
            }

            if (entity.getLiquidacionNomina() == null) {
                throw new ZMessManager().new ForeignException(
                    "liquidacionNomina");
            }

            if (entity.getDeducciones() == null) {
                throw new ZMessManager().new EmptyFieldException("deducciones");
            }

            if (entity.getDiasLaborados() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "diasLaborados");
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

            if (entity.getNoemId() == null) {
                throw new ZMessManager().new EmptyFieldException("noemId");
            }

            if (entity.getTotalPagar() == null) {
                throw new ZMessManager().new EmptyFieldException("totalPagar");
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

            if (entity.getEmpleado().getEmplId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "emplId_Empleado");
            }

            if (entity.getLiquidacionNomina().getLinoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "linoId_LiquidacionNomina");
            }

            nominaEmpleadoDAO.update(entity);

            log.debug("update NominaEmpleado successful");
        } catch (Exception e) {
            log.error("update NominaEmpleado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<NominaEmpleadoDTO> getDataNominaEmpleado()
        throws Exception {
        try {
            List<NominaEmpleado> nominaEmpleado = nominaEmpleadoDAO.findAll();

            List<NominaEmpleadoDTO> nominaEmpleadoDTO = new ArrayList<NominaEmpleadoDTO>();

            for (NominaEmpleado nominaEmpleadoTmp : nominaEmpleado) {
                NominaEmpleadoDTO nominaEmpleadoDTO2 = new NominaEmpleadoDTO();

                nominaEmpleadoDTO2.setNoemId(nominaEmpleadoTmp.getNoemId());
                nominaEmpleadoDTO2.setDeducciones((nominaEmpleadoTmp.getDeducciones() != null)
                    ? nominaEmpleadoTmp.getDeducciones() : null);
                nominaEmpleadoDTO2.setDiasLaborados((nominaEmpleadoTmp.getDiasLaborados() != null)
                    ? nominaEmpleadoTmp.getDiasLaborados() : null);
                nominaEmpleadoDTO2.setEstadoRegistro((nominaEmpleadoTmp.getEstadoRegistro() != null)
                    ? nominaEmpleadoTmp.getEstadoRegistro() : null);
                nominaEmpleadoDTO2.setFechaCreacion(nominaEmpleadoTmp.getFechaCreacion());
                nominaEmpleadoDTO2.setFechaModificacion(nominaEmpleadoTmp.getFechaModificacion());
                nominaEmpleadoDTO2.setTotalPagar((nominaEmpleadoTmp.getTotalPagar() != null)
                    ? nominaEmpleadoTmp.getTotalPagar() : null);
                nominaEmpleadoDTO2.setUsuCreador((nominaEmpleadoTmp.getUsuCreador() != null)
                    ? nominaEmpleadoTmp.getUsuCreador() : null);
                nominaEmpleadoDTO2.setUsuModificador((nominaEmpleadoTmp.getUsuModificador() != null)
                    ? nominaEmpleadoTmp.getUsuModificador() : null);
                nominaEmpleadoDTO2.setEmplId((nominaEmpleadoTmp.getEmpleado()
                                                                        .getEmplId() != null)
                    ? nominaEmpleadoTmp.getEmpleado().getEmplId() : null);
                nominaEmpleadoDTO2.setLinoId_LiquidacionNomina((nominaEmpleadoTmp.getLiquidacionNomina()
                                                                                 .getLinoId() != null)
                    ? nominaEmpleadoTmp.getLiquidacionNomina().getLinoId() : null);
                nominaEmpleadoDTO.add(nominaEmpleadoDTO2);
            }

            return nominaEmpleadoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public NominaEmpleado getNominaEmpleado(Integer noemId)
        throws Exception {
        log.debug("getting NominaEmpleado instance");

        NominaEmpleado entity = null;

        try {
            entity = nominaEmpleadoDAO.findById(noemId);
        } catch (Exception e) {
            log.error("get NominaEmpleado failed", e);
            throw new ZMessManager().new FindingException("NominaEmpleado");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<NominaEmpleado> findPageNominaEmpleado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<NominaEmpleado> entity = null;

        try {
            entity = nominaEmpleadoDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "NominaEmpleado Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberNominaEmpleado() throws Exception {
        Long entity = null;

        try {
            entity = nominaEmpleadoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "NominaEmpleado Count");
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
    public List<NominaEmpleado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<NominaEmpleado> list = new ArrayList<NominaEmpleado>();
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
            list = nominaEmpleadoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    @Transactional(readOnly=true)
    public List<NominaEmpleadoDTO> consultarLiquidacionNominaEmpleadoXLiquidacionNomina(Integer linoId) throws Exception {
    	
    	List<NominaEmpleadoDTO> lstEmpleado = null;
    	
    	try {
			
    		if(linoId == null) {
    			throw new Exception("Se debe ingresar una liquidación de nomina");
    		}
    		
    		lstEmpleado = nominaEmpleadoDAO.consultarLiquidacionNominaEmpleadoXLiquidacionNomina(linoId);
    		
    		return lstEmpleado;
		} catch (Exception e) {
			throw e;
		}
    }
}
