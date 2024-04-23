package mk.ukim.finki.LinkedLists;

import java.util.*;


public class MiceHoles {

    //TODO: implement function
    public static int minTime(int[] mice, int[] holes) {
        if(mice.length!=holes.length){
            return -1;
        }
        for (int i = 0; i < mice.length; i++) {
            for (int j = i; j < holes.length; j++) {
                if(mice[i]>mice[j]){
                    int tmp=mice[i];
                    mice[i]=mice[j];
                    mice[j]=tmp;
                }
                if(holes[i]>holes[j]){
                    int tmp=holes[i];
                    holes[i]=holes[j];
                    holes[j]=tmp;
                }
            }
        }

        int maxDiff=0;
        for (int i = 0; i < mice.length; i++) {
            if(Math.abs(mice[i]-holes[i])>maxDiff){
                maxDiff=Math.abs(mice[i]-holes[i]);
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String[] parts = line.split(" ");
        int[] mice = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            mice[i] = Integer.parseInt(parts[i]);
        }

        line = input.nextLine();
        parts = line.split(" ");
        int[] holes = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            holes[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(minTime(mice, holes));
    }
}