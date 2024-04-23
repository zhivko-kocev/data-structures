package mk.ukim.finki.Arrays;

import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {
        int[] pom = new int[a.length];
        for(int i=0;i<a.length;i++){
            pom[i] = 1;
        }

        for(int i = 1;i<a.length;i++){
            for(int j=0;j<i;j++){
                if(a[i] < a[j]&&pom[i] < pom[j]+1){
                    pom[i] = pom[j]+1;
                }
            }
        }

        int min =Integer.MIN_VALUE;
        for(int i=0;i<pom.length;i++){
            if(min < pom[i]){
                min = pom[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
