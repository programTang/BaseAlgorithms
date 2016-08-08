package org.tj.designpatterns.creater.prototype;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;

/**
 * Created by 001 on 16/8/8.
 */
public class Prototype implements Cloneable,Serializable {

//    原型模式   将一个对象作为原型 对其进行复制克隆，产生一个和原对象类似的新对象

    private static final long serialVersionUID = 1L;
    private String string;
    private SerializableObject serializableObject;

//    浅赋值 复制后 基本类型的变量类型将会重建 而引用类型还是指向原对象所指向的。
    public Object clone() throws CloneNotSupportedException {
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

//    深赋值 复制后 基本类型和引用类型都会重建
    public Object deepClone() throws IOException, ClassNotFoundException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getSerializableObject() {
        return serializableObject;
    }

    public void setSerializableObject(SerializableObject serializableObject) {
        this.serializableObject = serializableObject;
    }
}

class SerializableObject implements Serializable {
    private static final long serialVersionUID = 1L;
}
