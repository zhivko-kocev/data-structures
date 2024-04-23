package mk.ukim.finki.LinkedLists;

import mk.ukim.finki.DataStruct.DLL;
import mk.ukim.finki.DataStruct.DLLNode;

import java.util.Scanner;

public class DLLBattalion {
    public static void battalion(DLL<Integer> list, int a, int b) {
        if((list.getSize()==2)||(list.getFirst().element==a && list.getLast().element==b)){
            list.mirror();
            return;
        }
        DLL<Integer> tmp=new DLL<>();
        DLLNode<Integer> pred = list.find(a).pred,succ = list.find(b).succ;
        boolean start=false;
        for (DLLNode<Integer> i =list.getFirst(); i!=null; i=i.succ) {
            if(i.element==a){
                start=true;
            }
            if(i.element==b){
                tmp.insertLast(i.element);
                list.delete(i);
                start=false;
            }
            if(start){
                tmp.insertLast(i.element);
                list.delete(i);
            }
        }
        tmp.mirror();
        if(pred!=null){
            for (DLLNode<Integer> i = tmp.getFirst(); i!=null ; i=i.succ) {
                list.insertAfter(tmp.deleteFirst(),pred);
                pred=pred.succ;
            }
        }else {
            for (DLLNode<Integer> i = tmp.getLast(); i!=null ; i=i.pred) {
                list.insertBefore(tmp.deleteLast(),succ);
                succ=succ.pred;
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        DLL<Integer> list = new DLL<>();
        for(int i=0;i<n;i++) {
            list.insertLast(input.nextInt());
        }

        int a = input.nextInt();
        int b = input.nextInt();

        battalion(list, a, b);

        System.out.println(list);
        System.out.println(list.toStringR());


    }
}
