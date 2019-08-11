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
public class HoraExtraEmpleadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(HoraExtraEmpleadoDTO.class);
    private Double cantidadHoras;
    private String estadoRegistro;
    private Date fecha;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Integer hexmId;
    private String usuCreador;
    private String usuModificador;
    private Integer emplId;
    
    private Integer thoeId;
    private String codigoTipoHoraExtra;
    private String descripcionTipoHoraExtra;
    private String identificacionEmpleado;
    private String nombreEmpleado;
    private String codigoEmpleado;
    private Double porcentaje;
    
	
    public Double getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(Double cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Integer getHexmId() {
        return hexmId;
    }

    public void setHexmId(Integer hexmId) {
        this.hexmId = hexmId;
    }

    public Integer getThoeId() {
        return thoeId;
    }

    public void setThoeId(Integer thoeId) {
        this.thoeId = thoeId;
    }

    public String getUsuCreador() {
        return usuCreador;
    }

    public void setUsuCreador(String usuCreador) {
        this.usuCreador = usuCreador;
    }

    public String getUsuModificador() {
        return usuModificador;
    }

    public void setUsuModificador(String usuModificador) {
        this.usuModificador = usuModificador;
    }

	public Integer getEmplId() {
		return emplId;
	}

	public void setEmplId(Integer emplId) {
		this.emplId = emplId;
	}

	public String getDescripcionTipoHoraExtra() {
		return descripcionTipoHoraExtra;
	}

	public void setDescripcionTipoHoraExtra(String descripcionTipoHoraExtra) {
		this.descripcionTipoHoraExtra = descripcionTipoHoraExtra;
	}

	public String getIdentificacionEmpleado() {
		return identificacionEmpleado;
	}

	public void setIdentificacionEmpleado(String identificacionEmpleado) {
		this.identificacionEmpleado = identificacionEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	public String getCodigoTipoHoraExtra() {
		return codigoTipoHoraExtra;
	}

	public void setCodigoTipoHoraExtra(String codigoTipoHoraExtra) {
		this.codigoTipoHoraExtra = codigoTipoHoraExtra;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}


}
