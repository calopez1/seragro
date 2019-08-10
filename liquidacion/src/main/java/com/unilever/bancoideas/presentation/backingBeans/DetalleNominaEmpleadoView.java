package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.DetalleNominaEmpleadoDTO;
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
public class DetalleNominaEmpleadoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DetalleNominaEmpleadoView.class);
    private InputText txtAuxilioAlimentacion;
    private InputText txtAuxilioTransporte;
    private InputText txtEstadoRegistro;
    private InputText txtPension;
    private InputText txtSalarioLiquidado;
    private InputText txtSalud;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtValorHorasExtras;
    private InputText txtNoemId_NominaEmpleado;
    private InputText txtDnoeId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DetalleNominaEmpleadoDTO> data;
    private DetalleNominaEmpleadoDTO selectedDetalleNominaEmpleado;
    private DetalleNominaEmpleado entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public DetalleNominaEmpleadoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            DetalleNominaEmpleadoDTO detalleNominaEmpleadoDTO = (DetalleNominaEmpleadoDTO) e.getObject();

            if (txtAuxilioAlimentacion == null) {
                txtAuxilioAlimentacion = new InputText();
            }

            txtAuxilioAlimentacion.setValue(detalleNominaEmpleadoDTO.getAuxilioAlimentacion());

            if (txtAuxilioTransporte == null) {
                txtAuxilioTransporte = new InputText();
            }

            txtAuxilioTransporte.setValue(detalleNominaEmpleadoDTO.getAuxilioTransporte());

            if (txtEstadoRegistro == null) {
                txtEstadoRegistro = new InputText();
            }

            txtEstadoRegistro.setValue(detalleNominaEmpleadoDTO.getEstadoRegistro());

            if (txtPension == null) {
                txtPension = new InputText();
            }

            txtPension.setValue(detalleNominaEmpleadoDTO.getPension());

            if (txtSalarioLiquidado == null) {
                txtSalarioLiquidado = new InputText();
            }

            txtSalarioLiquidado.setValue(detalleNominaEmpleadoDTO.getSalarioLiquidado());

            if (txtSalud == null) {
                txtSalud = new InputText();
            }

            txtSalud.setValue(detalleNominaEmpleadoDTO.getSalud());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(detalleNominaEmpleadoDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(detalleNominaEmpleadoDTO.getUsuModificador());

            if (txtValorHorasExtras == null) {
                txtValorHorasExtras = new InputText();
            }

            txtValorHorasExtras.setValue(detalleNominaEmpleadoDTO.getValorHorasExtras());

            if (txtNoemId_NominaEmpleado == null) {
                txtNoemId_NominaEmpleado = new InputText();
            }

            txtNoemId_NominaEmpleado.setValue(detalleNominaEmpleadoDTO.getNoemId_NominaEmpleado());

            if (txtDnoeId == null) {
                txtDnoeId = new InputText();
            }

            txtDnoeId.setValue(detalleNominaEmpleadoDTO.getDnoeId());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(detalleNominaEmpleadoDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(detalleNominaEmpleadoDTO.getFechaModificacion());

            Integer dnoeId = FacesUtils.checkInteger(txtDnoeId);
            entity = businessDelegatorView.getDetalleNominaEmpleado(dnoeId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedDetalleNominaEmpleado = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedDetalleNominaEmpleado = null;

        if (txtAuxilioAlimentacion != null) {
            txtAuxilioAlimentacion.setValue(null);
            txtAuxilioAlimentacion.setDisabled(true);
        }

        if (txtAuxilioTransporte != null) {
            txtAuxilioTransporte.setValue(null);
            txtAuxilioTransporte.setDisabled(true);
        }

        if (txtEstadoRegistro != null) {
            txtEstadoRegistro.setValue(null);
            txtEstadoRegistro.setDisabled(true);
        }

        if (txtPension != null) {
            txtPension.setValue(null);
            txtPension.setDisabled(true);
        }

        if (txtSalarioLiquidado != null) {
            txtSalarioLiquidado.setValue(null);
            txtSalarioLiquidado.setDisabled(true);
        }

        if (txtSalud != null) {
            txtSalud.setValue(null);
            txtSalud.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtValorHorasExtras != null) {
            txtValorHorasExtras.setValue(null);
            txtValorHorasExtras.setDisabled(true);
        }

        if (txtNoemId_NominaEmpleado != null) {
            txtNoemId_NominaEmpleado.setValue(null);
            txtNoemId_NominaEmpleado.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtDnoeId != null) {
            txtDnoeId.setValue(null);
            txtDnoeId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
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
            Integer dnoeId = FacesUtils.checkInteger(txtDnoeId);
            entity = (dnoeId != null)
                ? businessDelegatorView.getDetalleNominaEmpleado(dnoeId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtAuxilioAlimentacion.setDisabled(false);
            txtAuxilioTransporte.setDisabled(false);
            txtEstadoRegistro.setDisabled(false);
            txtPension.setDisabled(false);
            txtSalarioLiquidado.setDisabled(false);
            txtSalud.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtValorHorasExtras.setDisabled(false);
            txtNoemId_NominaEmpleado.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtDnoeId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtAuxilioAlimentacion.setValue(entity.getAuxilioAlimentacion());
            txtAuxilioAlimentacion.setDisabled(false);
            txtAuxilioTransporte.setValue(entity.getAuxilioTransporte());
            txtAuxilioTransporte.setDisabled(false);
            txtEstadoRegistro.setValue(entity.getEstadoRegistro());
            txtEstadoRegistro.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtPension.setValue(entity.getPension());
            txtPension.setDisabled(false);
            txtSalarioLiquidado.setValue(entity.getSalarioLiquidado());
            txtSalarioLiquidado.setDisabled(false);
            txtSalud.setValue(entity.getSalud());
            txtSalud.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtValorHorasExtras.setValue(entity.getValorHorasExtras());
            txtValorHorasExtras.setDisabled(false);
            txtNoemId_NominaEmpleado.setValue(entity.getNominaEmpleado()
                                                    .getNoemId());
            txtNoemId_NominaEmpleado.setDisabled(false);
            txtDnoeId.setValue(entity.getDnoeId());
            txtDnoeId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedDetalleNominaEmpleado = (DetalleNominaEmpleadoDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedDetalleNominaEmpleado"));
        txtAuxilioAlimentacion.setValue(selectedDetalleNominaEmpleado.getAuxilioAlimentacion());
        txtAuxilioAlimentacion.setDisabled(false);
        txtAuxilioTransporte.setValue(selectedDetalleNominaEmpleado.getAuxilioTransporte());
        txtAuxilioTransporte.setDisabled(false);
        txtEstadoRegistro.setValue(selectedDetalleNominaEmpleado.getEstadoRegistro());
        txtEstadoRegistro.setDisabled(false);
        txtFechaCreacion.setValue(selectedDetalleNominaEmpleado.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedDetalleNominaEmpleado.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtPension.setValue(selectedDetalleNominaEmpleado.getPension());
        txtPension.setDisabled(false);
        txtSalarioLiquidado.setValue(selectedDetalleNominaEmpleado.getSalarioLiquidado());
        txtSalarioLiquidado.setDisabled(false);
        txtSalud.setValue(selectedDetalleNominaEmpleado.getSalud());
        txtSalud.setDisabled(false);
        txtUsuCreador.setValue(selectedDetalleNominaEmpleado.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedDetalleNominaEmpleado.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtValorHorasExtras.setValue(selectedDetalleNominaEmpleado.getValorHorasExtras());
        txtValorHorasExtras.setDisabled(false);
        txtNoemId_NominaEmpleado.setValue(selectedDetalleNominaEmpleado.getNoemId_NominaEmpleado());
        txtNoemId_NominaEmpleado.setDisabled(false);
        txtDnoeId.setValue(selectedDetalleNominaEmpleado.getDnoeId());
        txtDnoeId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedDetalleNominaEmpleado == null) && (entity == null)) {
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
            entity = new DetalleNominaEmpleado();

            Integer dnoeId = FacesUtils.checkInteger(txtDnoeId);

            entity.setAuxilioAlimentacion(FacesUtils.checkDouble(
                    txtAuxilioAlimentacion));
            entity.setAuxilioTransporte(FacesUtils.checkDouble(
                    txtAuxilioTransporte));
            entity.setDnoeId(dnoeId);
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setPension(FacesUtils.checkDouble(txtPension));
            entity.setSalarioLiquidado(FacesUtils.checkDouble(
                    txtSalarioLiquidado));
            entity.setSalud(FacesUtils.checkDouble(txtSalud));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkString(txtUsuModificador));
            entity.setValorHorasExtras(FacesUtils.checkDouble(
                    txtValorHorasExtras));
            entity.setNominaEmpleado((FacesUtils.checkInteger(
                    txtNoemId_NominaEmpleado) != null)
                ? businessDelegatorView.getNominaEmpleado(
                    FacesUtils.checkInteger(txtNoemId_NominaEmpleado)) : null);
            businessDelegatorView.saveDetalleNominaEmpleado(entity);
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
                Integer dnoeId = new Integer(selectedDetalleNominaEmpleado.getDnoeId());
                entity = businessDelegatorView.getDetalleNominaEmpleado(dnoeId);
            }

            entity.setAuxilioAlimentacion(FacesUtils.checkDouble(
                    txtAuxilioAlimentacion));
            entity.setAuxilioTransporte(FacesUtils.checkDouble(
                    txtAuxilioTransporte));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setPension(FacesUtils.checkDouble(txtPension));
            entity.setSalarioLiquidado(FacesUtils.checkDouble(
                    txtSalarioLiquidado));
            entity.setSalud(FacesUtils.checkDouble(txtSalud));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkString(txtUsuModificador));
            entity.setValorHorasExtras(FacesUtils.checkDouble(
                    txtValorHorasExtras));
            entity.setNominaEmpleado((FacesUtils.checkInteger(
                    txtNoemId_NominaEmpleado) != null)
                ? businessDelegatorView.getNominaEmpleado(
                    FacesUtils.checkInteger(txtNoemId_NominaEmpleado)) : null);
            businessDelegatorView.updateDetalleNominaEmpleado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedDetalleNominaEmpleado = (DetalleNominaEmpleadoDTO) (evt.getComponent()
                                                                           .getAttributes()
                                                                           .get("selectedDetalleNominaEmpleado"));

            Integer dnoeId = new Integer(selectedDetalleNominaEmpleado.getDnoeId());
            entity = businessDelegatorView.getDetalleNominaEmpleado(dnoeId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer dnoeId = FacesUtils.checkInteger(txtDnoeId);
            entity = businessDelegatorView.getDetalleNominaEmpleado(dnoeId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteDetalleNominaEmpleado(entity);
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
            selectedDetalleNominaEmpleado = (DetalleNominaEmpleadoDTO) (evt.getComponent()
                                                                           .getAttributes()
                                                                           .get("selectedDetalleNominaEmpleado"));

            Integer dnoeId = new Integer(selectedDetalleNominaEmpleado.getDnoeId());
            entity = businessDelegatorView.getDetalleNominaEmpleado(dnoeId);
            businessDelegatorView.deleteDetalleNominaEmpleado(entity);
            data.remove(selectedDetalleNominaEmpleado);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Double auxilioAlimentacion,
        Double auxilioTransporte, Integer dnoeId, String estadoRegistro,
        Date fechaCreacion, Date fechaModificacion, Double pension,
        Double salarioLiquidado, Double salud, String usuCreador,
        String usuModificador, Double valorHorasExtras,
        Integer noemId_NominaEmpleado) throws Exception {
        try {
            entity.setAuxilioAlimentacion(FacesUtils.checkDouble(
                    auxilioAlimentacion));
            entity.setAuxilioTransporte(FacesUtils.checkDouble(
                    auxilioTransporte));
            entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setPension(FacesUtils.checkDouble(pension));
            entity.setSalarioLiquidado(FacesUtils.checkDouble(salarioLiquidado));
            entity.setSalud(FacesUtils.checkDouble(salud));
            entity.setUsuCreador(FacesUtils.checkString(usuCreador));
            entity.setUsuModificador(FacesUtils.checkString(usuModificador));
            entity.setValorHorasExtras(FacesUtils.checkDouble(valorHorasExtras));
            businessDelegatorView.updateDetalleNominaEmpleado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("DetalleNominaEmpleadoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtAuxilioAlimentacion() {
        return txtAuxilioAlimentacion;
    }

    public void setTxtAuxilioAlimentacion(InputText txtAuxilioAlimentacion) {
        this.txtAuxilioAlimentacion = txtAuxilioAlimentacion;
    }

    public InputText getTxtAuxilioTransporte() {
        return txtAuxilioTransporte;
    }

    public void setTxtAuxilioTransporte(InputText txtAuxilioTransporte) {
        this.txtAuxilioTransporte = txtAuxilioTransporte;
    }

    public InputText getTxtEstadoRegistro() {
        return txtEstadoRegistro;
    }

    public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
        this.txtEstadoRegistro = txtEstadoRegistro;
    }

    public InputText getTxtPension() {
        return txtPension;
    }

    public void setTxtPension(InputText txtPension) {
        this.txtPension = txtPension;
    }

    public InputText getTxtSalarioLiquidado() {
        return txtSalarioLiquidado;
    }

    public void setTxtSalarioLiquidado(InputText txtSalarioLiquidado) {
        this.txtSalarioLiquidado = txtSalarioLiquidado;
    }

    public InputText getTxtSalud() {
        return txtSalud;
    }

    public void setTxtSalud(InputText txtSalud) {
        this.txtSalud = txtSalud;
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

    public InputText getTxtValorHorasExtras() {
        return txtValorHorasExtras;
    }

    public void setTxtValorHorasExtras(InputText txtValorHorasExtras) {
        this.txtValorHorasExtras = txtValorHorasExtras;
    }

    public InputText getTxtNoemId_NominaEmpleado() {
        return txtNoemId_NominaEmpleado;
    }

    public void setTxtNoemId_NominaEmpleado(InputText txtNoemId_NominaEmpleado) {
        this.txtNoemId_NominaEmpleado = txtNoemId_NominaEmpleado;
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

    public InputText getTxtDnoeId() {
        return txtDnoeId;
    }

    public void setTxtDnoeId(InputText txtDnoeId) {
        this.txtDnoeId = txtDnoeId;
    }

    public List<DetalleNominaEmpleadoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataDetalleNominaEmpleado();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<DetalleNominaEmpleadoDTO> detalleNominaEmpleadoDTO) {
        this.data = detalleNominaEmpleadoDTO;
    }

    public DetalleNominaEmpleadoDTO getSelectedDetalleNominaEmpleado() {
        return selectedDetalleNominaEmpleado;
    }

    public void setSelectedDetalleNominaEmpleado(
        DetalleNominaEmpleadoDTO detalleNominaEmpleado) {
        this.selectedDetalleNominaEmpleado = detalleNominaEmpleado;
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
