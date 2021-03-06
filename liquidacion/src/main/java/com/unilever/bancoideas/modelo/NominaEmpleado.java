package com.unilever.bancoideas.modelo;
// Generated 9/08/2019 11:14:06 AM by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * NominaEmpleado generated by hbm2java
 */
public class NominaEmpleado  implements java.io.Serializable {


     private Integer noemId;
     private LiquidacionNomina liquidacionNomina;
     private Empleado empleado;
     private Integer diasLaborados;
     private Double totalPagar;
     private Double deducciones;
     private String usuCreador;
     private String usuModificador;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estadoRegistro;
     private Set<LiquidacionHoraExtra> liquidacionHoraExtras = new HashSet<LiquidacionHoraExtra>(0);
     private Set<DetalleNominaEmpleado> detalleNominaEmpleados = new HashSet<DetalleNominaEmpleado>(0);

    public NominaEmpleado() {
    }

	
    public NominaEmpleado(Integer noemId, LiquidacionNomina liquidacionNomina, Empleado empleado, Integer diasLaborados, Double totalPagar, Double deducciones, String usuCreador, Date fechaCreacion, String estadoRegistro) {
        this.noemId = noemId;
        this.liquidacionNomina = liquidacionNomina;
        this.empleado = empleado;
        this.diasLaborados = diasLaborados;
        this.totalPagar = totalPagar;
        this.deducciones = deducciones;
        this.usuCreador = usuCreador;
        this.fechaCreacion = fechaCreacion;
        this.estadoRegistro = estadoRegistro;
    }
    public NominaEmpleado(Integer noemId, LiquidacionNomina liquidacionNomina, Empleado empleado, Integer diasLaborados, Double totalPagar, Double deducciones, String usuCreador, String usuModificador, Date fechaCreacion, Date fechaModificacion, String estadoRegistro, Set<LiquidacionHoraExtra> liquidacionHoraExtras, Set<DetalleNominaEmpleado> detalleNominaEmpleados) {
       this.noemId = noemId;
       this.liquidacionNomina = liquidacionNomina;
       this.empleado = empleado;
       this.diasLaborados = diasLaborados;
       this.totalPagar = totalPagar;
       this.deducciones = deducciones;
       this.usuCreador = usuCreador;
       this.usuModificador = usuModificador;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estadoRegistro = estadoRegistro;
       this.liquidacionHoraExtras = liquidacionHoraExtras;
       this.detalleNominaEmpleados = detalleNominaEmpleados;
    }
   
    public Integer getNoemId() {
        return this.noemId;
    }
    
    public void setNoemId(Integer noemId) {
        this.noemId = noemId;
    }
    public LiquidacionNomina getLiquidacionNomina() {
        return this.liquidacionNomina;
    }
    
    public void setLiquidacionNomina(LiquidacionNomina liquidacionNomina) {
        this.liquidacionNomina = liquidacionNomina;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Integer getDiasLaborados() {
        return this.diasLaborados;
    }
    
    public void setDiasLaborados(Integer diasLaborados) {
        this.diasLaborados = diasLaborados;
    }
    public Double getTotalPagar() {
        return this.totalPagar;
    }
    
    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }
    public Double getDeducciones() {
        return this.deducciones;
    }
    
    public void setDeducciones(Double deducciones) {
        this.deducciones = deducciones;
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
    public Set<DetalleNominaEmpleado> getDetalleNominaEmpleados() {
        return this.detalleNominaEmpleados;
    }
    
    public void setDetalleNominaEmpleados(Set<DetalleNominaEmpleado> detalleNominaEmpleados) {
        this.detalleNominaEmpleados = detalleNominaEmpleados;
    }




}


