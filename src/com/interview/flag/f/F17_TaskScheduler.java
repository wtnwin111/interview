package com.interview.flag.f;


import java.util.HashMap;

/**
 * Created_By: stefanie
 * Date: 15-1-30
 * Time: 下午10:36
 */
public class F17_TaskScheduler {
    public int totalTime(String task){
        HashMap<Character, Integer> earliestTime = new HashMap();
        int count = 0;

        for(int i = 0; i < task.length(); i++){
            char ch = task.charAt(i);
            int earliest = earliestTime.containsKey(ch)? earliestTime.get(ch) : 0;
            if(earliest > count) count = earliest;   //no earlier than earliest
            else count++;
            earliestTime.put(ch, count + 3);
        }
        return count;
    }

    public static void main(String[] args){
        F17_TaskScheduler scheduler = new F17_TaskScheduler();
        System.out.println(scheduler.totalTime("AABABCD"));  //10
    }
}
