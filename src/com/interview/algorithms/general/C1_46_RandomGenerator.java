package com.interview.algorithms.general;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 8/13/14
 * Time: 12:33 PM
 * <p/>
 * There is a random method rand(), generate 0 in possibility p, and generate 1 in possibility 1-p.
 * Write code to use this rand() generate 0 and 1 in the same possibility 0.5.
 * Write code to generate 1,2,3 in same possibility 1/3
 * Write code to generate 1-N in the same possibility 1/N.
 */
public class C1_46_RandomGenerator {

    //generate 0 and 1 with possibility 1/3 and 2/3
    public static int rand(){
        int number = new Random().nextInt(3); //generate 1, 2, 3
        if(number > 1) return 1;
        else return 0;
    }

    public static int rand(int n){
        boolean hasTrue = false;
        int index = 0;
        while(!hasTrue){
            for(int i = 0; i < n; i++){
                boolean b = randB();
                if(!hasTrue && b){
                    hasTrue = true;
                    index = i;
                } else if(hasTrue && b) {
                    hasTrue = false;
                    index = 0;
                    break;
                }
            }
        }
        return index + 1;
    }

    //generate true or false in the same possibility
    public static boolean randB(){
        int i = 0;
        int j = 0;
        while(i == j){
            i = rand();
            j = rand();
        }
        if(i == 1 && j == 0) return true;
        else return false;
    }

}
