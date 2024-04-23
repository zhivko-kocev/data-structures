package mk.ukim.finki.Arrays;

import mk.ukim.finki.DataStruct.Array;

import java.util.Scanner;

public class ArrayMeanWordLength {
    public static String wordClosestToAverageLength(Array<String> arr) {
        double sum = 0;
        for (int i = 0; i < arr.getSize(); i++) {
            sum += arr.get(i).length();
        }
        double average = sum / arr.getSize();
        String closest = arr.get(0);
        double closestRange = Math.abs(arr.get(0).length() - average);
        for (int i = 0; i < arr.getSize(); i++) {
            if (closestRange > Math.abs(arr.get(i).length() - average)) {
                closest = arr.get(i);
                closestRange = Math.abs(arr.get(i).length() - average);
            } else if (closestRange == Math.abs(arr.get(i).length() - average)) {
                if (arr.get(i).length() > closest.length()) {
                    closest = arr.get(i);
                }
            }
        }
        return closest;

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        Array<String> arr = new Array<>(N);
        input.nextLine();

        for (int i = 0; i < N; i++) {
            arr.insertLast(input.nextLine());
        }

        System.out.println(wordClosestToAverageLength(arr));
    }
}
