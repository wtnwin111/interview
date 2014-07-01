package com.interview.model.collection;

/**
 * Created_By: stefanie
 * Date: 14-7-1
 * Time: 下午11:08
 */
public class ArrayList<T> implements List<T> {
    static int N = 2;
    T[] array = (T[]) new Object[N];

    int size = 0;

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
        if(size >= array.length){
            N *= 2;
            duplicate();
        }
        if(size == 0) array[size] = element;
        else {
            int i = size - 1;
            for(; i > index; i--)
                array[i+1] = array[i];
            array[index] = element;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if(index >= 0 && index < size){
            return array[index];
        } else {
            return null;
        }
    }

    @Override
    public int indexOf(T element) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(element))    return i;
        }
        return -1;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    @Override
    public T remove(int index) {
        if(index >= 0 && index < size){
            T temp = array[index];
            for(int i = index; i < size - 1; i++){
                array[i] = array[i+1];
            }
            size--;
            if(size < array.length/4) {
                N = N /2;
                duplicate();
            }
            return temp;
        } else {
            return null;
        }
    }

    @Override
    public T remove(T element) {
        int index = indexOf(element);
        return remove(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    private void duplicate(){
        T[] newArray = (T[]) new Object[N];
        for(int i = 0; i < size; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
