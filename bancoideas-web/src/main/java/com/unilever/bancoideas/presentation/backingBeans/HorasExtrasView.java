package com.unilever.bancoideas.presentation.backingBeans;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;

import com.unilever.bancoideas.modelo.Cargo;
import com.unilever.bancoideas.modelo.Empleado;
import com.unilever.bancoideas.modelo.HoraExtraEmpleado;
import com.unilever.bancoideas.modelo.LiquidacionNomina;
import com.unilever.bancoideas.modelo.TipoHoraExtra;
import com.unilever.bancoideas.modelo.dto.EmpleadoDTO;
import com.unilever.bancoideas.modelo.dto.HoraExtraEmpleadoDTO;
import com.unilever.bancoideas.modelo.dto.LiquidacionNominaDTO;
import com.unilever.bancoideas.modelo.dto.UsuarioDTO;
import com.unilever.bancoideas.presentation.businessDelegate.IBusinessDelegatorView;
import com.unilever.bancoideas.utilities.Constantes;
import com.unilever.bancoideas.utilities.FacesUtils;

import java.io.Serializable;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class HorasExtrasView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    ///Variables para horas extras
    private String tipoHoraExtraSeleccionada;
    private List<TipoHoraExtra> lstTipoHoraExtra;
    private List<SelectItem> lstTipoHoraExtraItem;
    
    private String empleadoSeleccionado;
    private List<Empleado> lstEmpleado;
    private List<SelectItem> lstEmpleadoItem;
    
    private Date fecha;
    private Double numeroHoras;
    private String estadoRegistro;
    
    private HoraExtraEmpleadoDTO horaExtraSeleccionada;
    private List<HoraExtraEmpleadoDTO> data;
    
    //Variable de sesion
    private UsuarioDTO usuarioSesion;
    
    private boolean modificar;
    
    public HorasExtrasView() {
        super();
		usuarioSesion = (UsuarioDTO) FacesUtils.getManagedBeanFromSession("usuarioSesion");

    }
    
    @PostConstruct
    public void liquidacionNomina(){
    	
    	try {
    		
    		//Se sugiere la fecha actual
    		fecha = new Date();
    		estadoRegistro = Constantes.ESTADO_ACTIVO;
		   
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    	
    }
    
	public String action_guardar() {
		
		
		
		try {
			
			//Se realizan las validaciones de ingreso
			if(tipoHoraExtraSeleccionada == null || tipoHoraExtraSeleccionada.equals("-1")) {
				throw new Exception("Por favor seleccione un tipo hora extra");
			}
			if(empleadoSeleccionado == null || empleadoSeleccionado.equals("-1")) {
				throw new Exception("Por favor seleccione un empleado");
			}
			if(fecha == null) {
				throw new Exception("Por favor seleccione una fecha");
			}
			
			if(numeroHoras == null) {
				throw new Exception("Por favor ingrese el número de horas");
			}
			
			if(numeroHoras <=0) {
				throw new Exception("El número de horas ingresado es incorrecto");
			}
			
			if(numeroHoras > 24) {
				throw new Exception("Excede el número de horas diarias permitidas");
			}
			
			if(estadoRegistro == null) {
				throw new Exception("Por favor seleccione un estado");
			}
			
			
			if(modificar == true) {
				
				HoraExtraEmpleado hoex = businessDelegatorView.getHoraExtraEmpleado(horaExtraSeleccionada.getHexmId());
				hoex.setEstadoRegistro(estadoRegistro);
				hoex.setCantidadHoras(numeroHoras.doubleValue());
				businessDelegatorView.updateHoraExtraEmpleado(hoex);
				
				FacesUtils.addInfoMessage("Horas extras actualizada satisfactoriamente");
				data = null;
				
			}else {
				
				
				//Se arma el objeto a guardar
				HoraExtraEmpleado hoex = new HoraExtraEmpleado();
				hoex.setCantidadHoras(numeroHoras.doubleValue());
				hoex.setEstadoRegistro(estadoRegistro);
				hoex.setFecha(fecha);
				hoex.setUsuCreador(usuarioSesion.getUsuario());
				hoex.setFechaCreacion(new Date());
				
				//Se consulta el tipo de hora extra
				TipoHoraExtra thoe = businessDelegatorView.getTipoHoraExtra(Integer.parseInt(tipoHoraExtraSeleccionada));
				hoex.setTipoHoraExtra(thoe);
				//Se consulta el empleado
				Empleado empl = businessDelegatorView.getEmpleado(Integer.parseInt(empleadoSeleccionado));
				hoex.setEmpleado(empl);
				businessDelegatorView.saveHoraExtraEmpleado(hoex);
				
				FacesUtils.addInfoMessage("Horas extras registraadas satisfactoriamente");
				data = null;
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		return "";
	}
	
	public void action_cargar_hora() {
    	
    	try {
			
			
	    	if(horaExtraSeleccionada != null) {
	    		
	    		modificar = true;
	    		empleadoSeleccionado = horaExtraSeleccionada.getEmplId()+"";
	    		tipoHoraExtraSeleccionada = horaExtraSeleccionada.getThoeId()+"";
	    		fecha = horaExtraSeleccionada.getFecha();
	    		numeroHoras = horaExtraSeleccionada.getCantidadHoras();
	    	}
    	} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());		
    	}
    	
    }
    

	public String action_limpiar() {
		tipoHoraExtraSeleccionada = "-1";
		fecha = new Date();
		numeroHoras = null;
		empleadoSeleccionado = "-1";
		modificar = false;
		horaExtraSeleccionada = null;
		return "";
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public String getTipoHoraExtraSeleccionada() {
		return tipoHoraExtraSeleccionada;
	}

	public void setTipoHoraExtraSeleccionada(String tipoHoraExtraSeleccionada) {
		this.tipoHoraExtraSeleccionada = tipoHoraExtraSeleccionada;
	}

	public List<TipoHoraExtra> getLstTipoHoraExtra() {
		return lstTipoHoraExtra;
	}

	public void setLstTipoHoraExtra(List<TipoHoraExtra> lstTipoHoraExtra) {
		this.lstTipoHoraExtra = lstTipoHoraExtra;
	}

	public List<SelectItem> getLstTipoHoraExtraItem() {
		 try {
	            if (lstTipoHoraExtra == null) {
		        	Object[] variables = {"estadoRegistro", true, Constantes.ESTADO_ACTIVO, "="};
		        	lstTipoHoraExtra = businessDelegatorView.findByCriteriaInTipoHoraExtra(variables, null, null);
	            }
	            
	            if(lstTipoHoraExtraItem == null) {
	            	lstTipoHoraExtraItem = new ArrayList<>();
	            }else {
	            	lstTipoHoraExtraItem.clear();
	            }
	            
	            for(TipoHoraExtra thoe: lstTipoHoraExtra) {
	            	lstTipoHoraExtraItem.add(new SelectItem(thoe.getThoeId(),thoe.getDescripcion()));
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		 
		return lstTipoHoraExtraItem;
	}

	public void setLstTipoHoraExtraItem(List<SelectItem> lstTipoHoraExtraItem) {
		this.lstTipoHoraExtraItem = lstTipoHoraExtraItem;
	}

	public UsuarioDTO getUsuarioSesion() {
		return usuarioSesion;
	}

	public void setUsuarioSesion(UsuarioDTO usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(Double numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public String getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}

	public void setEmpleadoSeleccionado(String empleadoSeleccionado) {
		this.empleadoSeleccionado = empleadoSeleccionado;
	}

	public List<Empleado> getLstEmpleado() {
		return lstEmpleado;
	}

	public void setLstEmpleado(List<Empleado> lstEmpleado) {
		this.lstEmpleado = lstEmpleado;
	}

	public List<SelectItem> getLstEmpleadoItem() {
		try {
            if (lstEmpleado == null) {
	        	Object[] variables = {"estadoRegistro", true, Constantes.ESTADO_ACTIVO, "="};
	        	lstEmpleado = businessDelegatorView.findByCriteriaInEmpleado(variables, null, null);
            }
            
            if(lstEmpleadoItem == null) {
            	lstEmpleadoItem = new ArrayList<>();
            }else {
            	lstEmpleadoItem.clear();
            }
            
            String nombre = "";
            
            for(Empleado empl: lstEmpleado) {
            	nombre = empl.getPersona().getPrimerApellido() + (empl.getPersona().getSegundoApellido() == null ? "": " "+empl.getPersona().getSegundoApellido())
            			+ (" " + empl.getPersona().getPrimerNombre())
            			+ (empl.getPersona().getSegundoNombre() == null ? "": " "+empl.getPersona().getSegundoNombre());
            			
            	lstEmpleadoItem.add(new SelectItem(empl.getEmplId(),empl.getPersona().getIdentificacion() + " - " + nombre));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return lstEmpleadoItem;
	}

	public void setLstEmpleadoItem(List<SelectItem> lstEmpleadoItem) {
		this.lstEmpleadoItem = lstEmpleadoItem;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public HoraExtraEmpleadoDTO getHoraExtraSeleccionada() {
		return horaExtraSeleccionada;
	}

	public void setHoraExtraSeleccionada(HoraExtraEmpleadoDTO horaExtraSeleccionada) {
		this.horaExtraSeleccionada = horaExtraSeleccionada;
	}

	public List<HoraExtraEmpleadoDTO> getData() {
		 try {
	            if (data == null) {
	                data = businessDelegatorView.getDataHoraExtraEmpleado();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return data;	}

	public void setData(List<HoraExtraEmpleadoDTO> data) {
		this.data = data;
	}

	public boolean isModificar() {
		return modificar;
	}

	public void setModificar(boolean modificar) {
		this.modificar = modificar;
	}
    
	
   
	
    
}
