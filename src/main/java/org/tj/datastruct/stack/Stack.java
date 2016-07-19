package org.tj.datastruct.stack;

import java.util.Arrays;

/**
 * Created by 001 on 16/7/4.
 */
public class Stack<E>{

    int size = 0;
    Object[] elementData;

    public Stack(){
        elementData = new Object[16];
    }

    public boolean push(E e){
        if (elementData.length == size){
            //扩容
            ensureCapacityInternal(size);
        }
        elementData[size] = e;
        size++;
        return true;
    }

    private void ensureCapacityInternal(int size){
        elementData = Arrays.copyOf(elementData,size*2+1);
    }

    public E pop(){
        E e =  (E) elementData[--size];
        return e;
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=size-1;i>=0;i--){
            stringBuilder.append(elementData[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<String>();
        stringStack.push("a");
        stringStack.push("b");
        stringStack.push("c");
        System.out.println(stringStack.size);
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.size);

//        System.out.println(stringStack.pop());
    }

}
