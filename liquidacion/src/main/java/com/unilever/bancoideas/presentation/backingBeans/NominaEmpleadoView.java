package com.unilever.bancoideas.presentation.backingBeans;

import com.unilever.bancoideas.exceptions.*;
import com.unilever.bancoideas.modelo.*;
import com.unilever.bancoideas.modelo.dto.NominaEmpleadoDTO;
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
public class NominaEmpleadoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(NominaEmpleadoView.class);
    private InputText txtDeducciones;
    private InputText txtDiasLaborados;
    private InputText txtEstadoRegistro;
    private InputText txtTotalPagar;
    private InputText txtUsuCreador;
    private InputText txtUsuModificador;
    private InputText txtEmplId_Empleado;
    private InputText txtLinoId_LiquidacionNomina;
    private InputText txtNoemId;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<NominaEmpleadoDTO> data;
    private NominaEmpleadoDTO selectedNominaEmpleado;
    private NominaEmpleado entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public NominaEmpleadoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            NominaEmpleadoDTO nominaEmpleadoDTO = (NominaEmpleadoDTO) e.getObject();

            if (txtDeducciones == null) {
                txtDeducciones = new InputText();
            }

            txtDeducciones.setValue(nominaEmpleadoDTO.getDeducciones());

            if (txtDiasLaborados == null) {
                txtDiasLaborados = new InputText();
            }

            txtDiasLaborados.setValue(nominaEmpleadoDTO.getDiasLaborados());

            if (txtEstadoRegistro == null) {
                txtEstadoRegistro = new InputText();
            }

            txtEstadoRegistro.setValue(nominaEmpleadoDTO.getEstadoRegistro());

            if (txtTotalPagar == null) {
                txtTotalPagar = new InputText();
            }

            txtTotalPagar.setValue(nominaEmpleadoDTO.getTotalPagar());

            if (txtUsuCreador == null) {
                txtUsuCreador = new InputText();
            }

            txtUsuCreador.setValue(nominaEmpleadoDTO.getUsuCreador());

            if (txtUsuModificador == null) {
                txtUsuModificador = new InputText();
            }

            txtUsuModificador.setValue(nominaEmpleadoDTO.getUsuModificador());

            if (txtEmplId_Empleado == null) {
                txtEmplId_Empleado = new InputText();
            }

            txtEmplId_Empleado.setValue(nominaEmpleadoDTO.getEmplId_Empleado());

            if (txtLinoId_LiquidacionNomina == null) {
                txtLinoId_LiquidacionNomina = new InputText();
            }

            txtLinoId_LiquidacionNomina.setValue(nominaEmpleadoDTO.getLinoId_LiquidacionNomina());

            if (txtNoemId == null) {
                txtNoemId = new InputText();
            }

            txtNoemId.setValue(nominaEmpleadoDTO.getNoemId());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(nominaEmpleadoDTO.getFechaCreacion());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(nominaEmpleadoDTO.getFechaModificacion());

            Integer noemId = FacesUtils.checkInteger(txtNoemId);
            entity = businessDelegatorView.getNominaEmpleado(noemId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedNominaEmpleado = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedNominaEmpleado = null;

        if (txtDeducciones != null) {
            txtDeducciones.setValue(null);
            txtDeducciones.setDisabled(true);
        }

        if (txtDiasLaborados != null) {
            txtDiasLaborados.setValue(null);
            txtDiasLaborados.setDisabled(true);
        }

        if (txtEstadoRegistro != null) {
            txtEstadoRegistro.setValue(null);
            txtEstadoRegistro.setDisabled(true);
        }

        if (txtTotalPagar != null) {
            txtTotalPagar.setValue(null);
            txtTotalPagar.setDisabled(true);
        }

        if (txtUsuCreador != null) {
            txtUsuCreador.setValue(null);
            txtUsuCreador.setDisabled(true);
        }

        if (txtUsuModificador != null) {
            txtUsuModificador.setValue(null);
            txtUsuModificador.setDisabled(true);
        }

        if (txtEmplId_Empleado != null) {
            txtEmplId_Empleado.setValue(null);
            txtEmplId_Empleado.setDisabled(true);
        }

        if (txtLinoId_LiquidacionNomina != null) {
            txtLinoId_LiquidacionNomina.setValue(null);
            txtLinoId_LiquidacionNomina.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtNoemId != null) {
            txtNoemId.setValue(null);
            txtNoemId.setDisabled(false);
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
            Integer noemId = FacesUtils.checkInteger(txtNoemId);
            entity = (noemId != null)
                ? businessDelegatorView.getNominaEmpleado(noemId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDeducciones.setDisabled(false);
            txtDiasLaborados.setDisabled(false);
            txtEstadoRegistro.setDisabled(false);
            txtTotalPagar.setDisabled(false);
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setDisabled(false);
            txtEmplId_Empleado.setDisabled(false);
            txtLinoId_LiquidacionNomina.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtNoemId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDeducciones.setValue(entity.getDeducciones());
            txtDeducciones.setDisabled(false);
            txtDiasLaborados.setValue(entity.getDiasLaborados());
            txtDiasLaborados.setDisabled(false);
            txtEstadoRegistro.setValue(entity.getEstadoRegistro());
            txtEstadoRegistro.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtTotalPagar.setValue(entity.getTotalPagar());
            txtTotalPagar.setDisabled(false);
            txtUsuCreador.setValue(entity.getUsuCreador());
            txtUsuCreador.setDisabled(false);
            txtUsuModificador.setValue(entity.getUsuModificador());
            txtUsuModificador.setDisabled(false);
            txtEmplId_Empleado.setValue(entity.getEmpleado().getEmplId());
            txtEmplId_Empleado.setDisabled(false);
            txtLinoId_LiquidacionNomina.setValue(entity.getLiquidacionNomina()
                                                       .getLinoId());
            txtLinoId_LiquidacionNomina.setDisabled(false);
            txtNoemId.setValue(entity.getNoemId());
            txtNoemId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedNominaEmpleado = (NominaEmpleadoDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedNominaEmpleado"));
        txtDeducciones.setValue(selectedNominaEmpleado.getDeducciones());
        txtDeducciones.setDisabled(false);
        txtDiasLaborados.setValue(selectedNominaEmpleado.getDiasLaborados());
        txtDiasLaborados.setDisabled(false);
        txtEstadoRegistro.setValue(selectedNominaEmpleado.getEstadoRegistro());
        txtEstadoRegistro.setDisabled(false);
        txtFechaCreacion.setValue(selectedNominaEmpleado.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaModificacion.setValue(selectedNominaEmpleado.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtTotalPagar.setValue(selectedNominaEmpleado.getTotalPagar());
        txtTotalPagar.setDisabled(false);
        txtUsuCreador.setValue(selectedNominaEmpleado.getUsuCreador());
        txtUsuCreador.setDisabled(false);
        txtUsuModificador.setValue(selectedNominaEmpleado.getUsuModificador());
        txtUsuModificador.setDisabled(false);
        txtEmplId_Empleado.setValue(selectedNominaEmpleado.getEmplId_Empleado());
        txtEmplId_Empleado.setDisabled(false);
        txtLinoId_LiquidacionNomina.setValue(selectedNominaEmpleado.getLinoId_LiquidacionNomina());
        txtLinoId_LiquidacionNomina.setDisabled(false);
        txtNoemId.setValue(selectedNominaEmpleado.getNoemId());
        txtNoemId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedNominaEmpleado == null) && (entity == null)) {
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
            entity = new NominaEmpleado();

            Integer noemId = FacesUtils.checkInteger(txtNoemId);

            entity.setDeducciones(FacesUtils.checkDouble(txtDeducciones));
            entity.setDiasLaborados(FacesUtils.checkInteger(txtDiasLaborados));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setNoemId(noemId);
            entity.setTotalPagar(FacesUtils.checkDouble(txtTotalPagar));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkString(txtUsuModificador));
            entity.setEmpleado((FacesUtils.checkInteger(txtEmplId_Empleado) != null)
                ? businessDelegatorView.getEmpleado(FacesUtils.checkInteger(
                        txtEmplId_Empleado)) : null);
            entity.setLiquidacionNomina((FacesUtils.checkInteger(
                    txtLinoId_LiquidacionNomina) != null)
                ? businessDelegatorView.getLiquidacionNomina(
                    FacesUtils.checkInteger(txtLinoId_LiquidacionNomina)) : null);
            businessDelegatorView.saveNominaEmpleado(entity);
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
                Integer noemId = new Integer(selectedNominaEmpleado.getNoemId());
                entity = businessDelegatorView.getNominaEmpleado(noemId);
            }

            entity.setDeducciones(FacesUtils.checkDouble(txtDeducciones));
            entity.setDiasLaborados(FacesUtils.checkInteger(txtDiasLaborados));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setTotalPagar(FacesUtils.checkDouble(txtTotalPagar));
            entity.setUsuCreador(FacesUtils.checkString(txtUsuCreador));
            entity.setUsuModificador(FacesUtils.checkString(txtUsuModificador));
            entity.setEmpleado((FacesUtils.checkInteger(txtEmplId_Empleado) != null)
                ? businessDelegatorView.getEmpleado(FacesUtils.checkInteger(
                        txtEmplId_Empleado)) : null);
            entity.setLiquidacionNomina((FacesUtils.checkInteger(
                    txtLinoId_LiquidacionNomina) != null)
                ? businessDelegatorView.getLiquidacionNomina(
                    FacesUtils.checkInteger(txtLinoId_LiquidacionNomina)) : null);
            businessDelegatorView.updateNominaEmpleado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedNominaEmpleado = (NominaEmpleadoDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedNominaEmpleado"));

            Integer noemId = new Integer(selectedNominaEmpleado.getNoemId());
            entity = businessDelegatorView.getNominaEmpleado(noemId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer noemId = FacesUtils.checkInteger(txtNoemId);
            entity = businessDelegatorView.getNominaEmpleado(noemId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteNominaEmpleado(entity);
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
            selectedNominaEmpleado = (NominaEmpleadoDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedNominaEmpleado"));

            Integer noemId = new Integer(selectedNominaEmpleado.getNoemId());
            entity = businessDelegatorView.getNominaEmpleado(noemId);
            businessDelegatorView.deleteNominaEmpleado(entity);
            data.remove(selectedNominaEmpleado);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Double deducciones,
        Integer diasLaborados, String estadoRegistro, Date fechaCreacion,
        Date fechaModificacion, Integer noemId, Double totalPagar,
        String usuCreador, String usuModificador, Integer emplId_Empleado,
        Integer linoId_LiquidacionNomina) throws Exception {
        try {
            entity.setDeducciones(FacesUtils.checkDouble(deducciones));
            entity.setDiasLaborados(FacesUtils.checkInteger(diasLaborados));
            entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setTotalPagar(FacesUtils.checkDouble(totalPagar));
            entity.setUsuCreador(FacesUtils.checkString(usuCreador));
            entity.setUsuModificador(FacesUtils.checkString(usuModificador));
            businessDelegatorView.updateNominaEmpleado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("NominaEmpleadoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDeducciones() {
        return txtDeducciones;
    }

    public void setTxtDeducciones(InputText txtDeducciones) {
        this.txtDeducciones = txtDeducciones;
    }

    public InputText getTxtDiasLaborados() {
        return txtDiasLaborados;
    }

    public void setTxtDiasLaborados(InputText txtDiasLaborados) {
        this.txtDiasLaborados = txtDiasLaborados;
    }

    public InputText getTxtEstadoRegistro() {
        return txtEstadoRegistro;
    }

    public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
        this.txtEstadoRegistro = txtEstadoRegistro;
    }

    public InputText getTxtTotalPagar() {
        return txtTotalPagar;
    }

    public void setTxtTotalPagar(InputText txtTotalPagar) {
        this.txtTotalPagar = txtTotalPagar;
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

    public InputText getTxtEmplId_Empleado() {
        return txtEmplId_Empleado;
    }

    public void setTxtEmplId_Empleado(InputText txtEmplId_Empleado) {
        this.txtEmplId_Empleado = txtEmplId_Empleado;
    }

    public InputText getTxtLinoId_LiquidacionNomina() {
        return txtLinoId_LiquidacionNomina;
    }

    public void setTxtLinoId_LiquidacionNomina(
        InputText txtLinoId_LiquidacionNomina) {
        this.txtLinoId_LiquidacionNomina = txtLinoId_LiquidacionNomina;
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

    public InputText getTxtNoemId() {
        return txtNoemId;
    }

    public void setTxtNoemId(InputText txtNoemId) {
        this.txtNoemId = txtNoemId;
    }

    public List<NominaEmpleadoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataNominaEmpleado();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<NominaEmpleadoDTO> nominaEmpleadoDTO) {
        this.data = nominaEmpleadoDTO;
    }

    public NominaEmpleadoDTO getSelectedNominaEmpleado() {
        return selectedNominaEmpleado;
    }

    public void setSelectedNominaEmpleado(NominaEmpleadoDTO nominaEmpleado) {
        this.selectedNominaEmpleado = nominaEmpleado;
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
