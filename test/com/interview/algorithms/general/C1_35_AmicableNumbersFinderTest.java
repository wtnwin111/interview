package com.interview.algorithms.general;

import com.interview.basics.model.collection.List;
import junit.framework.TestCase;

public class C1_35_AmicableNumbersFinderTest extends TestCase {

    public void testFind() throws Exception {
        List<AmicableNumber> numbers = C1_35_AmicableNumbersFinder.find(10000);

        for(int i = 0; i < numbers.size(); i++){
            AmicableNumber number = numbers.get(i);
            System.out.println(number.num1 + "-" + number.num2);
        }

    }
}