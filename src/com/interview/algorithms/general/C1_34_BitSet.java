package com.interview.algorithms.general;

/**
 * Created_By: zouzhile
 * Date: 2/25/14
 * Time: 4:49 PM
 */
public class C1_34_BitSet {

    private int[] data;
    private int nbits;

    public C1_34_BitSet(int nbits) {
        this.nbits = nbits;
        int intRequired = nbits % 32 == 0 ? nbits / 32 : nbits / 32 + 1;
        data = new int[intRequired];
    }
    /*
     *  set the bit at the index to 1
     */
    public void set(int index) {
        int intIndex =  index % 32 == 0 ? index / 32 + 1 : index / 32;
        int pos = index % 32 == 0 ? 0 : index % 32 - 1;
        int mask = 1 << (31 - pos) ;
        data[intIndex] = data[intIndex] | mask;
    }

    public void unset(int index) {
        int intIndex = index % 32 == 0 ? index / 32 + 1 : index / 32;
        int pos = index % 32 == 0 ? 0 : index % 32 - 1;
        int mask = 1 << (31 - pos);
        data[intIndex] = data[intIndex] & ~ mask;
    }

    public void flip(int index) {
        int intIndex = index % 32 == 0 ? index / 32 + 1 : index / 32;
        int pos = index % 32 == 0 ? 0 : index % 32 - 1;
        int mask = 1 << (31 - pos) ;
        String maskBinary = this.toBinary(mask);
        String dataBinary = this.toBinary(data[intIndex]);
        data[intIndex] = data[intIndex] ^ mask;
        String binary = this.toBinary(data[intIndex]);
    }

    public String toString() {
        String result = "";
        int counter = 0;
        for(int i = 0; i < data.length && counter <= this.nbits; i ++) {
            int bits = data[i];
            String binary = this.toBinary(bits);
            result += binary + " ";
        }
        return result;
    }

    private String toBinary(int value) {
        String binary = "";
        for(int j = 0; j < 32; j ++) {
            binary = (value & 1) + binary;
            value = value >>> 1;
        }
        return binary;
    }

    public static void main(String[] args) {
        C1_34_BitSet bitset = new C1_34_BitSet(100);
        bitset.set(3);
        System.out.println(bitset.toString());
        bitset.flip(5);
        System.out.println(bitset.toString());
        bitset.unset(5);
        System.out.println(bitset.toString());
    }

}
