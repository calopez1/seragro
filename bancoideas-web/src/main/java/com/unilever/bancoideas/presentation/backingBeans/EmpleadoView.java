package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.EmpleadoDTO;
import com.unilever.bancoideas.modelo.dto.PersonaDTO;
import com.unilever.bancoideas.modelo.dto.UsuarioDTO;
import com.unilever.bancoideas.presentation.businessDelegate.*;
import com.unilever.bancoideas.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.wizard.Wizard;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class EmpleadoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EmpleadoView.class);
   
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnClear;
    private List<EmpleadoDTO> data;
    
    private EmpleadoDTO empleadoSeleccionado;
    private Empleado entity;
    
    private PersonaDTO personaSeleccionada;
    private Persona personaEntidad;
    
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
    //Variables Persona
    private String identificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private List<TipoIdentificacion> lstTipoIdentificacion;
    private List<SelectItem> lstTipoIdentificacionSelectItem;
    private String tipoIdentificacionSeleccionado;

    //Variables empleado
    private Date fechaInicio;
    private Date fechaFin;
    private String estadoRegistro;
    private String codigoEmpleado;
    private List<Cargo> lstCargo;
    private List<SelectItem> lstCargoItem;
    private String cargoSeleccionado;  
    
    public boolean deshabilitarModificacion;
    private UsuarioDTO usuarioSesion;

    private boolean skip;

    
    public EmpleadoView() {
        super();
		usuarioSesion = (UsuarioDTO) FacesUtils.getManagedBeanFromSession("usuarioSesion");

    }

    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    public String action_new() {
        action_clear();
        empleadoSeleccionado = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        empleadoSeleccionado = null;
        personaEntidad = null;  
        
        //Variables Persona
        identificacion = "";
        primerNombre = "";
        segundoNombre = "";
        primerApellido = "";
        segundoApellido = "";
        email = "";
    	tipoIdentificacionSeleccionado = "-1";
    	
        codigoEmpleado = "";
        fechaInicio = null;
        fechaFin = null;
        cargoSeleccionado = "-1";
        estadoRegistro = null;
        
        
        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        data = null;
        deshabilitarModificacion = false;
        
        lstCargo = null;
        lstTipoIdentificacion = null;
        
        
        return "";
    }

    public void action_cargar_empleado() {
    	
    	try {
			
			
	    	if(empleadoSeleccionado != null) {
	    		
	    		deshabilitarModificacion = true;
	    		
	    		identificacion = empleadoSeleccionado.getIdentificacionPersona();
	            primerNombre = empleadoSeleccionado.getPrimerNombre();
	            segundoNombre = empleadoSeleccionado.getSegundoNombre();
	            primerApellido = empleadoSeleccionado.getPrimerApellido();
	            segundoApellido = empleadoSeleccionado.getSegundoApellido();
	            
	        	tipoIdentificacionSeleccionado = empleadoSeleccionado.getIdTiid() + "";
	        	
	        	//Se consulta si la persona tiene  empleado
	        	Object[] variables = {"persona.persId", false, empleadoSeleccionado.getIdPers(), "="};
	        	List<Empleado> lstEmpleado = businessDelegatorView.findByCriteriaInEmpleado(variables, null, null);
	        	
	        	if(lstEmpleado != null && !lstEmpleado.isEmpty()) {
	        		Empleado empl = lstEmpleado.get(0);   
	        		
	        		codigoEmpleado = empl.getCodigo();
	        		fechaInicio = empl.getFechaInicio();
	        		fechaFin = empl.getFechaFin();
	        		cargoSeleccionado = empl.getCargo().getCargId().toString();
	                estadoRegistro = empl.getEstadoRegistro();
	        		
	        	}else {
	        		codigoEmpleado = "";
	        		fechaInicio = null;
	        		fechaFin = null;
	        		cargoSeleccionado = "-1";
	                estadoRegistro = null;
	        	}
	    		
	        	listener_identificacion();
	    		
	    	}
    	} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());		
    	}
    	
    }
    

    public void listener_identificacion() {
        try {
       
            if(identificacion != null && !identificacion.trim().equals("")) {
            	Object[] variables = {"identificacion", true, identificacion, "="};
            	List<Persona> lstPersonas = businessDelegatorView.findByCriteriaInPersona(variables, null, null);
            	
            	if(lstPersonas != null && !lstPersonas.isEmpty()) {
            		personaEntidad = lstPersonas.get(0);
            	}else {
            		personaEntidad = null;
            	}
            	
            }else {
            	personaEntidad = null;
            }
        
        
        
	        if (personaEntidad == null) {
	        	
	            primerNombre = "";
	            segundoNombre = "";
	            primerApellido = "";
	            segundoApellido = "";
	            email = "";
	        	tipoIdentificacionSeleccionado = "-1";
	        	        	
	            codigoEmpleado = "";
	            cargoSeleccionado = "-1";
	            fechaInicio = null;
	            fechaFin = null;
	            estadoRegistro = null;
	            deshabilitarModificacion = false; 

	            btnSave.setDisabled(false);
	            
	        } else {
	         
	        	identificacion = personaEntidad.getIdentificacion();
	            primerNombre = personaEntidad.getPrimerNombre();
	            segundoNombre = personaEntidad.getSegundoNombre();
	            primerApellido = personaEntidad.getPrimerApellido();
	            segundoApellido = personaEntidad.getSegundoApellido();
	            email = personaEntidad.getEmail();            
	        	tipoIdentificacionSeleccionado = personaEntidad.getTipoIdentificacion().getTiidId() + "";
	        	
	        	
	        	//Se consulta si la persona tiene  usuario
	        	Object[] variables = {"persona.persId", false, personaEntidad.getPersId(), "="};
	        	List<Empleado> lstEmpleado = businessDelegatorView.findByCriteriaInEmpleado(variables, null, null);
	        	
	        	if(lstEmpleado != null && !lstEmpleado.isEmpty()) {
	        		entity = lstEmpleado.get(0);   
	        		
	        		codigoEmpleado = entity.getCodigo();
	                cargoSeleccionado = entity.getCargo().getCargId().toString();
	                fechaInicio = entity.getFechaInicio();
	                fechaFin = entity.getFechaFin();

	                estadoRegistro = entity.getEstadoRegistro();
	        		
	        	}else {
	        		codigoEmpleado = "";
	 	            cargoSeleccionado = "-1";
	 	            fechaInicio = null;
	 	            fechaFin = null;
	                estadoRegistro = null;
	        	}
	        	       
	            deshabilitarModificacion = true;
	        	
	            btnSave.setDisabled(false);
	
	        }
        } catch (Exception e) {
        	personaEntidad = null;
        	entity = null;
        }

    }

    public String action_save() {
        try {
            if ((empleadoSeleccionado == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
        	
        	if(identificacion == null || identificacion.trim().equals("")) {
        		throw new Exception("Por favor ingrese una identificación");
        	}
        	
        	if(!Utilities.isNumeric(identificacion)) {
        		throw new Exception("La identificación debe ser númerica");
        	}
        	
        	if(Long.parseLong(identificacion) <=0) {
        		throw new Exception("Número identificación NO válido");
        	}
        	
        	
        	if(primerNombre == null || primerNombre.trim().equals("")) {
        		throw new Exception("Por favor ingrese un nombre");
        	}
        	
        	if(primerApellido == null || primerApellido.trim().equals("")) {
        		throw new Exception("Por favor ingrese un apellido");
        	}
        	
        	
        	if(tipoIdentificacionSeleccionado == null || tipoIdentificacionSeleccionado.trim().equals("-1")) {
        		throw new Exception("Por favor seleccione un tipo de identificación");
        	}       
        	
        	if(codigoEmpleado == null || codigoEmpleado.trim().equals("")) {
        		throw new Exception("Por favor ingrese un código empleado");
        	}
        	
        	if(fechaInicio == null) {
        		throw new Exception("Por favor ingrese la fecha inicial del empleado");
        	}
        	
        	if(fechaFin == null && estadoRegistro != null && estadoRegistro.equals(Constantes.ESTADO_INACTIVO)) {
        		throw new Exception("Por favor ingrese la fecha final del empleado");
        	}
        	

        	if(fechaFin != null && fechaInicio.after(fechaFin)) {
        		throw new Exception("La fecha inicial del empleado no puede ser mayor a la fecha fin");
        	}

        	if(fechaInicio.after(new Date())) {
        		throw new Exception("La fecha inicial NO puede ser mayor a la fecha actual");
        	}
        	
        	if(fechaFin != null &&  fechaFin.after(new Date())) {
        		throw new Exception("La fecha final NO puede ser mayor a la fecha actual");
        	}
        	
        	if(estadoRegistro == null || estadoRegistro.trim().equals("-1")) {
        		throw new Exception("Por favor seleccione un estado");
        	}
        	
        	if(cargoSeleccionado == null || cargoSeleccionado.equals("-1")) {
        		throw new Exception("Por favor seleccione un cargo");
        	}
               	
        	if(personaEntidad == null) {
        		personaEntidad = new Persona();
            	personaEntidad.setEstadoRegistro(estadoRegistro);
            	personaEntidad.setFechaCreacion(new Date());
            	personaEntidad.setIdentificacion(identificacion.trim());
            	personaEntidad.setPrimerApellido(primerApellido.trim());
            	personaEntidad.setPrimerNombre(primerNombre.trim());
            	personaEntidad.setSegundoApellido(segundoApellido != null ? segundoApellido.trim() : "");
            	personaEntidad.setSegundoNombre(segundoNombre != null ? segundoNombre.trim() : "");
            	
            	TipoIdentificacion tipoIdentificacion = businessDelegatorView.getTipoIdentificacion(Integer.parseInt(tipoIdentificacionSeleccionado));       	
            	personaEntidad.setTipoIdentificacion(tipoIdentificacion);
            	personaEntidad.setUsuCreador(usuarioSesion.getUsuario());
        	}
        	        	
            entity = new Empleado();
            
            entity.setEstadoRegistro(estadoRegistro);
            entity.setFechaCreacion(new Date());
            entity.setUsuCreador(usuarioSesion.getUsuario());
            entity.setCodigo(codigoEmpleado);
            entity.setFechaFin(fechaFin);
            entity.setFechaInicio(fechaInicio);
            
            Cargo cargo = businessDelegatorView.getCargo(Integer.parseInt(cargoSeleccionado));      
            entity.setCargo(cargo);
            
            businessDelegatorView.guardarEmpleado(personaEntidad, entity);
            
            FacesUtils.addInfoMessage("Se ha registrado el empleado satisfactoriamente");
            
            action_clear();
        } catch (Exception e) {
            entity = null;
            personaEntidad = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
        	
        	if(identificacion == null || identificacion.trim().equals("")) {
        		throw new Exception("Por favor ingrese una identificación");
        	}
        	
        	if(!Utilities.isNumeric(identificacion)) {
        		throw new Exception("La identificación debe ser númerica");
        	}
        	
        	if(Long.parseLong(identificacion) <=0) {
        		throw new Exception("Número identificación NO válido");
        	}
        	
        	if(primerNombre == null || primerNombre.trim().equals("")) {
        		throw new Exception("Por favor ingrese un nombre");
        	}
        	
        	if(primerApellido == null || primerApellido.trim().equals("")) {
        		throw new Exception("Por favor ingrese un apellido");
        	}

        	
        	if(tipoIdentificacionSeleccionado == null || tipoIdentificacionSeleccionado.trim().equals("-1")) {
        		throw new Exception("Por favor seleccione un tipo de identificación");
        	}       
        	
        	if(codigoEmpleado == null || codigoEmpleado.trim().equals("")) {
        		throw new Exception("Por favor ingrese un código empleado");
        	}
        	
        	if(fechaInicio == null) {
        		throw new Exception("Por favor ingrese la fecha inicial del empleado");
        	}
        	
        	if(fechaFin == null && estadoRegistro != null && estadoRegistro.equals(Constantes.ESTADO_INACTIVO)) {
        		throw new Exception("Por favor ingrese la fecha final del empleado");
        	}
        	

        	if(fechaFin != null && fechaInicio.after(fechaFin)) {
        		throw new Exception("La fecha inicial del empleado no puede ser mayor a la fecha fin");
        	}

        	if(fechaInicio.after(new Date())) {
        		throw new Exception("La fecha inicial NO puede ser mayor a la fecha actual");
        	}
        	
        	if(fechaFin != null && fechaFin.after(new Date())) {
        		throw new Exception("La fecha final NO puede ser mayor a la fecha actual");
        	}
        	
        	if(estadoRegistro == null || estadoRegistro.trim().equals("-1")) {
        		throw new Exception("Por favor seleccione un estado");
        	}
        	
        	if(cargoSeleccionado == null || cargoSeleccionado.equals("-1")) {
        		throw new Exception("Por favor seleccione un cargo");
        	}
               	
            if (entity == null) {
                Integer emplId = new Integer(empleadoSeleccionado.getEmplId());
                entity = businessDelegatorView.getEmpleado(emplId);
            }

            
            entity.setEstadoRegistro(estadoRegistro);
            entity.setFechaCreacion(new Date());
            entity.setUsuCreador(usuarioSesion.getUsuario());
            entity.setCodigo(codigoEmpleado);
            entity.setFechaFin(fechaFin);
            entity.setFechaInicio(fechaInicio);
            
            Cargo cargo = businessDelegatorView.getCargo(Integer.parseInt(cargoSeleccionado));      
            entity.setCargo(cargo);
            
            businessDelegatorView.updateEmpleado(entity);
            FacesUtils.addInfoMessage("Empleado modificado satisfactoriamente");
            
            deshabilitarModificacion = true;
            action_clear();

        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    
    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }


    public List<EmpleadoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataEmpleado();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<EmpleadoDTO> empleadoDTO) {
        this.data = empleadoDTO;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }

	public PersonaDTO getPersonaSeleccionada() {
		return personaSeleccionada;
	}

	public void setPersonaSeleccionada(PersonaDTO personaSeleccionada) {
		this.personaSeleccionada = personaSeleccionada;
	}



	public Persona getPersonaEntidad() {
		return personaEntidad;
	}



	public void setPersonaEntidad(Persona personaEntidad) {
		this.personaEntidad = personaEntidad;
	}



	public String getIdentificacion() {
		return identificacion;
	}



	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}



	public String getPrimerNombre() {
		return primerNombre;
	}



	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}



	public String getSegundoNombre() {
		return segundoNombre;
	}



	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}



	public String getPrimerApellido() {
		return primerApellido;
	}



	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}



	public String getSegundoApellido() {
		return segundoApellido;
	}



	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	public List<TipoIdentificacion> getLstTipoIdentificacion() {
		return lstTipoIdentificacion;
	}

	public void setLstTipoIdentificacion(List<TipoIdentificacion> lstTipoIdentificacion) {
		this.lstTipoIdentificacion = lstTipoIdentificacion;
	}

	public List<SelectItem> getLstTipoIdentificacionSelectItem() {
		
		 try {
	            if (lstTipoIdentificacion == null) {
		        	Object[] variables = {"estadoRegistro", true, Constantes.ESTADO_ACTIVO, "="};
	            	lstTipoIdentificacion = businessDelegatorView.findByCriteriaInTipoIdentificacion(variables, null, null);
	            }
	            
	            if(lstTipoIdentificacionSelectItem == null) {
	            	lstTipoIdentificacionSelectItem = new ArrayList<>();
	            }else {
	            	lstTipoIdentificacionSelectItem.clear();
	            }
	            
	            for(TipoIdentificacion tiid: lstTipoIdentificacion) {
	            	lstTipoIdentificacionSelectItem.add(new SelectItem(tiid.getTiidId(),tiid.getNombre()));
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return lstTipoIdentificacionSelectItem;
	
	}

	public void setLstTipoIdentificacionSelectItem(List<SelectItem> lstTipoIdentificacionSelectItem) {
		this.lstTipoIdentificacionSelectItem = lstTipoIdentificacionSelectItem;
	}

	public String getTipoIdentificacionSeleccionado() {
		return tipoIdentificacionSeleccionado;
	}

	public void setTipoIdentificacionSeleccionado(String tipoIdentificacionSeleccionado) {
		this.tipoIdentificacionSeleccionado = tipoIdentificacionSeleccionado;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public boolean isDeshabilitarModificacion() {
		return deshabilitarModificacion;
	}

	public void setDeshabilitarModificacion(boolean deshabilitarModificacion) {
		this.deshabilitarModificacion = deshabilitarModificacion;
	}

	public UsuarioDTO getUsuarioSesion() {
		return usuarioSesion;
	}

	public void setUsuarioSesion(UsuarioDTO usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public List<Cargo> getLstCargo() {
		return lstCargo;
	}

	public void setLstCargo(List<Cargo> lstCargo) {
		this.lstCargo = lstCargo;
	}

	public List<SelectItem> getLstCargoItem() {
		
		 try {
	            if (lstCargo == null) {
		        	Object[] variables = {"estadoRegistro", true, Constantes.ESTADO_ACTIVO, "="};
		        	lstCargo = businessDelegatorView.findByCriteriaInCargo(variables, null, null);
	            }
	            
	            if(lstCargoItem == null) {
	            	lstCargoItem = new ArrayList<>();
	            }else {
	            	lstCargoItem.clear();
	            }
	            
	            for(Cargo carg: lstCargo) {
	            	lstCargoItem.add(new SelectItem(carg.getCargId(),carg.getNombre()));
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
		 
		return lstCargoItem;
	}

	public void setLstCargoItem(List<SelectItem> lstCargoItem) {
		this.lstCargoItem = lstCargoItem;
	}

	public String getCargoSeleccionado() {
		return cargoSeleccionado;
	}

	public void setCargoSeleccionado(String cargoSeleccionado) {
		this.cargoSeleccionado = cargoSeleccionado;
	}

	public EmpleadoDTO getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}

	public void setEmpleadoSeleccionado(EmpleadoDTO empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}

	public Empleado getEntity() {
		return entity;
	}

	public void setEntity(Empleado entity) {
		this.entity = entity;
	}

    
	
	
    
}
