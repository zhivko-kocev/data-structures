package mk.ukim.finki.LinkedLists;

import java.util.Scanner;

public class CountWordPairs {
    public static int countWordPairs(String [] words) {
        int cnt=0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j <words.length-1 ; j++) {
                if(words[j].charAt(0)==words[j+1].charAt(0)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        String[] words = new String[N];

        for(int i=0;i<N;i++) {
            words[i] = input.next();
        }

        System.out.println(countWordPairs(words));

    }
}