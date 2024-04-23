package mk.ukim.finki.Algorythms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class card_trick {
    public static int count(int N){
        Queue<Integer> cards=new LinkedList<>();
        for (int i = 0; i < 51; i++) {
            cards.add(i+1);
        }
        int momCard=-1,counter=0;
        while(momCard!=N){
            Queue<Integer> someCards=new LinkedList<>();
            Stack<Integer> tmp=new Stack<>();
            for (int i = 0; i < 7; i++) {
                someCards.add(cards.remove());
            }
            while (!someCards.isEmpty()) {
                tmp.add(someCards.remove());
            }
            while (!tmp.isEmpty()) {
                someCards.add(tmp.pop());
            }
            for (int i = 0; i < 7; i++) {
                cards.add(someCards.remove());
                cards.add(cards.remove());
            }
            counter++;
            momCard=cards.peek();

        }

        return counter;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}
