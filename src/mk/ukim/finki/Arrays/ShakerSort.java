package mk.ukim.finki.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {

    static void shakerSort(int[] a, int n) {
        boolean swapped = true;
        int start = 0;
        int end = a.length - 1;

        while (swapped) {

            swapped = false;


            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped)
                break;

            for (int i = 0; i < n; i++) {
                System.out.printf("%d ", a[i]);
            }
            System.out.printf("%n");

            swapped = false;

            start = start + 1;


            for (int i = start; i < end; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.printf("%d ", a[i]);
            }
            System.out.printf("%n");
            end = end - 1;
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("%n");

        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("%n");
    }

    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(pom[i]);
        shakerSort(a, n);
    }
}