/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tyaa.tradingactivity.entity.Category;

/**
 *
 * @author Юрий
 */
@Stateless
public class CategoryFacade extends AbstractFacade<Category>
{

    @PersistenceContext(unitName = "TAServer-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager()
    {
        return em;
    }

    public CategoryFacade()
    {
        super(Category.class);
    }
    
}
