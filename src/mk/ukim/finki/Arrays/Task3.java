package mk.ukim.finki.Arrays;

import java.util.Scanner;

public class Task3 {
    public static void printReverse(String word) {
        for (int i = word.length() - 1; i >= 0; i--) {
            System.out.print(word.charAt(i));
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            String word = s.next();
            printReverse(word);
        }


    }
}
