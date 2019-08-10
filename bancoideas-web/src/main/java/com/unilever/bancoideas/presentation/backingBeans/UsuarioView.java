package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
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
public class UsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioView.class);
   
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnClear;
    private List<UsuarioDTO> data;
    
    private UsuarioDTO selectedUsuario;
    private Usuario entity;
    
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
    
    //Variables Usuario
    private List<Departamento> lstDepartamento;
    private List<SelectItem> lstDepartamentoSelectItem;
    private String departamentoSeleccionado;    
    private List<TipoUsuario> lstTipoUsuario;
    private List<SelectItem> lstTipoUsuarioSelectItem;
    private String tipoUsuarioSeleccionado;    
    private String usuario;
    private String contrasena;
    private String contrasena2;

    private String estadoRegistro;
    
    public boolean deshabilitarModificacion;
    private UsuarioDTO usuarioSesion;

    private boolean skip;

    
    public UsuarioView() {
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
        selectedUsuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedUsuario = null;
        personaEntidad = null;  
        
        //Variables Persona
        identificacion = "";
        primerNombre = "";
        segundoNombre = "";
        primerApellido = "";
        segundoApellido = "";
        email = "";
    	tipoIdentificacionSeleccionado = "-1";
    	
        usuario = "";
        contrasena = "";
        departamentoSeleccionado = "";
        tipoUsuarioSeleccionado = "";
        
        estadoRegistro = null;
        
        
        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        data = null;
        deshabilitarModificacion = false;
        
        lstDepartamento = null;
        lstTipoIdentificacion = null;
        lstTipoUsuario = null;
        
        
        return "";
    }

    public void action_cargar_usuario() {
    	
    	try {
			
			
	    	if(selectedUsuario != null) {
	    		
	    		deshabilitarModificacion = true;
	    		
	    		identificacion = selectedUsuario.getIdentificacionPersona();
	            primerNombre = selectedUsuario.getPrimerNombre();
	            segundoNombre = selectedUsuario.getSegundoNombre();
	            primerApellido = selectedUsuario.getPrimerApellido();
	            segundoApellido = selectedUsuario.getSegundoApellido();
	            email = selectedUsuario.getEmail();        
	            
	        	tipoIdentificacionSeleccionado = selectedUsuario.getIdTiid() + "";
	        	
	        	//Se consulta si la persona tiene  usuario
	        	Object[] variables = {"persona.persId", false, selectedUsuario.getIdPers(), "="};
	        	List<Usuario> lstUsuario = businessDelegatorView.findByCriteriaInUsuario(variables, null, null);
	        	
	        	if(lstUsuario != null && !lstUsuario.isEmpty()) {
	        		Usuario usu = lstUsuario.get(0);   
	        		
	        		usuario = usu.getUsuario();

	                contrasena = usu.getContrasena();
	                contrasena2 = usu.getContrasena();
	                departamentoSeleccionado = usu.getDepartamento().getDepaId() +"";
	                tipoUsuarioSeleccionado = usu.getTipoUsuario().getTiusId() +"";
	                estadoRegistro = usu.getEstadoRegistro();
	        		
	        	}else {
	        		usuario = "";
	                contrasena = "";
	                departamentoSeleccionado = "";
	                tipoUsuarioSeleccionado = "";
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
	        	
	            usuario = "";
	            contrasena = "";
	            departamentoSeleccionado = "";
	            tipoUsuarioSeleccionado = "";
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
	        	List<Usuario> lstUsuario = businessDelegatorView.findByCriteriaInUsuario(variables, null, null);
	        	
	        	if(lstUsuario != null && !lstUsuario.isEmpty()) {
	        		entity = lstUsuario.get(0);   
	        		
	        		usuario = entity.getUsuario();
	                contrasena = entity.getContrasena();
	                contrasena2 = entity.getContrasena();

	                departamentoSeleccionado = entity.getDepartamento().getDepaId() +"";
	                tipoUsuarioSeleccionado = entity.getTipoUsuario().getTiusId() +"";
	                estadoRegistro = entity.getEstadoRegistro();
	        		
	        	}else {
	        		usuario = "";
	                contrasena = "";
	                departamentoSeleccionado = "";
	                tipoUsuarioSeleccionado = "";
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
            if ((selectedUsuario == null) && (entity == null) && personaEntidad == null) {
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
        	
        	if(usuario == null || usuario.trim().equals("")) {
        		throw new Exception("Por favor ingrese un usuario");
        	}
        	
        	email = usuario;
        
        	
        	if(email == null || email.trim().equals("")) {
        		throw new Exception("Por favor ingrese un email");
        	}
        	
        	if(!Utilities.validateEmailAddress(email)) {
        		throw new Exception("El usuario debe ser un Email válido "+ email);
        	}
        	
        	if(contrasena == null || contrasena.trim().equals("")) {
        		throw new Exception("Por favor ingrese una contraseña");
        	}
        	
        	if(contrasena2 == null || contrasena2.trim().equals("")) {
        		throw new Exception("Por favor confirme la contraseña");
        	}
        	
        	if(!contrasena2.equals(contrasena)) {
        		throw new Exception("Las contraseñas NO coinciden");
        	}
        	
        	if(departamentoSeleccionado == null || departamentoSeleccionado.trim().equals("-1")) {
        		throw new Exception("Por favor seleccione un departamento");
        	}
        	
        	if(tipoUsuarioSeleccionado == null || tipoUsuarioSeleccionado.trim().equals("-1")) {
        		throw new Exception("Por favor seleccione un rol para el usuario");
        	}
        	
        	if(estadoRegistro == null || estadoRegistro.trim().equals("-1")) {
        		throw new Exception("Por favor seleccione un estado");
        	}
               	
        	personaEntidad = new Persona();
        	personaEntidad.setEmail(email.trim());
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
        	        	
            entity = new Usuario();
            
            entity.setContrasena(contrasena);
            entity.setEstadoRegistro(estadoRegistro);
            entity.setFechaCreacion(new Date());
            entity.setUsuCreador(usuarioSesion.getUsuario());
            entity.setUsuario(usuario);
            
            Departamento departamento = businessDelegatorView.getDepartamento(Integer.parseInt(departamentoSeleccionado));      
            entity.setDepartamento(departamento);
            
            TipoUsuario tipoUsuario = businessDelegatorView.getTipoUsuario(Integer.parseInt(tipoUsuarioSeleccionado));
            entity.setTipoUsuario(tipoUsuario);

            businessDelegatorView.guardarUsuario(personaEntidad, entity);
            
            FacesUtils.addInfoMessage("Se ha registrado el usuario satisfactoriamente");
            
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
        	
        	if(usuario == null || usuario.trim().equals("")) {
        		throw new Exception("Por favor ingrese un usuario");
        	}
        	
        	email = usuario;
        	
        	if(email == null || email.trim().equals("")) {
        		throw new Exception("Por favor ingrese un email");
        	}
        	
        	if(!Utilities.validateEmailAddress(email)) {
        		throw new Exception("El email "+ email+ " NO es válido");
        	}
        	
        	if(contrasena == null || contrasena.trim().equals("")) {
        		contrasena = entity.getContrasena();
        	}
        	
        	if(departamentoSeleccionado == null || departamentoSeleccionado.trim().equals("-1")) {
        		throw new Exception("Por favor seleccione un departamento");
        	}
        	
        	if(tipoUsuarioSeleccionado == null || tipoUsuarioSeleccionado.trim().equals("-1")) {
        		throw new Exception("Por favor seleccione un rol para el usuario");
        	}
        	
        	if(estadoRegistro == null || estadoRegistro.trim().equals("-1")) {
        		throw new Exception("Por favor seleccione un estado");
        	}
               	
            if (entity == null) {
                Integer usuaId = new Integer(selectedUsuario.getUsuaId());
                entity = businessDelegatorView.getUsuario(usuaId);
            }

            entity.setContrasena(contrasena);
            entity.setEstadoRegistro(estadoRegistro);
            
            Departamento departamento = businessDelegatorView.getDepartamento(Integer.parseInt(departamentoSeleccionado));      
            entity.setDepartamento(departamento);
            
            TipoUsuario tipoUsuario = businessDelegatorView.getTipoUsuario(Integer.parseInt(tipoUsuarioSeleccionado));
            entity.setTipoUsuario(tipoUsuario);
            entity.setFechaModificacion(new Date());
            entity.setUsuModifica(usuarioSesion.getUsuario());
           
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage("Usuario modificado satisfactoriamente");
            
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


    public List<UsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UsuarioDTO> usuarioDTO) {
        this.data = usuarioDTO;
    }

    public UsuarioDTO getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(UsuarioDTO usuario) {
        this.selectedUsuario = usuario;
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



	public Usuario getEntity() {
		return entity;
	}



	public void setEntity(Usuario entity) {
		this.entity = entity;
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



	public List<Departamento> getLstDepartamento() {
		return lstDepartamento;
	}



	public void setLstDepartamento(List<Departamento> lstDepartamento) {
		this.lstDepartamento = lstDepartamento;
	}



	public List<SelectItem> getLstDepartamentoSelectItem() {

		 try {
	            if (lstDepartamento == null) {
		        	Object[] variables = {"estadoRegistro", true, Constantes.ESTADO_ACTIVO, "="};
		        	lstDepartamento = businessDelegatorView.findByCriteriaInDepartamento(variables, null, null);
	            }
	            
	            if(lstDepartamentoSelectItem == null) {
	            	lstDepartamentoSelectItem = new ArrayList<>();
	            }else {
	            	lstDepartamentoSelectItem.clear();
	            }
	            
	            
	            for(Departamento depa: lstDepartamento) {
	            	lstDepartamentoSelectItem.add(new SelectItem(depa.getDepaId(),depa.getNombre()));
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		
		return lstDepartamentoSelectItem;
	}



	public void setLstDepartamentoSelectItem(List<SelectItem> lstDepartamentoSelectItem) {
		this.lstDepartamentoSelectItem = lstDepartamentoSelectItem;
	}


	public List<TipoUsuario> getLstTipoUsuario() {
		return lstTipoUsuario;
	}



	public void setLstTipoUsuario(List<TipoUsuario> lstTipoUsuario) {
		this.lstTipoUsuario = lstTipoUsuario;
	}



	public List<SelectItem> getLstTipoUsuarioSelectItem() {
		
		 try {
	            if (lstTipoUsuario == null) {
		        	Object[] variables = {"estadoRegistro", true, Constantes.ESTADO_ACTIVO, "="};
		        	lstTipoUsuario = businessDelegatorView.findByCriteriaInTipoUsuario(variables, null, null);
	            }
	            
	            if(lstTipoUsuarioSelectItem == null) {
	            	lstTipoUsuarioSelectItem = new ArrayList<>();
	            }else {
	            	lstTipoUsuarioSelectItem.clear();
	            }
	            
	            for(TipoUsuario tius: lstTipoUsuario) {
	            	lstTipoUsuarioSelectItem.add(new SelectItem(tius.getTiusId(),tius.getNombre()));
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
		return lstTipoUsuarioSelectItem;
	}



	public void setLstTipoUsuarioSelectItem(List<SelectItem> lstTipoUsuarioSelectItem) {
		this.lstTipoUsuarioSelectItem = lstTipoUsuarioSelectItem;
	}


	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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

	public String getDepartamentoSeleccionado() {
		return departamentoSeleccionado;
	}

	public void setDepartamentoSeleccionado(String departamentoSeleccionado) {
		this.departamentoSeleccionado = departamentoSeleccionado;
	}

	public String getTipoUsuarioSeleccionado() {
		return tipoUsuarioSeleccionado;
	}

	public void setTipoUsuarioSeleccionado(String tipoUsuarioSeleccionado) {
		this.tipoUsuarioSeleccionado = tipoUsuarioSeleccionado;
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

	public String getContrasena2() {
		return contrasena2;
	}

	public void setContrasena2(String contrasena2) {
		this.contrasena2 = contrasena2;
	}

    
	
	
    
}
