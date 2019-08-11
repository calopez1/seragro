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
import com.unilever.bancoideas.modelo.control.IDepartamentoLogic;
import com.unilever.bancoideas.modelo.control.IPersonaLogic;
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
import com.unilever.bancoideas.utilities.Constantes;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
	
    public List<Persona> getPersona() throws Exception;

    public void savePersona(Persona entity) throws Exception;

    public void deletePersona(Persona entity) throws Exception;

    public void updatePersona(Persona entity) throws Exception;

    public Persona getPersona(Integer persId) throws Exception;

    public List<Persona> findByCriteriaInPersona(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Persona> findPagePersona(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPersona() throws Exception;

    public List<PersonaDTO> getDataPersona() throws Exception;

    public List<Usuario> getUsuario() throws Exception;

    public void saveUsuario(Usuario entity) throws Exception;

    public void deleteUsuario(Usuario entity) throws Exception;

    public void updateUsuario(Usuario entity) throws Exception;

    public Usuario getUsuario(Integer usuaId) throws Exception;

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;

    public List<TipoUsuario> getTipoUsuario() throws Exception;

    public void saveTipoUsuario(TipoUsuario entity) throws Exception;

    public void deleteTipoUsuario(TipoUsuario entity) throws Exception;

    public void updateTipoUsuario(TipoUsuario entity) throws Exception;

    public TipoUsuario getTipoUsuario(Integer tiusId) throws Exception;

    public List<TipoUsuario> findByCriteriaInTipoUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoUsuario> findPageTipoUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoUsuario() throws Exception;

    public List<TipoUsuarioDTO> getDataTipoUsuario() throws Exception;

    public List<Departamento> getDepartamento() throws Exception;

    public void saveDepartamento(Departamento entity) throws Exception;

    public void deleteDepartamento(Departamento entity)
        throws Exception;

    public void updateDepartamento(Departamento entity)
        throws Exception;

    public Departamento getDepartamento(Integer depaId)
        throws Exception;

    public List<Departamento> findByCriteriaInDepartamento(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Departamento> findPageDepartamento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDepartamento() throws Exception;

    public List<DepartamentoDTO> getDataDepartamento()
        throws Exception;

    public List<TipoIdentificacion> getTipoIdentificacion()
        throws Exception;

    public void saveTipoIdentificacion(TipoIdentificacion entity)
        throws Exception;

    public void deleteTipoIdentificacion(TipoIdentificacion entity)
        throws Exception;

    public void updateTipoIdentificacion(TipoIdentificacion entity)
        throws Exception;

    public TipoIdentificacion getTipoIdentificacion(Integer tiidId)
        throws Exception;

    public List<TipoIdentificacion> findByCriteriaInTipoIdentificacion(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoIdentificacion> findPageTipoIdentificacion(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberTipoIdentificacion() throws Exception;

    public List<TipoIdentificacionDTO> getDataTipoIdentificacion()
        throws Exception;
    public void guardarUsuario(Persona persona, Usuario usuario) throws Exception;
    
    public List<Cargo> getCargo() throws Exception;

    public void saveCargo(Cargo entity) throws Exception;

    public void deleteCargo(Cargo entity) throws Exception;

    public void updateCargo(Cargo entity) throws Exception;

    public Cargo getCargo(Integer cargId) throws Exception;

    public List<Cargo> findByCriteriaInCargo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cargo> findPageCargo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCargo() throws Exception;

    public List<CargoDTO> getDataCargo() throws Exception;

    public List<Empleado> getEmpleado() throws Exception;

    public void saveEmpleado(Empleado entity) throws Exception;

    public void deleteEmpleado(Empleado entity) throws Exception;

    public void updateEmpleado(Empleado entity) throws Exception;

    public Empleado getEmpleado(Integer emplId) throws Exception;

    public List<Empleado> findByCriteriaInEmpleado(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Empleado> findPageEmpleado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEmpleado() throws Exception;

    public List<EmpleadoDTO> getDataEmpleado() throws Exception;

    public List<TipoHoraExtra> getTipoHoraExtra() throws Exception;

    public void saveTipoHoraExtra(TipoHoraExtra entity)
        throws Exception;

    public void deleteTipoHoraExtra(TipoHoraExtra entity)
        throws Exception;

    public void updateTipoHoraExtra(TipoHoraExtra entity)
        throws Exception;

    public TipoHoraExtra getTipoHoraExtra(Integer thoeId)
        throws Exception;

    public List<TipoHoraExtra> findByCriteriaInTipoHoraExtra(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<TipoHoraExtra> findPageTipoHoraExtra(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoHoraExtra() throws Exception;

    public List<TipoHoraExtraDTO> getDataTipoHoraExtra()
        throws Exception;

    public List<DetalleNominaEmpleado> getDetalleNominaEmpleado()
        throws Exception;

    public void saveDetalleNominaEmpleado(DetalleNominaEmpleado entity)
        throws Exception;

    public void deleteDetalleNominaEmpleado(DetalleNominaEmpleado entity)
        throws Exception;

    public void updateDetalleNominaEmpleado(DetalleNominaEmpleado entity)
        throws Exception;

    public DetalleNominaEmpleado getDetalleNominaEmpleado(Integer dnoeId)
        throws Exception;

    public List<DetalleNominaEmpleado> findByCriteriaInDetalleNominaEmpleado(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<DetalleNominaEmpleado> findPageDetalleNominaEmpleado(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDetalleNominaEmpleado()
        throws Exception;

    public List<DetalleNominaEmpleadoDTO> getDataDetalleNominaEmpleado()
        throws Exception;

    public List<NominaEmpleado> getNominaEmpleado() throws Exception;

    public void saveNominaEmpleado(NominaEmpleado entity)
        throws Exception;

    public void deleteNominaEmpleado(NominaEmpleado entity)
        throws Exception;

    public void updateNominaEmpleado(NominaEmpleado entity)
        throws Exception;

    public NominaEmpleado getNominaEmpleado(Integer noemId)
        throws Exception;

    public List<NominaEmpleado> findByCriteriaInNominaEmpleado(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<NominaEmpleado> findPageNominaEmpleado(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberNominaEmpleado() throws Exception;

    public List<NominaEmpleadoDTO> getDataNominaEmpleado()
        throws Exception;

    public List<LiquidacionNomina> getLiquidacionNomina()
        throws Exception;

    public void saveLiquidacionNomina(LiquidacionNomina entity)
        throws Exception;

    public void deleteLiquidacionNomina(LiquidacionNomina entity)
        throws Exception;

    public void updateLiquidacionNomina(LiquidacionNomina entity)
        throws Exception;

    public LiquidacionNomina getLiquidacionNomina(Integer linoId)
        throws Exception;

    public List<LiquidacionNomina> findByCriteriaInLiquidacionNomina(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<LiquidacionNomina> findPageLiquidacionNomina(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberLiquidacionNomina() throws Exception;

    public List<LiquidacionNominaDTO> getDataLiquidacionNomina()
        throws Exception;

   public void guardarEmpleado(Persona persona, Empleado empleado) throws Exception;
   
   public void guardarLiquidacionNomina(String descripcion, UsuarioDTO usuarioSesion, String mes, String ano, String periodoLiquidacion) throws Exception;

   public List<NominaEmpleadoDTO> consultarLiquidacionNominaEmpleadoXLiquidacionNomina(Integer linoId) throws Exception;
    
   public void liquidarNomina(LiquidacionNomina liquidacionNomina, UsuarioDTO usuario) throws Exception;
   
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
   
   public List<LiquidacionHoraExtra> getLiquidacionHoraExtra()
       throws Exception;

   public void saveLiquidacionHoraExtra(LiquidacionHoraExtra entity)
       throws Exception;

   public void deleteLiquidacionHoraExtra(LiquidacionHoraExtra entity)
       throws Exception;

   public void updateLiquidacionHoraExtra(LiquidacionHoraExtra entity)
       throws Exception;

   public LiquidacionHoraExtra getLiquidacionHoraExtra(Integer lhoeId)
       throws Exception;

   public List<LiquidacionHoraExtra> findByCriteriaInLiquidacionHoraExtra(
       Object[] variables, Object[] variablesBetween,
       Object[] variablesBetweenDates) throws Exception;

   public List<LiquidacionHoraExtra> findPageLiquidacionHoraExtra(
       String sortColumnName, boolean sortAscending, int startRow,
       int maxResults) throws Exception;

   public Long findTotalNumberLiquidacionHoraExtra() throws Exception;

   public List<LiquidacionHoraExtraDTO> getDataLiquidacionHoraExtra()
       throws Exception;

   public List<HoraExtraEmpleado> getHoraExtraEmpleado()
       throws Exception;

   public void saveHoraExtraEmpleado(HoraExtraEmpleado entity)
       throws Exception;

   public void deleteHoraExtraEmpleado(HoraExtraEmpleado entity)
       throws Exception;

   public void updateHoraExtraEmpleado(HoraExtraEmpleado entity)
       throws Exception;

   public HoraExtraEmpleado getHoraExtraEmpleado(Integer hexmId)
       throws Exception;

   public List<HoraExtraEmpleado> findByCriteriaInHoraExtraEmpleado(
       Object[] variables, Object[] variablesBetween,
       Object[] variablesBetweenDates) throws Exception;

   public List<HoraExtraEmpleado> findPageHoraExtraEmpleado(
       String sortColumnName, boolean sortAscending, int startRow,
       int maxResults) throws Exception;

   public Long findTotalNumberHoraExtraEmpleado() throws Exception;

   public List<HoraExtraEmpleadoDTO> getDataHoraExtraEmpleado()
       throws Exception;

   
}
