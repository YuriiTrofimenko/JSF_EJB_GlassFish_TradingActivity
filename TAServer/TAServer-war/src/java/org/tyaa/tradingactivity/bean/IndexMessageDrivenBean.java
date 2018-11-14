/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.tradingactivity.bean;

import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

/**
 *
 * @author Юрий
 */
@MessageDriven(
        mappedName="jms/TradingActivityWebTopic",
        name = "IndexMDB")
public class IndexMessageDrivenBean implements MessageListener{
    
    @Inject @Push(channel="new_sale_channel")
    private PushContext newSalesChannel;
        
    @Override
    public void onMessage(Message msg) {
        try {
            TextMessage message = (TextMessage)msg;
            //считываем свойство из соответствующего поля, заданное вручную в consumer
            System.out.println("FROM MDB - message type IS " + message.getStringProperty("message_type"));
            //считываем  само сообщение
            System.out.println("FROM MDB - message text IS " + message.getText());
            //отправляем в веб-представление сообщение
            newSalesChannel.send(message.getText());
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
    
}
