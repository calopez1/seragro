package com.unilever.bancoideas.dataaccess.dao;

import com.unilever.bancoideas.dataaccess.api.HibernateDaoImpl;
import com.unilever.bancoideas.modelo.HoraExtraEmpleado;
import com.unilever.bancoideas.modelo.dto.HoraExtraEmpleadoDTO;
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
 * HoraExtraEmpleado entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.HoraExtraEmpleado
 */
@Scope("singleton")
@Repository("HoraExtraEmpleadoDAO")
public class HoraExtraEmpleadoDAO extends HibernateDaoImpl<HoraExtraEmpleado, Integer>
    implements IHoraExtraEmpleadoDAO {
    private static final Logger log = LoggerFactory.getLogger(HoraExtraEmpleadoDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static IHoraExtraEmpleadoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IHoraExtraEmpleadoDAO) ctx.getBean("HoraExtraEmpleadoDAO");
    }
    
    @Override
    public List<HoraExtraEmpleadoDTO> consultarHorasExtrasPeriodo(String estado, String fechaInicial, String fechaFinal, Integer emplId) throws Exception {
		List<HoraExtraEmpleadoDTO> listDto = null;
		try {
			Query query = getSession().getNamedQuery("consultar_horas_extras_periodo");
			query.setParameter("pEstado", estado);
			query.setParameter("pFechaInicio", fechaInicial);
			query.setParameter("pFechaFin", fechaFinal);
			query.setParameter("pIdEmpl", emplId);

			
			query.setResultTransformer(Transformers.aliasToBean(HoraExtraEmpleadoDTO.class));
			listDto = query.list();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return listDto;
	}
    
    
}
