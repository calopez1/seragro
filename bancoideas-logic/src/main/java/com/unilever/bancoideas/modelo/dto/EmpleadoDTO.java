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
public class EmpleadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EmpleadoDTO.class);
    private String codigo;
    private Integer emplId;
    private String estadoRegistro;
    private Date fechaCreacion;
    private Date fechaFin;
    private Date fechaIncio;
    private Date fechaModificacion;
    private String usuCreador;
    private String usuModifica;
    private Integer idCarg;

    private Integer idPers;
    private Integer idTiid;
    private String identificacionPersona;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String codigoTipoId;
    private String nombreTipoId;
    private String codigoCarg;
    private String nombreCarg;
    
    
    
    
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getEmplId() {
        return emplId;
    }

    public void setEmplId(Integer emplId) {
        this.emplId = emplId;
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

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(Date fechaIncio) {
        this.fechaIncio = fechaIncio;
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

	public Integer getIdCarg() {
		return idCarg;
	}

	public void setIdCarg(Integer idCarg) {
		this.idCarg = idCarg;
	}

	public Integer getIdPers() {
		return idPers;
	}

	public void setIdPers(Integer idPers) {
		this.idPers = idPers;
	}

	public Integer getIdTiid() {
		return idTiid;
	}

	public void setIdTiid(Integer idTiid) {
		this.idTiid = idTiid;
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

	public String getCodigoCarg() {
		return codigoCarg;
	}

	public void setCodigoCarg(String codigoCarg) {
		this.codigoCarg = codigoCarg;
	}

	public String getNombreCarg() {
		return nombreCarg;
	}

	public void setNombreCarg(String nombreCarg) {
		this.nombreCarg = nombreCarg;
	}

    
}
