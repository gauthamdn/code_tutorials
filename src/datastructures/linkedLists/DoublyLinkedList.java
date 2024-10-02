package src.datastructures.linkedLists;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    private static class Node<T> {
        private T data;
        private Node<T> next, prev;

        private Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public String toString() {
            return data.toString();
        }

    }


    public void clear(){
        Node<T> trav = head;
        while(trav!=null){

            Node<T> next = trav.next;
            trav.next = trav.prev = null;
            trav.data = null;
            trav = next;

        }
        head = tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void add(T data){
        addlast(data);
    }

    private void addlast(T data) {
        if(isEmpty()){
            head = tail = new Node<T>(data, null, null );
        }
        else{

            tail.next = new Node<T>(data, tail, null);
            tail = tail.next;
        }

        size++;

    }

    private void addFirst(T data){
        if(isEmpty()){
            head = tail = new Node<T>(data, null, null );
        }
        else{
            head.prev = new Node<T>(data, head, null);
            head = head.prev;
        }
        size++;
    }

    private void addAt(int index, T data) throws Exception {

        if(index<0 || index>size) throw new Exception("Illegal index");

        if(index == 0){
            addFirst(data);
            return;
        }

        if(index == size){
            addlast(data);
            return;
        }

        Node<T> trav = head;

        for(int i = 0; i< index-1 ;i++){
                trav = trav.next;
        }

        Node<T> newNode = new Node<T>(data,trav,trav.next);
        trav.next.prev = newNode;
        trav.next = newNode;

        size++;


    }


    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        return (T) head.data;
    }

    public T peekLast(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        return (T) tail.data;
    }

    public T removefirst(){

        if(isEmpty()) throw new RuntimeException(" Empty List ");

        T data = (T)head.data;
        head = head.next;
        --size;

        if(isEmpty()) tail = null;
        else head.prev = null;

        return data;

    }

    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("Empty List ");
        T data = (T)tail.data;
        tail = tail.prev;
        --size;

        if(isEmpty()) head = null;
        else tail.next = null;


        return data;
    }

    public T remove(Node node){
        if(isEmpty()) throw new RuntimeException("Empty List ");
        if(node.prev == null){
            removefirst();
        }
        if(node.next == null){
            removeLast();
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        T data = (T) node.data;
        node.data = null;
        --size;

        return data;
    }

    public T removeAt(int index){
        if(isEmpty()) throw new RuntimeException("Empty List ");
        if(index<0 || index>size) throw new IndexOutOfBoundsException("Illegal index");
        Node<T> trav = head;

        for(int i = 0; i!= index ; i++){
            trav = trav.next;
        }

        return remove(trav);

    }


    public boolean remove(Object obj){
        Node<T> trav = head;
        if(isEmpty()) throw new RuntimeException("Empty List ");
        if(obj==null) {
            while(trav!=null){
                trav = trav.next;
                if(trav.data == null){
                    remove(trav);
                    return true;
                }

            }
        } else{
            for(trav = head ; trav != null;trav = trav.next){
                if(obj.equals(trav.data)){
                    remove(trav);
                    return true;
                }
            }
        }
        return false;

    }



    public int indexOf(Object obj){

        if(isEmpty()) throw new RuntimeException("Empty List");
        Node<T> trav = head;


        if(obj == null){
            for(int i=0;trav!=null;i++,trav = trav.next){
                if(trav.data == null)
                    return i;
            }

            return -1;

        } else{

            for(int i=0; trav!=null; i++,trav = trav.next){
                if(obj.equals(trav.data))
                    return i;
            }
            return -1;

        }


    }

    public boolean contains(Object obj) {
        if(indexOf(obj)!=-1)
            return true;
        else
            return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = (T) trav.data;
                trav = trav.next;
                return data;

            }
        };
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> trav = head;
        while(trav!=null){
            sb.append(trav.data);
            if(trav.next != null)
                sb.append(", ");
            trav = trav.next;
        }
        sb.append("]");
        return sb.toString();

    }



    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

        list.add(10);
        list.add(29);
        list.add(-30);
        list.add(4);
        list.addlast(45);
        System.out.println(list.head.data);
        System.out.println(list.tail.data);
        System.out.println(list.toString());

        list.removefirst();
        System.out.println(list.head.data);
        list.remove(4);
        System.out.println(list.toString());


    }
}
