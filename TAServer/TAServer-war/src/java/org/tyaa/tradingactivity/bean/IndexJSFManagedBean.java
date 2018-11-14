/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.bean;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import org.tyaa.tradingactivity.entity.Category;
import org.tyaa.tradingactivity.entity.Sale;
import org.tyaa.tradingactivity.session.CategoryFacade;
import org.tyaa.tradingactivity.session.SaleFacade;

/**
 *
 * @author Юлия
 */
@ManagedBean(name="index_data", eager = true)
@ApplicationScoped
public class IndexJSFManagedBean {

    private String mSearchString;
    
    public IndexJSFManagedBean() {
        //salesList = getAllSales();
    }
    
    @EJB
    SaleFacade saleFacade;
    
    @EJB
    CategoryFacade categoryFacade;
    
    public List getSales() throws InterruptedException{
        Map<String, String> params =
                FacesContext.getCurrentInstance()
                            .getExternalContext()
                            .getRequestParameterMap();
        if(params.containsKey("category_id")){
            Category category = categoryFacade.find(Integer.parseInt(params.get("category_id")));
            for (Sale sale : category.getSaleCollection()) {
                System.out.println(sale.getId());
            }
            return (List)category.getSaleCollection();
        }else if(params.containsKey("search_string")){
            List<Sale> sales =
                saleFacade.findBySecurityName(mSearchString);
                sales.stream().forEach((sale) -> {
                    System.out.println(sale.getSecurityName());
                });
                return sales;
        }
        return saleFacade.findAll();
    }
    
    public List getAllCategories(){
        return categoryFacade.findAll();
    }
    
    //Перезагрузка страницы каждые 5 секунд
    @Schedule(minute = "*/5", hour = "*", persistent=false)
    public void updateJsfPage() throws IOException {
        System.out.println("Jsf page updating");
        FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("#");
    }
    
    public String getSearchString() {
        return mSearchString;
    }

    public void setSearchString(String _searchString) {
        mSearchString = _searchString;
    }
}
