package org.tj.designpatterns.creater.factory.abstractfactory;

import org.tj.designpatterns.creater.factory.simplefactory.Sender;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by 001 on 16/8/22.
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactory factory = new MailSenderFactory();
        Sender sender = factory.produceSender();
        sender.send();
        AbstractFactory factory1 = new MessageSenderFactory();
        Sender sender1 = factory1.produceSender();
        sender1.send();



//        Calendar.getInstance()
//        Arrays.asList()
    }
}
