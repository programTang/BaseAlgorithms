package org.tj.datastruct.tree;

/**
 * Created by 001 on 16/7/4.
 */
public class Tree<E> {

    TreeNode[] treeNodes;

    class TreeNode{
        Object data;
        TreeNode firstChild;
        TreeNode sibling;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public TreeNode getFirstChild() {
            return firstChild;
        }

        public void setFirstChild(TreeNode firstChild) {
            this.firstChild = firstChild;
        }

        public TreeNode getSibling() {
            return sibling;
        }

        public void setSibling(TreeNode sibling) {
            this.sibling = sibling;
        }
    }

    public Tree(){
        treeNodes = (TreeNode[]) new Object[10];
    }

    public void setRoot(E e){
        treeNodes[0].data = e;
    }

//    public void setFirstChild(Tr){
//        treeNodes[0].data = e;
//    }
//


}
