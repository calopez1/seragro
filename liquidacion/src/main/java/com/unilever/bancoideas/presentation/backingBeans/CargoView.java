package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.CargoDTO;
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
public class CargoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CargoView.class);
    private InputText txtAuxilioAlimentacion;
    private InputText txtAuxilioTransporte;
    private InputText txtCodigo;
    private InputText txtEstadoRegistro;
    private InputText txtNombre;
    private InputText txtSalario;
    private InputText txtUsuCreador;
    private InputText txtUsuModificacion;
    private InputText txtCargId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CargoDTO> data;
    private CargoDTO selectedCargo;
    private Cargo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public CargoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            CargoDTO cargoDTO = (CargoDTO) e.getObject();

            if (txtAuxilioAlimentacion == null) {
                txtAuxilioAlimentacion = new InputText();
            }

            txtAuxilioAlimentacion.setValue(cargoDTO.getAuxilioAlimentacion());

            if (txtAuxilioTransporte == null) {
                txtAuxilioTransporte = new InputText();
            }

            txtAuxilioTransporte.setValue(cargoDTO.getAuxilioTransporte());

            if (txtCodigo == null) {
                txtCodigo = new InputText();
            }

            txtCodigo.setValue(cargoDTO.getCodigo());

            if (txtEstadoRegistro == null) {
                txtEstadoRegistro = new InputText();
            }

            txtEstadoRegistro.setValue(cargoDTO.getEstadoRegistro());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(cargoDTO.getNombre());

            if (txtSalario == null) {
                txtSalario = new InputText();
            }

            txtSalario.setValue(cargoDTO.getSalario());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(cargoDTO.getUsuCreador());

            if (txtUsuModificacion == null) {
                txtUsuModificacion = new InputText();
            }

            txtUsuModificacion.setValue(cargoDTO.getUsuModificacion());

            if (txtCargId == null) {
                txtCargId = new InputText();
            }

            txtCargId.setValue(cargoDTO.getCargId());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(cargoDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(cargoDTO.getFechaModificacion());

            Integer cargId = FacesUtils.checkInteger(txtCargId);
            entity = businessDelegatorView.getCargo(cargId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedCargo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedCargo = null;

        if (txtAuxilioAlimentacion != null) {
            txtAuxilioAlimentacion.setValue(null);
            txtAuxilioAlimentacion.setDisabled(true);
        }

        if (txtAuxilioTransporte != null) {
            txtAuxilioTransporte.setValue(null);
            txtAuxilioTransporte.setDisabled(true);
        }

        if (txtCodigo != null) {
            txtCodigo.setValue(null);
            txtCodigo.setDisabled(true);
        }

        if (txtEstadoRegistro != null) {
            txtEstadoRegistro.setValue(null);
            txtEstadoRegistro.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtSalario != null) {
            txtSalario.setValue(null);
            txtSalario.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificacion != null) {
            txtUsuModificacion.setValue(null);
            txtUsuModificacion.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtCargId != null) {
            txtCargId.setValue(null);
            txtCargId.setDisabled(false);
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
            Integer cargId = FacesUtils.checkInteger(txtCargId);
            entity = (cargId != null) ? businessDelegatorView.getCargo(cargId)
                                      : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtAuxilioAlimentacion.setDisabled(false);
            txtAuxilioTransporte.setDisabled(false);
            txtCodigo.setDisabled(false);
            txtEstadoRegistro.setDisabled(false);
            txtNombre.setDisabled(false);
            txtSalario.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificacion.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtCargId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtAuxilioAlimentacion.setValue(entity.getAuxilioAlimentacion());
            txtAuxilioAlimentacion.setDisabled(false);
            txtAuxilioTransporte.setValue(entity.getAuxilioTransporte());
            txtAuxilioTransporte.setDisabled(false);
            txtCodigo.setValue(entity.getCodigo());
            txtCodigo.setDisabled(false);
            txtEstadoRegistro.setValue(entity.getEstadoRegistro());
            txtEstadoRegistro.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtSalario.setValue(entity.getSalario());
            txtSalario.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificacion.setValue(entity.getUsuModificacion());
            txtUsuModificacion.setDisabled(false);
            txtCargId.setValue(entity.getCargId());
            txtCargId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedCargo = (CargoDTO) (evt.getComponent().getAttributes()
                                       .get("selectedCargo"));
        txtAuxilioAlimentacion.setValue(selectedCargo.getAuxilioAlimentacion());
        txtAuxilioAlimentacion.setDisabled(false);
        txtAuxilioTransporte.setValue(selectedCargo.getAuxilioTransporte());
        txtAuxilioTransporte.setDisabled(false);
        txtCodigo.setValue(selectedCargo.getCodigo());
        txtCodigo.setDisabled(false);
        txtEstadoRegistro.setValue(selectedCargo.getEstadoRegistro());
        txtEstadoRegistro.setDisabled(false);
        txtFechaCreacion.setValue(selectedCargo.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedCargo.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtNombre.setValue(selectedCargo.getNombre());
        txtNombre.setDisabled(false);
        txtSalario.setValue(selectedCargo.getSalario());
        txtSalario.setDisabled(false);
        txtUsuCreador.setValue(selectedCargo.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificacion.setValue(selectedCargo.getUsuModificacion());
        txtUsuModificacion.setDisabled(false);
        txtCargId.setValue(selectedCargo.getCargId());
        txtCargId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedCargo == null) && (entity == null)) {
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
            entity = new Cargo();

            Integer cargId = FacesUtils.checkInteger(txtCargId);

            entity.setAuxilioAlimentacion(FacesUtils.checkString(
                    txtAuxilioAlimentacion));
            entity.setAuxilioTransporte(FacesUtils.checkString(
                    txtAuxilioTransporte));
            entity.setCargId(cargId);
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setSalario(FacesUtils.checkDouble(txtSalario));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificacion(FacesUtils.checkString(txtUsuModificacion));
            businessDelegatorView.saveCargo(entity);
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
                Integer cargId = new Integer(selectedCargo.getCargId());
                entity = businessDelegatorView.getCargo(cargId);
            }

            entity.setAuxilioAlimentacion(FacesUtils.checkString(
                    txtAuxilioAlimentacion));
            entity.setAuxilioTransporte(FacesUtils.checkString(
                    txtAuxilioTransporte));
            entity.setCodigo(FacesUtils.checkString(txtCodigo));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setNombre(FacesUtils.checkString(txtNombre));
            entity.setSalario(FacesUtils.checkDouble(txtSalario));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificacion(FacesUtils.checkString(txtUsuModificacion));
            businessDelegatorView.updateCargo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedCargo = (CargoDTO) (evt.getComponent().getAttributes()
                                           .get("selectedCargo"));

            Integer cargId = new Integer(selectedCargo.getCargId());
            entity = businessDelegatorView.getCargo(cargId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer cargId = FacesUtils.checkInteger(txtCargId);
            entity = businessDelegatorView.getCargo(cargId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteCargo(entity);
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
            selectedCargo = (CargoDTO) (evt.getComponent().getAttributes()
                                           .get("selectedCargo"));

            Integer cargId = new Integer(selectedCargo.getCargId());
            entity = businessDelegatorView.getCargo(cargId);
            businessDelegatorView.deleteCargo(entity);
            data.remove(selectedCargo);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String auxilioAlimentacion,
        String auxilioTransporte, Integer cargId, String codigo,
        String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
        String nombre, Double salario, String usuCreador, String usuModificacion)
        throws Exception {
        try {
            entity.setAuxilioAlimentacion(FacesUtils.checkString(
                    auxilioAlimentacion));
            entity.setAuxilioTransporte(FacesUtils.checkString(
                    auxilioTransporte));
            entity.setCodigo(FacesUtils.checkString(codigo));
            entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setNombre(FacesUtils.checkString(nombre));
            entity.setSalario(FacesUtils.checkDouble(salario));
            entity.setUsuCreador(FacesUtils.checkString(usuCreador));
            entity.setUsuModificacion(FacesUtils.checkString(usuModificacion));
            businessDelegatorView.updateCargo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CargoView").requestRender();
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

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtSalario() {
        return txtSalario;
    }

    public void setTxtSalario(InputText txtSalario) {
        this.txtSalario = txtSalario;
    }

    public InputText getTxtUsuCreador() {
        return txtUsuCreador;
    }

    public void setTxtUsuCreador(InputText txtUsuCreador) {
        this.txtUsuCreador = txtUsuCreador;
    }

    public InputText getTxtUsuModificacion() {
        return txtUsuModificacion;
    }

    public void setTxtUsuModificacion(InputText txtUsuModificacion) {
        this.txtUsuModificacion = txtUsuModificacion;
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

    public InputText getTxtCargId() {
        return txtCargId;
    }

    public void setTxtCargId(InputText txtCargId) {
        this.txtCargId = txtCargId;
    }

    public List<CargoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCargo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CargoDTO> cargoDTO) {
        this.data = cargoDTO;
    }

    public CargoDTO getSelectedCargo() {
        return selectedCargo;
    }

    public void setSelectedCargo(CargoDTO cargo) {
        this.selectedCargo = cargo;
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
