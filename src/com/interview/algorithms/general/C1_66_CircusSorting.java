package com.interview.algorithms.general;

import com.interview.basics.sort.QuickSorter;

/**
 * Created_By: stefanie
 * Date: 14-10-19
 * Time: 上午11:38
 */
public class C1_66_CircusSorting {

    static class Person implements Comparable<Person>{
        int height;
        int weight;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        @Override
        public int compareTo(Person o) {
            if(height == o.height && weight == o.weight) return 0;
            else if(height <= o.height && weight <= o.weight) return -1;
            else return 1;
        }
    }

    public static void sort(Person[] persons){
        QuickSorter<Person> sorter = new QuickSorter<>();
        sorter.sort(persons);
    }
}
