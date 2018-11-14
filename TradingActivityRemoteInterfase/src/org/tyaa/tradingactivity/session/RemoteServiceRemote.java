/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.session;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;
import org.tyaa.tradingactivity.entity.Sale;

/**
 *
 * @author Юрий
 */

@Remote
public interface RemoteServiceRemote extends Serializable
{
    /*Получить все продажи*/
    List getAllSales();
    
    /*Добавить продажу*/
    //void addSale(Sale _sale, int _brokerId, int _categoryId);
    //void addSale(Sale _sale);
    void addSale(String _securityName, int _price, int _quantity, int _brokerId, int _categoryId);
}

