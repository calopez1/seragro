package com.unilever.bancoideas.dataaccess.dao;

import com.unilever.bancoideas.dataaccess.api.HibernateDaoImpl;
import com.unilever.bancoideas.modelo.LiquidacionNomina;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Example;

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
 * LiquidacionNomina entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.LiquidacionNomina
 */
@Scope("singleton")
@Repository("LiquidacionNominaDAO")
public class LiquidacionNominaDAO extends HibernateDaoImpl<LiquidacionNomina, Integer>
    implements ILiquidacionNominaDAO {
    private static final Logger log = LoggerFactory.getLogger(LiquidacionNominaDAO.class);
    @Resource
    private SessionFactory sessionFactory;

    public static ILiquidacionNominaDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (ILiquidacionNominaDAO) ctx.getBean("LiquidacionNominaDAO");
    }
    
    @Override
    public List<LiquidacionNomina> consultarLiquidacionNominaPeriodo(Date fechaInicial, Date fechaFinal) throws Exception {
		List<LiquidacionNomina> listDto = null;
		try {
			Query query = getSession().getNamedQuery("consulta_liquidacion_nomina_por_periodo");
			query.setParameter("pFechaInicio", fechaInicial);
			query.setParameter("pFechaFin", fechaFinal);
			listDto = query.list();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return listDto;
	}
    
    
    
}
