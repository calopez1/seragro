package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.DepartamentoDTO;
import com.unilever.bancoideas.modelo.dto.UsuarioDTO;
import com.unilever.bancoideas.presentation.businessDelegate.*;
import com.unilever.bancoideas.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

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


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DepartamentoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DepartamentoView.class);
   
    private String codigo;
    private String descripcion;
    private String estadoRegistro;
    private String nombre;
    
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnClear;
    
    private List<DepartamentoDTO> data;
    private DepartamentoDTO selectedDepartamento;
    private Departamento entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;
    
    private UsuarioDTO usuarioSesion;
    private boolean deshabilitadoModificacion;

    public DepartamentoView() {
        super();
		usuarioSesion = (UsuarioDTO) FacesUtils.getManagedBeanFromSession("usuarioSesion");
    }

    public String action_new() {
        action_clear();
        selectedDepartamento = null;
        setShowDialog(true);

        return "";
    }
    
    public void action_clear() {
    	
    	if(selectedDepartamento != null) {
    		selectedDepartamento = null;
    	}
    	
    	codigo = "";
    	descripcion = "";
    	estadoRegistro = null;
    	nombre = "";
    	
        btnSave.setDisabled(true);
        data = null;
        deshabilitadoModificacion = false;
        selectedDepartamento = null;
        entity = null;
    	
    }
    
    public void action_cargar_departamento() {
    	
    	if(selectedDepartamento != null) {
    		codigo = selectedDepartamento.getCodigo();
    		nombre = selectedDepartamento.getNombre();
    		descripcion = selectedDepartamento.getDescripcion();
    		estadoRegistro = selectedDepartamento.getEstadoRegistro();
    		
    		listener_codigo();
    		
    	}
    	
    }
    
    public void listener_codigo() {
        
    	List<Departamento> lstDepartamento = null;
    	
    	try {
        	
        	if(codigo == null) {
        		entity = null;
        	}else{
        		
        		Object[] variables = {"codigo", true, codigo, "="};
        		lstDepartamento = businessDelegatorView.findByCriteriaInDepartamento(variables, null, null);
        		if(lstDepartamento == null || lstDepartamento.isEmpty()) {
        			entity = null;
        		}else {
        			entity = lstDepartamento.get(0);
        		}        		
        	}
        	
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
        	
        	descripcion = "";
        	estadoRegistro = null;
        	nombre = "";
            btnSave.setDisabled(false);
            deshabilitadoModificacion = false;
            
        } else {
        	
        	codigo = entity.getCodigo();
        	descripcion = entity.getDescripcion();
        	estadoRegistro = entity.getEstadoRegistro();
        	nombre = entity.getNombre();
        	deshabilitadoModificacion = true;
            btnSave.setDisabled(false);
        	
         }
    }

    public String action_save() {
        try {
            if ((selectedDepartamento == null) && (entity == null)) {
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
            entity = new Departamento();

            if(codigo == null || codigo.trim().equals("")) {
            	throw new Exception("Por favor ingrese un código");
            }        
            if(nombre == null || nombre.trim().equals("")) {
            	throw new Exception("Por favor ingrese un nombre");
            }           
            if(estadoRegistro == null  || estadoRegistro.trim().equals("")) {
            	throw new Exception("Por favor seleccione un estado");
            }
            
            entity.setCodigo(codigo);
            entity.setDescripcion(descripcion);
            entity.setEstadoRegistro(estadoRegistro);
            entity.setFechaCreacion(new Date());
            entity.setNombre(nombre);
            entity.setUsuCreador(usuarioSesion.getUsuario());
            businessDelegatorView.saveDepartamento(entity);
            FacesUtils.addInfoMessage("Se ha registrado el departamento satisfactoriamente");
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer depaId = new Integer(selectedDepartamento.getDepaId());
                entity = businessDelegatorView.getDepartamento(depaId);
            }

            if(codigo == null || codigo.trim().equals("")) {
            	throw new Exception("Por favor ingrese un código");
            }        
            if(nombre == null || nombre.trim().equals("")) {
            	throw new Exception("Por favor ingrese un nombre");
            }           
            if(estadoRegistro == null  || estadoRegistro.trim().equals("")) {
            	throw new Exception("Por favor seleccione un estado");
            }
            
            entity.setCodigo(codigo);
            entity.setDescripcion(descripcion);
            entity.setEstadoRegistro(estadoRegistro);
            entity.setNombre(nombre);
            entity.setUsuModificador(usuarioSesion.getUsuario());
            entity.setFechaModificacion(new Date());

            businessDelegatorView.updateDepartamento(entity);
            FacesUtils.addInfoMessage("Se ha modificado satisfactoriamente el departamento");
            
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

   

    public List<DepartamentoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataDepartamento();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DepartamentoDTO> departamentoDTO) {
        this.data = departamentoDTO;
    }

    public DepartamentoDTO getSelectedDepartamento() {
        return selectedDepartamento;
    }

    public void setSelectedDepartamento(DepartamentoDTO departamento) {
        this.selectedDepartamento = departamento;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getEntity() {
		return entity;
	}

	public void setEntity(Departamento entity) {
		this.entity = entity;
	}

	public UsuarioDTO getUsuarioSesion() {
		return usuarioSesion;
	}

	public void setUsuarioSesion(UsuarioDTO usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}

	public boolean isDeshabilitadoModificacion() {
		return deshabilitadoModificacion;
	}

	public void setDeshabilitadoModificacion(boolean deshabilitadoModificacion) {
		this.deshabilitadoModificacion = deshabilitadoModificacion;
	}
    
    
}
