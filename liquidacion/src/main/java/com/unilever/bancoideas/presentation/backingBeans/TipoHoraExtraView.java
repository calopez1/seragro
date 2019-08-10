package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.TipoHoraExtraDTO;
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
public class TipoHoraExtraView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoHoraExtraView.class);
    private InputText txtCodigo;
    private InputText txtDescripcion;
    private InputText txtEstadoRegistro;
    private InputText txtPorcentaje;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtThoeId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoHoraExtraDTO> data;
    private TipoHoraExtraDTO selectedTipoHoraExtra;
    private TipoHoraExtra entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TipoHoraExtraView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TipoHoraExtraDTO tipoHoraExtraDTO = (TipoHoraExtraDTO) e.getObject();

            if (txtCodigo == null) {
                txtCodigo = new InputText();
            }

            txtCodigo.setValue(tipoHoraExtraDTO.getCodigo());

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(tipoHoraExtraDTO.getDescripcion());

            if (txtEstadoRegistro == null) {
                txtEstadoRegistro = new InputText();
            }

            txtEstadoRegistro.setValue(tipoHoraExtraDTO.getEstadoRegistro());

            if (txtPorcentaje == null) {
                txtPorcentaje = new InputText();
            }

            txtPorcentaje.setValue(tipoHoraExtraDTO.getPorcentaje());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(tipoHoraExtraDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(tipoHoraExtraDTO.getUsuModificador());

            if (txtThoeId == null) {
                txtThoeId = new InputText();
            }

            txtThoeId.setValue(tipoHoraExtraDTO.getThoeId());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(tipoHoraExtraDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(tipoHoraExtraDTO.getFechaModificacion());

            Integer thoeId = FacesUtils.checkInteger(txtThoeId);
            entity = businessDelegatorView.getTipoHoraExtra(thoeId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTipoHoraExtra = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoHoraExtra = null;

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(true);
        }

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtEstadoRegistro != null) {
            txtEstadoRegistro.setValue(null);
            txtEstadoRegistro.setDisabled(true);
        }

        if (txtPorcentaje != null) {
            txtPorcentaje.setValue(null);
            txtPorcentaje.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtThoeId != null) {
            txtThoeId.setValue(null);
            txtThoeId.setDisabled(false);
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
            Integer thoeId = FacesUtils.checkInteger(txtThoeId);
            entity = (thoeId != null)
                ? businessDelegatorView.getTipoHoraExtra(thoeId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCodigo.setDisabled(false);
            txtDescripcion.setDisabled(false);
            txtEstadoRegistro.setDisabled(false);
            txtPorcentaje.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtThoeId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtEstadoRegistro.setValue(entity.getEstadoRegistro());
            txtEstadoRegistro.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtPorcentaje.setValue(entity.getPorcentaje());
            txtPorcentaje.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtThoeId.setValue(entity.getThoeId());
            txtThoeId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoHoraExtra = (TipoHoraExtraDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTipoHoraExtra"));
        txtCodigo.setValue(selectedTipoHoraExtra.getCodigo());
        txtCodigo.setDisabled(false);
        txtDescripcion.setValue(selectedTipoHoraExtra.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtEstadoRegistro.setValue(selectedTipoHoraExtra.getEstadoRegistro());
        txtEstadoRegistro.setDisabled(false);
        txtFechaCreacion.setValue(selectedTipoHoraExtra.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedTipoHoraExtra.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtPorcentaje.setValue(selectedTipoHoraExtra.getPorcentaje());
        txtPorcentaje.setDisabled(false);
        txtUsuCreador.setValue(selectedTipoHoraExtra.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedTipoHoraExtra.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtThoeId.setValue(selectedTipoHoraExtra.getThoeId());
        txtThoeId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoHoraExtra == null) && (entity == null)) {
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
            entity = new TipoHoraExtra();

            Integer thoeId = FacesUtils.checkInteger(txtThoeId);

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setPorcentaje(FacesUtils.checkDouble(txtPorcentaje));
            entity.setThoeId(thoeId);
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkString(txtUsuModificador));
            businessDelegatorView.saveTipoHoraExtra(entity);
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
                Integer thoeId = new Integer(selectedTipoHoraExtra.getThoeId());
                entity = businessDelegatorView.getTipoHoraExtra(thoeId);
            }

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setPorcentaje(FacesUtils.checkDouble(txtPorcentaje));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkString(txtUsuModificador));
            businessDelegatorView.updateTipoHoraExtra(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoHoraExtra = (TipoHoraExtraDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedTipoHoraExtra"));

            Integer thoeId = new Integer(selectedTipoHoraExtra.getThoeId());
            entity = businessDelegatorView.getTipoHoraExtra(thoeId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer thoeId = FacesUtils.checkInteger(txtThoeId);
            entity = businessDelegatorView.getTipoHoraExtra(thoeId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoHoraExtra(entity);
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
            selectedTipoHoraExtra = (TipoHoraExtraDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedTipoHoraExtra"));

            Integer thoeId = new Integer(selectedTipoHoraExtra.getThoeId());
            entity = businessDelegatorView.getTipoHoraExtra(thoeId);
            businessDelegatorView.deleteTipoHoraExtra(entity);
            data.remove(selectedTipoHoraExtra);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codigo, String descripcion,
        String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
        Double porcentaje, Integer thoeId, String usuCreador,
        String usuModificador) throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setPorcentaje(FacesUtils.checkDouble(porcentaje));
            entity.setUsuCreador(FacesUtils.checkString(usuCreador));
            entity.setUsuModificador(FacesUtils.checkString(usuModificador));
            businessDelegatorView.updateTipoHoraExtra(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoHoraExtraView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtEstadoRegistro() {
        return txtEstadoRegistro;
    }

    public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
        this.txtEstadoRegistro = txtEstadoRegistro;
    }

    public InputText getTxtPorcentaje() {
        return txtPorcentaje;
    }

    public void setTxtPorcentaje(InputText txtPorcentaje) {
        this.txtPorcentaje = txtPorcentaje;
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

    public InputText getTxtThoeId() {
        return txtThoeId;
    }

    public void setTxtThoeId(InputText txtThoeId) {
        this.txtThoeId = txtThoeId;
    }

    public List<TipoHoraExtraDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoHoraExtra();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoHoraExtraDTO> tipoHoraExtraDTO) {
        this.data = tipoHoraExtraDTO;
    }

    public TipoHoraExtraDTO getSelectedTipoHoraExtra() {
        return selectedTipoHoraExtra;
    }

    public void setSelectedTipoHoraExtra(TipoHoraExtraDTO tipoHoraExtra) {
        this.selectedTipoHoraExtra = tipoHoraExtra;
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
