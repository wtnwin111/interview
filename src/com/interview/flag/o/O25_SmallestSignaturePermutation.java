package com.interview.flag.o;

import com.interview.utils.ConsoleWriter;

/**
 * Created_By: stefanie
 * Date: 14-12-8
 * Time: 下午9:05
 */
public class O25_SmallestSignaturePermutation {
    public int[] find(String signature){
        int len = signature.length();
        int[] numbers = new int[len];
        int option = 1;
        int count = 0;
        for(int i = 0; i <= len; i++){
            if(i < len && signature.charAt(i) == 'D') count++;
            else {
                if(i < len){
                    numbers[i] = option++;
                }
                for(int j = 1; j <= count; j++){
                    numbers[i - j] = option++;
                }
                count = 0;
            }
        }
        return numbers;
    }

    public static void main(String[] args){
        O25_SmallestSignaturePermutation finder = new O25_SmallestSignaturePermutation();
        int[] numbers = finder.find("DDIIDI");
        ConsoleWriter.printIntArray(numbers);
        numbers = finder.find("DDIDDD");
        ConsoleWriter.printIntArray(numbers);
        numbers = finder.find("IIDIID");
        ConsoleWriter.printIntArray(numbers);
    }
}
