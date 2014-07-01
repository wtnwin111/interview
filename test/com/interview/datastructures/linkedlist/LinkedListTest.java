package com.interview.datastructures.linkedlist;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase {

    public void test(LinkedListIface<Integer> list) {
        list.add(2);
        assertEquals(1, list.size());

        list.add(4);
        assertEquals(2, list.size());

        assertEquals(2, list.get(0).intValue());
        assertEquals(4, list.get(1).intValue());
        assertEquals(null, list.get(-1));
        assertEquals(null, list.get(5));
        assertEquals(1, list.indexOf(4));
        assertEquals(-1, list.indexOf(5));
        assertEquals(2, list.previous(4).intValue());
        assertEquals(null, list.previous(2));
        assertEquals(null, list.previous(5));
//
        assertEquals(true, list.contains(4));
        assertEquals(false, list.contains(3));
//
        assertEquals(2, list.remove(0).intValue());
        assertEquals(1, list.size());
        assertEquals(false, list.contains(2));
        assertEquals(4, list.get(0).intValue());
        assertEquals(-1, list.indexOf(2));
        assertEquals(null, list.remove(5));
        assertEquals(4, list.removeElement(new Integer(4)).intValue());
        assertEquals(0, list.size());
        assertEquals(null, list.remove(5));
    }

    public void testLinkedList(){
        LinkedList<Integer> list = new LinkedList<>();
        test(list);
    }

//    public void testBiLinkedList(){
//        LinkedList<Integer> list = new LinkedList<>(true, false);
//        test(list);
//    }
//
//    public void testTailedLinkedList(){
//        LinkedList<Integer> list = new LinkedList<>(true, true);
//        test(list);
//        assertEquals(4, list.getTail().value);
//        list.add(5);
//        assertEquals(5, list.getTail().value);
////        list.remove(5);
////        assertEquals(4, list.getTail().value);
//    }
}