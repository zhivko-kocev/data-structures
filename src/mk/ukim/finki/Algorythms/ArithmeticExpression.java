package mk.ukim.finki.Algorythms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {
    static int presmetaj(char c[], int l, int r) {
        if(r-l+1 == 5) {
            if(c[l+2] == '+')
                return ((c[l+1] - '0') + (c[l+3] - '0'));
            else if(c[l+2] == '-')
                return ((c[l+1] - '0') - (c[l+3] - '0'));
        }

        int opened = 0, index = 0;

        for(int i = l; i < r; i++) {
            if(c[i] == '(') opened++;
            if(c[i] == ')') opened--;
            if((c[i] == '+') || (c[i] == '-')) {
                if(opened == 1) {
                    index = i;
                    break;
                }
            }
        }

        if(c[index] == '+')
            return presmetaj(c, l+1, index-1) + presmetaj(c, index+1, r-1);
        else return presmetaj(c, l+1, index-1) - presmetaj(c, index+1, r-1);
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}

