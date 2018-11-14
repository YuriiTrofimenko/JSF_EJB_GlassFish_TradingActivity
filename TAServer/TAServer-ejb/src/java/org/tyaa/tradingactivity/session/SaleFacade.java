/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import org.tyaa.tradingactivity.entity.Sale;

/**
 *
 * @author Юрий
 */
@Stateless
public class SaleFacade extends AbstractFacade<Sale>
{

    @PersistenceContext(unitName = "TAServer-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public SaleFacade()
    {
        super(Sale.class);
    }
    
    //
    public List<Sale> findBySecurityName(Object _security_name)
    {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        javax.persistence.criteria.CriteriaQuery<Sale> cq =
                cb.createQuery(Sale.class);
        /*Metamodel metamodel = em.getMetamodel();
        EntityType<Sale> Sale_ = metamodel.entity(Sale.class);*/
        Root<Sale> saleRoot = cq.from(Sale.class);
        cq.select(saleRoot);
        cq.where(cb.equal(saleRoot.get("securityName"), _security_name));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
