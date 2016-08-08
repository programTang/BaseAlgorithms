package org.tj.designpatterns.creater.builder;

import org.tj.designpatterns.creater.factory.simplefactory.MailSender;
import org.tj.designpatterns.creater.factory.simplefactory.MessageSender;
import org.tj.designpatterns.creater.factory.simplefactory.Sender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 001 on 16/8/8.
 */
public class Builder {

//    主要针对工厂模式而言，工厂模式主要建造某一类单个产品，而建造者模式这是建造这些单个产品组成的复杂产品 比如轮胎之于汽车

    public List<Sender> senders = new ArrayList<>();

    public List<Sender> produceMailAndMsgSender(int count){
        int i = 0;
        for (;i < count/2; i++ ){
            senders.add(new MailSender());
        }
        for ( ;i<count;i++){
            senders.add(new MessageSender());
        }
        return senders;
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        List<Sender> senders1 = builder.produceMailAndMsgSender(10);
        for (Sender sender : senders1){
            sender.send();
        }

    }

}
