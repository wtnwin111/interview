package com.interview.algorithms.general;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: stefanie
 * Date: 9/25/14
 * Time: 3:04 PM
 */
public class C1_23A_PostfixExpression {

    public static String transform(String exp){
        int emptyMark = -1;
        Stack<String> numbers = new Stack<>();
        Stack<Character> ops = new Stack<>();

        char[] chars = exp.toCharArray();
        int numberBegin = emptyMark;
        for(int i = 0; i < chars.length; i++){
            if(isNumber(chars[i])) {
                if(numberBegin == emptyMark) numberBegin = i;
                continue;
            }
            if(numberBegin != emptyMark){
                numbers.push(String.valueOf(chars, numberBegin, i - numberBegin));
                numberBegin = emptyMark;
            }
            if(chars[i] == ')') pop(numbers, ops);
            else if(chars[i] == '(') numbers.push("B");
            else if(isOperation(chars[i])) ops.push(chars[i]);

        }
        if(numberBegin > 0) numbers.push(String.valueOf(chars, numberBegin, chars.length - numberBegin));
        if(numbers.size() > 1)  pop(numbers, ops);
        return numbers.peek();
    }

    public static void pop(Stack<String> numbers, Stack<Character> ops){
        String n = numbers.pop();
        if("B".equals(n)) return;

        StringBuilder builder = new StringBuilder();
        builder.append(n);
        n = numbers.pop();
        while(!"B".equals(n)){
            builder.insert(0, " ");
            builder.insert(0, n);
            char op = ops.pop();
            builder.append(" ");
            builder.append(op);
            if(numbers.empty()) break;
            n = numbers.pop();
        }
        numbers.push(builder.toString());
    }

    private static boolean isOperation(char charValue) {
        return charValue == '+' || charValue == '-'
                || charValue == '*' || charValue == '/';
    }

    private static boolean isNumber(char charValue){
        return charValue == '.'
                || (charValue >= '0' && charValue <= '9');
    }
}
