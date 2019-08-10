package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.LiquidacionHoraExtraDTO;
import com.unilever.bancoideas.presentation.businessDelegate.*;
import com.unilever.bancoideas.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class LiquidacionHoraExtraView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LiquidacionHoraExtraView.class);
    private InputText txtEstadoRegistro;
    private InputText txtHorasTrabajadas;
    private InputText txtTotalPagarHorasExtras;
    private InputText txtTotalPagarRecargo;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtValorHoraExtra;
    private InputText txtValorRecargo;
    private InputText txtNoemId_NominaEmpleado;
    private InputText txtThoeId_TipoHoraExtra;
    private InputText txtLhoeId;
    private Calendar txtFecha;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<LiquidacionHoraExtraDTO> data;
    private LiquidacionHoraExtraDTO selectedLiquidacionHoraExtra;
    private LiquidacionHoraExtra entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public LiquidacionHoraExtraView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            LiquidacionHoraExtraDTO liquidacionHoraExtraDTO = (LiquidacionHoraExtraDTO) e.getObject();

            if (txtEstadoRegistro == null) {
                txtEstadoRegistro = new InputText();
            }

            txtEstadoRegistro.setValue(liquidacionHoraExtraDTO.getEstadoRegistro());

            if (txtHorasTrabajadas == null) {
                txtHorasTrabajadas = new InputText();
            }

            txtHorasTrabajadas.setValue(liquidacionHoraExtraDTO.getHorasTrabajadas());

            if (txtTotalPagarHorasExtras == null) {
                txtTotalPagarHorasExtras = new InputText();
            }

            txtTotalPagarHorasExtras.setValue(liquidacionHoraExtraDTO.getTotalPagarHorasExtras());

            if (txtTotalPagarRecargo == null) {
                txtTotalPagarRecargo = new InputText();
            }

            txtTotalPagarRecargo.setValue(liquidacionHoraExtraDTO.getTotalPagarRecargo());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(liquidacionHoraExtraDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(liquidacionHoraExtraDTO.getUsuModificador());

            if (txtValorHoraExtra == null) {
                txtValorHoraExtra = new InputText();
            }

            txtValorHoraExtra.setValue(liquidacionHoraExtraDTO.getValorHoraExtra());

            if (txtValorRecargo == null) {
                txtValorRecargo = new InputText();
            }

            txtValorRecargo.setValue(liquidacionHoraExtraDTO.getValorRecargo());

            if (txtNoemId_NominaEmpleado == null) {
                txtNoemId_NominaEmpleado = new InputText();
            }

            txtNoemId_NominaEmpleado.setValue(liquidacionHoraExtraDTO.getNoemId_NominaEmpleado());

            if (txtThoeId_TipoHoraExtra == null) {
                txtThoeId_TipoHoraExtra = new InputText();
            }

            txtThoeId_TipoHoraExtra.setValue(liquidacionHoraExtraDTO.getThoeId_TipoHoraExtra());

            if (txtLhoeId == null) {
                txtLhoeId = new InputText();
            }

            txtLhoeId.setValue(liquidacionHoraExtraDTO.getLhoeId());

            if (txtFecha == null) {
                txtFecha = new Calendar();
            }

            txtFecha.setValue(liquidacionHoraExtraDTO.getFecha());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(liquidacionHoraExtraDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(liquidacionHoraExtraDTO.getFechaModificacion());

            Integer lhoeId = FacesUtils.checkInteger(txtLhoeId);
            entity = businessDelegatorView.getLiquidacionHoraExtra(lhoeId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedLiquidacionHoraExtra = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedLiquidacionHoraExtra = null;

        if (txtEstadoRegistro != null) {
            txtEstadoRegistro.setValue(null);
            txtEstadoRegistro.setDisabled(true);
        }

        if (txtHorasTrabajadas != null) {
            txtHorasTrabajadas.setValue(null);
            txtHorasTrabajadas.setDisabled(true);
        }

        if (txtTotalPagarHorasExtras != null) {
            txtTotalPagarHorasExtras.setValue(null);
            txtTotalPagarHorasExtras.setDisabled(true);
        }

        if (txtTotalPagarRecargo != null) {
            txtTotalPagarRecargo.setValue(null);
            txtTotalPagarRecargo.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtValorHoraExtra != null) {
            txtValorHoraExtra.setValue(null);
            txtValorHoraExtra.setDisabled(true);
        }

        if (txtValorRecargo != null) {
            txtValorRecargo.setValue(null);
            txtValorRecargo.setDisabled(true);
        }

        if (txtNoemId_NominaEmpleado != null) {
            txtNoemId_NominaEmpleado.setValue(null);
            txtNoemId_NominaEmpleado.setDisabled(true);
        }

        if (txtThoeId_TipoHoraExtra != null) {
            txtThoeId_TipoHoraExtra.setValue(null);
            txtThoeId_TipoHoraExtra.setDisabled(true);
        }

        if (txtFecha != null) {
            txtFecha.setValue(null);
            txtFecha.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtLhoeId != null) {
            txtLhoeId.setValue(null);
            txtLhoeId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFecha() {
        Date inputDate = (Date) txtFecha.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaCreacion() {
        Date inputDate = (Date) txtFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaModificacion() {
        Date inputDate = (Date) txtFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer lhoeId = FacesUtils.checkInteger(txtLhoeId);
            entity = (lhoeId != null)
                ? businessDelegatorView.getLiquidacionHoraExtra(lhoeId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtEstadoRegistro.setDisabled(false);
            txtHorasTrabajadas.setDisabled(false);
            txtTotalPagarHorasExtras.setDisabled(false);
            txtTotalPagarRecargo.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtValorHoraExtra.setDisabled(false);
            txtValorRecargo.setDisabled(false);
            txtNoemId_NominaEmpleado.setDisabled(false);
            txtThoeId_TipoHoraExtra.setDisabled(false);
            txtFecha.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtLhoeId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtEstadoRegistro.setValue(entity.getEstadoRegistro());
            txtEstadoRegistro.setDisabled(false);
            txtFecha.setValue(entity.getFecha());
            txtFecha.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtHorasTrabajadas.setValue(entity.getHorasTrabajadas());
            txtHorasTrabajadas.setDisabled(false);
            txtTotalPagarHorasExtras.setValue(entity.getTotalPagarHorasExtras());
            txtTotalPagarHorasExtras.setDisabled(false);
            txtTotalPagarRecargo.setValue(entity.getTotalPagarRecargo());
            txtTotalPagarRecargo.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtValorHoraExtra.setValue(entity.getValorHoraExtra());
            txtValorHoraExtra.setDisabled(false);
            txtValorRecargo.setValue(entity.getValorRecargo());
            txtValorRecargo.setDisabled(false);
            txtNoemId_NominaEmpleado.setValue(entity.getNominaEmpleado()
                                                    .getNoemId());
            txtNoemId_NominaEmpleado.setDisabled(false);
            txtThoeId_TipoHoraExtra.setValue(entity.getTipoHoraExtra()
                                                   .getThoeId());
            txtThoeId_TipoHoraExtra.setDisabled(false);
            txtLhoeId.setValue(entity.getLhoeId());
            txtLhoeId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedLiquidacionHoraExtra = (LiquidacionHoraExtraDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedLiquidacionHoraExtra"));
        txtEstadoRegistro.setValue(selectedLiquidacionHoraExtra.getEstadoRegistro());
        txtEstadoRegistro.setDisabled(false);
        txtFecha.setValue(selectedLiquidacionHoraExtra.getFecha());
        txtFecha.setDisabled(false);
        txtFechaCreacion.setValue(selectedLiquidacionHoraExtra.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedLiquidacionHoraExtra.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtHorasTrabajadas.setValue(selectedLiquidacionHoraExtra.getHorasTrabajadas());
        txtHorasTrabajadas.setDisabled(false);
        txtTotalPagarHorasExtras.setValue(selectedLiquidacionHoraExtra.getTotalPagarHorasExtras());
        txtTotalPagarHorasExtras.setDisabled(false);
        txtTotalPagarRecargo.setValue(selectedLiquidacionHoraExtra.getTotalPagarRecargo());
        txtTotalPagarRecargo.setDisabled(false);
        txtUsuCreador.setValue(selectedLiquidacionHoraExtra.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedLiquidacionHoraExtra.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtValorHoraExtra.setValue(selectedLiquidacionHoraExtra.getValorHoraExtra());
        txtValorHoraExtra.setDisabled(false);
        txtValorRecargo.setValue(selectedLiquidacionHoraExtra.getValorRecargo());
        txtValorRecargo.setDisabled(false);
        txtNoemId_NominaEmpleado.setValue(selectedLiquidacionHoraExtra.getNoemId_NominaEmpleado());
        txtNoemId_NominaEmpleado.setDisabled(false);
        txtThoeId_TipoHoraExtra.setValue(selectedLiquidacionHoraExtra.getThoeId_TipoHoraExtra());
        txtThoeId_TipoHoraExtra.setDisabled(false);
        txtLhoeId.setValue(selectedLiquidacionHoraExtra.getLhoeId());
        txtLhoeId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedLiquidacionHoraExtra == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new LiquidacionHoraExtra();

            Integer lhoeId = FacesUtils.checkInteger(txtLhoeId);

            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFecha(FacesUtils.checkDate(txtFecha));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setHorasTrabajadas(FacesUtils.checkInteger(
                    txtHorasTrabajadas));
            entity.setLhoeId(lhoeId);
            entity.setTotalPagarHorasExtras(FacesUtils.checkDouble(
                    txtTotalPagarHorasExtras));
            entity.setTotalPagarRecargo(FacesUtils.checkDouble(
                    txtTotalPagarRecargo));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkString(txtUsuModificador));
            entity.setValorHoraExtra(FacesUtils.checkDouble(txtValorHoraExtra));
            entity.setValorRecargo(FacesUtils.checkDouble(txtValorRecargo));
            entity.setNominaEmpleado((FacesUtils.checkInteger(
                    txtNoemId_NominaEmpleado) != null)
                ? businessDelegatorView.getNominaEmpleado(
                    FacesUtils.checkInteger(txtNoemId_NominaEmpleado)) : null);
            entity.setTipoHoraExtra((FacesUtils.checkInteger(
                    txtThoeId_TipoHoraExtra) != null)
                ? businessDelegatorView.getTipoHoraExtra(
                    FacesUtils.checkInteger(txtThoeId_TipoHoraExtra)) : null);
            businessDelegatorView.saveLiquidacionHoraExtra(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer lhoeId = new Integer(selectedLiquidacionHoraExtra.getLhoeId());
                entity = businessDelegatorView.getLiquidacionHoraExtra(lhoeId);
            }

            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFecha(FacesUtils.checkDate(txtFecha));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setHorasTrabajadas(FacesUtils.checkInteger(
                    txtHorasTrabajadas));
            entity.setTotalPagarHorasExtras(FacesUtils.checkDouble(
                    txtTotalPagarHorasExtras));
            entity.setTotalPagarRecargo(FacesUtils.checkDouble(
                    txtTotalPagarRecargo));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkString(txtUsuModificador));
            entity.setValorHoraExtra(FacesUtils.checkDouble(txtValorHoraExtra));
            entity.setValorRecargo(FacesUtils.checkDouble(txtValorRecargo));
            entity.setNominaEmpleado((FacesUtils.checkInteger(
                    txtNoemId_NominaEmpleado) != null)
                ? businessDelegatorView.getNominaEmpleado(
                    FacesUtils.checkInteger(txtNoemId_NominaEmpleado)) : null);
            entity.setTipoHoraExtra((FacesUtils.checkInteger(
                    txtThoeId_TipoHoraExtra) != null)
                ? businessDelegatorView.getTipoHoraExtra(
                    FacesUtils.checkInteger(txtThoeId_TipoHoraExtra)) : null);
            businessDelegatorView.updateLiquidacionHoraExtra(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedLiquidacionHoraExtra = (LiquidacionHoraExtraDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedLiquidacionHoraExtra"));

            Integer lhoeId = new Integer(selectedLiquidacionHoraExtra.getLhoeId());
            entity = businessDelegatorView.getLiquidacionHoraExtra(lhoeId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer lhoeId = FacesUtils.checkInteger(txtLhoeId);
            entity = businessDelegatorView.getLiquidacionHoraExtra(lhoeId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteLiquidacionHoraExtra(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedLiquidacionHoraExtra = (LiquidacionHoraExtraDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedLiquidacionHoraExtra"));

            Integer lhoeId = new Integer(selectedLiquidacionHoraExtra.getLhoeId());
            entity = businessDelegatorView.getLiquidacionHoraExtra(lhoeId);
            businessDelegatorView.deleteLiquidacionHoraExtra(entity);
            data.remove(selectedLiquidacionHoraExtra);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String estadoRegistro, Date fecha,
        Date fechaCreacion, Date fechaModificacion, Integer horasTrabajadas,
        Integer lhoeId, Double totalPagarHorasExtras, Double totalPagarRecargo,
        String usuCreador, String usuModificador, Double valorHoraExtra,
        Double valorRecargo, Integer noemId_NominaEmpleado,
        Integer thoeId_TipoHoraExtra) throws Exception {
        try {
            entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
            entity.setFecha(FacesUtils.checkDate(fecha));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setHorasTrabajadas(FacesUtils.checkInteger(horasTrabajadas));
            entity.setTotalPagarHorasExtras(FacesUtils.checkDouble(
                    totalPagarHorasExtras));
            entity.setTotalPagarRecargo(FacesUtils.checkDouble(
                    totalPagarRecargo));
            entity.setUsuCreador(FacesUtils.checkString(usuCreador));
            entity.setUsuModificador(FacesUtils.checkString(usuModificador));
            entity.setValorHoraExtra(FacesUtils.checkDouble(valorHoraExtra));
            entity.setValorRecargo(FacesUtils.checkDouble(valorRecargo));
            businessDelegatorView.updateLiquidacionHoraExtra(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("LiquidacionHoraExtraView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtEstadoRegistro() {
        return txtEstadoRegistro;
    }

    public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
        this.txtEstadoRegistro = txtEstadoRegistro;
    }

    public InputText getTxtHorasTrabajadas() {
        return txtHorasTrabajadas;
    }

    public void setTxtHorasTrabajadas(InputText txtHorasTrabajadas) {
        this.txtHorasTrabajadas = txtHorasTrabajadas;
    }

    public InputText getTxtTotalPagarHorasExtras() {
        return txtTotalPagarHorasExtras;
    }

    public void setTxtTotalPagarHorasExtras(InputText txtTotalPagarHorasExtras) {
        this.txtTotalPagarHorasExtras = txtTotalPagarHorasExtras;
    }

    public InputText getTxtTotalPagarRecargo() {
        return txtTotalPagarRecargo;
    }

    public void setTxtTotalPagarRecargo(InputText txtTotalPagarRecargo) {
        this.txtTotalPagarRecargo = txtTotalPagarRecargo;
    }

    public InputText getTxtUsuCreador() {
        return txtUsuCreador;
    }

    public void setTxtUsuCreador(InputText txtUsuCreador) {
        this.txtUsuCreador = txtUsuCreador;
    }

    public InputText getTxtUsuModificador() {
        return txtUsuModificador;
    }

    public void setTxtUsuModificador(InputText txtUsuModificador) {
        this.txtUsuModificador = txtUsuModificador;
    }

    public InputText getTxtValorHoraExtra() {
        return txtValorHoraExtra;
    }

    public void setTxtValorHoraExtra(InputText txtValorHoraExtra) {
        this.txtValorHoraExtra = txtValorHoraExtra;
    }

    public InputText getTxtValorRecargo() {
        return txtValorRecargo;
    }

    public void setTxtValorRecargo(InputText txtValorRecargo) {
        this.txtValorRecargo = txtValorRecargo;
    }

    public InputText getTxtNoemId_NominaEmpleado() {
        return txtNoemId_NominaEmpleado;
    }

    public void setTxtNoemId_NominaEmpleado(InputText txtNoemId_NominaEmpleado) {
        this.txtNoemId_NominaEmpleado = txtNoemId_NominaEmpleado;
    }

    public InputText getTxtThoeId_TipoHoraExtra() {
        return txtThoeId_TipoHoraExtra;
    }

    public void setTxtThoeId_TipoHoraExtra(InputText txtThoeId_TipoHoraExtra) {
        this.txtThoeId_TipoHoraExtra = txtThoeId_TipoHoraExtra;
    }

    public Calendar getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(Calendar txtFecha) {
        this.txtFecha = txtFecha;
    }

    public Calendar getTxtFechaCreacion() {
        return txtFechaCreacion;
    }

    public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
        this.txtFechaCreacion = txtFechaCreacion;
    }

    public Calendar getTxtFechaModificacion() {
        return txtFechaModificacion;
    }

    public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
        this.txtFechaModificacion = txtFechaModificacion;
    }

    public InputText getTxtLhoeId() {
        return txtLhoeId;
    }

    public void setTxtLhoeId(InputText txtLhoeId) {
        this.txtLhoeId = txtLhoeId;
    }

    public List<LiquidacionHoraExtraDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataLiquidacionHoraExtra();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<LiquidacionHoraExtraDTO> liquidacionHoraExtraDTO) {
        this.data = liquidacionHoraExtraDTO;
    }

    public LiquidacionHoraExtraDTO getSelectedLiquidacionHoraExtra() {
        return selectedLiquidacionHoraExtra;
    }

    public void setSelectedLiquidacionHoraExtra(
        LiquidacionHoraExtraDTO liquidacionHoraExtra) {
        this.selectedLiquidacionHoraExtra = liquidacionHoraExtra;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
