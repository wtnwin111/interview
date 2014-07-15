package com.interview.basics.model.collection.hash;


/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/15/14
 * Time: 3:14 PM
 */
class SetEntry<K extends Comparable> implements Entry<K, K>{
    int hash;
    K item;
    Entry<K, K> next;

    SetEntry(int hash, K item, Entry<K, K> next) {
        this.hash = hash;
        this.item = item;
        this.next = next;
    }

    @Override
    public int hash() {
        return hash;
    }

    @Override
    public K key() {
        return item;
    }

    @Override
    public K value() {
        return item;
    }

    @Override
    public Entry<K, K> next() {
        return next;
    }

    @Override
    public void setValue(K value) {
        item = value;
    }

    @Override
    public void setNext(Entry<K, K> next) {
        this.next = next;
    }
}

public class HashSet<T extends Comparable> implements Set<T> {
    HashContainer<T, T> container = new HashContainer<T, T>() {
        @Override
        protected Entry<T, T>[] initCapacity(int capacity) {
            return (Entry<T, T>[]) new SetEntry[capacity];
        }

        @Override
        protected Entry<T, T> getEntry(int hash, T key, T value, Entry<T, T> next) {
            return new SetEntry(hash, key, next);
        }
    };

    @Override
    public void add(T element) {
        container.put(element, element);
    }

    @Override
    public T get(int index) {
        if(index >= container.count) return null;
        int count = 0;
        for(int i = 0; i < container.table.length; i++){
            Entry<T, T> entry = container.table[i];
            while(entry != null){
                if(count == index) return entry.value();
                count++;
                entry = entry.next();
            }
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        return container.get(element) != null;
    }

    @Override
    public T remove(T element) {
        return container.remove(element);
    }

    @Override
    public int size() {
        return container.count;
    }

    @Override
    public boolean isEmpty() {
        return container.count == 0;
    }
}
