package org.tj.designpatterns.creater.factory.simplefactory;

/**
 * Created by 001 on 16/8/7.
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("send Email");
    }
}
