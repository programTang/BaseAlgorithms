package org.tj.designpatterns.creater.factory.abstractfactory;

import org.tj.designpatterns.creater.factory.simplefactory.MessageSender;
import org.tj.designpatterns.creater.factory.simplefactory.Sender;

/**
 * Created by 001 on 16/8/22.
 */
public class MessageSenderFactory extends AbstractFactory {
    @Override
    public Sender produceSender() {
        return new MessageSender();
    }
}
