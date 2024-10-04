package src.datastructures.stack;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack <T> implements Iterable <T>{

    private LinkedList <T> list = new LinkedList<T>();

    public Stack() {

    }

    public Stack(T elem) {
        list.add(elem);
    }


    public void push(T elem) {
        list.addLast(elem);
    }

    public T pop() {
        if(isEmpty()) {

            throw new java.util.EmptyStackException();
        }

        else {
            T data = list.getLast();

            return list.removeLast();
        }


    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return list.size()==0;
    }

    public int size() {
        return list.size();
    }


    public T peek() {
        if(isEmpty()) throw new java.util.EmptyStackException();

        return list.getLast();
    }

    public int search(T elem) {
        if(isEmpty()) throw new java.util.EmptyStackException();
        // use lastIndexOf to get the last occurence in the list
        return list.lastIndexOf(elem);
    }





    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return list.iterator();
    }




    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Stack s = new Stack();
        s.push("A");
        s.push("B");
        s.push(1);
        s.push(2);

        System.out.println("Print "+s.list.size());
        s.forEach(System.out::println);

        s.pop();
        s.pop();
        s.forEach(System.out::println);
        s.pop();
        s.pop();
        s.forEach(System.out::println);

    }

}
