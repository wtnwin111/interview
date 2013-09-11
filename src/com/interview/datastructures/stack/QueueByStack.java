package com.interview.datastructures.stack;

/**
 * Created_By: zouzhile
 * Date: 9/11/13
 * Time: 9:31 PM
 */
public class QueueByStack <T> {

    BasicStack<T> stackOne = new BasicStack<T>();
    BasicStack<T> stackTwo = new BasicStack<T>();

    public void append(T value) {
        stackOne.push(value);
    }

    public T pop() {
        while(! stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }
        T returnValue = stackTwo.pop();
        while(! stackTwo.isEmpty()) {
            stackOne.push(stackTwo.pop());
        }
        return returnValue;
    }
}
