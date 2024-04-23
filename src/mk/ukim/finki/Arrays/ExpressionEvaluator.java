package mk.ukim.finki.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression) {
        char[] splited = expression.toCharArray();
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        Stack<Integer> finalSum = new Stack<>();
        for (char c : splited) {
            if (!Character.isDigit(c)) {
                operators.push(c);
            }
        }
        String [] s=expression.split("[+*]+");
        for (String string : s) {
            numbers.push(Integer.parseInt(string));
        }
        while (!operators.empty()) {
            char operator = operators.pop();
            if (operator == '*') {
                int num1 = numbers.pop();
                int num2 = numbers.pop();
                numbers.push(num1 * num2);
            } else {
                finalSum.push(numbers.pop());
            }
        }
        int sum = 0;
        while (!numbers.empty()) {
            sum += numbers.pop();
        }
        while (!finalSum.empty()) {
            sum += finalSum.pop();
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}