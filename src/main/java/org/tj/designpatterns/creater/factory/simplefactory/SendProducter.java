package org.tj.designpatterns.creater.factory.simplefactory;

/**
 * Created by 001 on 16/8/7.
 */
public enum SendProducter {
    Mail("mail"),Message("message");

    private String producter;

    private SendProducter(String producter){
        this.producter = producter;
    }

    @Override
    public String toString() {
        return producter;
    }
}
