package org.tj.datastruct.tree;

public class TreeNode<T>{

    private T data;
    TreeNode<T> firstChild;
    TreeNode<T> nextSibling;

    public TreeNode(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode<T> firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode<T> getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode<T> nextSibling) {
        this.nextSibling = nextSibling;
    }

    public static void main(String[] args) {
//        TreeNode<String> treeNode = new TreeNode<>("A");
//        treeNode<String>
    }


}