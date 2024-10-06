package src.datastructures.binarysearchtrees;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> {


    private int nodeCount=0;
    private Node root = null;

    private class Node{
        T data;
        Node left, right;
        public Node(Node left, Node right, T data) {
            this.data= data;
            this.left = left;
            this.right = right;
        }
    }



    public boolean isEmpty() {
        return size()==0;
    }



    private int size() {
        // TODO Auto-generated method stub
        return nodeCount;
    }


    public boolean add(T elem) {

        if(contains(elem)) return false;
        else
            root = add(root,elem);
        nodeCount++;
        return true;

    }



    private Node add(Node node, T elem) {
        // TODO Auto-generated method stub

        if(node == null ) {
            node = new Node(null,null,elem);
        }
        else {

            if(elem.compareTo(node.data)<0) {
                node.left = add(node.left,elem);
            }else {
                node.right = add(node.right,elem);
            }

        }


        return node;
    }


    public boolean remove(T elem) {

        if(contains(elem)) {
            root = remove(root,elem);
            nodeCount--;
            return true;
        }

        return false;
    }


    private Node remove(Node node, T elem) {


        if(node == null) return null;

        int cmp = elem.compareTo(node.data);

        if(cmp <0) {

            node.left = remove(node.left,elem);


        }else if(cmp>0) {

            node.right = remove(node.right,elem);

        }else {

            if(node.left == null) {
                Node rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;

            }else if(node.right == null) {
                Node leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
            }else {

                // go down to the right subtree and dig left
                Node tmp = digLeft(node.right);

                //swap the data
                node.data = tmp.data;

                node.right = remove(node.right,tmp.data);




            }
        }



        // TODO Auto-generated method stub
        return node;
    }



    private Node digLeft(Node node) {
        // TODO Auto-generated method stub
        Node cur = node;
        while(cur.left!=null) {
            cur = cur.left;
        }
        return cur;
    }

    private Node digRight(Node node) {
        // TODO Auto-generated method stub
        Node cur = node;
        while(cur.right!=null) {
            cur = cur.right;
        }
        return cur;
    }



    public boolean contains(T elem) {
        // TODO Auto-generated method stub

        return contains(root, elem);
    }



    private boolean contains(Node node, T elem) {
        // TODO Auto-generated method stub

        if(node == null ) return false;

        int cmp = elem.compareTo(node.data);
        if(cmp <0) {
            return contains(node.left,elem);
        }else if(cmp >0) {
            return contains(node.right,elem);
        }else return true;
    }



    public int height() {
        return height(root);
    }



    private int height(Node node) {
        // TODO Auto-generated method stub

        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;

    }

    public Iterator<T> traverse(TreeTraversalOrder order){

        switch(order) {
            case PRE_ORDER : return preOrderTraversal();
            case IN_ORDER  : return inOrderTraversal();
            case POST_ORDER : return postOrderTraversal();
            case LEVEL_ORDER : return levelOrderTraversal();
            default : return null;
        }

    }



    private Iterator<T> levelOrderTraversal() {
        // TODO Auto-generated method stub
        return null;
    }



    private Iterator<T> postOrderTraversal() {
        // TODO Auto-generated method stub
        return null;
    }



    private Iterator<T> inOrderTraversal() {
        // TODO Auto-generated method stub
        return null;
    }



    private Iterator<T> preOrderTraversal() {
        // TODO Auto-generated method stub
        return null;
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(11);
        bst.add(2);
        bst.add(131);
        bst.add(44);
        bst.add(16);
        bst.add(5);
        System.out.println("node count: "+ bst.nodeCount);
        System.out.println("height:" + bst.height());

        bst.remove(131);
        bst.remove(5);
        System.out.println("node count: "+ bst.nodeCount);
        System.out.println("height:" + bst.height());

    }

}


