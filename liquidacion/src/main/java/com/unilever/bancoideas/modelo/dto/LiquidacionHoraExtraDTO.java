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
    private String estadoRegistro;
    private Date fecha;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Integer horasTrabajadas;
    private Integer lhoeId;
    private Double totalPagarHorasExtras;
    private Double totalPagarRecargo;
    private String usuCreador;
    private String usuModificador;
    private Double valorHoraExtra;
    private Double valorRecargo;
    private Integer noemId_NominaEmpleado;
    private Integer thoeId_TipoHoraExtra;

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Integer getLhoeId() {
        return lhoeId;
    }

    public void setLhoeId(Integer lhoeId) {
        this.lhoeId = lhoeId;
    }

    public Double getTotalPagarHorasExtras() {
        return totalPagarHorasExtras;
    }

    public void setTotalPagarHorasExtras(Double totalPagarHorasExtras) {
        this.totalPagarHorasExtras = totalPagarHorasExtras;
    }

    public Double getTotalPagarRecargo() {
        return totalPagarRecargo;
    }

    public void setTotalPagarRecargo(Double totalPagarRecargo) {
        this.totalPagarRecargo = totalPagarRecargo;
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

    public Double getValorHoraExtra() {
        return valorHoraExtra;
    }

    public void setValorHoraExtra(Double valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }

    public Double getValorRecargo() {
        return valorRecargo;
    }

    public void setValorRecargo(Double valorRecargo) {
        this.valorRecargo = valorRecargo;
    }

    public Integer getNoemId_NominaEmpleado() {
        return noemId_NominaEmpleado;
    }

    public void setNoemId_NominaEmpleado(Integer noemId_NominaEmpleado) {
        this.noemId_NominaEmpleado = noemId_NominaEmpleado;
    }

    public Integer getThoeId_TipoHoraExtra() {
        return thoeId_TipoHoraExtra;
    }

    public void setThoeId_TipoHoraExtra(Integer thoeId_TipoHoraExtra) {
        this.thoeId_TipoHoraExtra = thoeId_TipoHoraExtra;
    }
}
