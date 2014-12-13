package com.interview.books.ccinterview;

/**
 * Created_By: stefanie
 * Date: 14-12-13
 * Time: 下午4:25
 */
public class CC14_NumbersWithSameNumberOfOne {
    public static int next(int n){
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while((c & 1) == 0 && (c != 0)){
            c0++;
            c >>= 1;
        }
        while((c & 1) == 1){
            c1++;
            c >>= 1;
        }
        if(c0 + c1 == 31 || c0 + c1 == 0) return -1;

        int p = c0 + c1;
        n |= 1 << p;             //00000100000    rightmost zero to one
        n &= ~((1 << p) - 1);    //11111100000    clear left of rightmost to zero
        n |= (1 << (c1 - 1)) - 1;//00000000011    put rest 1 to the end
        return n;

//      return n + (1 << c0) + (1 << (c1 - 1)) - 1;

    }

    public static int prev(int n){
        int c = n;
        int c0 = 0;
        int c1 = 0;
        while((c & 1) == 1){
            c1++;
            c >>= 1;
        }
        if(c == 0) return -1;
        while((c & 1) == 0 && (c != 0)){
            c0++;
            c >>= 1;
        }

        int p = c0 + c1;
        n &= ((~0) << (p + 1));        //clear from bit p onwards
        int mask = (1 << (c1 + 1)) - 1;//sequence of (c1 + 1) ones
        n |= mask << (c0 - 1);
        return n;

//      return n - (1 << c1) - (1 << (c0 - 1)) + 1;
    }

    public static void main(String[] args){
        int n = 0x367C;
        System.out.println(Integer.toBinaryString(n));
        n = next(n);
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(prev(n)));
    }
}
