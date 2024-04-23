package mk.ukim.finki.LinkedLists;

import mk.ukim.finki.DataStruct.SLL;
import mk.ukim.finki.DataStruct.SLLNode;

import java.util.Scanner;

public class SpecialSLLDelete<E> {

    //TODO: implement method
    public void specialDelete(SLL<E> list, int m) {
        int index=0;
        for (SLLNode <E> i = list.getFirst(); i != null ; i=i.succ) {
            if(index==m-1){
                list.delete(i);
                m+=m;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        SLL<Integer> list = new SLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int m = input.nextInt();

        SpecialSLLDelete<Integer> tmp = new SpecialSLLDelete<>();

        tmp.specialDelete(list, m);

        System.out.println(list);
    }

}