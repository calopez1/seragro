package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.EmpleadoDTO;
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
public class EmpleadoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EmpleadoView.class);
    private InputText txtCodigo;
    private InputText txtEstadoRegistro;
    private InputText txtUsuCreador;
    private InputText txtUsuModifica;
    private InputText txtCargId_Cargo;
    private InputText txtPersId_Persona;
    private InputText txtEmplId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaFin;
    private Calendar txtFechaIncio;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<EmpleadoDTO> data;
    private EmpleadoDTO selectedEmpleado;
    private Empleado entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public EmpleadoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            EmpleadoDTO empleadoDTO = (EmpleadoDTO) e.getObject();

            if (txtCodigo == null) {
                txtCodigo = new InputText();
            }

            txtCodigo.setValue(empleadoDTO.getCodigo());

            if (txtEstadoRegistro == null) {
                txtEstadoRegistro = new InputText();
            }

            txtEstadoRegistro.setValue(empleadoDTO.getEstadoRegistro());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(empleadoDTO.getUsuCreador());

            if (txtUsuModifica == null) {
                txtUsuModifica = new InputText();
            }

            txtUsuModifica.setValue(empleadoDTO.getUsuModifica());

            if (txtCargId_Cargo == null) {
                txtCargId_Cargo = new InputText();
            }

            txtCargId_Cargo.setValue(empleadoDTO.getCargId_Cargo());

            if (txtPersId_Persona == null) {
                txtPersId_Persona = new InputText();
            }

            txtPersId_Persona.setValue(empleadoDTO.getPersId_Persona());

            if (txtEmplId == null) {
                txtEmplId = new InputText();
            }

            txtEmplId.setValue(empleadoDTO.getEmplId());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(empleadoDTO.getFechaCreacion());

            if (txtFechaFin == null) {
                txtFechaFin = new Calendar();
            }

            txtFechaFin.setValue(empleadoDTO.getFechaFin());

            if (txtFechaIncio == null) {
                txtFechaIncio = new Calendar();
            }

            txtFechaIncio.setValue(empleadoDTO.getFechaIncio());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(empleadoDTO.getFechaModificacion());

            Integer emplId = FacesUtils.checkInteger(txtEmplId);
            entity = businessDelegatorView.getEmpleado(emplId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedEmpleado = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedEmpleado = null;

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(true);
        }

        if (txtEstadoRegistro != null) {
            txtEstadoRegistro.setValue(null);
            txtEstadoRegistro.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModifica != null) {
            txtUsuModifica.setValue(null);
            txtUsuModifica.setDisabled(true);
        }

        if (txtCargId_Cargo != null) {
            txtCargId_Cargo.setValue(null);
            txtCargId_Cargo.setDisabled(true);
        }

        if (txtPersId_Persona != null) {
            txtPersId_Persona.setValue(null);
            txtPersId_Persona.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaFin != null) {
            txtFechaFin.setValue(null);
            txtFechaFin.setDisabled(true);
        }

        if (txtFechaIncio != null) {
            txtFechaIncio.setValue(null);
            txtFechaIncio.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtEmplId != null) {
            txtEmplId.setValue(null);
            txtEmplId.setDisabled(false);
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

    public void listener_txtFechaIncio() {
        Date inputDate = (Date) txtFechaIncio.getValue();
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
            Integer emplId = FacesUtils.checkInteger(txtEmplId);
            entity = (emplId != null)
                ? businessDelegatorView.getEmpleado(emplId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCodigo.setDisabled(false);
            txtEstadoRegistro.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModifica.setDisabled(false);
            txtCargId_Cargo.setDisabled(false);
            txtPersId_Persona.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaFin.setDisabled(false);
            txtFechaIncio.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtEmplId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtEstadoRegistro.setValue(entity.getEstadoRegistro());
            txtEstadoRegistro.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaFin.setValue(entity.getFechaFin());
            txtFechaFin.setDisabled(false);
            txtFechaIncio.setValue(entity.getFechaIncio());
            txtFechaIncio.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModifica.setValue(entity.getUsuModifica());
            txtUsuModifica.setDisabled(false);
            txtCargId_Cargo.setValue(entity.getCargo().getCargId());
            txtCargId_Cargo.setDisabled(false);
            txtPersId_Persona.setValue(entity.getPersona().getPersId());
            txtPersId_Persona.setDisabled(false);
            txtEmplId.setValue(entity.getEmplId());
            txtEmplId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedEmpleado = (EmpleadoDTO) (evt.getComponent().getAttributes()
                                             .get("selectedEmpleado"));
        txtCodigo.setValue(selectedEmpleado.getCodigo());
        txtCodigo.setDisabled(false);
        txtEstadoRegistro.setValue(selectedEmpleado.getEstadoRegistro());
        txtEstadoRegistro.setDisabled(false);
        txtFechaCreacion.setValue(selectedEmpleado.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaFin.setValue(selectedEmpleado.getFechaFin());
        txtFechaFin.setDisabled(false);
        txtFechaIncio.setValue(selectedEmpleado.getFechaIncio());
        txtFechaIncio.setDisabled(false);
        txtFechaModificacion.setValue(selectedEmpleado.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedEmpleado.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModifica.setValue(selectedEmpleado.getUsuModifica());
        txtUsuModifica.setDisabled(false);
        txtCargId_Cargo.setValue(selectedEmpleado.getCargId_Cargo());
        txtCargId_Cargo.setDisabled(false);
        txtPersId_Persona.setValue(selectedEmpleado.getPersId_Persona());
        txtPersId_Persona.setDisabled(false);
        txtEmplId.setValue(selectedEmpleado.getEmplId());
        txtEmplId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedEmpleado == null) && (entity == null)) {
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
            entity = new Empleado();

            Integer emplId = FacesUtils.checkInteger(txtEmplId);

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setEmplId(emplId);
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaFin(FacesUtils.checkDate(txtFechaFin));
            entity.setFechaIncio(FacesUtils.checkDate(txtFechaIncio));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModifica(FacesUtils.checkString(txtUsuModifica));
            entity.setCargo((FacesUtils.checkInteger(txtCargId_Cargo) != null)
                ? businessDelegatorView.getCargo(FacesUtils.checkInteger(
                        txtCargId_Cargo)) : null);
            entity.setPersona((FacesUtils.checkInteger(txtPersId_Persona) != null)
                ? businessDelegatorView.getPersona(FacesUtils.checkInteger(
                        txtPersId_Persona)) : null);
            businessDelegatorView.saveEmpleado(entity);
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
                Integer emplId = new Integer(selectedEmpleado.getEmplId());
                entity = businessDelegatorView.getEmpleado(emplId);
            }

            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaFin(FacesUtils.checkDate(txtFechaFin));
            entity.setFechaIncio(FacesUtils.checkDate(txtFechaIncio));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModifica(FacesUtils.checkString(txtUsuModifica));
            entity.setCargo((FacesUtils.checkInteger(txtCargId_Cargo) != null)
                ? businessDelegatorView.getCargo(FacesUtils.checkInteger(
                        txtCargId_Cargo)) : null);
            entity.setPersona((FacesUtils.checkInteger(txtPersId_Persona) != null)
                ? businessDelegatorView.getPersona(FacesUtils.checkInteger(
                        txtPersId_Persona)) : null);
            businessDelegatorView.updateEmpleado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedEmpleado = (EmpleadoDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedEmpleado"));

            Integer emplId = new Integer(selectedEmpleado.getEmplId());
            entity = businessDelegatorView.getEmpleado(emplId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer emplId = FacesUtils.checkInteger(txtEmplId);
            entity = businessDelegatorView.getEmpleado(emplId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteEmpleado(entity);
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
            selectedEmpleado = (EmpleadoDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedEmpleado"));

            Integer emplId = new Integer(selectedEmpleado.getEmplId());
            entity = businessDelegatorView.getEmpleado(emplId);
            businessDelegatorView.deleteEmpleado(entity);
            data.remove(selectedEmpleado);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String codigo, Integer emplId,
        String estadoRegistro, Date fechaCreacion, Date fechaFin,
        Date fechaIncio, Date fechaModificacion, String usuCreador,
        String usuModifica, Integer cargId_Cargo, Integer persId_Persona)
        throws Exception {
        try {
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaFin(FacesUtils.checkDate(fechaFin));
            entity.setFechaIncio(FacesUtils.checkDate(fechaIncio));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkString(usuCreador));
            entity.setUsuModifica(FacesUtils.checkString(usuModifica));
            businessDelegatorView.updateEmpleado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("EmpleadoView").requestRender();
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

    public InputText getTxtUsuModifica() {
        return txtUsuModifica;
    }

    public void setTxtUsuModifica(InputText txtUsuModifica) {
        this.txtUsuModifica = txtUsuModifica;
    }

    public InputText getTxtCargId_Cargo() {
        return txtCargId_Cargo;
    }

    public void setTxtCargId_Cargo(InputText txtCargId_Cargo) {
        this.txtCargId_Cargo = txtCargId_Cargo;
    }

    public InputText getTxtPersId_Persona() {
        return txtPersId_Persona;
    }

    public void setTxtPersId_Persona(InputText txtPersId_Persona) {
        this.txtPersId_Persona = txtPersId_Persona;
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

    public Calendar getTxtFechaIncio() {
        return txtFechaIncio;
    }

    public void setTxtFechaIncio(Calendar txtFechaIncio) {
        this.txtFechaIncio = txtFechaIncio;
    }

    public Calendar getTxtFechaModificacion() {
        return txtFechaModificacion;
    }

    public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
        this.txtFechaModificacion = txtFechaModificacion;
    }

    public InputText getTxtEmplId() {
        return txtEmplId;
    }

    public void setTxtEmplId(InputText txtEmplId) {
        this.txtEmplId = txtEmplId;
    }

    public List<EmpleadoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataEmpleado();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<EmpleadoDTO> empleadoDTO) {
        this.data = empleadoDTO;
    }

    public EmpleadoDTO getSelectedEmpleado() {
        return selectedEmpleado;
    }

    public void setSelectedEmpleado(EmpleadoDTO empleado) {
        this.selectedEmpleado = empleado;
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
