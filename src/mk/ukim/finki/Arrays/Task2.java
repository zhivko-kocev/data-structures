package mk.ukim.finki.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void printPushedZeroes(int[] array, int n) {
        int[] pom=new int[n];
        int pomLength = n-1;
        for (int i = n-1; i >=0; i--) {
            if (array[i] != 0) {
                pom[pomLength--]=array[i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(pom[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }
        printPushedZeroes(array, n);
        System.out.println(Arrays.toString(array));
    }
}
