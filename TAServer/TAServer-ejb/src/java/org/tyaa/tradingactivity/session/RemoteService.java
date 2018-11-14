/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.session;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.tyaa.tradingactivity.entity.Broker;
import org.tyaa.tradingactivity.entity.Sale;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.tyaa.tradingactivity.entity.Category;

/**
 *
 * @author Юрий
 */
@Stateless
public class RemoteService implements RemoteServiceRemote {
    @EJB
    SaleFacade saleFacade;
    
    @EJB
    BrokerFacade brokerFacade;
    
    @EJB
    CategoryFacade categoryFacade;
    
    @Resource(name="jms/TradingActivityPool")
    private ConnectionFactory connectionFactory;
    
    @Resource(name="jms/TradingActivityWebTopic")
    private Destination destination;

    @Override
    public List getAllSales() {
        return saleFacade.findAll();
    }
    
    @Override
    public void addSale(String _securityName, int _price, int _quantity, int _brokerId, int _categoryId)
    {
        //int _brokerId = 1; int _categoryId = 1;
        Sale _sale = new Sale();
        _sale.setSecurityName(_securityName);
        _sale.setPrice(_price);
        _sale.setQuantity(_quantity);
        Broker broker = brokerFacade.find(_brokerId);
        Category category = categoryFacade.find(_categoryId);
        System.err.println(_sale);
        System.err.println(_sale.getSecurityName());
        if(broker != null && category != null){
            _sale.setBrokerId(broker);
            _sale.setCategoryId(category);
            saleFacade.create(_sale);
            sendActionString("new sales");
        }
    }
    
    public void sendActionString(String _actionString) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setStringProperty("message_type", "notify");
            message.setText(_actionString);
            producer.send(message);
            System.out.println("message sent");
            session.close();
            connection.close();
        } catch (JMSException ex) {
            System.err.println("Sending message error");
            ex.printStackTrace();
        } 
    }
}
