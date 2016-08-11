package org.tj.datastruct.tree;

/**
 * Created by 001 on 16/8/10.
 */
public class BinaryTree<T> {

    T element;
    BinaryTree<T> left;
    BinaryTree<T> right;

    public BinaryTree(T t){

    }

    public BinaryTree(T e,BinaryTree<T> left,BinaryTree<T> right){
        this.element = e;
        this.left = left;
        this.right = right;
    }


}
