package com.unilever.bancoideas.modelo;
// Generated 9/08/2019 11:14:06 AM by Hibernate Tools 4.0.0


import java.util.Date;

/**
 * DetalleNominaEmpleado generated by hbm2java
 */
public class DetalleNominaEmpleado  implements java.io.Serializable {


     private Integer dnoeId;
     private NominaEmpleado nominaEmpleado;
     private Double salarioLiquidado;
     private Double auxilioTransporte;
     private Double auxilioAlimentacion;
     private Double valorHorasExtras;
     private Double salud;
     private Double pension;
     private String usuCreador;
     private String usuModificador;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estadoRegistro;

    public DetalleNominaEmpleado() {
    }

	
    public DetalleNominaEmpleado(Integer dnoeId, NominaEmpleado nominaEmpleado, Double salarioLiquidado, Double auxilioTransporte, Double auxilioAlimentacion, Double valorHorasExtras, Double salud, Double pension, String usuCreador, Date fechaCreacion, String estadoRegistro) {
        this.dnoeId = dnoeId;
        this.nominaEmpleado = nominaEmpleado;
        this.salarioLiquidado = salarioLiquidado;
        this.auxilioTransporte = auxilioTransporte;
        this.auxilioAlimentacion = auxilioAlimentacion;
        this.valorHorasExtras = valorHorasExtras;
        this.salud = salud;
        this.pension = pension;
        this.usuCreador = usuCreador;
        this.fechaCreacion = fechaCreacion;
        this.estadoRegistro = estadoRegistro;
    }
    public DetalleNominaEmpleado(Integer dnoeId, NominaEmpleado nominaEmpleado, Double salarioLiquidado, Double auxilioTransporte, Double auxilioAlimentacion, Double valorHorasExtras, Double salud, Double pension, String usuCreador, String usuModificador, Date fechaCreacion, Date fechaModificacion, String estadoRegistro) {
       this.dnoeId = dnoeId;
       this.nominaEmpleado = nominaEmpleado;
       this.salarioLiquidado = salarioLiquidado;
       this.auxilioTransporte = auxilioTransporte;
       this.auxilioAlimentacion = auxilioAlimentacion;
       this.valorHorasExtras = valorHorasExtras;
       this.salud = salud;
       this.pension = pension;
       this.usuCreador = usuCreador;
       this.usuModificador = usuModificador;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estadoRegistro = estadoRegistro;
    }
   
    public Integer getDnoeId() {
        return this.dnoeId;
    }
    
    public void setDnoeId(Integer dnoeId) {
        this.dnoeId = dnoeId;
    }
    public NominaEmpleado getNominaEmpleado() {
        return this.nominaEmpleado;
    }
    
    public void setNominaEmpleado(NominaEmpleado nominaEmpleado) {
        this.nominaEmpleado = nominaEmpleado;
    }
    public Double getSalarioLiquidado() {
        return this.salarioLiquidado;
    }
    
    public void setSalarioLiquidado(Double salarioLiquidado) {
        this.salarioLiquidado = salarioLiquidado;
    }
    public Double getAuxilioTransporte() {
        return this.auxilioTransporte;
    }
    
    public void setAuxilioTransporte(Double auxilioTransporte) {
        this.auxilioTransporte = auxilioTransporte;
    }
    public Double getAuxilioAlimentacion() {
        return this.auxilioAlimentacion;
    }
    
    public void setAuxilioAlimentacion(Double auxilioAlimentacion) {
        this.auxilioAlimentacion = auxilioAlimentacion;
    }
    public Double getValorHorasExtras() {
        return this.valorHorasExtras;
    }
    
    public void setValorHorasExtras(Double valorHorasExtras) {
        this.valorHorasExtras = valorHorasExtras;
    }
    public Double getSalud() {
        return this.salud;
    }
    
    public void setSalud(Double salud) {
        this.salud = salud;
    }
    public Double getPension() {
        return this.pension;
    }
    
    public void setPension(Double pension) {
        this.pension = pension;
    }
    public String getUsuCreador() {
        return this.usuCreador;
    }
    
    public void setUsuCreador(String usuCreador) {
        this.usuCreador = usuCreador;
    }
    public String getUsuModificador() {
        return this.usuModificador;
    }
    
    public void setUsuModificador(String usuModificador) {
        this.usuModificador = usuModificador;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public String getEstadoRegistro() {
        return this.estadoRegistro;
    }
    
    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }




}


