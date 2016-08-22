package org.tj.designpatterns.creater.factory.abstractfactory;

import org.tj.designpatterns.creater.factory.simplefactory.MailSender;
import org.tj.designpatterns.creater.factory.simplefactory.Sender;

/**
 * Created by 001 on 16/8/22.
 */
public class MailSenderFactory extends AbstractFactory {
    @Override
    public Sender produceSender() {
        return new MailSender();
    }
}
