package mk.ukim.finki.LinkedLists;

import mk.ukim.finki.DataStruct.DLL;
import mk.ukim.finki.DataStruct.DLLNode;

import java.util.Scanner;


public class ListaOdListi {

    public static long sumOfList(DLL<Integer> list){
        int sum=0;
        for (DLLNode<Integer> i = list.getFirst(); i !=null ; i=i.succ) {
            sum+=i.element;
        }
        return sum;
    }
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        long product=1;
        for (DLLNode<DLL<Integer>> i = list.getFirst(); i !=null ; i=i.succ) {
           product*=sumOfList(i.element);
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }

}
