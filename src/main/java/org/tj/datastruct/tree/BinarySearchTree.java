package org.tj.datastruct.tree;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by 001 on 16/8/10.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
//    二分查找树


    private BinaryNode<T> root;

    public BinarySearchTree(){
        root = null;
    }

    public BinarySearchTree(T element){
        root = new BinaryNode(element);
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public boolean contains(T element){
        return contains(element,root);
    }

    public T findMin(){
        return findMin(root);
    }

    public T findMax(){
        return findMax(root);
    }

    public BinarySearchTree insert(T element){
        insert(element,root);
        return this;
    }

    public BinarySearchTree insert(T[] elements){
        int length = elements.length;
        for (int i=0;i<length;i++){
            insert(elements[i]);
        }
        return this;
    }

    public BinarySearchTree remove(T element){
        remove(element,root);
        return this;
    }

    public void insert(T element,BinaryNode<T> node){
        if (node == null){
             new BinaryNode<T>(element);
        }
        if (node.getElement().compareTo(element) >= 0 ){
            if (node.getLeft() == null){
                node.setLeft(new BinaryNode<T>(element));
                return;
            }else
                insert(element,node.getLeft());
        }else {
            if(node.getRight() == null){
                node.setRight(new BinaryNode<T>(element));
                return;
            }else
                insert(element,node.getRight());
        }
    }

    public void remove(T element,BinaryNode<T> node){

    }

    public int depth(){
        return depth(root);
    }

    public T findMin(BinaryNode<T> node){
        if (node == null){
            return null;
        }else if (node.getLeft() == null){
            return node.getElement();
        }
        return findMin(node.getLeft());
    }

    public T findMax(BinaryNode<T> node){
        if (node == null){
            return null;
        }else if (node.getRight() == null){
            return node.getElement();
        }
        return findMax(node.getRight());
    }

    public boolean contains(T element,BinaryNode<T> root){
        if (root == null){
            return false;
        }
        if (root.getElement().compareTo(element) > 0){
//            比节点小 继续想左边寻找
            return contains(element,root.getLeft());
        }else if (root.getElement().compareTo(element) < 0){
            return contains(element,root.getRight());
        }else {
            return true;
        }
    }

    public int depth(BinaryNode<T> node){
        if (node == null){
            return 0;
        }
        int ldepth,rdepth;
        ldepth = depth(node.getLeft())+1;
        rdepth = depth(node.getRight())+1;
        return ldepth>rdepth?ldepth:rdepth;
    }

    public void preOrder(){
        preOrder(root);
        System.out.println(" ");
    }

    public void order(){
        order(root);
        System.out.println(" ");
    }

    public void afterOrder(){
        afterOrder(root);
        System.out.println(" ");
    }

    public void widthOrder(){
        widthOrder(root);
        System.out.println(" ");
    }

    public void preOrder(BinaryNode<T> node){
        if (node == null){
            return;
        }else {
            System.out.print(node.getElement() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void order(BinaryNode<T> node){
        if (node == null){
            return;
        }else {
            order(node.getLeft());
            System.out.print(node.getElement() + " ");
            order(node.getRight());
        }
    }

    public void afterOrder(BinaryNode<T> node){
        if (node == null){
            return;
        }else {
            afterOrder(node.getLeft());
            afterOrder(node.getRight());
            System.out.print(node.getElement()+" ");
        }
    }

//    宽度遍历
    public void widthOrder(BinaryNode<T> node){
        Queue<BinaryNode<T>> nodeQueue = new LinkedBlockingDeque<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            BinaryNode<T> node1 = nodeQueue.poll();
            System.out.print(node1.getElement() + " ");
            if (node1.getLeft() != null){
                nodeQueue.add(node1.getLeft());
            }
            if (node1.getRight() != null){
                nodeQueue.add(node1.getRight());
            }
        }
    }

//    求二叉树节点个数 递归
    public int getNodeNumsRec(){
        return getNodeNumsRec(root);
    }


    public int getNodeNumsRec(BinaryNode<T> binaryNode){
        if (binaryNode == null){
            return 0;
        }else {
            return getNodeNumsRec(binaryNode.getLeft())+getNodeNumsRec(binaryNode.getRight())+1;
        }
    }
//循环
    public int getNodeNums(){
        return getNodeNums(root);
    }

    public int getNodeNums(BinaryNode node){
        if (node == null){
            return 0;
        }
        Queue<BinaryNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);
        int count = 1;
        while (!nodeQueue.isEmpty()){
            BinaryNode node1 = nodeQueue.remove();
            if (node1.getLeft() != null){
                nodeQueue.add(node1.getLeft());
                count++;
            }
            if (node1.getRight() != null){
                nodeQueue.add(node1.getRight());
                count++;
            }
        }
        return count;
    }

    private static class BinaryNode<T>{
        private T element;
        private BinaryNode<T> left;
        private BinaryNode<T> right;
        public BinaryNode(T t){
            this.element = t;
        }

        public BinaryNode(){
        }

        public BinaryNode(T e,BinaryNode<T> left,BinaryNode<T> right){
            this.element = e;
            this.left = left;
            this.right = right;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public BinaryNode<T> getLeft() {
            return left;
        }

        public void setLeft(BinaryNode<T> left) {
            this.left = left;
        }

        public BinaryNode<T> getRight() {
            return right;
        }

        public void setRight(BinaryNode<T> right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>(5);
        binarySearchTree.insert(3).insert(9).insert(2).insert(4).insert(7).insert(11);
        System.out.println(binarySearchTree.findMin()+"   "+binarySearchTree.findMax());
        System.out.println(binarySearchTree.contains(6));
        System.out.println(binarySearchTree.depth());
        binarySearchTree.preOrder();
        binarySearchTree.order();
        binarySearchTree.afterOrder();
        binarySearchTree.widthOrder();
        System.out.println(binarySearchTree.getNodeNumsRec());
        System.out.println(binarySearchTree.getNodeNums());
    }


}
