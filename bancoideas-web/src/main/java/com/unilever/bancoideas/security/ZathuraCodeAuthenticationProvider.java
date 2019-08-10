package com.unilever.bancoideas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Component;

import com.unilever.bancoideas.modelo.Departamento;
import com.unilever.bancoideas.modelo.Persona;
import com.unilever.bancoideas.modelo.TipoIdentificacion;
import com.unilever.bancoideas.modelo.TipoUsuario;
import com.unilever.bancoideas.modelo.Usuario;
import com.unilever.bancoideas.modelo.dto.UsuarioDTO;
import com.unilever.bancoideas.presentation.businessDelegate.IBusinessDelegatorView;
import com.unilever.bancoideas.utilities.Constantes;
import com.unilever.bancoideas.utilities.FacesUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Component("zathuraCodeAuthenticationProvider")
public class ZathuraCodeAuthenticationProvider implements AuthenticationProvider {
	
	/**
	 * Implementacion de la seguridad propia
	 */
	@Autowired
	private IBusinessDelegatorView businessDelegatorView;
		
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
    	//Usuario logueado
    	Usuario usuario = null;
    	List<Usuario> lstUsuario = null;
    	UsuarioDTO usuarioSesion = null;
    	try {
	
    		//Se recibe el usuario y contrasena
	    	String name = authentication.getName();
	        String password = authentication.getCredentials().toString();
	
	        //Se valida si se ingresa la informacion necesario para el login
	        if(name == null || name.trim().equals("")) {
	        	throw new Exception("Por favor ingrese un usuario");
	        }
	        if(password == null || password.trim().equals("")) {
	        	throw new Exception("Por favor ingrese una contraseña");
	        }
	        
	        //Se consulta si el usuario existe en la bd
	        Object[] variables = {"usuario", true, name, "=","estadoRegistro", true, Constantes.ESTADO_ACTIVO, "="};
	        lstUsuario = businessDelegatorView.findByCriteriaInUsuario(variables, null, null);
	        
	        if(lstUsuario == null || lstUsuario.isEmpty()) {
	        	throw new Exception("El usuario "+name+ " NO existe");
	        }else {
	        	usuario = lstUsuario.get(0);
	        }
	        
	        //Se valida la contrasena
	        if (name.equals(usuario.getUsuario()) && password.equals(usuario.getContrasena())) {
	           
	        	//Se consulta el rol del usuario
	        	TipoUsuario tipoUsuario = businessDelegatorView.getTipoUsuario(usuario.getTipoUsuario().getTiusId());
	        	Persona persona = businessDelegatorView.getPersona(usuario.getPersona().getPersId());
	        	TipoIdentificacion tipoIdentificacion = businessDelegatorView.getTipoIdentificacion(persona.getTipoIdentificacion().getTiidId());
	        	Departamento departamento = businessDelegatorView.getDepartamento(usuario.getDepartamento().getDepaId());
	        	
	        	final List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	            grantedAuths.add(new SimpleGrantedAuthority(tipoUsuario.getCodigo()));
	
	            final UserDetails principal = new User(name, password, grantedAuths);
	            final Authentication auth = new UsernamePasswordAuthenticationToken(principal,  password, grantedAuths);

	            usuarioSesion = new UsuarioDTO();
	            usuarioSesion.setCodigoDepartamento(departamento.getCodigo());
	            usuarioSesion.setIdDepa(departamento.getDepaId());
	            usuarioSesion.setNombreDepartamento(departamento.getNombre());

	            usuarioSesion.setCodigoTipoId(tipoIdentificacion.getCodigo());
	            usuarioSesion.setNombreTipoId(tipoIdentificacion.getNombre());

	            usuarioSesion.setIdTius(tipoUsuario.getTiusId());
	            usuarioSesion.setCodigoRol(tipoUsuario.getCodigo());
	            usuarioSesion.setNombreRol(tipoUsuario.getNombre());

	            usuarioSesion.setUsuaId(usuario.getUsuaId());
	            usuarioSesion.setUsuario(usuario.getUsuario());
	            usuarioSesion.setEstadoRegistro(usuario.getEstadoRegistro());

	            usuarioSesion.setEmail(persona.getEmail());
	            usuarioSesion.setIdentificacionPersona(persona.getIdentificacion());
	            usuarioSesion.setIdPers(persona.getPersId());
	            usuarioSesion.setPrimerApellido(persona.getPrimerApellido());
	            usuarioSesion.setPrimerNombre(persona.getPrimerNombre());
	            usuarioSesion.setSegundoApellido(persona.getSegundoApellido());
	            usuarioSesion.setSegundoNombre(persona.getSegundoNombre());
	            
	            FacesUtils.setManagedBeanInSession("usuarioSesion", null);
	            FacesUtils.setManagedBeanInSession("usuarioSesion", usuarioSesion);

	            return auth;
	        } else {
	        	FacesUtils.addErrorMessage("La contraseña es incorrecta");
	            return null;
	        }
    	} catch (Exception e) {
    		FacesUtils.addErrorMessage(e.getMessage());
    		return null;
    	}
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    
    
}
