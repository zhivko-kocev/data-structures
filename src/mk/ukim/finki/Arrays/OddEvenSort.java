package mk.ukim.finki.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class OddEvenSort {

    static void oddEvenSort(int[] a, int n)
    {
        List<Integer> odd= Arrays.stream(a).boxed().filter(i -> i % 2 != 0).collect(Collectors.toList());
        List<Integer> even= Arrays.stream(a).boxed().filter(i -> i % 2 == 0).collect(Collectors.toList());
        odd.sort(Comparator.naturalOrder());
        even.sort(Comparator.reverseOrder());
        Queue<Integer> o=new LinkedList<>(odd);
        Queue<Integer> e=new LinkedList<>(even);
        for (int i = 0; i < n; i++) {
            if(!o.isEmpty()){
                a[i]=o.remove();
            }else{
                a[i]=e.remove();
            }
        }
    }

    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}