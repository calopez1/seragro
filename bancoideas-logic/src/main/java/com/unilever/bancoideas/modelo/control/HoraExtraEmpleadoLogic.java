package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.dataaccess.dao.*;
import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.HoraExtraEmpleadoDTO;
import com.unilever.bancoideas.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
@Service("HoraExtraEmpleadoLogic")
public class HoraExtraEmpleadoLogic implements IHoraExtraEmpleadoLogic {
    private static final Logger log = LoggerFactory.getLogger(HoraExtraEmpleadoLogic.class);

    /**
     * DAO injected by Spring that manages HoraExtraEmpleado entities
     *
     */
    @Autowired
    private IHoraExtraEmpleadoDAO horaExtraEmpleadoDAO;

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
    * Logic injected by Spring that manages TipoHoraExtra entities
    *
    */
    @Autowired
    ITipoHoraExtraLogic logicTipoHoraExtra2;

    @Transactional(readOnly = true)
    public List<HoraExtraEmpleado> getHoraExtraEmpleado()
        throws Exception {
        log.debug("finding all HoraExtraEmpleado instances");

        List<HoraExtraEmpleado> list = new ArrayList<HoraExtraEmpleado>();

        try {
            list = horaExtraEmpleadoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all HoraExtraEmpleado failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "HoraExtraEmpleado");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveHoraExtraEmpleado(HoraExtraEmpleado entity)
        throws Exception {
        log.debug("saving HoraExtraEmpleado instance");

        try {
            if (entity.getEmpleado() == null) {
                throw new ZMessManager().new ForeignException("empleado");
            }

            if (entity.getTipoHoraExtra() == null) {
                throw new ZMessManager().new ForeignException("tipoHoraExtra");
            }

            if (entity.getCantidadHoras() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "cantidadHoras");
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

            if (entity.getFecha() == null) {
                throw new ZMessManager().new EmptyFieldException("fecha");
            }

            if (entity.getFechaCreacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechaCreacion");
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

            if (entity.getTipoHoraExtra().getThoeId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "thoeId_TipoHoraExtra");
            }

            horaExtraEmpleadoDAO.save(entity);

            log.debug("save HoraExtraEmpleado successful");
        } catch (Exception e) {
            log.error("save HoraExtraEmpleado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteHoraExtraEmpleado(HoraExtraEmpleado entity)
        throws Exception {
        log.debug("deleting HoraExtraEmpleado instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "HoraExtraEmpleado");
        }

        if (entity.getHexmId() == null) {
            throw new ZMessManager().new EmptyFieldException("hexmId");
        }

        List<LiquidacionHoraExtra> liquidacionHoraExtras = null;

        try {
            liquidacionHoraExtras = liquidacionHoraExtraDAO.findByProperty("horaExtraEmpleado.hexmId",
                    entity.getHexmId());

            if (Utilities.validationsList(liquidacionHoraExtras) == true) {
                throw new ZMessManager().new DeletingException(
                    "liquidacionHoraExtras");
            }

            horaExtraEmpleadoDAO.delete(entity);

            log.debug("delete HoraExtraEmpleado successful");
        } catch (Exception e) {
            log.error("delete HoraExtraEmpleado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateHoraExtraEmpleado(HoraExtraEmpleado entity)
        throws Exception {
        log.debug("updating HoraExtraEmpleado instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "HoraExtraEmpleado");
            }

            if (entity.getEmpleado() == null) {
                throw new ZMessManager().new ForeignException("empleado");
            }

            if (entity.getTipoHoraExtra() == null) {
                throw new ZMessManager().new ForeignException("tipoHoraExtra");
            }

            if (entity.getCantidadHoras() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "cantidadHoras");
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

            if (entity.getFecha() == null) {
                throw new ZMessManager().new EmptyFieldException("fecha");
            }

            if (entity.getFechaCreacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "fechaCreacion");
            }

            if (entity.getHexmId() == null) {
                throw new ZMessManager().new EmptyFieldException("hexmId");
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

            if (entity.getTipoHoraExtra().getThoeId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "thoeId_TipoHoraExtra");
            }

            horaExtraEmpleadoDAO.update(entity);

            log.debug("update HoraExtraEmpleado successful");
        } catch (Exception e) {
            log.error("update HoraExtraEmpleado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<HoraExtraEmpleadoDTO> getDataHoraExtraEmpleado()
        throws Exception {
        try {
            List<HoraExtraEmpleado> horaExtraEmpleado = horaExtraEmpleadoDAO.findAll();

            List<HoraExtraEmpleadoDTO> horaExtraEmpleadoDTO = new ArrayList<HoraExtraEmpleadoDTO>();

            for (HoraExtraEmpleado horaExtraEmpleadoTmp : horaExtraEmpleado) {
                HoraExtraEmpleadoDTO horaExtraEmpleadoDTO2 = new HoraExtraEmpleadoDTO();

                horaExtraEmpleadoDTO2.setHexmId(horaExtraEmpleadoTmp.getHexmId());
                horaExtraEmpleadoDTO2.setCantidadHoras((horaExtraEmpleadoTmp.getCantidadHoras() != null)
                    ? horaExtraEmpleadoTmp.getCantidadHoras() : null);
                horaExtraEmpleadoDTO2.setEstadoRegistro((horaExtraEmpleadoTmp.getEstadoRegistro() != null)
                    ? horaExtraEmpleadoTmp.getEstadoRegistro() : null);
                horaExtraEmpleadoDTO2.setFecha(horaExtraEmpleadoTmp.getFecha());
                horaExtraEmpleadoDTO2.setFechaCreacion(horaExtraEmpleadoTmp.getFechaCreacion());
                horaExtraEmpleadoDTO2.setFechaModificacion(horaExtraEmpleadoTmp.getFechaModificacion());
                horaExtraEmpleadoDTO2.setUsuCreador((horaExtraEmpleadoTmp.getUsuCreador() != null)
                    ? horaExtraEmpleadoTmp.getUsuCreador() : null);
                horaExtraEmpleadoDTO2.setUsuModificador((horaExtraEmpleadoTmp.getUsuModificador() != null)
                    ? horaExtraEmpleadoTmp.getUsuModificador() : null);
                horaExtraEmpleadoDTO2.setEmplId((horaExtraEmpleadoTmp.getEmpleado()
                                                                              .getEmplId() != null)
                    ? horaExtraEmpleadoTmp.getEmpleado().getEmplId() : null);
                horaExtraEmpleadoDTO2.setThoeId((horaExtraEmpleadoTmp.getTipoHoraExtra() .getThoeId() != null)
                    ? horaExtraEmpleadoTmp.getTipoHoraExtra().getThoeId() : null);
                
                horaExtraEmpleadoDTO2.setDescripcionTipoHoraExtra((horaExtraEmpleadoTmp.getTipoHoraExtra().getDescripcion() != null)
                        ? horaExtraEmpleadoTmp.getTipoHoraExtra().getDescripcion() : null);
                
                horaExtraEmpleadoDTO2.setIdentificacionEmpleado((horaExtraEmpleadoTmp.getEmpleado().getPersona().getIdentificacion() != null)
                        ? horaExtraEmpleadoTmp.getEmpleado().getPersona().getIdentificacion() : null);
                
                String nombre = (horaExtraEmpleadoTmp.getEmpleado().getPersona().getPrimerApellido())+
                				(horaExtraEmpleadoTmp.getEmpleado().getPersona().getSegundoApellido() == null ? "": " "+horaExtraEmpleadoTmp.getEmpleado().getPersona().getSegundoApellido())+
                				(horaExtraEmpleadoTmp.getEmpleado().getPersona().getPrimerNombre())+
                				(horaExtraEmpleadoTmp.getEmpleado().getPersona().getSegundoNombre() == null ? "": " "+horaExtraEmpleadoTmp.getEmpleado().getPersona().getSegundoNombre());
                
                horaExtraEmpleadoDTO2.setNombreEmpleado((horaExtraEmpleadoTmp.getEmpleado().getPersona().getPrimerNombre() != null)
                        ? nombre : null);
                
                horaExtraEmpleadoDTO2.setCodigoEmpleado((horaExtraEmpleadoTmp.getEmpleado().getCodigo() != null)
                        ? horaExtraEmpleadoTmp.getEmpleado().getCodigo() : null);
                
                horaExtraEmpleadoDTO.add(horaExtraEmpleadoDTO2);
            }

            return horaExtraEmpleadoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public HoraExtraEmpleado getHoraExtraEmpleado(Integer hexmId)
        throws Exception {
        log.debug("getting HoraExtraEmpleado instance");

        HoraExtraEmpleado entity = null;

        try {
            entity = horaExtraEmpleadoDAO.findById(hexmId);
        } catch (Exception e) {
            log.error("get HoraExtraEmpleado failed", e);
            throw new ZMessManager().new FindingException("HoraExtraEmpleado");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<HoraExtraEmpleado> findPageHoraExtraEmpleado(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<HoraExtraEmpleado> entity = null;

        try {
            entity = horaExtraEmpleadoDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "HoraExtraEmpleado Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberHoraExtraEmpleado() throws Exception {
        Long entity = null;

        try {
            entity = horaExtraEmpleadoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "HoraExtraEmpleado Count");
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
    public List<HoraExtraEmpleado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<HoraExtraEmpleado> list = new ArrayList<HoraExtraEmpleado>();
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
            list = horaExtraEmpleadoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly= true)
    public List<HoraExtraEmpleadoDTO> consultarHorasExtrasPeriodo(String estado, Date fechaInicial, Date fechaFinal, Integer emplId) throws Exception{
    	
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String fechaInicio = "";
		String fechaFin = "";
    	try {
    		
    		if(estado == null) {
    			throw new Exception("Se debe ingresar un estado");
    		}

    		if(fechaInicial == null) {
    			throw new Exception("Se debe ingresar una fecha inicial");
    		}

    		if(fechaFinal == null) {
    			throw new Exception("Se debe ingresar una fecha final");
    		}
    		
    		fechaInicio = simpleDateFormat.format(fechaInicial);
    		fechaFin = simpleDateFormat.format(fechaFinal);

			return horaExtraEmpleadoDAO.consultarHorasExtrasPeriodo(estado, fechaInicio, fechaFin, emplId);
    		
		} catch (Exception e) {
			throw e;
		}
    }
}
