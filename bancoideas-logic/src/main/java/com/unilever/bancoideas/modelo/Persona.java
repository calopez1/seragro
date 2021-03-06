package com.unilever.bancoideas.modelo;
// Generated 8/03/2019 12:07:24 PM by Hibernate Tools 5.1.0.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private Integer persId;
     private TipoIdentificacion tipoIdentificacion;
     private String primerNombre;
     private String segundoNombre;
     private String primerApellido;
     private String segundoApellido;
     private String identificacion;
     private String email;
     private String usuCreador;
     private String usuModifica;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estadoRegistro;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public Persona() {
    }

	
    public Persona(Integer persId, TipoIdentificacion tipoIdentificacion, String primerNombre, String primerApellido, String identificacion, String email, String usuCreador, Date fechaCreacion, String estadoRegistro) {
        this.persId = persId;
        this.tipoIdentificacion = tipoIdentificacion;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.identificacion = identificacion;
        this.email = email;
        this.usuCreador = usuCreador;
        this.fechaCreacion = fechaCreacion;
        this.estadoRegistro = estadoRegistro;
    }
    public Persona(Integer persId, TipoIdentificacion tipoIdentificacion, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String identificacion, String email, String usuCreador, String usuModifica, Date fechaCreacion, Date fechaModificacion, String estadoRegistro, Set<Usuario> usuarios) {
       this.persId = persId;
       this.tipoIdentificacion = tipoIdentificacion;
       this.primerNombre = primerNombre;
       this.segundoNombre = segundoNombre;
       this.primerApellido = primerApellido;
       this.segundoApellido = segundoApellido;
       this.identificacion = identificacion;
       this.email = email;
       this.usuCreador = usuCreador;
       this.usuModifica = usuModifica;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estadoRegistro = estadoRegistro;
       this.usuarios = usuarios;
    }
   
    public Integer getPersId() {
        return this.persId;
    }
    
    public void setPersId(Integer persId) {
        this.persId = persId;
    }
    public TipoIdentificacion getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }
    
    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    public String getPrimerNombre() {
        return this.primerNombre;
    }
    
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }
    public String getSegundoNombre() {
        return this.segundoNombre;
    }
    
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
    public String getPrimerApellido() {
        return this.primerApellido;
    }
    
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getSegundoApellido() {
        return this.segundoApellido;
    }
    
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public String getIdentificacion() {
        return this.identificacion;
    }
    
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsuCreador() {
        return this.usuCreador;
    }
    
    public void setUsuCreador(String usuCreador) {
        this.usuCreador = usuCreador;
    }
    public String getUsuModifica() {
        return this.usuModifica;
    }
    
    public void setUsuModifica(String usuModifica) {
        this.usuModifica = usuModifica;
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
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}


