package src.datastructures.queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Queue <T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<T>();

    public Queue() {}

    public Queue(T elem){
        offer(elem);
    }

    private void offer(T elem) {
        list.addLast(elem);

    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size()==0;
    }

    public T peek() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        return list.peekFirst();
    }

    public T poll() {
        if(isEmpty()) throw new RuntimeException("Queue is empty");
        return list.removeFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }


    public static void main(String[] args) {
        Queue q = new Queue();
        //q.poll();
        q.offer("Hello");
        q.offer("World");
        System.out.println(q.size());
        for(int i=0;i<=q.size();i++) {
            System.out.println(q.poll());
        }

    }
}
