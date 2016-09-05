package org.tj.datastruct.tree;

/**
 * Created by 001 on 16/8/30.
 */
public class AVLTree<T extends Comparable<? super T>> {

    private AVLTreeNode root;

    public AVLTree(T root){
        this.root = new AVLTreeNode(root);
        this.root.setHeight(1);
    }

    public AVLTreeNode getRoot() {
        return root;
    }

    public void setRoot(AVLTreeNode root) {
        this.root = root;
    }

    public int height(){
        if (root == null)
            return 0;
        return root.getHeight();
    }

//左左旋转  k2 是相对根节点  k1是是k2的左节点  返回旋转后的相对根节点
    public AVLTreeNode lLRotation(AVLTreeNode k2){
        AVLTreeNode k1 = k2.getLeft();
        k2.setLeft(k1.getLeft());
        k1.setRight(k2);
        k2.setHeight(max(k2.getLeft().getHeight(),k2.getRight().getHeight()) + 1);
        k1.setHeight(max(k1.getLeft().getHeight(),k2.getHeight()) +1);
        return k1;
    }

//右右旋转  k1 是相对根节点  k2是是k1的右节点  返回旋转后的相对根节点k2
    public AVLTreeNode rRRotation(AVLTreeNode k1){
        AVLTreeNode k2 = k1;
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.setHeight(max(k1.getLeft().getHeight(),k1.getRight().getHeight()) +1);
        k2.setHeight(max(k1.getHeight(),k2.right.getHeight()));
        return k2;
    }

//    左右旋转  k3是相对根节点  k1 为k3左节点  k2 为k1右节点  先以k1为相对根节点 RR -> LL
    public AVLTreeNode lRRotation(AVLTreeNode k3){
//        AVLTreeNode k1 = k3.getLeft();
//        AVLTreeNode k2 = rRRotation(k1);
        k3.setLeft(rRRotation(k3.getLeft()));
        return lLRotation(k3);
    }

//    右左旋转 k1是相对根节点  以k1右节点为相对根节点LL -> RR
    public AVLTreeNode rLRotation(AVLTreeNode k1){
        k1.setRight(lLRotation(k1.getRight()));
        return rRRotation(k1);
    }

    public void insert(T e){
        insert(root,e);
    }

    public AVLTreeNode insert(AVLTreeNode node,T e){
        if (node == null){
            node = new AVLTreeNode(e);
        }else {
            if (node.getElement().compareTo(e)>=0){
                node.setLeft(insert(node.getLeft(),e));
                if (node.getLeft().getHeight() - node.getRight().getHeight() == 2){
                    if (node.getLeft().getElement().compareTo(e)>=0){
//                        左左
                        lLRotation(node);
                    }else {
//                        左右
                        lRRotation(node);
                    }
                }

            }else {
                node.setRight(insert(node.getRight(),e));
                if (node.getRight().getHeight() - node.getLeft().getHeight() == 2){
                    if(node.getLeft().get)
                }
            }
        }
    }


//

    public int max(int a,int b){
        return a>=b?a:b;
    }

    private class AVLTreeNode{
        T element;
        AVLTreeNode left;
        AVLTreeNode right;
        int height;

        public AVLTreeNode(T element){
            this.element = element;
            this.height = 1;
        }

        public AVLTreeNode(T element,AVLTreeNode left,AVLTreeNode right){
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public AVLTreeNode getLeft() {
            return left;
        }

        public void setLeft(AVLTreeNode left) {
            this.left = left;
        }

        public AVLTreeNode getRight() {
            return right;
        }

        public void setRight(AVLTreeNode right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
