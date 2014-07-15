package com.interview.basics.model.collection.hash;

interface Entry<K extends Comparable, V> {
    public int hash();
    public K key();
    public V value();
    public Entry<K, V> next();
    public void setValue(V value);
    public void setNext(Entry<K, V> next);
}
public abstract class HashContainer<K extends Comparable, V> {

    protected float loadFactor;
    protected int capacity;
    protected int count;
    protected int threshold;

    protected transient Entry<K,V>[] table;

    protected abstract Entry<K, V>[] initCapacity(int capacity);
    protected abstract Entry<K, V> getEntry(int hash, K key, V value, Entry<K, V> next);

    @SuppressWarnings("unchecked")
    public HashContainer(int initialCapacity, float loadFactor) {
        if(initialCapacity < 0 || loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException(String.format("Illegal capacity or loadFactor [capacity=%s,loadFactor=%s]", initialCapacity, loadFactor));
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        table = initCapacity(this.capacity);
        this.threshold = (int)(this.capacity * this.loadFactor);
    }

    public HashContainer(){
        this(100, 0.75f);
    }

    public synchronized V get(K key) {
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % this.capacity;

        for(Entry<K,V> entry = this.table[index]; entry != null; entry = entry.next()){
            if(entry.hash() == hash && entry.key().equals(key)){
                return entry.value();
            }
        }
        return null;
    }

    public synchronized V put(K key, V value) {
        if (key == null || value == null)
            throw new IllegalArgumentException("Null is not allowed for key or value");
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % this.capacity;

        for(Entry<K,V> entry = this.table[index]; entry != null; entry = entry.next()){
            if(entry.hash() == hash && entry.key().equals(key)){
                V oldValue = entry.value();
                entry.setValue(value);
                return oldValue;
            }
        }

        if(count >= threshold){
            rehash();
            index = (hash & 0x7FFFFFFF) % this.capacity;
        }

        Entry<K,V> entry = this.table[index];
        table[index] = getEntry(hash, key, value, entry);
        this.count ++;
        return null;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        int newCapacity = this.capacity * 2 + 1;
        Entry<K,V>[] newTable = initCapacity(newCapacity);

        for(int i = this.capacity - 1; i >= 0 ; i --){
            for(Entry<K,V> entry = this.table[i]; entry != null; ) {
                Entry<K,V> nextEntry = entry.next();
                int index = (entry.hash() & 0x7FFFFFFF) % newCapacity;
                entry.setNext(newTable[index]);
                newTable[index] = entry;
                entry = nextEntry;
            }
        }

        this.capacity = newCapacity;
        this.table = newTable;
        this.threshold =  (int) (this.capacity * this.loadFactor);
    }

    public synchronized V remove(K key){
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % this.capacity;

        Entry<K,V> previous = null;

        for(Entry<K,V> entry = this.table[index]; entry != null; previous=entry, entry = entry.next()){
            if(entry.hash() == hash && entry.key().equals(key)){
                V value = entry.value();
                if(previous == null) {
                    this.table[index] = entry.next();
                } else {
                    previous.setNext(entry.next());
                }
                this.count--;
                entry = null;
                return value;
            }
        }
        return null;
    }
}
