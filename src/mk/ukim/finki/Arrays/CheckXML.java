package mk.ukim.finki.Arrays;

import mk.ukim.finki.DataStruct.ArrayStack;
import mk.ukim.finki.DataStruct.LinkedStack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckXML {
    public static int isValid(String[] exp) {
        ArrayStack<String> attempt = new ArrayStack<>(exp.length);
        int help;
        for (String s : exp) { // go minime celo
            if (s.contains("[") || s.contains("]")) {// dali e tag

                if (s.indexOf('/') == -1) { // dali e opening tag

                    attempt.push(s); //pushni go ako e

                } else if (s.indexOf('/') != -1) { //dali e closing tag

                    String tmp3 = "empty";

                    if (attempt.peek() != null) {
                        tmp3 = "[/" + attempt.pop().substring(1);
                    }
                    if (!s.equals(tmp3)) {//dali se isti

                        help = 0; // ako ne se, ne e valid

                        return help; // leave function
                    }
                }
            }
        }
        help = 1;
        return help;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] redovi = new String[n];
        for (int i = 0; i < n; i++)
            redovi[i] = br.readLine();
        int valid;
        valid = isValid(redovi);
        System.out.println(valid);
        br.close();
    }
}
