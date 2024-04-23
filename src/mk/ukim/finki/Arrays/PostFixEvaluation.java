package mk.ukim.finki.Arrays;

import mk.ukim.finki.DataStruct.ArrayStack;


import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PostFixEvaluation {

    static int evaluatePostfix(String[] izraz, int n) {

        ArrayStack<Integer> evaluate =new ArrayStack<>(n);
        for (int i = 0; i < n; i++) {
            if(izraz[i].chars().allMatch(Character::isDigit)){
                evaluate.push(Integer.parseInt(izraz[i]));
            }else{
                int second=evaluate.pop();
                int first=evaluate.pop();
                if(izraz[i].equals("+")){
                    evaluate.push(first+second);
                }else if(izraz[i].equals("-")){
                    evaluate.push(first-second);
                }else if(izraz[i].equals("*")){
                    evaluate.push(first*second);
                }else if(izraz[i].equals("/")){
                    if(first==0 || second==0){
                        return 0;
                    }
                    evaluate.push(first/second);
                }
            }
        }
        return evaluate.pop();
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        String[] exp = expression.split("\\s+");

        int rez = evaluatePostfix(exp, exp.length);
        System.out.println(rez);

        br.close();

    }

}
