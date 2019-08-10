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
public class DetalleNominaEmpleadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DetalleNominaEmpleadoDTO.class);
    private Double auxilioAlimentacion;
    private Double auxilioTransporte;
    private Integer dnoeId;
    private String estadoRegistro;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Double pension;
    private Double salarioLiquidado;
    private Double salud;
    private String usuCreador;
    private String usuModificador;
    private Double valorHorasExtras;
    private Integer noemId_NominaEmpleado;

    public Double getAuxilioAlimentacion() {
        return auxilioAlimentacion;
    }

    public void setAuxilioAlimentacion(Double auxilioAlimentacion) {
        this.auxilioAlimentacion = auxilioAlimentacion;
    }

    public Double getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public void setAuxilioTransporte(Double auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }

    public Integer getDnoeId() {
        return dnoeId;
    }

    public void setDnoeId(Integer dnoeId) {
        this.dnoeId = dnoeId;
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

    public Double getPension() {
        return pension;
    }

    public void setPension(Double pension) {
        this.pension = pension;
    }

    public Double getSalarioLiquidado() {
        return salarioLiquidado;
    }

    public void setSalarioLiquidado(Double salarioLiquidado) {
        this.salarioLiquidado = salarioLiquidado;
    }

    public Double getSalud() {
        return salud;
    }

    public void setSalud(Double salud) {
        this.salud = salud;
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

    public Double getValorHorasExtras() {
        return valorHorasExtras;
    }

    public void setValorHorasExtras(Double valorHorasExtras) {
        this.valorHorasExtras = valorHorasExtras;
    }

    public Integer getNoemId_NominaEmpleado() {
        return noemId_NominaEmpleado;
    }

    public void setNoemId_NominaEmpleado(Integer noemId_NominaEmpleado) {
        this.noemId_NominaEmpleado = noemId_NominaEmpleado;
    }
}
