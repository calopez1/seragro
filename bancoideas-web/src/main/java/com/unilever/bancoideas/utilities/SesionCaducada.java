package com.unilever.bancoideas.utilities;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;




public class SesionCaducada implements Filter {
	static Logger log = LoggerFactory.getLogger(SesionCaducada.class);

	private FilterConfig config;
	private HashMap<String, String[]> map;
	private String paginaError;
	private String paginaFinSesion;
	private String objetoVerificacion;
	private String appName;
	private String paginaExcluida;
	private  WebApplicationContext ctx;

//	@ManagedProperty(value = "#{businessDelegatorView}")
//	private IBusinessDelegatorView businessDelegatorView;

	public String getExtension(String fichero) {
		String extension = null;
		String s = fichero;
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			extension = s.substring(i + 1).toLowerCase();
		}
		return extension;
	}

	public void destroy() {
		config = null;
	}

	public void init(FilterConfig config) throws ServletException {
		try{
			this.config = config;
			String delimitador = ",";

			//String a = Htt;
			paginaError = config.getInitParameter("paginaError");
			paginaFinSesion =  config.getInitParameter("paginaFinSesion");
			objetoVerificacion = config.getInitParameter("objetoVerificacion");
			appName = config.getInitParameter("appName");
			paginaExcluida=config.getInitParameter("paginaExcluida");

			Enumeration<String> e = config.getInitParameterNames();
			map = new HashMap<String, String[]>();
			if (paginaError == null) throw new ServletException("Parametrizar en el Web.xml el parametro 'paginaError'.");
			if (paginaFinSesion == null) throw new ServletException("Parametrizar en el Web.xml el parametro 'paginaFinSesion'.");
			if (objetoVerificacion == null) throw new ServletException("Parametrizar en el Web.xml el parametro 'objetoVerificacion'.");
			if (appName == null) throw new ServletException("Parametrizar en el Web.xml el parametro 'appName'.");
			if (paginaExcluida == null) throw new ServletException("Parametrizar en el Web.xml el parametro 'paginaExcluida'.");

			while (e.hasMoreElements()) {
				String element = (String) e.nextElement();
				String linea_props = (String) config.getInitParameter(element);
				String[] props = linea_props.split(delimitador);
				map.put(element, props);
			}
		}catch (ServletException e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		String uri = ((HttpServletRequest) request).getRequestURI();
		String path = request.getServletContext().getContextPath();
		//String uri3 = request.getr;
		boolean flagReestablecerContrasena = false;
		
		HttpSession session = null;
		try{
			try {

				if (request instanceof HttpServletRequest) {
					session = ((HttpServletRequest) request).getSession();
				}

				if (uri.startsWith("/siemamobile-web/XHTML/reestablecerContrasena.xhtml")) {
					flagReestablecerContrasena = true;
					this.ctx = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
//					if (this.ctx.containsBean("businessDelegatorView")) {
//						this.businessDelegatorView = (IBusinessDelegatorView) this.ctx.getBean("businessDelegatorView");
//					}

					String token = ((HttpServletRequest) request).getParameter("token");

					//boolean tokenValido = businessDelegatorView.validarToken(token);

//					if (tokenValido) {
//						session = ((HttpServletRequest) request).getSession(true);
//						session.setAttribute("token", token);
//						chain.doFilter(request, response);
//						((HttpServletResponse) response).sendRedirect("/siemamobile-web/reestablecerContrasena.xhtml");
//					}

				}

				if (session.getAttribute(objetoVerificacion) != null) {
					chain.doFilter(request, response);
				} else if (session.getAttribute(objetoVerificacion) == null && flagReestablecerContrasena==false) {
					throw new Exception("Objeto de verificacion "+objetoVerificacion+" = nulo.");
				}

			} catch (javax.servlet.ServletException je) {
				log.error("appName: "+appName+" - Filtro: Excepcion: " + je.getMessage());
				throw je;
			} catch (Exception ex) {
				log.error("appName: "+appName+" - Error al acceder a: " + uri);
				log.error("appName: "+appName+" - Filtro: " + ex.getMessage());
				throw new ServletException("En el Filtro solicitando: " + uri + "<br/>" + ex.getMessage());
			}
		}catch (Exception e) {
			log.error("appName: "+appName+" - Filtro: " + e.getMessage());
			((HttpServletResponse) response).sendRedirect(path + paginaFinSesion);
		}
	}

//	public IBusinessDelegatorView getBusinessDelegatorView() {
//		return businessDelegatorView;
//	}
//
//	public void setBusinessDelegatorView(
//			IBusinessDelegatorView businessDelegatorView) {
//		this.businessDelegatorView = businessDelegatorView;
//	}

}
