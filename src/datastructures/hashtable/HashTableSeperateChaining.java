package src.datastructures.hashtable;


import java.util.*;

class Entry<K,V>{
    int hash;
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }


    public boolean equals(Entry<K,V> other){
        if(hash !=other.hash) return false;
        return key.equals(other.key);
    }

    @Override
    public String toString(){
        return key + " => " + value;
    }

}

@SuppressWarnings("unchecked")
public class HashTableSeperateChaining<K,V> implements Iterator<K> {

    private static final int DEFAULT_CAPACITY = 3;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private double maxloadFactor;
    private int capacity, threshold, size=0;
    private LinkedList <Entry<K,V>> [] table;

    public HashTableSeperateChaining() {
        this(DEFAULT_CAPACITY,DEFAULT_LOAD_FACTOR);
    }
    public HashTableSeperateChaining(int capacity) {
        this(capacity,DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeperateChaining(int capacity, double maxloadFactor) {

        if(capacity < 0)
            throw new IllegalArgumentException("Illegal capacity: " + capacity);

        if(maxloadFactor <= 0 || Double.isNaN(maxloadFactor) || Double.isInfinite(maxloadFactor))
            throw new IllegalArgumentException("Illegal maxloadFactor: " + maxloadFactor);

        this.maxloadFactor = maxloadFactor;
        this.capacity = Math.max(DEFAULT_CAPACITY,capacity);
        threshold =(int) (this.capacity * maxloadFactor);
        table = new LinkedList[this.capacity];

    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int normalizeIndex(int keyHash){
        return ( keyHash & 0x7FFFFFFF) % this.capacity;
    }

    public void clear(){
        Arrays.fill(table, null);
        size = 0;
    }


    public boolean containsKey(K key){
        return hasKey(key);
    }

    private boolean hasKey(K key) {
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketSeekEntry(bucketIndex,key) != null;
    }


    public V put(K key, V value){
        return insert(key,value);
    }
    public V add(K key, V value){
        return insert(key,value);
    }

    public V insert(K key, V value){
      if(key == null) throw new IllegalArgumentException("Null key");
      Entry<K,V> newEntry = new Entry<>(key, value);
      int bucketIndex = normalizeIndex(newEntry.hash);
      return bucketInsertEntry(bucketIndex,newEntry);
    }

    public V get(K key) {
        if(key == null) throw new IllegalArgumentException("Null key");
        int bucketIndex = normalizeIndex(key.hashCode());
        Entry<K,V> entry = bucketSeekEntry(bucketIndex, key);
        return null;
    }

    public V remove(K key){
        if(key == null) throw new IllegalArgumentException("Null key");
        int bucketIndex = normalizeIndex(key.hashCode());
        return bucketRemoveEntry(bucketIndex,key);
    }

    private V bucketRemoveEntry(int bucketIndex, K key) {
        Entry<K,V> entry = bucketSeekEntry(bucketIndex,key);
        if(entry != null) {
            LinkedList <Entry<K,V>> links = table[bucketIndex];
            links.remove(entry);
            --size;
            return entry.value;
        }else
            return null;

    }

    private V bucketInsertEntry(int bucketIndex, Entry<K,V> newEntry) {

        LinkedList< Entry<K,V>> bucket = table[bucketIndex];
        if(bucket == null) {
            table[bucketIndex] = bucket = new LinkedList<>();
        }
        Entry<K,V> existingEntry = bucketSeekEntry(bucketIndex,newEntry.key);
        if(existingEntry == null) {
            bucket.add(newEntry);
            if(++size > threshold) {
                resizeTable();
            }
            return null;
        }else{
            V oldVal = existingEntry.value;
            existingEntry.value = newEntry.value;
            return oldVal;
        }


    }

    private void resizeTable() {

        capacity *= 2;
        threshold = (int) (capacity * maxloadFactor);

        LinkedList<Entry<K,V>> [] newTable = new LinkedList[capacity];

        for(int i=0;i<table.length;i++){
            if(table[i] != null){

                for(Entry<K,V> entry : table[i]){
                    int bucketIndex = normalizeIndex(entry.hash);
                    LinkedList <Entry<K,V>> bucket = newTable[bucketIndex];
                    if(bucket == null) newTable[bucketIndex] = bucket = new LinkedList<>();
                    bucket.add(entry);
                }

                table[i].clear();
                table[i] = null;

            }
        }
        table = newTable;

    }


    private Entry<K, V> bucketSeekEntry(int bucketIndex, K key) {

        if(key == null) return null;
        LinkedList< Entry<K,V>> bucket = table[bucketIndex];
        if(bucket == null) return null;
        for(Entry<K,V> entry : bucket) {
            if(entry.key.equals(key))
                return entry;
        }

        return null;
    }

    public List<K> keys(){
        List<K> keys = new ArrayList<>(size());
        for(LinkedList <Entry<K,V>> bucket : table){
            if(bucket != null)
                for(Entry<K,V> entry : bucket)
                    keys.add(entry.key);
        }
        return keys;
    }

    public List<V> Values(){
        List<V> vals = new ArrayList<>(size());
        for(LinkedList <Entry<K,V>> bucket : table){
            if(bucket != null)
                for(Entry<K,V> entry : bucket)
                    vals.add(entry.value);
        }
        return vals;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public K next() {
        return null;
    }


    public static void main(String[] args) {
        HashTableSeperateChaining hs = new HashTableSeperateChaining();
        hs.add(12,"User1");
        hs.add(31,"User2");
        System.out.println(hs.keys());
        System.out.println(hs.Values() );
    }


}
