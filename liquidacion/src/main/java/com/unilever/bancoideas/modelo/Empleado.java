package com.unilever.bancoideas.modelo;
// Generated 9/08/2019 11:14:06 AM by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private Integer emplId;
     private Cargo cargo;
     private Persona persona;
     private Date fechaIncio;
     private Date fechaFin;
     private String codigo;
     private String usuCreador;
     private String usuModifica;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estadoRegistro;
     private Set<NominaEmpleado> nominaEmpleados = new HashSet<NominaEmpleado>(0);

    public Empleado() {
    }

	
    public Empleado(Integer emplId, Cargo cargo, Persona persona, Date fechaIncio, String codigo, String usuCreador, Date fechaCreacion, String estadoRegistro) {
        this.emplId = emplId;
        this.cargo = cargo;
        this.persona = persona;
        this.fechaIncio = fechaIncio;
        this.codigo = codigo;
        this.usuCreador = usuCreador;
        this.fechaCreacion = fechaCreacion;
        this.estadoRegistro = estadoRegistro;
    }
    public Empleado(Integer emplId, Cargo cargo, Persona persona, Date fechaIncio, Date fechaFin, String codigo, String usuCreador, String usuModifica, Date fechaCreacion, Date fechaModificacion, String estadoRegistro, Set<NominaEmpleado> nominaEmpleados) {
       this.emplId = emplId;
       this.cargo = cargo;
       this.persona = persona;
       this.fechaIncio = fechaIncio;
       this.fechaFin = fechaFin;
       this.codigo = codigo;
       this.usuCreador = usuCreador;
       this.usuModifica = usuModifica;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estadoRegistro = estadoRegistro;
       this.nominaEmpleados = nominaEmpleados;
    }
   
    public Integer getEmplId() {
        return this.emplId;
    }
    
    public void setEmplId(Integer emplId) {
        this.emplId = emplId;
    }
    public Cargo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Date getFechaIncio() {
        return this.fechaIncio;
    }
    
    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
    public Set<NominaEmpleado> getNominaEmpleados() {
        return this.nominaEmpleados;
    }
    
    public void setNominaEmpleados(Set<NominaEmpleado> nominaEmpleados) {
        this.nominaEmpleados = nominaEmpleados;
    }




}


