package com.unilever.bancoideas.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura/
* www.zathuracode.org
*
*/
public class NominaEmpleadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(NominaEmpleadoDTO.class);
    private Double deducciones;
    private Integer diasLaborados;
    private String estadoRegistro;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Integer noemId;
    private Double totalPagar;
    private String usuCreador;
    private String usuModificador;
    private Integer emplId;
    private Integer linoId_LiquidacionNomina;
    private String codidoEmpleado;
    private Integer persId;
    private String identificacion;
    private String nombre;
    private Integer tiidId;
    private String codigoTipoIdentificacion;
    private String nombreTipoIdentificacion;
    private Integer cargId;
    private String codigoCargo;
    private String nombreCargo;
    private Double totalDeduccion;
    private Double totalDevengado;
	private Double totalHorasExtras;
	
	public Double getDeducciones() {
		return deducciones;
	}
	public void setDeducciones(Double deducciones) {
		this.deducciones = deducciones;
	}
	public Integer getDiasLaborados() {
		return diasLaborados;
	}
	public void setDiasLaborados(Integer diasLaborados) {
		this.diasLaborados = diasLaborados;
	}
	public String getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Double getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}
	public String getUsuCreador() {
		return usuCreador;
	}
	public void setUsuCreador(String usuCreador) {
		this.usuCreador = usuCreador;
	}
	public String getUsuModificador() {
		return usuModificador;
	}
	public void setUsuModificador(String usuModificador) {
		this.usuModificador = usuModificador;
	}
	public Integer getLinoId_LiquidacionNomina() {
		return linoId_LiquidacionNomina;
	}
	public void setLinoId_LiquidacionNomina(Integer linoId_LiquidacionNomina) {
		this.linoId_LiquidacionNomina = linoId_LiquidacionNomina;
	}
	public String getCodidoEmpleado() {
		return codidoEmpleado;
	}
	public void setCodidoEmpleado(String codidoEmpleado) {
		this.codidoEmpleado = codidoEmpleado;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoTipoIdentificacion() {
		return codigoTipoIdentificacion;
	}
	public void setCodigoTipoIdentificacion(String codigoTipoIdentificacion) {
		this.codigoTipoIdentificacion = codigoTipoIdentificacion;
	}
	public String getNombreTipoIdentificacion() {
		return nombreTipoIdentificacion;
	}
	public void setNombreTipoIdentificacion(String nombreTipoIdentificacion) {
		this.nombreTipoIdentificacion = nombreTipoIdentificacion;
	}
	public String getCodigoCargo() {
		return codigoCargo;
	}
	public void setCodigoCargo(String codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
	public String getNombreCargo() {
		return nombreCargo;
	}
	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
	public Integer getNoemId() {
		return noemId;
	}
	public void setNoemId(Integer noemId) {
		this.noemId = noemId;
	}
	public Integer getEmplId() {
		return emplId;
	}
	public void setEmplId(Integer emplId) {
		this.emplId = emplId;
	}
	public Integer getPersId() {
		return persId;
	}
	public void setPersId(Integer persId) {
		this.persId = persId;
	}
	public Integer getTiidId() {
		return tiidId;
	}
	public void setTiidId(Integer tiidId) {
		this.tiidId = tiidId;
	}
	public Integer getCargId() {
		return cargId;
	}
	public void setCargId(Integer cargId) {
		this.cargId = cargId;
	}
	public Double getTotalDeduccion() {
		return totalDeduccion;
	}
	public void setTotalDeduccion(Double totalDeduccion) {
		this.totalDeduccion = totalDeduccion;
	}
	public Double getTotalDevengado() {
		return totalDevengado;
	}
	public void setTotalDevengado(Double totalDevengado) {
		this.totalDevengado = totalDevengado;
	}
	public Double getTotalHorasExtras() {
		return totalHorasExtras;
	}
	public void setTotalHorasExtras(Double totalHorasExtras) {
		this.totalHorasExtras = totalHorasExtras;
	}

	
}
