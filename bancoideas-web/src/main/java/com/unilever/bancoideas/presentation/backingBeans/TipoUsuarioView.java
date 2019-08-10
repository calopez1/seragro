package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.TipoUsuarioDTO;
import com.unilever.bancoideas.modelo.dto.UsuarioDTO;
import com.unilever.bancoideas.presentation.businessDelegate.*;
import com.unilever.bancoideas.utilities.*;

import org.primefaces.component.commandbutton.CommandButton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;


import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TipoUsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoUsuarioView.class);
    
    private String codigo;
    private String descripcion;
    private String estadoRegistro;
    private String nombre;
    
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnClear;
    
    
    private List<TipoUsuarioDTO> data;
    private TipoUsuarioDTO selectedTipoUsuario;
    private TipoUsuario entity;
    
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    private UsuarioDTO usuarioSesion;
    private boolean deshabilitadoModificacion;
    
    public TipoUsuarioView() {
        super();
        usuarioSesion = (UsuarioDTO) FacesUtils.getManagedBeanFromSession("usuarioSesion");
    }

    public String action_new() {
        action_clear();
        selectedTipoUsuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoUsuario = null;

        codigo = "";
    	descripcion = "";
    	estadoRegistro = null;
    	nombre = "";
        deshabilitadoModificacion = false;
        data = null;

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        return "";
    }

    public void action_cargar_tipo_usuario() {
    	
    	if(selectedTipoUsuario != null) {
    		codigo = selectedTipoUsuario.getCodigo();
    		nombre = selectedTipoUsuario.getNombre();
    		descripcion = selectedTipoUsuario.getDescripcion();
    		estadoRegistro = selectedTipoUsuario.getEstadoRegistro();
    		
    		listener_codigo();
    		
    	}
    	
    }
    
    public void listener_codigo() {
        
    	List<TipoUsuario> lstTipoUsuario = null;
    	
    	try {
        	
        	if(codigo == null) {
        		entity = null;
        	}else{
        		
        		Object[] variables = {"codigo", true, codigo, "="};
        		lstTipoUsuario = businessDelegatorView.findByCriteriaInTipoUsuario(variables, null, null);
        		if(lstTipoUsuario == null || lstTipoUsuario.isEmpty()) {
        			entity = null;
        		}else {
        			entity = lstTipoUsuario.get(0);
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
            if ((selectedTipoUsuario == null) && (entity == null)) {
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
            entity = new TipoUsuario();

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
            businessDelegatorView.saveTipoUsuario(entity);
            FacesUtils.addInfoMessage("Se ha registrado el rol satisfactoriamente");
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
                Integer tiudId = new Integer(selectedTipoUsuario.getTiusId());
                entity = businessDelegatorView.getTipoUsuario(tiudId);
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
            entity.setUsuModifica(usuarioSesion.getUsuario());
            entity.setFechaModificacion(new Date());

            businessDelegatorView.updateTipoUsuario(entity);
            FacesUtils.addInfoMessage("Se ha modificado satisfactoriamente el rol");
            
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public List<TipoUsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoUsuarioDTO> tipoUsuarioDTO) {
        this.data = tipoUsuarioDTO;
    }

    public TipoUsuarioDTO getSelectedTipoUsuario() {
        return selectedTipoUsuario;
    }

    public void setSelectedTipoUsuario(TipoUsuarioDTO tipoUsuario) {
        this.selectedTipoUsuario = tipoUsuario;
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

	public TipoUsuario getEntity() {
		return entity;
	}

	public void setEntity(TipoUsuario entity) {
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
