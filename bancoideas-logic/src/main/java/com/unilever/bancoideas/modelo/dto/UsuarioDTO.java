package com.unilever.bancoideas.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioDTO.class);
    private String estadoRegistro;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuCreador;
    private String usuModifica;
    private Integer usuaId;
    private String usuario;
    private Integer idDepa;
    private Integer idPers;
    private Integer idTius;
    private Integer idTiid;
    private String codigoDepartamento;
    private String nombreDepartamento;
    private String identificacionPersona;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String email;
    private String codigoTipoId;
    private String nombreTipoId;
    private String codigoRol;
    private String nombreRol;
    private String contrasena;
    
	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(String estadoRegistro, Date fechaCreacion, Date fechaModificacion, String usuCreador,
			String usuModifica, Integer usuaId, String usuario, Integer idDepa, Integer idPers, Integer idTius,
			String codigoDepartamento, String nombreDepartamento, String identificacionPersona, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String email, String codigoTipoId,
			String nombreTipoId) {
		super();
		this.estadoRegistro = estadoRegistro;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModifica = usuModifica;
		this.usuaId = usuaId;
		this.usuario = usuario;
		this.idDepa = idDepa;
		this.idPers = idPers;
		this.idTius = idTius;
		this.codigoDepartamento = codigoDepartamento;
		this.nombreDepartamento = nombreDepartamento;
		this.identificacionPersona = identificacionPersona;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.email = email;
		this.codigoTipoId = codigoTipoId;
		this.nombreTipoId = nombreTipoId;
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
	public Integer getIdDepa() {
		return idDepa;
	}
	public void setIdDepa(Integer idDepa) {
		this.idDepa = idDepa;
	}
	public Integer getIdPers() {
		return idPers;
	}
	public void setIdPers(Integer idPers) {
		this.idPers = idPers;
	}
	public Integer getIdTius() {
		return idTius;
	}
	public void setIdTius(Integer idTius) {
		this.idTius = idTius;
	}
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public String getIdentificacionPersona() {
		return identificacionPersona;
	}
	public void setIdentificacionPersona(String identificacionPersona) {
		this.identificacionPersona = identificacionPersona;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodigoTipoId() {
		return codigoTipoId;
	}
	public void setCodigoTipoId(String codigoTipoId) {
		this.codigoTipoId = codigoTipoId;
	}
	public String getNombreTipoId() {
		return nombreTipoId;
	}
	public void setNombreTipoId(String nombreTipoId) {
		this.nombreTipoId = nombreTipoId;
	}

	public String getCodigoRol() {
		return codigoRol;
	}

	public void setCodigoRol(String codigoRol) {
		this.codigoRol = codigoRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Integer getIdTiid() {
		return idTiid;
	}

	public void setIdTiid(Integer idTiid) {
		this.idTiid = idTiid;
	}
    

    
}
