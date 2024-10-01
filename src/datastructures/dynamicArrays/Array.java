package src.datastructures.dynamicArrays;

import java.util.Iterator;

public class Array <T> implements Iterable <T>  {

    private T [] arr; // declaring an array
    private int len = 0;
    private int capacity= 0;



    public Array(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("Illegal Capacity: "+capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity]; // initializing the array with the capacity
    }

    public int size(){
        return len;
    }
    public boolean isEmpty(){
        return size() ==0;
    }

    public T get(int index){
        return arr[index];
    }

    public void clear(){
        for(int i = 0;i<capacity;i++) arr[i] = null;
        len = 0;
    }

    public void set(int index, T element){
        if(index < 0 || index >= capacity) throw new IllegalArgumentException("Illegal Index: "+index);
        arr[index] = element;
    }

    public void add(T element){
        if(len+1 >=capacity){
            T[] newArr = (T[]) new Object[capacity*2];
            for(int i = 0;i<len;i++)
                newArr[i] = arr[i];
            arr = newArr;
        }
        arr[len++] = element;
    }

    public T removeAt(int index){
        if(index<0 || index>=len) throw new IllegalArgumentException("Illegal Index: "+index);
        T data = arr[index];
        T [] newArr = (T[]) new Object[len-1];
        for(int i=0,j=0;i<len;i++,j++){
            if(i==index){
                j--;
            }
            else newArr[j] = arr[i];
        }
        arr = newArr;
        capacity = --len;
        return data;
    }

    public boolean remove(Object obj){

        for(int i = 0;i<len;i++){
            if(arr[i].equals(obj)){
                removeAt(i); return true;
            }
        }
        return false;

    }

    public int indexOf(Object obj){
        for(int i = 0;i<len;i++){
            if(arr[i].equals(obj)){
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj)!=-1;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index<len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }


    public String toString(){
        if(len==0) return "[]";
        else{
            StringBuilder sb = new StringBuilder(len).append("[");
            for(int i = 0;i<len-1;i++){
                sb.append(arr[i]).append(", ");
            }
            return sb.append(arr[len-1]+"]").toString();
        }
    }

    public static void main(String[] args) {
        Array testArray = new Array(5);
        testArray.add(54);
        testArray.add(44);
        testArray.add(133);
        testArray.add(-3);

        System.out.println(testArray.toString());

        testArray.add(90);
        testArray.add(77);
        System.out.println(testArray.toString());

        System.out.println(testArray.get(5));


    }
}
