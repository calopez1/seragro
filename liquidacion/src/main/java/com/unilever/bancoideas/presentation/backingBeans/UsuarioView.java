package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.UsuarioDTO;
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
public class UsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioView.class);
    private InputText txtContrasena;
    private InputText txtEstadoRegistro;
    private InputText txtUsuCreador;
    private InputText txtUsuModifica;
    private InputText txtUsuario;
    private InputText txtDepaId_Departamento;
    private InputText txtPersId_Persona;
    private InputText txtTiusId_TipoUsuario;
    private InputText txtUsuaId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<UsuarioDTO> data;
    private UsuarioDTO selectedUsuario;
    private Usuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public UsuarioView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            UsuarioDTO usuarioDTO = (UsuarioDTO) e.getObject();

            if (txtContrasena == null) {
                txtContrasena = new InputText();
            }

            txtContrasena.setValue(usuarioDTO.getContrasena());

            if (txtEstadoRegistro == null) {
                txtEstadoRegistro = new InputText();
            }

            txtEstadoRegistro.setValue(usuarioDTO.getEstadoRegistro());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(usuarioDTO.getUsuCreador());

            if (txtUsuModifica == null) {
                txtUsuModifica = new InputText();
            }

            txtUsuModifica.setValue(usuarioDTO.getUsuModifica());

            if (txtUsuario == null) {
                txtUsuario = new InputText();
            }

            txtUsuario.setValue(usuarioDTO.getUsuario());

            if (txtDepaId_Departamento == null) {
                txtDepaId_Departamento = new InputText();
            }

            txtDepaId_Departamento.setValue(usuarioDTO.getDepaId_Departamento());

            if (txtPersId_Persona == null) {
                txtPersId_Persona = new InputText();
            }

            txtPersId_Persona.setValue(usuarioDTO.getPersId_Persona());

            if (txtTiusId_TipoUsuario == null) {
                txtTiusId_TipoUsuario = new InputText();
            }

            txtTiusId_TipoUsuario.setValue(usuarioDTO.getTiusId_TipoUsuario());

            if (txtUsuaId == null) {
                txtUsuaId = new InputText();
            }

            txtUsuaId.setValue(usuarioDTO.getUsuaId());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(usuarioDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(usuarioDTO.getFechaModificacion());

            Integer usuaId = FacesUtils.checkInteger(txtUsuaId);
            entity = businessDelegatorView.getUsuario(usuaId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedUsuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedUsuario = null;

        if (txtContrasena != null) {
            txtContrasena.setValue(null);
            txtContrasena.setDisabled(true);
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

        if (txtUsuario != null) {
            txtUsuario.setValue(null);
            txtUsuario.setDisabled(true);
        }

        if (txtDepaId_Departamento != null) {
            txtDepaId_Departamento.setValue(null);
            txtDepaId_Departamento.setDisabled(true);
        }

        if (txtPersId_Persona != null) {
            txtPersId_Persona.setValue(null);
            txtPersId_Persona.setDisabled(true);
        }

        if (txtTiusId_TipoUsuario != null) {
            txtTiusId_TipoUsuario.setValue(null);
            txtTiusId_TipoUsuario.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtUsuaId != null) {
            txtUsuaId.setValue(null);
            txtUsuaId.setDisabled(false);
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
            Integer usuaId = FacesUtils.checkInteger(txtUsuaId);
            entity = (usuaId != null)
                ? businessDelegatorView.getUsuario(usuaId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtContrasena.setDisabled(false);
            txtEstadoRegistro.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModifica.setDisabled(false);
            txtUsuario.setDisabled(false);
            txtDepaId_Departamento.setDisabled(false);
            txtPersId_Persona.setDisabled(false);
            txtTiusId_TipoUsuario.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtUsuaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtContrasena.setValue(entity.getContrasena());
            txtContrasena.setDisabled(false);
            txtEstadoRegistro.setValue(entity.getEstadoRegistro());
            txtEstadoRegistro.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModifica.setValue(entity.getUsuModifica());
            txtUsuModifica.setDisabled(false);
            txtUsuario.setValue(entity.getUsuario());
            txtUsuario.setDisabled(false);
            txtDepaId_Departamento.setValue(entity.getDepartamento().getDepaId());
            txtDepaId_Departamento.setDisabled(false);
            txtPersId_Persona.setValue(entity.getPersona().getPersId());
            txtPersId_Persona.setDisabled(false);
            txtTiusId_TipoUsuario.setValue(entity.getTipoUsuario().getTiusId());
            txtTiusId_TipoUsuario.setDisabled(false);
            txtUsuaId.setValue(entity.getUsuaId());
            txtUsuaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                           .get("selectedUsuario"));
        txtContrasena.setValue(selectedUsuario.getContrasena());
        txtContrasena.setDisabled(false);
        txtEstadoRegistro.setValue(selectedUsuario.getEstadoRegistro());
        txtEstadoRegistro.setDisabled(false);
        txtFechaCreacion.setValue(selectedUsuario.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedUsuario.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtUsuCreador.setValue(selectedUsuario.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModifica.setValue(selectedUsuario.getUsuModifica());
        txtUsuModifica.setDisabled(false);
        txtUsuario.setValue(selectedUsuario.getUsuario());
        txtUsuario.setDisabled(false);
        txtDepaId_Departamento.setValue(selectedUsuario.getDepaId_Departamento());
        txtDepaId_Departamento.setDisabled(false);
        txtPersId_Persona.setValue(selectedUsuario.getPersId_Persona());
        txtPersId_Persona.setDisabled(false);
        txtTiusId_TipoUsuario.setValue(selectedUsuario.getTiusId_TipoUsuario());
        txtTiusId_TipoUsuario.setDisabled(false);
        txtUsuaId.setValue(selectedUsuario.getUsuaId());
        txtUsuaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedUsuario == null) && (entity == null)) {
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
            entity = new Usuario();

            Integer usuaId = FacesUtils.checkInteger(txtUsuaId);

            entity.setContrasena(FacesUtils.checkString(txtContrasena));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModifica(FacesUtils.checkString(txtUsuModifica));
            entity.setUsuaId(usuaId);
            entity.setUsuario(FacesUtils.checkString(txtUsuario));
            entity.setDepartamento((FacesUtils.checkInteger(
                    txtDepaId_Departamento) != null)
                ? businessDelegatorView.getDepartamento(FacesUtils.checkInteger(
                        txtDepaId_Departamento)) : null);
            entity.setPersona((FacesUtils.checkInteger(txtPersId_Persona) != null)
                ? businessDelegatorView.getPersona(FacesUtils.checkInteger(
                        txtPersId_Persona)) : null);
            entity.setTipoUsuario((FacesUtils.checkInteger(
                    txtTiusId_TipoUsuario) != null)
                ? businessDelegatorView.getTipoUsuario(FacesUtils.checkInteger(
                        txtTiusId_TipoUsuario)) : null);
            businessDelegatorView.saveUsuario(entity);
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
                Integer usuaId = new Integer(selectedUsuario.getUsuaId());
                entity = businessDelegatorView.getUsuario(usuaId);
            }

            entity.setContrasena(FacesUtils.checkString(txtContrasena));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModifica(FacesUtils.checkString(txtUsuModifica));
            entity.setUsuario(FacesUtils.checkString(txtUsuario));
            entity.setDepartamento((FacesUtils.checkInteger(
                    txtDepaId_Departamento) != null)
                ? businessDelegatorView.getDepartamento(FacesUtils.checkInteger(
                        txtDepaId_Departamento)) : null);
            entity.setPersona((FacesUtils.checkInteger(txtPersId_Persona) != null)
                ? businessDelegatorView.getPersona(FacesUtils.checkInteger(
                        txtPersId_Persona)) : null);
            entity.setTipoUsuario((FacesUtils.checkInteger(
                    txtTiusId_TipoUsuario) != null)
                ? businessDelegatorView.getTipoUsuario(FacesUtils.checkInteger(
                        txtTiusId_TipoUsuario)) : null);
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                               .get("selectedUsuario"));

            Integer usuaId = new Integer(selectedUsuario.getUsuaId());
            entity = businessDelegatorView.getUsuario(usuaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer usuaId = FacesUtils.checkInteger(txtUsuaId);
            entity = businessDelegatorView.getUsuario(usuaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteUsuario(entity);
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
            selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                               .get("selectedUsuario"));

            Integer usuaId = new Integer(selectedUsuario.getUsuaId());
            entity = businessDelegatorView.getUsuario(usuaId);
            businessDelegatorView.deleteUsuario(entity);
            data.remove(selectedUsuario);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String contrasena, String estadoRegistro,
        Date fechaCreacion, Date fechaModificacion, String usuCreador,
        String usuModifica, Integer usuaId, String usuario,
        Integer depaId_Departamento, Integer persId_Persona,
        Integer tiusId_TipoUsuario) throws Exception {
        try {
            entity.setContrasena(FacesUtils.checkString(contrasena));
            entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setUsuCreador(FacesUtils.checkString(usuCreador));
            entity.setUsuModifica(FacesUtils.checkString(usuModifica));
            entity.setUsuario(FacesUtils.checkString(usuario));
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("UsuarioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtContrasena() {
        return txtContrasena;
    }

    public void setTxtContrasena(InputText txtContrasena) {
        this.txtContrasena = txtContrasena;
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

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public InputText getTxtDepaId_Departamento() {
        return txtDepaId_Departamento;
    }

    public void setTxtDepaId_Departamento(InputText txtDepaId_Departamento) {
        this.txtDepaId_Departamento = txtDepaId_Departamento;
    }

    public InputText getTxtPersId_Persona() {
        return txtPersId_Persona;
    }

    public void setTxtPersId_Persona(InputText txtPersId_Persona) {
        this.txtPersId_Persona = txtPersId_Persona;
    }

    public InputText getTxtTiusId_TipoUsuario() {
        return txtTiusId_TipoUsuario;
    }

    public void setTxtTiusId_TipoUsuario(InputText txtTiusId_TipoUsuario) {
        this.txtTiusId_TipoUsuario = txtTiusId_TipoUsuario;
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

    public InputText getTxtUsuaId() {
        return txtUsuaId;
    }

    public void setTxtUsuaId(InputText txtUsuaId) {
        this.txtUsuaId = txtUsuaId;
    }

    public List<UsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UsuarioDTO> usuarioDTO) {
        this.data = usuarioDTO;
    }

    public UsuarioDTO getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(UsuarioDTO usuario) {
        this.selectedUsuario = usuario;
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
