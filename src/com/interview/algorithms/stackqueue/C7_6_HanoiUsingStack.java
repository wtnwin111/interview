package com.interview.algorithms.stackqueue;

import com.interview.basics.model.collection.list.ArrayList;
import com.interview.basics.model.collection.list.List;
import com.interview.basics.model.collection.stack.LinkedStack;
import com.interview.basics.model.collection.stack.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 7/15/14
 * Time: 11:21 AM
 */
class Step{
    int disk;
    int from;
    int to;

    Step(int disk, int from, int to) {
        this.disk = disk;
        this.from = from;
        this.to = to;
    }

    public String toString(){
        return disk + " " + from + "-->" + to;
    }
}
class Tower{
    Stack<Integer> disks;
    int index;

    public Tower(int index){
        this.index = index;
        this.disks = new LinkedStack<>();
    }

    public void add(int d){
        if(!disks.isEmpty() && disks.peek() <= d)   System.err.println("Wrong Place of Disk " + d + " to tower " + this.index);
        else disks.push(d);
    }

    public Step moveTopTo(Tower t){
        int disk = disks.pop();
        t.add(disk);
        //System.out.printf("Move disk %d from %d to %d\n", disk, this.index, t.index);
        return new Step(disk, this.index, t.index);
    }

    public void printState(){
        System.out.printf("The state of tower %d is: \n", this.index);
        for(int i = 0; i < disks.size(); i++){
            System.out.print(disks.get(i) + " ");
        }
        System.out.println("");
    }

    public void moveDisks(int n, Tower destination, Tower buffer, List<Step> steps){
        if(n > 0){
            moveDisks(n-1, buffer, destination, steps);
            steps.add(moveTopTo(destination));
            buffer.moveDisks(n - 1, destination, this, steps);
        }

    }

}
public class C7_6_HanoiUsingStack {

    public static List<Step> solve(int n){
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
        for (int i = n - 1; i >= 0; i--) towers[0].add(i);
        //System.out.println("Start State");
        //for(int i = 0; i < 3; i++) towers[i].printState();
        List<Step> steps = new ArrayList<>();
        towers[0].moveDisks(n, towers[2], towers[1], steps);
        //System.out.println("End State");
        //for(int i = 0; i < 3; i++) towers[i].printState();
        return steps;
    }

}
