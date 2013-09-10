package com.interview.datastructures.stack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Build a virtual stack containing a set of stacks holding the stack elements.
 * Each stack inside the virtual stack can not exceed a given length; once the length is reached,
 * we should create another stack inside the virtual stack to hold more elements.
 *
 * Also, please implement an interface pop(int index) that performs pop at the given sub-stack.
 *
 * Created_By: zouzhile
 * Date: 9/10/13
 * Time: 9:24 PM
 */
public class SetOfStacks <T> {

    private int capacity;

    List<BasicStack<T>> stacks = new ArrayList<BasicStack<T>>();

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        BasicStack<T> stack = new BasicStack<T>();
        stacks.add(stack);
    }

    public void push(T value){
        BasicStack<T> stack = stacks.get(stacks.size() - 1);
        if(stack.getSize() >= this.capacity) {
            stack = new BasicStack<T>();
            stacks.add(stack);
        }
        stack.push(value);
    }

    public T pop() {
        BasicStack<T> stack = stacks.get(stacks.size() - 1);
        return stack.pop();
    }

    public T pop(int index) {
        if(index > stacks.size() - 1)
            return null;
        return stacks.get(index).pop();
    }

}
