package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.PersonaDTO;
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
public class PersonaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PersonaView.class);
    private InputText txtEmail;
    private InputText txtEstadoRegistro;
    private InputText txtIdentificacion;
    private InputText txtPrimerApellido;
    private InputText txtPrimerNombre;
    private InputText txtSegundoApellido;
    private InputText txtSegundoNombre;
    private InputText txtUsuCreador;
    private InputText txtUsuModifica;
    private InputText txtTiidId_TipoIdentificacion;
    private InputText txtPersId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<PersonaDTO> data;
    private PersonaDTO selectedPersona;
    private Persona entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public PersonaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            PersonaDTO personaDTO = (PersonaDTO) e.getObject();

            if (txtEmail == null) {
                txtEmail = new InputText();
            }

            txtEmail.setValue(personaDTO.getEmail());

            if (txtEstadoRegistro == null) {
                txtEstadoRegistro = new InputText();
            }

            txtEstadoRegistro.setValue(personaDTO.getEstadoRegistro());

            if (txtIdentificacion == null) {
                txtIdentificacion = new InputText();
            }

            txtIdentificacion.setValue(personaDTO.getIdentificacion());

            if (txtPrimerApellido == null) {
                txtPrimerApellido = new InputText();
            }

            txtPrimerApellido.setValue(personaDTO.getPrimerApellido());

            if (txtPrimerNombre == null) {
                txtPrimerNombre = new InputText();
            }

            txtPrimerNombre.setValue(personaDTO.getPrimerNombre());

            if (txtSegundoApellido == null) {
                txtSegundoApellido = new InputText();
            }

            txtSegundoApellido.setValue(personaDTO.getSegundoApellido());

            if (txtSegundoNombre == null) {
                txtSegundoNombre = new InputText();
            }

            txtSegundoNombre.setValue(personaDTO.getSegundoNombre());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(personaDTO.getUsuCreador());

            if (txtUsuModifica == null) {
                txtUsuModifica = new InputText();
            }

            txtUsuModifica.setValue(personaDTO.getUsuModifica());

            if (txtTiidId_TipoIdentificacion == null) {
                txtTiidId_TipoIdentificacion = new InputText();
            }

            txtTiidId_TipoIdentificacion.setValue(personaDTO.getTiidId_TipoIdentificacion());

            if (txtPersId == null) {
                txtPersId = new InputText();
            }

            txtPersId.setValue(personaDTO.getPersId());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(personaDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(personaDTO.getFechaModificacion());

            Integer persId = FacesUtils.checkInteger(txtPersId);
            entity = businessDelegatorView.getPersona(persId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedPersona = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedPersona = null;

        if (txtEmail != null) {
            txtEmail.setValue(null);
            txtEmail.setDisabled(true);
        }

        if (txtEstadoRegistro != null) {
            txtEstadoRegistro.setValue(null);
            txtEstadoRegistro.setDisabled(true);
        }

        if (txtIdentificacion != null) {
            txtIdentificacion.setValue(null);
            txtIdentificacion.setDisabled(true);
        }

        if (txtPrimerApellido != null) {
            txtPrimerApellido.setValue(null);
            txtPrimerApellido.setDisabled(true);
        }

        if (txtPrimerNombre != null) {
            txtPrimerNombre.setValue(null);
            txtPrimerNombre.setDisabled(true);
        }

        if (txtSegundoApellido != null) {
            txtSegundoApellido.setValue(null);
            txtSegundoApellido.setDisabled(true);
        }

        if (txtSegundoNombre != null) {
            txtSegundoNombre.setValue(null);
            txtSegundoNombre.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModifica != null) {
            txtUsuModifica.setValue(null);
            txtUsuModifica.setDisabled(true);
        }

        if (txtTiidId_TipoIdentificacion != null) {
            txtTiidId_TipoIdentificacion.setValue(null);
            txtTiidId_TipoIdentificacion.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtPersId != null) {
            txtPersId.setValue(null);
            txtPersId.setDisabled(false);
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
            Integer persId = FacesUtils.checkInteger(txtPersId);
            entity = (persId != null)
                ? businessDelegatorView.getPersona(persId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtEmail.setDisabled(false);
            txtEstadoRegistro.setDisabled(false);
            txtIdentificacion.setDisabled(false);
            txtPrimerApellido.setDisabled(false);
            txtPrimerNombre.setDisabled(false);
            txtSegundoApellido.setDisabled(false);
            txtSegundoNombre.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModifica.setDisabled(false);
            txtTiidId_TipoIdentificacion.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtPersId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtEmail.setValue(entity.getEmail());
            txtEmail.setDisabled(false);
            txtEstadoRegistro.setValue(entity.getEstadoRegistro());
            txtEstadoRegistro.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtIdentificacion.setValue(entity.getIdentificacion());
            txtIdentificacion.setDisabled(false);
            txtPrimerApellido.setValue(entity.getPrimerApellido());
            txtPrimerApellido.setDisabled(false);
            txtPrimerNombre.setValue(entity.getPrimerNombre());
            txtPrimerNombre.setDisabled(false);
            txtSegundoApellido.setValue(entity.getSegundoApellido());
            txtSegundoApellido.setDisabled(false);
            txtSegundoNombre.setValue(entity.getSegundoNombre());
            txtSegundoNombre.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModifica.setValue(entity.getUsuModifica());
            txtUsuModifica.setDisabled(false);
            txtTiidId_TipoIdentificacion.setValue(entity.getTipoIdentificacion()
                                                        .getTiidId());
            txtTiidId_TipoIdentificacion.setDisabled(false);
            txtPersId.setValue(entity.getPersId());
            txtPersId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedPersona = (PersonaDTO) (evt.getComponent().getAttributes()
                                           .get("selectedPersona"));
        txtEmail.setValue(selectedPersona.getEmail());
        txtEmail.setDisabled(false);
        txtEstadoRegistro.setValue(selectedPersona.getEstadoRegistro());
        txtEstadoRegistro.setDisabled(false);
        txtFechaCreacion.setValue(selectedPersona.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedPersona.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtIdentificacion.setValue(selectedPersona.getIdentificacion());
        txtIdentificacion.setDisabled(false);
        txtPrimerApellido.setValue(selectedPersona.getPrimerApellido());
        txtPrimerApellido.setDisabled(false);
        txtPrimerNombre.setValue(selectedPersona.getPrimerNombre());
        txtPrimerNombre.setDisabled(false);
        txtSegundoApellido.setValue(selectedPersona.getSegundoApellido());
        txtSegundoApellido.setDisabled(false);
        txtSegundoNombre.setValue(selectedPersona.getSegundoNombre());
        txtSegundoNombre.setDisabled(false);
        txtUsuCreador.setValue(selectedPersona.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModifica.setValue(selectedPersona.getUsuModifica());
        txtUsuModifica.setDisabled(false);
        txtTiidId_TipoIdentificacion.setValue(selectedPersona.getTiidId_TipoIdentificacion());
        txtTiidId_TipoIdentificacion.setDisabled(false);
        txtPersId.setValue(selectedPersona.getPersId());
        txtPersId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedPersona == null) && (entity == null)) {
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
            entity = new Persona();

            Integer persId = FacesUtils.checkInteger(txtPersId);

            entity.setEmail(FacesUtils.checkString(txtEmail));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setIdentificacion(FacesUtils.checkString(txtIdentificacion));
            entity.setPersId(persId);
            entity.setPrimerApellido(FacesUtils.checkString(txtPrimerApellido));
            entity.setPrimerNombre(FacesUtils.checkString(txtPrimerNombre));
            entity.setSegundoApellido(FacesUtils.checkString(txtSegundoApellido));
            entity.setSegundoNombre(FacesUtils.checkString(txtSegundoNombre));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModifica(FacesUtils.checkString(txtUsuModifica));
            entity.setTipoIdentificacion((FacesUtils.checkInteger(
                    txtTiidId_TipoIdentificacion) != null)
                ? businessDelegatorView.getTipoIdentificacion(
                    FacesUtils.checkInteger(txtTiidId_TipoIdentificacion)) : null);
            businessDelegatorView.savePersona(entity);
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
                Integer persId = new Integer(selectedPersona.getPersId());
                entity = businessDelegatorView.getPersona(persId);
            }

            entity.setEmail(FacesUtils.checkString(txtEmail));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setIdentificacion(FacesUtils.checkString(txtIdentificacion));
            entity.setPrimerApellido(FacesUtils.checkString(txtPrimerApellido));
            entity.setPrimerNombre(FacesUtils.checkString(txtPrimerNombre));
            entity.setSegundoApellido(FacesUtils.checkString(txtSegundoApellido));
            entity.setSegundoNombre(FacesUtils.checkString(txtSegundoNombre));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModifica(FacesUtils.checkString(txtUsuModifica));
            entity.setTipoIdentificacion((FacesUtils.checkInteger(
                    txtTiidId_TipoIdentificacion) != null)
                ? businessDelegatorView.getTipoIdentificacion(
                    FacesUtils.checkInteger(txtTiidId_TipoIdentificacion)) : null);
            businessDelegatorView.updatePersona(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedPersona = (PersonaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedPersona"));

            Integer persId = new Integer(selectedPersona.getPersId());
            entity = businessDelegatorView.getPersona(persId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer persId = FacesUtils.checkInteger(txtPersId);
            entity = businessDelegatorView.getPersona(persId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deletePersona(entity);
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
            selectedPersona = (PersonaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedPersona"));

            Integer persId = new Integer(selectedPersona.getPersId());
            entity = businessDelegatorView.getPersona(persId);
            businessDelegatorView.deletePersona(entity);
            data.remove(selectedPersona);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String email, String estadoRegistro,
        Date fechaCreacion, Date fechaModificacion, String identificacion,
        Integer persId, String primerApellido, String primerNombre,
        String segundoApellido, String segundoNombre, String usuCreador,
        String usuModifica, Integer tiidId_TipoIdentificacion)
        throws Exception {
        try {
            entity.setEmail(FacesUtils.checkString(email));
            entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setIdentificacion(FacesUtils.checkString(identificacion));
            entity.setPrimerApellido(FacesUtils.checkString(primerApellido));
            entity.setPrimerNombre(FacesUtils.checkString(primerNombre));
            entity.setSegundoApellido(FacesUtils.checkString(segundoApellido));
            entity.setSegundoNombre(FacesUtils.checkString(segundoNombre));
            entity.setUsuCreador(FacesUtils.checkString(usuCreador));
            entity.setUsuModifica(FacesUtils.checkString(usuModifica));
            businessDelegatorView.updatePersona(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("PersonaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(InputText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public InputText getTxtEstadoRegistro() {
        return txtEstadoRegistro;
    }

    public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
        this.txtEstadoRegistro = txtEstadoRegistro;
    }

    public InputText getTxtIdentificacion() {
        return txtIdentificacion;
    }

    public void setTxtIdentificacion(InputText txtIdentificacion) {
        this.txtIdentificacion = txtIdentificacion;
    }

    public InputText getTxtPrimerApellido() {
        return txtPrimerApellido;
    }

    public void setTxtPrimerApellido(InputText txtPrimerApellido) {
        this.txtPrimerApellido = txtPrimerApellido;
    }

    public InputText getTxtPrimerNombre() {
        return txtPrimerNombre;
    }

    public void setTxtPrimerNombre(InputText txtPrimerNombre) {
        this.txtPrimerNombre = txtPrimerNombre;
    }

    public InputText getTxtSegundoApellido() {
        return txtSegundoApellido;
    }

    public void setTxtSegundoApellido(InputText txtSegundoApellido) {
        this.txtSegundoApellido = txtSegundoApellido;
    }

    public InputText getTxtSegundoNombre() {
        return txtSegundoNombre;
    }

    public void setTxtSegundoNombre(InputText txtSegundoNombre) {
        this.txtSegundoNombre = txtSegundoNombre;
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

    public InputText getTxtTiidId_TipoIdentificacion() {
        return txtTiidId_TipoIdentificacion;
    }

    public void setTxtTiidId_TipoIdentificacion(
        InputText txtTiidId_TipoIdentificacion) {
        this.txtTiidId_TipoIdentificacion = txtTiidId_TipoIdentificacion;
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

    public InputText getTxtPersId() {
        return txtPersId;
    }

    public void setTxtPersId(InputText txtPersId) {
        this.txtPersId = txtPersId;
    }

    public List<PersonaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataPersona();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<PersonaDTO> personaDTO) {
        this.data = personaDTO;
    }

    public PersonaDTO getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(PersonaDTO persona) {
        this.selectedPersona = persona;
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
