package com.unilever.bancoideas.modelo;
// Generated 9/08/2019 11:14:06 AM by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TipoIdentificacion generated by hbm2java
 */
public class TipoIdentificacion  implements java.io.Serializable {


     private Integer tiidId;
     private String codigo;
     private String nombre;
     private String usuCreador;
     private String usuModificador;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estadoRegistro;
     private Set<Persona> personas = new HashSet<Persona>(0);

    public TipoIdentificacion() {
    }

	
    public TipoIdentificacion(Integer tiidId, String codigo, String nombre, String usuCreador, Date fechaCreacion, String estadoRegistro) {
        this.tiidId = tiidId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.usuCreador = usuCreador;
        this.fechaCreacion = fechaCreacion;
        this.estadoRegistro = estadoRegistro;
    }
    public TipoIdentificacion(Integer tiidId, String codigo, String nombre, String usuCreador, String usuModificador, Date fechaCreacion, Date fechaModificacion, String estadoRegistro, Set<Persona> personas) {
       this.tiidId = tiidId;
       this.codigo = codigo;
       this.nombre = nombre;
       this.usuCreador = usuCreador;
       this.usuModificador = usuModificador;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estadoRegistro = estadoRegistro;
       this.personas = personas;
    }
   
    public Integer getTiidId() {
        return this.tiidId;
    }
    
    public void setTiidId(Integer tiidId) {
        this.tiidId = tiidId;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public Set<Persona> getPersonas() {
        return this.personas;
    }
    
    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }




}


