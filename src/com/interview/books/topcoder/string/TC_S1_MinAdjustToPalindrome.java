package com.interview.books.topcoder.string;

/**
 * Created_By: stefanie
 * Date: 15-1-7
 * Time: 下午4:20
 */
public class TC_S1_MinAdjustToPalindrome {
    public String adjust(String str){
        return null;
    }

    public static void main(String[] args){
        TC_S1_MinAdjustToPalindrome adjuster = new TC_S1_MinAdjustToPalindrome();
        System.out.println(adjuster.adjust("RACE")); //ECARACE
        System.out.println(adjuster.adjust("TOPCODER")); //REDTOCPCOTDER
        System.out.println(adjuster.adjust("Q")); //Q
        System.out.println(adjuster.adjust("MADAMIMADAM")); //MADAMIMADAM
        System.out.println(adjuster.adjust("ALRCAGOEUAOEURGCOEUOOIGFA")); //AFLRCAGIOEOUAEOCEGRURGECOEAUOEOIGACRLFA
    }
}
