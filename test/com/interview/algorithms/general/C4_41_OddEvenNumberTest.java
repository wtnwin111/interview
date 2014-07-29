package com.interview.algorithms.general;

import com.interview.utils.ConsoleWriter;
import junit.framework.TestCase;

/**
 * Created_By: stefanie
 * Date: 14-7-29
 * Time: 下午10:18
 */
public class C4_41_OddEvenNumberTest extends TestCase {

    public void testcase1() throws Exception {
        int[] a = new int[]{2,3,4,1,2,6,7};
        C4_41_OddEvenNumber.order(a);
        assertTrue(check(a));
    }

    public void testcase2(){
        int[] a = new int[] {1,3,5,6,2,8,0};
        C4_41_OddEvenNumber.order(a);
        assertTrue(check(a));
    }

    public void testcase3(){
        int[] a = new int[] {2,4,6,8,1,3,5,7};
        C4_41_OddEvenNumber.order(a);
        assertTrue(check(a));
    }

    public void testcase4(){
        int[] a = new int[] {2,4,6,8};
        C4_41_OddEvenNumber.order(a);
        assertTrue(check(a));
    }

    public void testcase5(){
        int[] a = new int[] {1,3,5,7};
        C4_41_OddEvenNumber.order(a);
        assertTrue(check(a));
    }

    public void testcase6(){
        int[] a = new int[] {2,4,6,8,1};
        C4_41_OddEvenNumber.order(a);
        ConsoleWriter.printIntArray(a);
        assertTrue(check(a));
    }

    public void testcase7(){
        int[] a = new int[] {2,1,3,5,7};
        C4_41_OddEvenNumber.order(a);
        ConsoleWriter.printIntArray(a);
        assertTrue(check(a));
    }

    private boolean check(int[] a){
        boolean isEven = false;
        for(int i = 0; i < a.length; i++){
            if(!isEven && a[i]%2 == 0) isEven = true;
            else if(isEven && a[i] % 2 != 0) return false;
        }
        return true;
    }
}
