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
public class LiquidacionHoraExtraDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LiquidacionHoraExtraDTO.class);
    private Double cantidadHoras;
    private String estadoRegistro;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Integer lhoeId;
    private Double porcentaje;
    private Double totalPagar;
    private String usuCreador;
    private String usuModificador;
    private Double valor;
    private Integer hexmId_HoraExtraEmpleado;
    private Integer noemId_NominaEmpleado;

  

    public Double getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(Double cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
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

    public Integer getLhoeId() {
        return lhoeId;
    }

    public void setLhoeId(Integer lhoeId) {
        this.lhoeId = lhoeId;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getHexmId_HoraExtraEmpleado() {
        return hexmId_HoraExtraEmpleado;
    }

    public void setHexmId_HoraExtraEmpleado(Integer hexmId_HoraExtraEmpleado) {
        this.hexmId_HoraExtraEmpleado = hexmId_HoraExtraEmpleado;
    }

    public Integer getNoemId_NominaEmpleado() {
        return noemId_NominaEmpleado;
    }

    public void setNoemId_NominaEmpleado(Integer noemId_NominaEmpleado) {
        this.noemId_NominaEmpleado = noemId_NominaEmpleado;
    }
}
