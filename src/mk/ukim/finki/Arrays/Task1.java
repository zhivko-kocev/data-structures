package mk.ukim.finki.Arrays;

import mk.ukim.finki.DataStruct.Array;

import java.util.Scanner;

public class Task1<E> {
    public void changeArrays(Array<E> first, Array<E> second) {
        if (first.getSize() != second.getSize()) {
            System.out.println("The arrays are not the same!");
            return;
        }
        for (int i = 0; i < first.getSize(); i++) {
            if (first.get(i).equals(second.get(i))) {
                second.delete(i);
                first.delete(i);
                i--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Array<Integer> first = new Array<>(10);
        Array<Integer> second = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            first.insertLast(input.nextInt());
        }
        for (int i = 0; i < 10; i++) {
            second.insertLast(input.nextInt());
        }
        Task1<Integer> tmp = new Task1<>();
        tmp.changeArrays(first, second);
        System.out.println(first);
        System.out.println(second);
    }
}
