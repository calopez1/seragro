package com.unilever.bancoideas.modelo;
// Generated 9/08/2019 11:14:06 AM by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * LiquidacionNomina generated by hbm2java
 */
public class LiquidacionNomina  implements java.io.Serializable {


     private Integer linoId;
     private Date fechaInicio;
     private Date fechaFin;
     private Integer diasNomina;
     private String descripcion;
     private String codigo;
     private String usuCreador;
     private String usuModificador;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estadoRegistro;
     private Set<NominaEmpleado> nominaEmpleados = new HashSet<NominaEmpleado>(0);

    public LiquidacionNomina() {
    }

	
    public LiquidacionNomina(Integer linoId, Date fechaInicio, Date fechaFin, Integer diasNomina, String codigo, String usuCreador, Date fechaCreacion, String estadoRegistro) {
        this.linoId = linoId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.diasNomina = diasNomina;
        this.codigo = codigo;
        this.usuCreador = usuCreador;
        this.fechaCreacion = fechaCreacion;
        this.estadoRegistro = estadoRegistro;
    }
    public LiquidacionNomina(Integer linoId, Date fechaInicio, Date fechaFin, Integer diasNomina, String descripcion, String codigo, String usuCreador, String usuModificador, Date fechaCreacion, Date fechaModificacion, String estadoRegistro, Set<NominaEmpleado> nominaEmpleados) {
       this.linoId = linoId;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.diasNomina = diasNomina;
       this.descripcion = descripcion;
       this.codigo = codigo;
       this.usuCreador = usuCreador;
       this.usuModificador = usuModificador;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estadoRegistro = estadoRegistro;
       this.nominaEmpleados = nominaEmpleados;
    }
   
    public Integer getLinoId() {
        return this.linoId;
    }
    
    public void setLinoId(Integer linoId) {
        this.linoId = linoId;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Integer getDiasNomina() {
        return this.diasNomina;
    }
    
    public void setDiasNomina(Integer diasNomina) {
        this.diasNomina = diasNomina;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    public Set<NominaEmpleado> getNominaEmpleados() {
        return this.nominaEmpleados;
    }
    
    public void setNominaEmpleados(Set<NominaEmpleado> nominaEmpleados) {
        this.nominaEmpleados = nominaEmpleados;
    }




}


