package com.interview.flag.o;

import java.util.Random;

/**
 * Created_By: stefanie
 * Date: 14-12-8
 * Time: 下午10:20
 */
public class O27_ProbabilityRandomGenerator {
    int[] numbers;
    int[] density;
    int sum;
    Random random = new Random();

    public O27_ProbabilityRandomGenerator(int[] probabilities){
        this.numbers = probabilities;
        this.density = new int[numbers.length];
        sum = 0;
        for(int i = 0; i < probabilities.length; i++){
            density[i] = sum + 1;
            sum += probabilities[i];
        }
    }

    private int find(int number){
        int low = 0;
        int high = density.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(density[mid] == number) return mid;
            else if(number < density[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return low - 1;
    }

    public int random(){
        int rand = random.nextInt(sum) + 1;
        int offset = find(rand);
        return this.numbers[offset];
    }

    public static void main(String[] args){
        int[] pro = new int[]{1,5,3,2,4};
        O27_ProbabilityRandomGenerator generator = new O27_ProbabilityRandomGenerator(pro);
        double[] marker = new double[6];
        for(int i = 0; i < 1000; i++){
            int rand = generator.random();
            marker[rand]++;
        }
        for(int i = 1; i < marker.length; i++) {
            System.out.println(marker[i] / 1000);
        }
    }
}
