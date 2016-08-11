package org.tj.datastruct.tree;

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
    }

    public void order(){
        order(root);
    }

    public void afterOrder(){
        afterOrder(root);
    }

    public void preOrder(BinaryNode<T> node){
        if (node == null){
            return;
        }else {
            System.out.print(node.getElement());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void order(BinaryNode<T> node){
        if (node == null){
            return;
        }else {
            preOrder(node.getLeft());
            System.out.print(node.getElement());
            preOrder(node.getRight());
        }
    }

    public void afterOrder(BinaryNode<T> node){
        if (node == null){
            return;
        }else {
            preOrder(node.getLeft());
            preOrder(node.getRight());
            System.out.print(node.getElement());
        }
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
    }


}
