package com.unilever.bancoideas.modelo;
// Generated 9/08/2019 08:51:24 PM by Hibernate Tools 4.0.0


import java.util.Date;

/**
 * Parametros generated by hbm2java
 */
public class Parametros  implements java.io.Serializable {


     private Integer paraId;
     private String codigo;
     private String valor;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estadoRegistro;
     private String usuCreador;
     private String usuModificador;
     private String descripcion;

    public Parametros() {
    }

	
    public Parametros(Integer paraId, String codigo, String valor, Date fechaCreacion, String estadoRegistro, String usuCreador, String descripcion) {
        this.paraId = paraId;
        this.codigo = codigo;
        this.valor = valor;
        this.fechaCreacion = fechaCreacion;
        this.estadoRegistro = estadoRegistro;
        this.usuCreador = usuCreador;
        this.descripcion = descripcion;
    }
    public Parametros(Integer paraId, String codigo, String valor, Date fechaCreacion, Date fechaModificacion, String estadoRegistro, String usuCreador, String usuModificador, String descripcion) {
       this.paraId = paraId;
       this.codigo = codigo;
       this.valor = valor;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estadoRegistro = estadoRegistro;
       this.usuCreador = usuCreador;
       this.usuModificador = usuModificador;
       this.descripcion = descripcion;
    }
   
    public Integer getParaId() {
        return this.paraId;
    }
    
    public void setParaId(Integer paraId) {
        this.paraId = paraId;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getValor() {
        return this.valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
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
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


