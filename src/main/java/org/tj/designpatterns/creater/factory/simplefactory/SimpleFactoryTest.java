package org.tj.designpatterns.creater.factory.simplefactory;

import javax.servlet.http.HttpServlet;
import java.util.Calendar;

/**
 * Created by 001 on 16/8/7.
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = senderFactory.produceSender(SendProducter.Mail);
        sender.send();
        Calendar calendar = Calendar.getInstance();
//        StringBuilder stringBuilder
//        HttpServlet servlet =
    }
}
