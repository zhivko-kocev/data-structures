package mk.ukim.finki.LinkedLists;

import mk.ukim.finki.DataStruct.DLL;
import mk.ukim.finki.DataStruct.DLLNode;
import mk.ukim.finki.DataStruct.SLL;
import mk.ukim.finki.DataStruct.SLLNode;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {
    public static boolean isVowel(char a) {
        a = Character.toLowerCase(a);
        return a == 'a' || a == 'e' || a == 'o' || a == 'u' || a == 'i';
    }

    public static void main(String[] args) {
        int br= 12345;
        System.out.println(String.valueOf(br).length());
    }
}
