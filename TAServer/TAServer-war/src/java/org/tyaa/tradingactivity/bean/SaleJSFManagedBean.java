/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.bean;

import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import org.tyaa.tradingactivity.entity.Sale;
import org.tyaa.tradingactivity.session.SaleFacade;

/**
 *
 * @author Юлия
 */
@ManagedBean(name="sale_data", eager = false)
@ApplicationScoped
public class SaleJSFManagedBean {

    /**
     * Creates a new instance of IndexJSFManagedBean
     */
    
    //private List<Sale> salesList = new ArrayList<>();
    
    public SaleJSFManagedBean() {
        //salesList = getAllSales();
    }
    
    @EJB
    SaleFacade saleFacade;
    
    public Sale getSale() throws InterruptedException{
        //Thread.sleep(1000);
        Map<String, String> params =
                FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .getRequestParameterMap();
        if(params.containsKey("sale_id")){
            Sale sale = saleFacade.find(Integer.valueOf(params.get("sale_id")));
            return sale;
        }else
        {
            return null;
        }
    }
}
