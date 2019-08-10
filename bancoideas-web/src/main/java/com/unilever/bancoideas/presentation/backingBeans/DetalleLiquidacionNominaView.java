package com.unilever.bancoideas.presentation.backingBeans;

import groovy.json.internal.Charsets;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unilever.bancoideas.modelo.LiquidacionNomina;
import com.unilever.bancoideas.modelo.NominaEmpleado;
import com.unilever.bancoideas.modelo.dto.NominaEmpleadoDTO;
import com.unilever.bancoideas.modelo.dto.UsuarioDTO;
import com.unilever.bancoideas.presentation.businessDelegate.IBusinessDelegatorView;
import com.unilever.bancoideas.utilities.Constantes;
import com.unilever.bancoideas.utilities.FacesUtils;

import java.io.ByteArrayInputStream;
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
 *         www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class DetalleLiquidacionNominaView implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(DetalleLiquidacionNominaView.class);
	
	private static final long serialVersionUID = 1L;

	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	/// Variables para cabecera de liquidacion
	private String descripcion;
	private Date fechaDesde;
	private Date fechaHasta;
	private String estadoSeleccionado;
	private List<SelectItem> lstEstados = new ArrayList<SelectItem>();
	private LiquidacionNomina liquidacionNomina;
	private List<LiquidacionNomina> lstLiquidaciones = new ArrayList<LiquidacionNomina>();
	private List<NominaEmpleadoDTO> lstLiquidacionNominaEmpleado = new ArrayList<NominaEmpleadoDTO>();
	private NominaEmpleado liquidacionNominaEmpleado = new NominaEmpleado();
	private Double totalLiquidado;
	private StreamedContent fileReporteGenerado;
	private boolean pintarMensajeLiquidacionVacia;
	private Date fechaExpedicionComprobantes;
	// Variable de sesion
	private UsuarioDTO usuarioSesion;

	private boolean pintarBotonLiquidar;
	private boolean pintarBotonAprobar;
	private boolean pintarBotonPagar;


	
	public DetalleLiquidacionNominaView() {

		super();
		usuarioSesion = (UsuarioDTO) FacesUtils.getManagedBeanFromSession("usuarioSesion");
	}

	@PostConstruct
	public void liquidacionNomina() {

		try {

			// Se baja de sesion la liquidacion nomina
			liquidacionNomina = (LiquidacionNomina) FacesUtils.getManagedBeanFromSession(Constantes.SESION_LIQUIDACION_NOMINA);

			// En caso de no existir una liquidacion seleccionada se debe
			// mostrar el mensaje de seleccionar liquidacion
			if (liquidacionNomina == null) {
				pintarMensajeLiquidacionVacia = true;
			} else {
				pintarMensajeLiquidacionVacia = false;
			}

			// Solo se puede liquidar si la liquidacion está en esta pre-nomina
			// o creada
			if (liquidacionNomina != null && (liquidacionNomina.getEstado().equals(Constantes.ESTADO_LIQUIDACION_CREADA))) {
				pintarBotonLiquidar = true;
				pintarBotonAprobar = false;
				pintarBotonPagar = false;
			} else if (liquidacionNomina.getEstado().equals(Constantes.ESTADO_LIQUIDACION_PRE_NOMINA)) {
				pintarBotonLiquidar = true;
				pintarBotonAprobar = true;
				pintarBotonPagar = false;
			} else if (liquidacionNomina.getEstado().equals(Constantes.ESTADO_LIQUIDACION_LIQUIDADA)) {
				pintarBotonLiquidar = false;
				pintarBotonAprobar = false;
				pintarBotonPagar = true;
			} else {
				pintarBotonLiquidar = false;
				pintarBotonAprobar = false;
				pintarBotonPagar = false;
			}

			// Se consulta los empleados liquidados si existen
			if (liquidacionNomina != null) {
				lstLiquidacionNominaEmpleado = businessDelegatorView.consultarLiquidacionNominaEmpleadoXLiquidacionNomina(liquidacionNomina.getLinoId());
			}


		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

	}


	public void action_liquidarNomina() {

		try {
			businessDelegatorView.liquidarNomina(liquidacionNomina,usuarioSesion);

			liquidacionNomina.setEstado(Constantes.ESTADO_LIQUIDACION_PRE_NOMINA);
			lstLiquidacionNominaEmpleado = businessDelegatorView.consultarLiquidacionNominaEmpleadoXLiquidacionNomina(liquidacionNomina.getLinoId());
			FacesUtils.addInfoMessage("Se ha liquidado la nómina satisfactoriamente");

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

	}

	public void action_liquidar_empleado() {

		try {

//			businessDelegatorView.liquidarEmpleado(liquidacionNominaEmpleado.getLineId(), usuCodigo,
//					liquidacionNomina.getFechaInicio(), liquidacionNomina.getFechaFin(), anoFiscal,
//					Constantes.ESTADO_LIQUIDACION_PRE_NOMINA);
//
//			liquidacionNomina.setEstado(Constantes.ESTADO_LIQUIDACION_PRE_NOMINA);
//			liquidacionNomina.setEstadoDescripcion("Pre-Nomina");
//			lstLiquidacionNominaEmpleado = businessDelegatorView
//					.consultarLiquidacionNominaEmpleadoXLiquidacionNomina(liquidacionNomina.getLinoId(), anoFiscal);
			FacesUtils.addInfoMessage("Se ha liquidado la nómina satisfactoriamente");

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

	}

	public void action_detallar_conceptos() {

		try {

//			// Se consulta los concepto de nomina para el nomina empleado
//			// seleccionado
//			lstTipoConceptoNomina = businessDelegatorView
//					.consultarConceptosNominaXNominaEmpleado(liquidacionNominaEmpleado.getLineId());
//			totalLiquidado = 0d;
//
//			for (TipoConceptoNominaDTO tipoConcepto : lstTipoConceptoNomina) {
//				totalLiquidado = totalLiquidado + tipoConcepto.getTotal();
//			}

			System.out.println("Datallar conceptos");
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

	}

	public void action_aprobar() {

		try {

//			liquidacionNomina = businessDelegatorView.aprobarLiquidacionNomina(liquidacionNomina, usuCodigo);
//			FacesUtils.addInfoMessage("Liquidación de Nómina Aprobada Satisfactoriamente");
//
//			pintarBotonLiquidar = false;
//			pintarBotonAprobar = false;
//			pintarBotonPagar = true;

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

	}

	public void action_pagar(ActionEvent event) {

		try {

//			if (solicitudCDPSeleccionada == null) {
//				throw new Exception("Debe seleccionar la Solicitud de CDP asociada al pago de la nómina");
//			}
//
//			cdpPagada = businessDelegatorView.pagarNominaLiquidada(liquidacionNomina.getLinoId(),
//					solicitudCDPSeleccionada.getScdpId(), usuCodigo, fechaExpedicionComprobantes);
//
//			log.info("Id: " + cdpPagada.getCdpId() + ", Consecutivo: " + cdpPagada.getConsecutivo());
//			
//			FacesUtils.addInfoMessage(
//					"Se han creado exitosamente los documentos presupuestales y de tesorería correspondientes a la nómina");
//
//			FacesUtils.hideDialog("dialogoPagarNomina");
//
//			FacesUtils.showDialog("dlgGenerarReportes");
//			
			pintarBotonLiquidar = false;
			pintarBotonAprobar = false;
			pintarBotonPagar = false;

		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

	}

	

	/////////////////////////////////////////////////////////////////////////////
	////////////////////// GETTERS AND
	///////////////////////////////////////////////////////////////////////////// SETTERS////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
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

	public boolean isPintarMensajeLiquidacionVacia() {
		return pintarMensajeLiquidacionVacia;
	}

	public void setPintarMensajeLiquidacionVacia(boolean pintarMensajeLiquidacionVacia) {
		this.pintarMensajeLiquidacionVacia = pintarMensajeLiquidacionVacia;
	}

	public boolean isPintarBotonLiquidar() {
		return pintarBotonLiquidar;
	}

	public void setPintarBotonLiquidar(boolean pintarBotonLiquidar) {
		this.pintarBotonLiquidar = pintarBotonLiquidar;
	}
	
	public Double getTotalLiquidado() {
		return totalLiquidado;
	}

	public void setTotalLiquidado(Double totalLiquidado) {
		this.totalLiquidado = totalLiquidado;
	}

	public boolean isPintarBotonAprobar() {
		return pintarBotonAprobar;
	}

	public void setPintarBotonAprobar(boolean pintarBotonAprobar) {
		this.pintarBotonAprobar = pintarBotonAprobar;
	}

	public boolean isPintarBotonPagar() {
		return pintarBotonPagar;
	}

	public void setPintarBotonPagar(boolean pintarBotonPagar) {
		this.pintarBotonPagar = pintarBotonPagar;
	}

	public StreamedContent getFileReporteGenerado() {
		return fileReporteGenerado;
	}

	public void setFileReporteGenerado(StreamedContent fileReporteGenerado) {
		this.fileReporteGenerado = fileReporteGenerado;
	}

	public Date getFechaExpedicionComprobantes() {
		return fechaExpedicionComprobantes;
	}

	public void setFechaExpedicionComprobantes(Date fechaExpedicionComprobantes) {
		this.fechaExpedicionComprobantes = fechaExpedicionComprobantes;
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

	public List<NominaEmpleadoDTO> getLstLiquidacionNominaEmpleado() {
		return lstLiquidacionNominaEmpleado;
	}

	public void setLstLiquidacionNominaEmpleado(List<NominaEmpleadoDTO> lstLiquidacionNominaEmpleado) {
		this.lstLiquidacionNominaEmpleado = lstLiquidacionNominaEmpleado;
	}

	public NominaEmpleado getLiquidacionNominaEmpleado() {
		return liquidacionNominaEmpleado;
	}

	public void setLiquidacionNominaEmpleado(NominaEmpleado liquidacionNominaEmpleado) {
		this.liquidacionNominaEmpleado = liquidacionNominaEmpleado;
	}

	public UsuarioDTO getUsuarioSesion() {
		return usuarioSesion;
	}

	public void setUsuarioSesion(UsuarioDTO usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}

	
}
