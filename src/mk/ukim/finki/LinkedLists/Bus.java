package mk.ukim.finki.LinkedLists;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        int max,min;
        if(M==0){
            max=N*100;
        }else{
            max=((M-1)*100)+(N*100);
        }

        if(N<=M){
            min=M*100;
        }else{
            min=(M*100)+(N-M)*100;
        }
        System.out.println(min);
        System.out.println(max);

    }

}
