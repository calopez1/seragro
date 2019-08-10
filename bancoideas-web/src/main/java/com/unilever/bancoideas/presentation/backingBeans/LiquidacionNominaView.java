package com.unilever.bancoideas.presentation.backingBeans;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;

import com.unilever.bancoideas.modelo.LiquidacionNomina;
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
public class LiquidacionNominaView implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    ///Variables para cabecera de liquidacion
    private String descripcion;
    private Date fechaDesde;
    private Date fechaHasta;
    private String estadoSeleccionado;
    private List<SelectItem> lstEstados = new ArrayList<SelectItem>();
    private LiquidacionNomina liquidacionNomina;
    private List<LiquidacionNomina> lstLiquidaciones = new ArrayList<LiquidacionNomina>();
    private String periodoLiquidacion;
    private List<SelectItem> lstAnosLiquidacion = new ArrayList<SelectItem>();
    private String anoLiquidacion;
    private String mesLiquidacion;
    
    
    //Variable de sesion
    private UsuarioDTO usuarioSesion;
    
    public LiquidacionNominaView() {
        super();
		usuarioSesion = (UsuarioDTO) FacesUtils.getManagedBeanFromSession("usuarioSesion");

    }
    
    @PostConstruct
    public void liquidacionNomina(){
    	
    	try {
    		
    		//Se elimina la liquidacion nomina de sesion
    		FacesUtils.setManagedBeanInSession("liquidacionNomina", null);
    		
        	//Se cargan la lista de estado
		   lstEstados.add(new SelectItem(Constantes.ESTADO_LIQUIDACION_CREADA, "Creada"));
		   lstEstados.add(new SelectItem(Constantes.ESTADO_LIQUIDACION_PRE_NOMINA, "Pre Nomina"));
		   lstEstados.add(new SelectItem(Constantes.ESTADO_LIQUIDACION_LIQUIDADA, "Liquidada"));
		   lstEstados.add(new SelectItem(Constantes.ESTADO_LIQUIDACION_PAGADA, "Pagada"));
		 
		   //Se consultan las liquidaciones existentes
		   consultarLiquidacionNomina();
		  
		   //Se sugiere el año actual
		   java.util.Calendar cal= java.util.Calendar.getInstance();
		   int year= cal.get(java.util.Calendar.YEAR);		   
		   anoLiquidacion = year + "";
		   
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    	
    }
    

   public void action_guardarLiquidacionNomina(){
    	
	   
    	try {
    		
    		//Se guarda la liqudacion de nomina cabecera
    		businessDelegatorView.guardarLiquidacionNomina(descripcion, usuarioSesion, mesLiquidacion, anoLiquidacion, periodoLiquidacion);
    		FacesUtils.addInfoMessage("Se ha creado el periodo de nomina satisfactoriamente");
    		
    		//Se vuelven a consultar las liquidacion de nomina
    		consultarLiquidacionNomina();

    		
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
    	
    }
   
   public void consultarLiquidacionNomina() throws Exception{
	   
	   try {
		   
		   //Se consultan las liquidaciones existentes	   
		   Object[] variables = {"estadoRegistro", true, Constantes.ESTADO_ACTIVO, "="};
		   lstLiquidaciones = businessDelegatorView.findByCriteriaInLiquidacionNomina(variables, null, null);
		   
	   }catch (Exception e) {
		   throw e;
	   }
	  
   }
   
   public String action_ir_detalle_liquidacion(){
   	
   	try {
   		
   		//Se coloca en sesion la liquidacion de nomina seleccionada
		FacesUtils.setManagedBeanInSession(Constantes.SESION_LIQUIDACION_NOMINA, liquidacionNomina);
		return "detalleLiquidarNomina";
   		
	} catch (Exception e) {
		FacesUtils.addErrorMessage(e.getMessage());
	}
	return null;

   }
   
   
   public void action_limpiarLiquidacionNomina(){
   	
   	try {
	   	 descripcion = "";
	     fechaDesde = null;
	     fechaHasta = null;
	     estadoSeleccionado = "";
	     
	     //Se sugiere el año actual
		   java.util.Calendar cal= java.util.Calendar.getInstance();
		   int year= cal.get(java.util.Calendar.YEAR);		   
		   anoLiquidacion = year + "";
		   
	      mesLiquidacion = "-1";
	      periodoLiquidacion = "-1";
	     
   	}catch (Exception e){
   		FacesUtils.addErrorMessage(e.getMessage());
   	}
   
   }
    
    
    /////////////////////////////////////////////////////////////////////////////
    //////////////////////GETTERS AND SETTERS////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////
   
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getEstadoSeleccionado() {
		return estadoSeleccionado;
	}

	public void setEstadoSeleccionado(String estadoSeleccionado) {
		this.estadoSeleccionado = estadoSeleccionado;
	}

	public List<SelectItem> getLstEstados() {
		return lstEstados;
	}

	public void setLstEstados(List<SelectItem> lstEstados) {
		this.lstEstados = lstEstados;
	}

	public LiquidacionNomina getLiquidacionNomina() {
		return liquidacionNomina;
	}

	public void setLiquidacionNomina(LiquidacionNomina liquidacionNomina) {
		this.liquidacionNomina = liquidacionNomina;
	}

	public List<LiquidacionNomina> getLstLiquidaciones() {
		return lstLiquidaciones;
	}

	public void setLstLiquidaciones(List<LiquidacionNomina> lstLiquidaciones) {
		this.lstLiquidaciones = lstLiquidaciones;
	}

	public UsuarioDTO getUsuarioSesion() {
		return usuarioSesion;
	}

	public void setUsuarioSesion(UsuarioDTO usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}

	public String getPeriodoLiquidacion() {
		return periodoLiquidacion;
	}

	public void setPeriodoLiquidacion(String periodoLiquidacion) {
		this.periodoLiquidacion = periodoLiquidacion;
	}

	public List<SelectItem> getLstAnosLiquidacion() {
		
		if(lstAnosLiquidacion == null) {
			lstAnosLiquidacion = new ArrayList<SelectItem>();
		}else {
			lstAnosLiquidacion.clear();
		}
		
		for(int i= 2018; i <2050; i++) {
			lstAnosLiquidacion.add(new SelectItem(i+"",i+""));
		}
		
		return lstAnosLiquidacion;
	}

	public void setLstAnosLiquidacion(List<SelectItem> lstAnosLiquidacion) {
		this.lstAnosLiquidacion = lstAnosLiquidacion;
	}

	public String getAnoLiquidacion() {
		return anoLiquidacion;
	}

	public void setAnoLiquidacion(String anoLiquidacion) {
		this.anoLiquidacion = anoLiquidacion;
	}

	public String getMesLiquidacion() {
		return mesLiquidacion;
	}

	public void setMesLiquidacion(String mesLiquidacion) {
		this.mesLiquidacion = mesLiquidacion;
	}

	
    
}
