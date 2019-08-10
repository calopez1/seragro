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
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioDTO.class);
    private String contrasena;
    private String estadoRegistro;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuCreador;
    private String usuModifica;
    private Integer usuaId;
    private String usuario;
    private Integer depaId_Departamento;
    private Integer persId_Persona;
    private Integer tiusId_TipoUsuario;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getUsuCreador() {
        return usuCreador;
    }

    public void setUsuCreador(String usuCreador) {
        this.usuCreador = usuCreador;
    }

    public String getUsuModifica() {
        return usuModifica;
    }

    public void setUsuModifica(String usuModifica) {
        this.usuModifica = usuModifica;
    }

    public Integer getUsuaId() {
        return usuaId;
    }

    public void setUsuaId(Integer usuaId) {
        this.usuaId = usuaId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getDepaId_Departamento() {
        return depaId_Departamento;
    }

    public void setDepaId_Departamento(Integer depaId_Departamento) {
        this.depaId_Departamento = depaId_Departamento;
    }

    public Integer getPersId_Persona() {
        return persId_Persona;
    }

    public void setPersId_Persona(Integer persId_Persona) {
        this.persId_Persona = persId_Persona;
    }

    public Integer getTiusId_TipoUsuario() {
        return tiusId_TipoUsuario;
    }

    public void setTiusId_TipoUsuario(Integer tiusId_TipoUsuario) {
        this.tiusId_TipoUsuario = tiusId_TipoUsuario;
    }
}
