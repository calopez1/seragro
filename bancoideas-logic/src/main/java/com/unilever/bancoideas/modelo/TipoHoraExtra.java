package com.unilever.bancoideas.modelo;
// Generated 9/08/2019 11:14:06 AM by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TipoHoraExtra generated by hbm2java
 */
public class TipoHoraExtra  implements java.io.Serializable {


     private Integer thoeId;
     private String codigo;
     private String descripcion;
     private Double porcentaje;
     private String usuCreador;
     private String usuModificador;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estadoRegistro;
     private Set<LiquidacionHoraExtra> liquidacionHoraExtras = new HashSet<LiquidacionHoraExtra>(0);

    public TipoHoraExtra() {
    }

	
    public TipoHoraExtra(Integer thoeId, String codigo, String descripcion, Double porcentaje, String usuCreador, Date fechaCreacion, String estadoRegistro) {
        this.thoeId = thoeId;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
        this.usuCreador = usuCreador;
        this.fechaCreacion = fechaCreacion;
        this.estadoRegistro = estadoRegistro;
    }
    public TipoHoraExtra(Integer thoeId, String codigo, String descripcion, Double porcentaje, String usuCreador, String usuModificador, Date fechaCreacion, Date fechaModificacion, String estadoRegistro, Set<LiquidacionHoraExtra> liquidacionHoraExtras) {
       this.thoeId = thoeId;
       this.codigo = codigo;
       this.descripcion = descripcion;
       this.porcentaje = porcentaje;
       this.usuCreador = usuCreador;
       this.usuModificador = usuModificador;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estadoRegistro = estadoRegistro;
       this.liquidacionHoraExtras = liquidacionHoraExtras;
    }
   
    public Integer getThoeId() {
        return this.thoeId;
    }
    
    public void setThoeId(Integer thoeId) {
        this.thoeId = thoeId;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getPorcentaje() {
        return this.porcentaje;
    }
    
    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
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
    public Set<LiquidacionHoraExtra> getLiquidacionHoraExtras() {
        return this.liquidacionHoraExtras;
    }
    
    public void setLiquidacionHoraExtras(Set<LiquidacionHoraExtra> liquidacionHoraExtras) {
        this.liquidacionHoraExtras = liquidacionHoraExtras;
    }




}


