package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.LiquidacionNominaDTO;
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
public class LiquidacionNominaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LiquidacionNominaView.class);
    private InputText txtCodigo;
    private InputText txtDescripcion;
    private InputText txtDiasNomina;
    private InputText txtEstadoRegistro;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtLinoId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaFin;
    private Calendar txtFechaInicio;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<LiquidacionNominaDTO> data;
    private LiquidacionNominaDTO selectedLiquidacionNomina;
    private LiquidacionNomina entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public LiquidacionNominaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            LiquidacionNominaDTO liquidacionNominaDTO = (LiquidacionNominaDTO) e.getObject();

            if (txtCodigo == null) {
                txtCodigo = new InputText();
            }

            txtCodigo.setValue(liquidacionNominaDTO.getCodigo());

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(liquidacionNominaDTO.getDescripcion());

            if (txtDiasNomina == null) {
                txtDiasNomina = new InputText();
            }

            txtDiasNomina.setValue(liquidacionNominaDTO.getDiasNomina());

            if (txtEstadoRegistro == null) {
                txtEstadoRegistro = new InputText();
            }

            txtEstadoRegistro.setValue(liquidacionNominaDTO.getEstadoRegistro());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(liquidacionNominaDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(liquidacionNominaDTO.getUsuModificador());

            if (txtLinoId == null) {
                txtLinoId = new InputText();
            }

            txtLinoId.setValue(liquidacionNominaDTO.getLinoId());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(liquidacionNominaDTO.getFechaCreacion());

            if (txtFechaFin == null) {
                txtFechaFin = new Calendar();
            }

            txtFechaFin.setValue(liquidacionNominaDTO.getFechaFin());

            if (txtFechaInicio == null) {
                txtFechaInicio = new Calendar();
            }

            txtFechaInicio.setValue(liquidacionNominaDTO.getFechaInicio());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(liquidacionNominaDTO.getFechaModificacion());

            Integer linoId = FacesUtils.checkInteger(txtLinoId);
            entity = businessDelegatorView.getLiquidacionNomina(linoId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedLiquidacionNomina = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedLiquidacionNomina = null;

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(true);
        }

        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtDiasNomina != null) {
            txtDiasNomina.setValue(null);
            txtDiasNomina.setDisabled(true);
        }

        if (txtEstadoRegistro != null) {
            txtEstadoRegistro.setValue(null);
            txtEstadoRegistro.setDisabled(true);
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

        if (txtFechaFin != null) {
            txtFechaFin.setValue(null);
            txtFechaFin.setDisabled(true);
        }

        if (txtFechaInicio != null) {
            txtFechaInicio.setValue(null);
            txtFechaInicio.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtLinoId != null) {
            txtLinoId.setValue(null);
            txtLinoId.setDisabled(false);
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

    public void listener_txtFechaFin() {
        Date inputDate = (Date) txtFechaFin.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtFechaInicio() {
        Date inputDate = (Date) txtFechaInicio.getValue();
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
            Integer linoId = FacesUtils.checkInteger(txtLinoId);
            entity = (linoId != null)
                ? businessDelegatorView.getLiquidacionNomina(linoId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCodigo.setDisabled(false);
            txtDescripcion.setDisabled(false);
            txtDiasNomina.setDisabled(false);
            txtEstadoRegistro.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaFin.setDisabled(false);
            txtFechaInicio.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtLinoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtDiasNomina.setValue(entity.getDiasNomina());
            txtDiasNomina.setDisabled(false);
            txtEstadoRegistro.setValue(entity.getEstadoRegistro());
            txtEstadoRegistro.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaFin.setValue(entity.getFechaFin());
            txtFechaFin.setDisabled(false);
            txtFechaInicio.setValue(entity.getFechaInicio());
            txtFechaInicio.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtLinoId.setValue(entity.getLinoId());
            txtLinoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedLiquidacionNomina = (LiquidacionNominaDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedLiquidacionNomina"));
        txtCodigo.setValue(selectedLiquidacionNomina.getCodigo());
        txtCodigo.setDisabled(false);
        txtDescripcion.setValue(selectedLiquidacionNomina.getDescripcion());
        txtDescripcion.setDisabled(false);
        txtDiasNomina.setValue(selectedLiquidacionNomina.getDiasNomina());
        txtDiasNomina.setDisabled(false);
        txtEstadoRegistro.setValue(selectedLiquidacionNomina.getEstadoRegistro());
        txtEstadoRegistro.setDisabled(false);
        txtFechaCreacion.setValue(selectedLiquidacionNomina.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaFin.setValue(selectedLiquidacionNomina.getFechaFin());
        txtFechaFin.setDisabled(false);
        txtFechaInicio.setValue(selectedLiquidacionNomina.getFechaInicio());
        txtFechaInicio.setDisabled(false);
        txtFechaModificacion.setValue(selectedLiquidacionNomina.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedLiquidacionNomina.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedLiquidacionNomina.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtLinoId.setValue(selectedLiquidacionNomina.getLinoId());
        txtLinoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedLiquidacionNomina == null) && (entity == null)) {
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
            entity = new LiquidacionNomina();

            Integer linoId = FacesUtils.checkInteger(txtLinoId);

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setDiasNomina(FacesUtils.checkInteger(txtDiasNomina));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaFin(FacesUtils.checkDate(txtFechaFin));
            entity.setFechaInicio(FacesUtils.checkDate(txtFechaInicio));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setLinoId(linoId);
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkString(txtUsuModificador));
            businessDelegatorView.saveLiquidacionNomina(entity);
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
                Integer linoId = new Integer(selectedLiquidacionNomina.getLinoId());
                entity = businessDelegatorView.getLiquidacionNomina(linoId);
            }

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
            entity.setDiasNomina(FacesUtils.checkInteger(txtDiasNomina));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaFin(FacesUtils.checkDate(txtFechaFin));
            entity.setFechaInicio(FacesUtils.checkDate(txtFechaInicio));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkString(txtUsuModificador));
            businessDelegatorView.updateLiquidacionNomina(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedLiquidacionNomina = (LiquidacionNominaDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedLiquidacionNomina"));

            Integer linoId = new Integer(selectedLiquidacionNomina.getLinoId());
            entity = businessDelegatorView.getLiquidacionNomina(linoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer linoId = FacesUtils.checkInteger(txtLinoId);
            entity = businessDelegatorView.getLiquidacionNomina(linoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteLiquidacionNomina(entity);
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
            selectedLiquidacionNomina = (LiquidacionNominaDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedLiquidacionNomina"));

            Integer linoId = new Integer(selectedLiquidacionNomina.getLinoId());
            entity = businessDelegatorView.getLiquidacionNomina(linoId);
            businessDelegatorView.deleteLiquidacionNomina(entity);
            data.remove(selectedLiquidacionNomina);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codigo, String descripcion,
        Integer diasNomina, String estadoRegistro, Date fechaCreacion,
        Date fechaFin, Date fechaInicio, Date fechaModificacion,
        Integer linoId, String usuCreador, String usuModificador)
        throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setDescripcion(FacesUtils.checkString(descripcion));
            entity.setDiasNomina(FacesUtils.checkInteger(diasNomina));
            entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaFin(FacesUtils.checkDate(fechaFin));
            entity.setFechaInicio(FacesUtils.checkDate(fechaInicio));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkString(usuCreador));
            entity.setUsuModificador(FacesUtils.checkString(usuModificador));
            businessDelegatorView.updateLiquidacionNomina(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("LiquidacionNominaView").requestRender();
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

    public InputText getTxtDiasNomina() {
        return txtDiasNomina;
    }

    public void setTxtDiasNomina(InputText txtDiasNomina) {
        this.txtDiasNomina = txtDiasNomina;
    }

    public InputText getTxtEstadoRegistro() {
        return txtEstadoRegistro;
    }

    public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
        this.txtEstadoRegistro = txtEstadoRegistro;
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

    public Calendar getTxtFechaFin() {
        return txtFechaFin;
    }

    public void setTxtFechaFin(Calendar txtFechaFin) {
        this.txtFechaFin = txtFechaFin;
    }

    public Calendar getTxtFechaInicio() {
        return txtFechaInicio;
    }

    public void setTxtFechaInicio(Calendar txtFechaInicio) {
        this.txtFechaInicio = txtFechaInicio;
    }

    public Calendar getTxtFechaModificacion() {
        return txtFechaModificacion;
    }

    public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
        this.txtFechaModificacion = txtFechaModificacion;
    }

    public InputText getTxtLinoId() {
        return txtLinoId;
    }

    public void setTxtLinoId(InputText txtLinoId) {
        this.txtLinoId = txtLinoId;
    }

    public List<LiquidacionNominaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataLiquidacionNomina();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<LiquidacionNominaDTO> liquidacionNominaDTO) {
        this.data = liquidacionNominaDTO;
    }

    public LiquidacionNominaDTO getSelectedLiquidacionNomina() {
        return selectedLiquidacionNomina;
    }

    public void setSelectedLiquidacionNomina(
        LiquidacionNominaDTO liquidacionNomina) {
        this.selectedLiquidacionNomina = liquidacionNomina;
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
