package com.unilever.bancoideas.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.unilever.bancoideas.modelo.dto.UsuarioDTO;
import com.unilever.bancoideas.utilities.FacesUtils;



/**
 * @author Zathura Code Generator http://code.google.com/p/zathura/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class MenuView implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MenuView.class);
	private String nombrePersona;
	private String empresaPersona;
	private MenuModel model;
	private String anoFiscal;
	private String estadoAnoFiscal;
    public String nombreUsuario;


	public MenuView() {
		super();

	}

	@PostConstruct
	public void infoPersonaTopBar(){
		
		UsuarioDTO usuarioSesion = (UsuarioDTO) FacesUtils.getManagedBeanFromSession("usuarioSesion");
		nombreUsuario = usuarioSesion.getIdentificacionPersona() + " - "+usuarioSesion.getPrimerNombre() + " " + usuarioSesion.getPrimerApellido();
        
		//Se declara el modelo que contendra todas las opciones
		model = new DefaultMenuModel();

//		
//		//se itera cada grupo de la lista de opciones
//		for (GrupoDTO grupoDTO : listaOpcionesPadres) {
//			DefaultSubMenu subMenu = new DefaultSubMenu();
//			subMenu.setId(grupoDTO.getGru_codigo());
//			subMenu.setLabel(grupoDTO.getGru_nombre());
//			subMenu.setIcon(grupoDTO.getGru_icono());
//			
//			for (GrupoDTO grupoDTOHija : listaOpcionesHijas) {
//				if(grupoDTO.getGru_codigo().trim().equals(grupoDTOHija.getGru_codigo_padre().trim())){
//					
//					DefaultSubMenu subMenuHija = new DefaultSubMenu();
//					subMenuHija.setId(grupoDTOHija.getGru_codigo());
//					subMenuHija.setLabel(grupoDTOHija.getGru_nombre());
//					subMenuHija.setIcon(grupoDTOHija.getGru_icono());
//					//se itera cada una de las opciones por grupo
//					if(grupoDTOHija.getOpciones().size() > 0){
//						for (OpcionDTO opcionHija : grupoDTOHija.getOpciones()) {
//							//para cada opcion, se crea un item y se agrega al submenu
//							DefaultMenuItem itemHija = new DefaultMenuItem();
//							itemHija.setId(opcionHija.getOpc_codigo());
//							itemHija.setValue(opcionHija.getOpc_nombre());
//							itemHija.setUrl(opcionHija.getOpc_llave_acceso());
//							subMenuHija.addElement(itemHija);
//
//						}
//					}
//					subMenu.addElement(subMenuHija);
//					
//				}
//			}
//			//se itera cada una de las opciones por grupo
//			if(grupoDTO.getOpciones().size() > 0){
//				for (OpcionDTO opcion : grupoDTO.getOpciones()) {
//					//para cada opcion, se crea un item y se agrega al submenu
//					DefaultMenuItem item = new DefaultMenuItem();
//					item.setId(opcion.getOpc_codigo());
//					item.setValue(opcion.getOpc_nombre());
//					item.setUrl(opcion.getOpc_llave_acceso());
//					subMenu.addElement(item);
//
//				}
//			}
//			model.addElement(subMenu);
//		}
//		
//		//Item temporal para asignar iconos a los submenu y menu item
//		DefaultMenuItem sm_fonts = new DefaultMenuItem();
//		sm_fonts.setId("sm_fonts");
//		sm_fonts.setValue("Fonts");
//		sm_fonts.setIcon("icon-book");
//		sm_fonts.setOutcome("font-icons.xhtml");
//		sm_fonts.setRendered(false);
//		model.addElement(sm_fonts);
		
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getEmpresaPersona() {
		return empresaPersona;
	}

	public void setEmpresaPersona(String empresaPersona) {
		this.empresaPersona = empresaPersona;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}
	
	public String getAnoFiscal() {
		return anoFiscal;
	}

	public void setAnoFiscal(String anoFiscal) {
		this.anoFiscal = anoFiscal;
	}

	public String getEstadoAnoFiscal() {
		return estadoAnoFiscal;
	}

	public void setEstadoAnoFiscal(String estadoAnoFiscal) {
		this.estadoAnoFiscal = estadoAnoFiscal;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	

}
