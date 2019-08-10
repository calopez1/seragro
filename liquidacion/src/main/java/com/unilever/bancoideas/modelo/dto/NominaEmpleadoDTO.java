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
    private Integer emplId_Empleado;
    private Integer linoId_LiquidacionNomina;

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

    public Integer getNoemId() {
        return noemId;
    }

    public void setNoemId(Integer noemId) {
        this.noemId = noemId;
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

    public Integer getEmplId_Empleado() {
        return emplId_Empleado;
    }

    public void setEmplId_Empleado(Integer emplId_Empleado) {
        this.emplId_Empleado = emplId_Empleado;
    }

    public Integer getLinoId_LiquidacionNomina() {
        return linoId_LiquidacionNomina;
    }

    public void setLinoId_LiquidacionNomina(Integer linoId_LiquidacionNomina) {
        this.linoId_LiquidacionNomina = linoId_LiquidacionNomina;
    }
}
