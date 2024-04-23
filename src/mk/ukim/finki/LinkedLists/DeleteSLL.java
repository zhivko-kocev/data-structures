package mk.ukim.finki.LinkedLists;

import mk.ukim.finki.DataStruct.SLL;
import mk.ukim.finki.DataStruct.SLLNode;

import java.util.Scanner;

public class DeleteSLL {

    public static int countAppearance(SLL<Integer> list,int br){
        int count=0;
        for (SLLNode<Integer> i = list.getFirst(); i!=null ; i=i.succ) {
            if(i.element==br){
                count++;
            }
        }
        return count;
    }
    public static void change(SLL<Integer> list, int br) {
        int appearances=countAppearance(list,br);
        if(appearances % 2 == 0){
            return;
        }
        for (SLLNode<Integer> i = list.getFirst(); i!=null ; i=i.succ) {
            if(i.element==br){
                list.insertBefore(br,i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n, broj;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for(int i = 0; i<n; i++) {
            list1.insertLast(scan.nextInt());
        }
        int br = scan.nextInt();
        change(list1,br);
        System.out.println(list1);


    }
}
