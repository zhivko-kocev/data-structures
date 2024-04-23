package mk.ukim.finki.Algorythms;

import java.util.Arrays;
import java.util.Scanner;

public class MaxProduct {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int [] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        int [] pom=Arrays.copyOf(arr,n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if((arr[i] > arr[j]) && (pom[i] <pom[j]*arr[i])){
                    pom[i]*=arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(pom));

    }
}
