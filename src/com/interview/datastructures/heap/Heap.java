package com.interview.datastructures.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/1/14
 * Time: 1:26 PM
 */
public class Heap<T extends Comparable<T>> {
    public static int MAX_HEAD = 0;
    public static int MIN_HEAD = 1;

    int type;
    List<T> store = new ArrayList<T>();

    public Heap() {
        this.type = MAX_HEAD;
    }

    public Heap(int type) {
        this.type = type;
    }

    public void add(T element){
        store.add(element);
        swim(store.size() - 1);
    }

    public T getHead(){
        return store.get(0);
    }

    public T pollHead(){
        T temp = store.remove(0);
        sink(0);
        return temp;
    }

    public int size(){
        return store.size();
    }

    private void sink(int k) {
        //index start from 0, so the K -> 2K+1, 2K+2
        while(2*k + 1 < store.size()){
            int j = 2*k + 1;
            if(type == MAX_HEAD){
                if( j + 1 < store.size() && store.get(j).compareTo(store.get(j + 1)) < 0) j++;
                if(store.get(k).compareTo(store.get(j)) > 0) break;
            } else {
                if( j + 1 < store.size() && store.get(j).compareTo(store.get(j + 1)) > 0) j++;
                if(store.get(k).compareTo(store.get(j)) < 0) break;
            }
            swap(j, k);
            k = j;
        }
    }

    private void swim(int k){
        while(true){
            int p = (k-1)/2;
            if(type == MAX_HEAD){
                if(k <= 0 || p < 0 || store.get(p).compareTo(store.get(k)) >= 0) break;
            } else {
                if(k <= 0 || p < 0 || store.get(p).compareTo(store.get(k)) <= 0) break;
            }
            swap(p, k);
            k = p;
        }
    }

    private void swap(int i, int j){
        T temp = store.get(i);
        store.set(i, store.get(j));
        store.set(j, temp);
    }
}
