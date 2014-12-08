package com.interview.flag.o;

/**
 * Created_By: stefanie
 * Date: 14-12-8
 * Time: 下午10:00
 */
public class O26_AggregatedNumber {
    public boolean isAggredated(String number){
        for(int i = 1; i < number.length()/2;i++){
            for(int j = i + 1; j <= number.length() / 2 + 1; j++){
                //check if number[0,i-1] and number[i,j-1]
                if(isMatch(i, j, number)) return true;
            }
        }
        return false;
    }

    private boolean isMatch(int i, int j, String number){
        int first = Integer.parseInt(number.substring(0, i));
        int second = Integer.parseInt(number.substring(i, j));
        while(true){
            int third = first + second;
            String thirdString = String.valueOf(third);
            if(number.length() < j + thirdString.length()) break;

            String substring = number.substring(j, j + thirdString.length());
            if(!thirdString.equals(substring)) return false;
            first = second;
            second = third;
            j += thirdString.length();
        }
        return j == number.length();
    }

    public static void main(String[] args){
        O26_AggregatedNumber checker = new O26_AggregatedNumber();
        System.out.println(checker.isAggredated("112358"));
        System.out.println(checker.isAggredated("122436"));
        System.out.println(checker.isAggredated("1232447"));
        System.out.println(checker.isAggredated("1232547"));

    }
}
