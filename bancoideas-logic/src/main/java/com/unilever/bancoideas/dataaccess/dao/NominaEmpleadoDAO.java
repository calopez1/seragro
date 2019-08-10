package com.unilever.bancoideas.dataaccess.dao;

import com.unilever.bancoideas.dataaccess.api.HibernateDaoImpl;
import com.unilever.bancoideas.modelo.NominaEmpleado;
import com.unilever.bancoideas.modelo.dto.NominaEmpleadoDTO;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Example;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;


/**
 * A data access object (DAO) providing persistence and search support for
 * NominaEmpleado entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.NominaEmpleado
 */
@Scope("singleton")
@Repository("NominaEmpleadoDAO")
public class NominaEmpleadoDAO extends HibernateDaoImpl<NominaEmpleado, Integer>
    implements INominaEmpleadoDAO {
    private static final Logger log = LoggerFactory.getLogger(NominaEmpleadoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static INominaEmpleadoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (INominaEmpleadoDAO) ctx.getBean("NominaEmpleadoDAO");
    }
    
    
    @Override
    public List<NominaEmpleadoDTO> consultarLiquidacionNominaEmpleadoXLiquidacionNomina(Integer linoId) throws Exception {
		List<NominaEmpleadoDTO> listDto = null;
		try {
			Query query = getSession().getNamedQuery("consultar_liquidacion_nomina_empleado_x_liquidacion_nomina");
			query.setParameter("pLinoId", linoId);
			query.setResultTransformer(Transformers.aliasToBean(NominaEmpleadoDTO.class));
			listDto = query.list();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return listDto;
	}
    
    @Override
   	public void eliminarNominaEmpleado(Integer linoId) throws Exception {
   		try {
   			Query query = getSession().getNamedQuery("eliminar_liquidacion_nomina_empleado");
   			query.setParameter("pLinoId", linoId);
   			query.executeUpdate();
   		} catch (Exception e) {
   			log.error(e.getMessage());
   			throw e;
   		}
   		
   	}
    
}
