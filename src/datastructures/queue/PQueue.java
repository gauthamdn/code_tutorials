package src.datastructures.queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PQueue <T extends Comparable<T>>{

    private int heapSize = 0;
    private int heapCapacity = 0;

    private List<T> heap = null;

    private Map<T, TreeSet<Integer>> map = new HashMap();



    public PQueue() {
        this(1);
    }



    public PQueue(int sz) {
        heap = new ArrayList<>(sz);
        // TODO Auto-generated constructor stub
    }

    public PQueue(T[] elems) {

        heapSize = heapCapacity = elems.length;
        heap = new ArrayList<>(heapCapacity);

        for(int i = 0;i<heapSize ;i++) {
            mapAdd(elems[i],i);
            heap.add(elems[i]);

        }

        for(int i = Math.max(0,(heapSize/2)-1) ;i>=0 ; i-- ) {
            sink(i);
        }

    }


    public PQueue(Collection<T> elems) {
        this(elems.size());
        for(T elem: elems) {
            add(elem);
        }
    }


    public boolean isEmpty() {
        return heapSize ==0;
    }

    public void clear() {
        for(int i = 0; i<heapCapacity;i++) {
            heap.set(i, null);
            heapSize = 0;
            map.clear();
        }
    }

    public int size() {
        return heapSize;

    }

    public T peek() {
        if(isEmpty()) return null;
        return heap.get(0);
    }


    public T poll() {
        return removeAt(0);

    }


    public boolean contains(T elem) {
        // using maps
        //if(elem == null) return false;
        //return map.containsKey(elem);

        for(int i = 0; i<heapSize;i++) {
            if(heap.get(i).equals(elem)) return true;
        }
        return false;
    }





    private void add(T elem) {
        // TODO Auto-generated method stub

        if(elem == null) throw new IllegalArgumentException();

        if(heapSize<heapCapacity) {
            // insert to the last node of heap
            heap.set(heapSize, elem);

        }else {
            heap.add(elem);
            heapCapacity++;
        }

        mapAdd(elem,heapSize);

        swim(heapSize);
        heapSize++;


    }

    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);

        // returns true if node i <= node j
        return node1.compareTo(node2)<=0;
    }



    private void swim(int k) {
        // TODO Auto-generated method stub

        //k is the node where insert happened.
        // grab the index of the next parent node w.r.t K

        int parent = (k-1)/2;


        // keep swimming up while we have not reached the root and while we are less than our parent
        while(k>0 && less(k,parent)) {

            // swap the parent and k nodes
            swap(parent,k);
            k=parent;

            // get the next parent node index
            parent = (k-1)/2;

        }


    }



    private void swap(int i, int j) {
        // TODO Auto-generated method stub

        T i_elem = heap.get(i);
        T j_elem = heap.get(j);

        heap.set(i, j_elem);
        heap.set(j, i_elem);

        mapSwap(i_elem,j_elem,i,j);

    }










    private void sink(int k) {
        // TODO Auto-generated method stub

        while(true) {

            int left = 2*k + 1; // left child node index
            int right = 2*k + 2; // right child node index

            int smallest = left; // assume left is smallest

            // find which is smaller left or right
            // if right is smaller set the right to be smallest

            if(right<heapSize && less(right,left)) {
                smallest = right;

            }

            // stopping condition when we are out of the tree or we cannot sink anymore
            if(left >= heapSize || less(k,smallest)) break;

            swap(smallest, k);
            k = smallest;




        }



    }


    private boolean remove(T elem) {

        if(elem == null) return false;


        // linear removal O(n)
        for(int i =0;i<heapSize;i++) {
            if(heap.get(i).equals(elem)){
                removeAt(i);
                return true;
            }
        }
        return false;



    }


    private T removeAt(int i) {


        if(isEmpty()) return null;

        heapSize--;
        T remove_data = heap.get(i);

        swap(i,heapSize);


        heap.set(heapSize, null);
        mapRemove(remove_data, heapSize);

        if(i == heapSize) return remove_data;

        T elem = heap.get(i);
        sink(i);


        if(heap.get(i).equals(elem))
            swim(i);

        return remove_data;


    }



    private void mapRemove(T value, int index) {
        // TODO Auto-generated method stub


        TreeSet <Integer> set = map.get(value);
        set.remove(index);
        if(set.size()==0) map.remove(value);
    }



    private void mapAdd(T value, int index) {
        // TODO Auto-generated method stub

        TreeSet <Integer> set = map.get(value);
        if(set == null) {
            set = new TreeSet<>();
            set.add(index);
            map.put(value, set);

        }else set.add(index);

    }


    private void mapSwap(T val1, T val2, int val1_index, int val2_index) {
        // TODO Auto-generated method stub

        Set<Integer> set1 = map.get(val1);
        Set <Integer> set2 = map.get(val2);

        set1.remove(val1_index);
        set2.remove(val2_index);

        set1.add(val2_index);
        set2.add(val1_index);

    }


    public boolean isMinHeap(int k) {

        if(k>heapSize) return true;

        int left = 2*k+1;
        int right = 2*k + 2;

        if(left<heapSize  && !less(k,left)) return false;
        if(right<heapSize && !less(k,right)) return false;


        return isMinHeap(left) && isMinHeap(right);
    }


    @Override
    public String toString() {
        return heap.toString();
    }




    public static void main(String[] args) {


        PQueue<Integer> queue = new PQueue<Integer>();
        System.out.println("Size : "+queue.size());

        queue.add(6);
        System.out.println(queue.toString());
        queue.add(2);
        System.out.println(queue.toString());
        queue.add(5);
        System.out.println(queue.toString());
        queue.add(3);
        System.out.println(queue.toString());
        queue.add(4);
        System.out.println(queue.toString());
        queue.add(1);
        System.out.println(queue.toString());

        queue.remove(4);
        System.out.println(queue.toString());
        queue.remove(2);
        System.out.println(queue.toString());
        queue.removeAt(3);
        System.out.println(queue.toString());

        System.out.println("Size : "+queue.size());

        System.out.println(queue.toString());

    }






}
