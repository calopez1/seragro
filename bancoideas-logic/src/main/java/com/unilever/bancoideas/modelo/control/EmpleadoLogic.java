package com.unilever.bancoideas.modelo.control;

import com.unilever.bancoideas.dataaccess.dao.*;
import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.exceptions.ZMessManager.EmptyFieldException;
import com.unilever.bancoideas.exceptions.ZMessManager.ForeignException;
import com.unilever.bancoideas.exceptions.ZMessManager.NotValidFormatException;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.EmpleadoDTO;
import com.unilever.bancoideas.utilities.Utilities;

import org.codehaus.groovy.ast.expr.ConstantExpression;
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
@Service("EmpleadoLogic")
public class EmpleadoLogic implements IEmpleadoLogic {
    private static final Logger log = LoggerFactory.getLogger(EmpleadoLogic.class);

    /**
     * DAO injected by Spring that manages Empleado entities
     *
     */
    @Autowired
    private IEmpleadoDAO empleadoDAO;
    
    @Autowired
    private IPersonaDAO personaDAO;

    /**
    * DAO injected by Spring that manages NominaEmpleado entities
    *
    */
    @Autowired
    private INominaEmpleadoDAO nominaEmpleadoDAO;

    /**
    * Logic injected by Spring that manages Cargo entities
    *
    */
    @Autowired
    ICargoLogic logicCargo1;

    /**
    * Logic injected by Spring that manages Persona entities
    *
    */
    @Autowired
    IPersonaLogic logicPersona2;

    @Transactional(readOnly = true)
    public List<Empleado> getEmpleado() throws Exception {
        log.debug("finding all Empleado instances");

        List<Empleado> list = new ArrayList<Empleado>();

        try {
            list = empleadoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Empleado failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Empleado");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveEmpleado(Empleado entity) throws Exception {
        log.debug("saving Empleado instance");

        try {
            if (entity.getCargo() == null) {
                throw new ZMessManager().new ForeignException("cargo");
            }

            if (entity.getPersona() == null) {
                throw new ZMessManager().new ForeignException("persona");
            }

            if (entity.getCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("codigo");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
            }

            if (entity.getEmplId() == null) {
                throw new ZMessManager().new EmptyFieldException("emplId");
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

            if (entity.getFechaInicio() == null) {
                throw new ZMessManager().new EmptyFieldException("fechaInicio");
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

            if ((entity.getUsuModifica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuModifica(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "usuModifica");
            }

            if (entity.getCargo().getCargId() == null) {
                throw new ZMessManager().new EmptyFieldException("cargId_Cargo");
            }

            if (entity.getPersona().getPersId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "persId_Persona");
            }

            if (getEmpleado(entity.getEmplId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            empleadoDAO.save(entity);

            log.debug("save Empleado successful");
        } catch (Exception e) {
            log.error("save Empleado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteEmpleado(Empleado entity) throws Exception {
        log.debug("deleting Empleado instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Empleado");
        }

        if (entity.getEmplId() == null) {
            throw new ZMessManager().new EmptyFieldException("emplId");
        }

        List<NominaEmpleado> nominaEmpleados = null;

        try {
            nominaEmpleados = nominaEmpleadoDAO.findByProperty("empleado.emplId",
                    entity.getEmplId());

            if (Utilities.validationsList(nominaEmpleados) == true) {
                throw new ZMessManager().new DeletingException(
                    "nominaEmpleados");
            }

            empleadoDAO.delete(entity);

            log.debug("delete Empleado successful");
        } catch (Exception e) {
            log.error("delete Empleado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateEmpleado(Empleado entity) throws Exception {
        log.debug("updating Empleado instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Empleado");
            }

            if (entity.getCargo() == null) {
                throw new ZMessManager().new ForeignException("cargo");
            }

            if (entity.getPersona() == null) {
                throw new ZMessManager().new ForeignException("persona");
            }

            if (entity.getCodigo() == null) {
                throw new ZMessManager().new EmptyFieldException("codigo");
            }

            if ((entity.getCodigo() != null) &&
                    (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                        100) == false)) {
                throw new ZMessManager().new NotValidFormatException("codigo");
            }

            if (entity.getEmplId() == null) {
                throw new ZMessManager().new EmptyFieldException("emplId");
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

            if (entity.getFechaInicio() == null) {
                throw new ZMessManager().new EmptyFieldException("fechaInicio");
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

            if ((entity.getUsuModifica() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getUsuModifica(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "usuModifica");
            }

            if (entity.getCargo().getCargId() == null) {
                throw new ZMessManager().new EmptyFieldException("cargId_Cargo");
            }

            if (entity.getPersona().getPersId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "persId_Persona");
            }

            empleadoDAO.update(entity);

            log.debug("update Empleado successful");
        } catch (Exception e) {
            log.error("update Empleado failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<EmpleadoDTO> getDataEmpleado() throws Exception {
        try {
            List<Empleado> empleado = empleadoDAO.findAll();

            List<EmpleadoDTO> empleadoDTO = new ArrayList<EmpleadoDTO>();

            for (Empleado empleadoTmp : empleado) {
                EmpleadoDTO empleadoDTO2 = new EmpleadoDTO();

                empleadoDTO2.setEmplId(empleadoTmp.getEmplId());
                empleadoDTO2.setCodigo((empleadoTmp.getCodigo() != null) ? empleadoTmp.getCodigo() : null);
                empleadoDTO2.setEstadoRegistro((empleadoTmp.getEstadoRegistro() != null) ? empleadoTmp.getEstadoRegistro() : null);
                empleadoDTO2.setFechaCreacion(empleadoTmp.getFechaCreacion());
                empleadoDTO2.setFechaFin(empleadoTmp.getFechaFin());
                empleadoDTO2.setFechaIncio(empleadoTmp.getFechaInicio());
                empleadoDTO2.setFechaModificacion(empleadoTmp.getFechaModificacion());
                empleadoDTO2.setUsuCreador((empleadoTmp.getUsuCreador() != null)  ? empleadoTmp.getUsuCreador() : null);
                empleadoDTO2.setUsuModifica((empleadoTmp.getUsuModifica() != null)  ? empleadoTmp.getUsuModifica() : null);
                empleadoDTO2.setIdCarg((empleadoTmp.getCargo().getCargId() != null)  ? empleadoTmp.getCargo().getCargId() : null);
                empleadoDTO2.setIdPers((empleadoTmp.getPersona().getPersId() != null) ? empleadoTmp.getPersona().getPersId() : null);
                
                empleadoDTO2.setIdentificacionPersona((empleadoTmp.getPersona().getIdentificacion() != null) ? empleadoTmp.getPersona().getIdentificacion() : null);
                empleadoDTO2.setPrimerNombre((empleadoTmp.getPersona().getPrimerNombre() != null) ? empleadoTmp.getPersona().getPrimerNombre() : null);
                empleadoDTO2.setSegundoNombre((empleadoTmp.getPersona().getSegundoNombre() != null) ? empleadoTmp.getPersona().getSegundoNombre() : null);
                empleadoDTO2.setPrimerApellido((empleadoTmp.getPersona().getPrimerApellido() != null) ? empleadoTmp.getPersona().getPrimerApellido() : null);
                empleadoDTO2.setSegundoApellido((empleadoTmp.getPersona().getSegundoApellido() != null) ? empleadoTmp.getPersona().getSegundoApellido() : null);

                empleadoDTO2.setCodigoTipoId((empleadoTmp.getPersona().getTipoIdentificacion().getCodigo() != null) ? empleadoTmp.getPersona().getTipoIdentificacion().getCodigo() : null);
                empleadoDTO2.setNombreTipoId((empleadoTmp.getPersona().getTipoIdentificacion().getNombre() != null) ? empleadoTmp.getPersona().getTipoIdentificacion().getNombre() : null);
                empleadoDTO2.setIdTiid((empleadoTmp.getPersona().getTipoIdentificacion().getTiidId() != null) ? empleadoTmp.getPersona().getTipoIdentificacion().getTiidId() : null);

                empleadoDTO2.setCodigoCarg((empleadoTmp.getCargo().getCodigo() != null) ? empleadoTmp.getCargo().getCodigo() : null);
                empleadoDTO2.setNombreCarg((empleadoTmp.getCargo().getNombre() != null) ? empleadoTmp.getCargo().getNombre() : null);

                empleadoDTO.add(empleadoDTO2);
            }

            return empleadoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Empleado getEmpleado(Integer emplId) throws Exception {
        log.debug("getting Empleado instance");

        Empleado entity = null;

        try {
            entity = empleadoDAO.findById(emplId);
        } catch (Exception e) {
            log.error("get Empleado failed", e);
            throw new ZMessManager().new FindingException("Empleado");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Empleado> findPageEmpleado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Empleado> entity = null;

        try {
            entity = empleadoDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Empleado Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberEmpleado() throws Exception {
        Long entity = null;

        try {
            entity = empleadoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Empleado Count");
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
    public List<Empleado> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Empleado> list = new ArrayList<Empleado>();
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
            list = empleadoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED , rollbackFor=Exception.class)
    public void guardarEmpleado(Persona persona, Empleado entity) throws Exception {
        log.debug("saving empleado instance");

        try {
        	
        	 if (persona.getTipoIdentificacion() == null) {
                 throw new ZMessManager().new ForeignException(
                     "tipoIdentificacion");
             }

             if (persona.getEstadoRegistro() == null) {
                 throw new ZMessManager().new EmptyFieldException(
                     "estadoRegistro");
             }

             if ((persona.getEstadoRegistro() != null) &&
                     (Utilities.checkWordAndCheckWithlength(
                    		 persona.getEstadoRegistro(), 1) == false)) {
                 throw new ZMessManager().new NotValidFormatException(
                     "estadoRegistro");
             }

             if (persona.getFechaCreacion() == null) {
                 throw new ZMessManager().new EmptyFieldException(
                     "fechaCreacion");
             }

             if (persona.getIdentificacion() == null) {
                 throw new ZMessManager().new EmptyFieldException(
                     "identificacion");
             }

             if ((persona.getIdentificacion() != null) &&
                     (Utilities.checkWordAndCheckWithlength(
                    		 persona.getIdentificacion(), 255) == false)) {
                 throw new ZMessManager().new NotValidFormatException(
                     "identificacion");
             }

            
             if (persona.getPrimerApellido() == null) {
                 throw new ZMessManager().new EmptyFieldException(
                     "primerApellido");
             }

             if ((persona.getPrimerApellido() != null) &&
                     (Utilities.checkWordAndCheckWithlength(
                    		 persona.getPrimerApellido(), 255) == false)) {
                 throw new ZMessManager().new NotValidFormatException(
                     "primerApellido");
             }

             if (persona.getPrimerNombre() == null) {
                 throw new ZMessManager().new EmptyFieldException("primerNombre");
             }

             if ((persona.getPrimerNombre() != null) &&
                     (Utilities.checkWordAndCheckWithlength(
                    		 persona.getPrimerNombre(), 255) == false)) {
                 throw new ZMessManager().new NotValidFormatException(
                     "primerNombre");
             }

            
             if (persona.getUsuCreador() == null) {
                 throw new ZMessManager().new EmptyFieldException("usuCreador");
             }

             if ((persona.getUsuCreador() != null) &&
                     (Utilities.checkWordAndCheckWithlength(
                    		 persona.getUsuCreador(), 255) == false)) {
                 throw new ZMessManager().new NotValidFormatException(
                     "usuCreador");
             }

             if (persona.getTipoIdentificacion().getTiidId() == null) {
                 throw new ZMessManager().new EmptyFieldException(
                     "tiidId_TipoIdentificacion");
             }

            Object[] variables = {"identificacion", true, persona.getIdentificacion(), "="};
          	List<Persona> lstPersona = logicPersona2.findByCriteria(variables, null, null);

          	if(lstPersona!= null && !lstPersona.isEmpty()) {
          		
          		if(lstPersona.get(0).getEstadoRegistro().equals("I")) {
          			lstPersona.get(0).setEstadoRegistro("A");
          			personaDAO.update(lstPersona.get(0));
          			entity.setPersona(lstPersona.get(0));
          		}else {
          			entity.setPersona(lstPersona.get(0));
          		}
          	}else {
          		personaDAO.save(persona);
          		entity.setPersona(persona);
          	}

        	
        	if (entity.getCargo() == null) {
                 throw new ZMessManager().new ForeignException("cargo");
             }

             if (entity.getPersona() == null) {
                 throw new ZMessManager().new ForeignException("persona");
             }

             if (entity.getCodigo() == null) {
                 throw new ZMessManager().new EmptyFieldException("codigo");
             }

             if ((entity.getCodigo() != null) &&
                     (Utilities.checkWordAndCheckWithlength(entity.getCodigo(),
                         100) == false)) {
                 throw new ZMessManager().new NotValidFormatException("codigo");
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

             if (entity.getFechaInicio() == null) {
                 throw new ZMessManager().new EmptyFieldException("fechaInicio");
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

             if ((entity.getUsuModifica() != null) &&
                     (Utilities.checkWordAndCheckWithlength(
                         entity.getUsuModifica(), 100) == false)) {
                 throw new ZMessManager().new NotValidFormatException(
                     "usuModifica");
             }

             if (entity.getCargo().getCargId() == null) {
                 throw new ZMessManager().new EmptyFieldException("cargId_Cargo");
             }

             if (entity.getPersona().getPersId() == null) {
                 throw new ZMessManager().new EmptyFieldException(
                     "persId_Persona");
             }
        
         	Object[] variablesEmpleado = {"codigo", true, entity.getCodigo(), "="};
         	List<Empleado> lstEmpleado = findByCriteria(variablesEmpleado, null, null);

         	if(lstEmpleado!= null && !lstEmpleado.isEmpty()) {
         		throw new Exception("Ya existe un empleado con código "+ entity.getCodigo());
         	}

             empleadoDAO.save(entity);

             log.debug("save Empleado successful");

             
        } catch (Exception e) {
            log.error("save Usuario failed", e);
            throw e;
        } finally {
        }
    }
}
