package org.tj.designpatterns.creater.factory.simplefactory;

/**
 * Created by 001 on 16/8/7.
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SenderFactory senderFactory = new SenderFactory();
        Sender sender = (MailSender) senderFactory.produceSender(SendProducter.Mail);
        sender.send();
    }
}
