package com.unilever.bancoideas.presentation.businessDelegate;

import com.unilever.bancoideas.modelo.Cargo;
import com.unilever.bancoideas.modelo.Departamento;
import com.unilever.bancoideas.modelo.DetalleNominaEmpleado;
import com.unilever.bancoideas.modelo.Empleado;
import com.unilever.bancoideas.modelo.HoraExtraEmpleado;
import com.unilever.bancoideas.modelo.LiquidacionHoraExtra;
import com.unilever.bancoideas.modelo.LiquidacionNomina;
import com.unilever.bancoideas.modelo.NominaEmpleado;
import com.unilever.bancoideas.modelo.Parametros;
import com.unilever.bancoideas.modelo.Persona;
import com.unilever.bancoideas.modelo.TipoHoraExtra;
import com.unilever.bancoideas.modelo.TipoIdentificacion;
import com.unilever.bancoideas.modelo.TipoUsuario;
import com.unilever.bancoideas.modelo.Usuario;
import com.unilever.bancoideas.modelo.control.DepartamentoLogic;
import com.unilever.bancoideas.modelo.control.ICargoLogic;
import com.unilever.bancoideas.modelo.control.IDepartamentoLogic;
import com.unilever.bancoideas.modelo.control.IDetalleNominaEmpleadoLogic;
import com.unilever.bancoideas.modelo.control.IEmpleadoLogic;
import com.unilever.bancoideas.modelo.control.IHoraExtraEmpleadoLogic;
import com.unilever.bancoideas.modelo.control.ILiquidacionHoraExtraLogic;
import com.unilever.bancoideas.modelo.control.ILiquidacionNominaLogic;
import com.unilever.bancoideas.modelo.control.INominaEmpleadoLogic;
import com.unilever.bancoideas.modelo.control.IParametrosLogic;
import com.unilever.bancoideas.modelo.control.IPersonaLogic;
import com.unilever.bancoideas.modelo.control.ITipoHoraExtraLogic;
import com.unilever.bancoideas.modelo.control.ITipoIdentificacionLogic;
import com.unilever.bancoideas.modelo.control.ITipoUsuarioLogic;
import com.unilever.bancoideas.modelo.control.IUsuarioLogic;
import com.unilever.bancoideas.modelo.control.PersonaLogic;
import com.unilever.bancoideas.modelo.control.TipoIdentificacionLogic;
import com.unilever.bancoideas.modelo.control.TipoUsuarioLogic;
import com.unilever.bancoideas.modelo.control.UsuarioLogic;
import com.unilever.bancoideas.modelo.dto.CargoDTO;
import com.unilever.bancoideas.modelo.dto.DepartamentoDTO;
import com.unilever.bancoideas.modelo.dto.DetalleNominaEmpleadoDTO;
import com.unilever.bancoideas.modelo.dto.EmpleadoDTO;
import com.unilever.bancoideas.modelo.dto.HoraExtraEmpleadoDTO;
import com.unilever.bancoideas.modelo.dto.LiquidacionHoraExtraDTO;
import com.unilever.bancoideas.modelo.dto.LiquidacionNominaDTO;
import com.unilever.bancoideas.modelo.dto.NominaEmpleadoDTO;
import com.unilever.bancoideas.modelo.dto.ParametrosDTO;
import com.unilever.bancoideas.modelo.dto.PersonaDTO;
import com.unilever.bancoideas.modelo.dto.TipoHoraExtraDTO;
import com.unilever.bancoideas.modelo.dto.TipoIdentificacionDTO;
import com.unilever.bancoideas.modelo.dto.TipoUsuarioDTO;
import com.unilever.bancoideas.modelo.dto.UsuarioDTO;
import com.unilever.bancoideas.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private ICargoLogic cargoLogic;
    @Autowired
    private IEmpleadoLogic empleadoLogic;
    @Autowired
    private ITipoHoraExtraLogic tipoHoraExtraLogic;
    @Autowired
    private IPersonaLogic personaLogic;
    @Autowired
    private IDetalleNominaEmpleadoLogic detalleNominaEmpleadoLogic;
    @Autowired
    private ILiquidacionHoraExtraLogic liquidacionHoraExtraLogic;
    @Autowired
    private INominaEmpleadoLogic nominaEmpleadoLogic;
    @Autowired
    private IUsuarioLogic usuarioLogic;
    @Autowired
    private ILiquidacionNominaLogic liquidacionNominaLogic;
    @Autowired
    private ITipoUsuarioLogic tipoUsuarioLogic;
    @Autowired
    private IDepartamentoLogic departamentoLogic;
    @Autowired
    private ITipoIdentificacionLogic tipoIdentificacionLogic;
    @Autowired
    private IParametrosLogic parametrosLogic;
    @Autowired
    private IHoraExtraEmpleadoLogic horaExtraEmpleadoLogic;
    
    public List<Persona> getPersona() throws Exception {
        return personaLogic.getPersona();
    }

    public void savePersona(Persona entity) throws Exception {
        personaLogic.savePersona(entity);
    }

    public void deletePersona(Persona entity) throws Exception {
        personaLogic.deletePersona(entity);
    }

    public void updatePersona(Persona entity) throws Exception {
        personaLogic.updatePersona(entity);
    }

    public Persona getPersona(Integer persId) throws Exception {
        Persona persona = null;

        try {
            persona = personaLogic.getPersona(persId);
        } catch (Exception e) {
            throw e;
        }

        return persona;
    }

    public List<Persona> findByCriteriaInPersona(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return personaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Persona> findPagePersona(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return personaLogic.findPagePersona(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberPersona() throws Exception {
        return personaLogic.findTotalNumberPersona();
    }

    public List<PersonaDTO> getDataPersona() throws Exception {
        return personaLogic.getDataPersona();
    }

    public List<Usuario> getUsuario() throws Exception {
        return usuarioLogic.getUsuario();
    }

    public void saveUsuario(Usuario entity) throws Exception {
        usuarioLogic.saveUsuario(entity);
    }

    public void deleteUsuario(Usuario entity) throws Exception {
        usuarioLogic.deleteUsuario(entity);
    }

    public void updateUsuario(Usuario entity) throws Exception {
        usuarioLogic.updateUsuario(entity);
    }

    public Usuario getUsuario(Integer usuaId) throws Exception {
        Usuario usuario = null;

        try {
            usuario = usuarioLogic.getUsuario(usuaId);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioLogic.findPageUsuario(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuario() throws Exception {
        return usuarioLogic.findTotalNumberUsuario();
    }

    public List<UsuarioDTO> getDataUsuario() throws Exception {
        return usuarioLogic.getDataUsuario();
    }

    public List<TipoUsuario> getTipoUsuario() throws Exception {
        return tipoUsuarioLogic.getTipoUsuario();
    }

    public void saveTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioLogic.saveTipoUsuario(entity);
    }

    public void deleteTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioLogic.deleteTipoUsuario(entity);
    }

    public void updateTipoUsuario(TipoUsuario entity) throws Exception {
        tipoUsuarioLogic.updateTipoUsuario(entity);
    }

    public TipoUsuario getTipoUsuario(Integer tiusId) throws Exception {
        TipoUsuario tipoUsuario = null;

        try {
            tipoUsuario = tipoUsuarioLogic.getTipoUsuario(tiusId);
        } catch (Exception e) {
            throw e;
        }

        return tipoUsuario;
    }

    public List<TipoUsuario> findByCriteriaInTipoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoUsuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoUsuarioLogic.findPageTipoUsuario(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoUsuario() throws Exception {
        return tipoUsuarioLogic.findTotalNumberTipoUsuario();
    }

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception {
        return tipoUsuarioLogic.getDataTipoUsuario();
    }

    public List<Departamento> getDepartamento() throws Exception {
        return departamentoLogic.getDepartamento();
    }

    public void saveDepartamento(Departamento entity) throws Exception {
        departamentoLogic.saveDepartamento(entity);
    }

    public void deleteDepartamento(Departamento entity)
        throws Exception {
        departamentoLogic.deleteDepartamento(entity);
    }

    public void updateDepartamento(Departamento entity)
        throws Exception {
        departamentoLogic.updateDepartamento(entity);
    }

    public Departamento getDepartamento(Integer depaId)
        throws Exception {
        Departamento departamento = null;

        try {
            departamento = departamentoLogic.getDepartamento(depaId);
        } catch (Exception e) {
            throw e;
        }

        return departamento;
    }

    public List<Departamento> findByCriteriaInDepartamento(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return departamentoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Departamento> findPageDepartamento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return departamentoLogic.findPageDepartamento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberDepartamento() throws Exception {
        return departamentoLogic.findTotalNumberDepartamento();
    }

    public List<DepartamentoDTO> getDataDepartamento()
        throws Exception {
        return departamentoLogic.getDataDepartamento();
    }

    public List<TipoIdentificacion> getTipoIdentificacion()
        throws Exception {
        return tipoIdentificacionLogic.getTipoIdentificacion();
    }

    public void saveTipoIdentificacion(TipoIdentificacion entity)
        throws Exception {
        tipoIdentificacionLogic.saveTipoIdentificacion(entity);
    }

    public void deleteTipoIdentificacion(TipoIdentificacion entity)
        throws Exception {
        tipoIdentificacionLogic.deleteTipoIdentificacion(entity);
    }

    public void updateTipoIdentificacion(TipoIdentificacion entity)
        throws Exception {
        tipoIdentificacionLogic.updateTipoIdentificacion(entity);
    }

    public TipoIdentificacion getTipoIdentificacion(Integer tiidId)
        throws Exception {
        TipoIdentificacion tipoIdentificacion = null;

        try {
            tipoIdentificacion = tipoIdentificacionLogic.getTipoIdentificacion(tiidId);
        } catch (Exception e) {
            throw e;
        }

        return tipoIdentificacion;
    }

    public List<TipoIdentificacion> findByCriteriaInTipoIdentificacion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoIdentificacionLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<TipoIdentificacion> findPageTipoIdentificacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return tipoIdentificacionLogic.findPageTipoIdentificacion(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoIdentificacion() throws Exception {
        return tipoIdentificacionLogic.findTotalNumberTipoIdentificacion();
    }

    public List<TipoIdentificacionDTO> getDataTipoIdentificacion()
        throws Exception {
        return tipoIdentificacionLogic.getDataTipoIdentificacion();
    }
    
    public void guardarUsuario (Persona persona, Usuario usuario)  throws Exception{
    	usuarioLogic.guardarUsuario(persona, usuario);
    }
    
    public void guardarEmpleado(Persona persona, Empleado empleado) throws Exception{
    	empleadoLogic.guardarEmpleado(persona, empleado);
    }

    
    public List<Cargo> getCargo() throws Exception {
        return cargoLogic.getCargo();
    }

    public void saveCargo(Cargo entity) throws Exception {
        cargoLogic.saveCargo(entity);
    }

    public void deleteCargo(Cargo entity) throws Exception {
        cargoLogic.deleteCargo(entity);
    }

    public void updateCargo(Cargo entity) throws Exception {
        cargoLogic.updateCargo(entity);
    }

    public Cargo getCargo(Integer cargId) throws Exception {
        Cargo cargo = null;

        try {
            cargo = cargoLogic.getCargo(cargId);
        } catch (Exception e) {
            throw e;
        }

        return cargo;
    }

    public List<Cargo> findByCriteriaInCargo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return cargoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Cargo> findPageCargo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return cargoLogic.findPageCargo(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCargo() throws Exception {
        return cargoLogic.findTotalNumberCargo();
    }

    public List<CargoDTO> getDataCargo() throws Exception {
        return cargoLogic.getDataCargo();
    }

    public List<Empleado> getEmpleado() throws Exception {
        return empleadoLogic.getEmpleado();
    }

    public void saveEmpleado(Empleado entity) throws Exception {
        empleadoLogic.saveEmpleado(entity);
    }

    public void deleteEmpleado(Empleado entity) throws Exception {
        empleadoLogic.deleteEmpleado(entity);
    }

    public void updateEmpleado(Empleado entity) throws Exception {
        empleadoLogic.updateEmpleado(entity);
    }

    public Empleado getEmpleado(Integer emplId) throws Exception {
        Empleado empleado = null;

        try {
            empleado = empleadoLogic.getEmpleado(emplId);
        } catch (Exception e) {
            throw e;
        }

        return empleado;
    }

    public List<Empleado> findByCriteriaInEmpleado(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return empleadoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Empleado> findPageEmpleado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return empleadoLogic.findPageEmpleado(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberEmpleado() throws Exception {
        return empleadoLogic.findTotalNumberEmpleado();
    }

    public List<EmpleadoDTO> getDataEmpleado() throws Exception {
        return empleadoLogic.getDataEmpleado();
    }

    public List<TipoHoraExtra> getTipoHoraExtra() throws Exception {
        return tipoHoraExtraLogic.getTipoHoraExtra();
    }

    public void saveTipoHoraExtra(TipoHoraExtra entity)
        throws Exception {
        tipoHoraExtraLogic.saveTipoHoraExtra(entity);
    }

    public void deleteTipoHoraExtra(TipoHoraExtra entity)
        throws Exception {
        tipoHoraExtraLogic.deleteTipoHoraExtra(entity);
    }

    public void updateTipoHoraExtra(TipoHoraExtra entity)
        throws Exception {
        tipoHoraExtraLogic.updateTipoHoraExtra(entity);
    }

    public TipoHoraExtra getTipoHoraExtra(Integer thoeId)
        throws Exception {
        TipoHoraExtra tipoHoraExtra = null;

        try {
            tipoHoraExtra = tipoHoraExtraLogic.getTipoHoraExtra(thoeId);
        } catch (Exception e) {
            throw e;
        }

        return tipoHoraExtra;
    }

    public List<TipoHoraExtra> findByCriteriaInTipoHoraExtra(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return tipoHoraExtraLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<TipoHoraExtra> findPageTipoHoraExtra(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoHoraExtraLogic.findPageTipoHoraExtra(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberTipoHoraExtra() throws Exception {
        return tipoHoraExtraLogic.findTotalNumberTipoHoraExtra();
    }

    public List<TipoHoraExtraDTO> getDataTipoHoraExtra()
        throws Exception {
        return tipoHoraExtraLogic.getDataTipoHoraExtra();
    }

    public List<DetalleNominaEmpleado> getDetalleNominaEmpleado()
        throws Exception {
        return detalleNominaEmpleadoLogic.getDetalleNominaEmpleado();
    }

    public void saveDetalleNominaEmpleado(DetalleNominaEmpleado entity)
        throws Exception {
        detalleNominaEmpleadoLogic.saveDetalleNominaEmpleado(entity);
    }

    public void deleteDetalleNominaEmpleado(DetalleNominaEmpleado entity)
        throws Exception {
        detalleNominaEmpleadoLogic.deleteDetalleNominaEmpleado(entity);
    }

    public void updateDetalleNominaEmpleado(DetalleNominaEmpleado entity)
        throws Exception {
        detalleNominaEmpleadoLogic.updateDetalleNominaEmpleado(entity);
    }

    public DetalleNominaEmpleado getDetalleNominaEmpleado(Integer dnoeId)
        throws Exception {
        DetalleNominaEmpleado detalleNominaEmpleado = null;

        try {
            detalleNominaEmpleado = detalleNominaEmpleadoLogic.getDetalleNominaEmpleado(dnoeId);
        } catch (Exception e) {
            throw e;
        }

        return detalleNominaEmpleado;
    }

    public List<DetalleNominaEmpleado> findByCriteriaInDetalleNominaEmpleado(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return detalleNominaEmpleadoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<DetalleNominaEmpleado> findPageDetalleNominaEmpleado(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return detalleNominaEmpleadoLogic.findPageDetalleNominaEmpleado(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberDetalleNominaEmpleado()
        throws Exception {
        return detalleNominaEmpleadoLogic.findTotalNumberDetalleNominaEmpleado();
    }

    public List<DetalleNominaEmpleadoDTO> getDataDetalleNominaEmpleado()
        throws Exception {
        return detalleNominaEmpleadoLogic.getDataDetalleNominaEmpleado();
    }

    public List<NominaEmpleado> getNominaEmpleado() throws Exception {
        return nominaEmpleadoLogic.getNominaEmpleado();
    }

    public void saveNominaEmpleado(NominaEmpleado entity)
        throws Exception {
        nominaEmpleadoLogic.saveNominaEmpleado(entity);
    }

    public void deleteNominaEmpleado(NominaEmpleado entity)
        throws Exception {
        nominaEmpleadoLogic.deleteNominaEmpleado(entity);
    }

    public void updateNominaEmpleado(NominaEmpleado entity)
        throws Exception {
        nominaEmpleadoLogic.updateNominaEmpleado(entity);
    }

    public NominaEmpleado getNominaEmpleado(Integer noemId)
        throws Exception {
        NominaEmpleado nominaEmpleado = null;

        try {
            nominaEmpleado = nominaEmpleadoLogic.getNominaEmpleado(noemId);
        } catch (Exception e) {
            throw e;
        }

        return nominaEmpleado;
    }

    public List<NominaEmpleado> findByCriteriaInNominaEmpleado(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return nominaEmpleadoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<NominaEmpleado> findPageNominaEmpleado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return nominaEmpleadoLogic.findPageNominaEmpleado(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberNominaEmpleado() throws Exception {
        return nominaEmpleadoLogic.findTotalNumberNominaEmpleado();
    }

    public List<NominaEmpleadoDTO> getDataNominaEmpleado()
        throws Exception {
        return nominaEmpleadoLogic.getDataNominaEmpleado();
    }

    public List<LiquidacionNomina> getLiquidacionNomina()
        throws Exception {
        return liquidacionNominaLogic.getLiquidacionNomina();
    }

    public void saveLiquidacionNomina(LiquidacionNomina entity)
        throws Exception {
        liquidacionNominaLogic.saveLiquidacionNomina(entity);
    }

    public void deleteLiquidacionNomina(LiquidacionNomina entity)
        throws Exception {
        liquidacionNominaLogic.deleteLiquidacionNomina(entity);
    }

    public void updateLiquidacionNomina(LiquidacionNomina entity)
        throws Exception {
        liquidacionNominaLogic.updateLiquidacionNomina(entity);
    }

    public LiquidacionNomina getLiquidacionNomina(Integer linoId)
        throws Exception {
        LiquidacionNomina liquidacionNomina = null;

        try {
            liquidacionNomina = liquidacionNominaLogic.getLiquidacionNomina(linoId);
        } catch (Exception e) {
            throw e;
        }

        return liquidacionNomina;
    }

    public List<LiquidacionNomina> findByCriteriaInLiquidacionNomina(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return liquidacionNominaLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<LiquidacionNomina> findPageLiquidacionNomina(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return liquidacionNominaLogic.findPageLiquidacionNomina(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberLiquidacionNomina() throws Exception {
        return liquidacionNominaLogic.findTotalNumberLiquidacionNomina();
    }

    public List<LiquidacionNominaDTO> getDataLiquidacionNomina()
        throws Exception {
        return liquidacionNominaLogic.getDataLiquidacionNomina();
    }

    public void guardarLiquidacionNomina(String descripcion, UsuarioDTO usuarioSesion, String mes, String ano, String periodoLiquidacion) throws Exception{
    	liquidacionNominaLogic.guardarLiquidacionNomina( descripcion,  usuarioSesion,  mes,  ano, periodoLiquidacion);
    }
    
    public List<NominaEmpleadoDTO> consultarLiquidacionNominaEmpleadoXLiquidacionNomina(Integer linoId) throws Exception{
    	return nominaEmpleadoLogic.consultarLiquidacionNominaEmpleadoXLiquidacionNomina(linoId);
    }
    
    public void liquidarNomina(LiquidacionNomina liquidacionNomina, UsuarioDTO usuario) throws Exception{
    	liquidacionNominaLogic.liquidarNomina(liquidacionNomina, usuario);
    }
    
    public List<Parametros> getParametros() throws Exception {
        return parametrosLogic.getParametros();
    }

    public void saveParametros(Parametros entity) throws Exception {
        parametrosLogic.saveParametros(entity);
    }

    public void deleteParametros(Parametros entity) throws Exception {
        parametrosLogic.deleteParametros(entity);
    }

    public void updateParametros(Parametros entity) throws Exception {
        parametrosLogic.updateParametros(entity);
    }

    public Parametros getParametros(Integer paraId) throws Exception {
        Parametros parametros = null;

        try {
            parametros = parametrosLogic.getParametros(paraId);
        } catch (Exception e) {
            throw e;
        }

        return parametros;
    }

    public List<Parametros> findByCriteriaInParametros(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return parametrosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Parametros> findPageParametros(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return parametrosLogic.findPageParametros(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberParametros() throws Exception {
        return parametrosLogic.findTotalNumberParametros();
    }

    public List<ParametrosDTO> getDataParametros() throws Exception {
        return parametrosLogic.getDataParametros();
    }
  
    public List<LiquidacionHoraExtra> getLiquidacionHoraExtra()
        throws Exception {
        return liquidacionHoraExtraLogic.getLiquidacionHoraExtra();
    }

    public void saveLiquidacionHoraExtra(LiquidacionHoraExtra entity)
        throws Exception {
        liquidacionHoraExtraLogic.saveLiquidacionHoraExtra(entity);
    }

    public void deleteLiquidacionHoraExtra(LiquidacionHoraExtra entity)
        throws Exception {
        liquidacionHoraExtraLogic.deleteLiquidacionHoraExtra(entity);
    }

    public void updateLiquidacionHoraExtra(LiquidacionHoraExtra entity)
        throws Exception {
        liquidacionHoraExtraLogic.updateLiquidacionHoraExtra(entity);
    }

    public LiquidacionHoraExtra getLiquidacionHoraExtra(Integer lhoeId)
        throws Exception {
        LiquidacionHoraExtra liquidacionHoraExtra = null;

        try {
            liquidacionHoraExtra = liquidacionHoraExtraLogic.getLiquidacionHoraExtra(lhoeId);
        } catch (Exception e) {
            throw e;
        }

        return liquidacionHoraExtra;
    }

    public List<LiquidacionHoraExtra> findByCriteriaInLiquidacionHoraExtra(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return liquidacionHoraExtraLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<LiquidacionHoraExtra> findPageLiquidacionHoraExtra(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return liquidacionHoraExtraLogic.findPageLiquidacionHoraExtra(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberLiquidacionHoraExtra() throws Exception {
        return liquidacionHoraExtraLogic.findTotalNumberLiquidacionHoraExtra();
    }

    public List<LiquidacionHoraExtraDTO> getDataLiquidacionHoraExtra()
        throws Exception {
        return liquidacionHoraExtraLogic.getDataLiquidacionHoraExtra();
    }

    public List<HoraExtraEmpleado> getHoraExtraEmpleado()
        throws Exception {
        return horaExtraEmpleadoLogic.getHoraExtraEmpleado();
    }

    public void saveHoraExtraEmpleado(HoraExtraEmpleado entity)
        throws Exception {
        horaExtraEmpleadoLogic.saveHoraExtraEmpleado(entity);
    }

    public void deleteHoraExtraEmpleado(HoraExtraEmpleado entity)
        throws Exception {
        horaExtraEmpleadoLogic.deleteHoraExtraEmpleado(entity);
    }

    public void updateHoraExtraEmpleado(HoraExtraEmpleado entity)
        throws Exception {
        horaExtraEmpleadoLogic.updateHoraExtraEmpleado(entity);
    }

    public HoraExtraEmpleado getHoraExtraEmpleado(Integer hexmId)
        throws Exception {
        HoraExtraEmpleado horaExtraEmpleado = null;

        try {
            horaExtraEmpleado = horaExtraEmpleadoLogic.getHoraExtraEmpleado(hexmId);
        } catch (Exception e) {
            throw e;
        }

        return horaExtraEmpleado;
    }

    public List<HoraExtraEmpleado> findByCriteriaInHoraExtraEmpleado(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return horaExtraEmpleadoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<HoraExtraEmpleado> findPageHoraExtraEmpleado(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return horaExtraEmpleadoLogic.findPageHoraExtraEmpleado(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberHoraExtraEmpleado() throws Exception {
        return horaExtraEmpleadoLogic.findTotalNumberHoraExtraEmpleado();
    }

    public List<HoraExtraEmpleadoDTO> getDataHoraExtraEmpleado()
        throws Exception {
        return horaExtraEmpleadoLogic.getDataHoraExtraEmpleado();
    }

}
