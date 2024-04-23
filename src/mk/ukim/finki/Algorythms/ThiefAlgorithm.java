package mk.ukim.finki.Algorythms;

import java.util.*;
import java.util.stream.Collectors;

public class ThiefAlgorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Double> articles = new ArrayList<>();
        while (true) {
            String number = input.next();
            if (number.equals("#")) {
                break;
            }
            articles.add(Double.parseDouble(number));
        }
        articles = articles.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        double[] packages = new double[articles.size()];
        int i = 0;
        while (!articles.isEmpty()) {
            for (int j = 0; j < articles.size(); j++) {
                if (packages[i] + articles.get(j) <= 1) {
                    packages[i] += articles.get(j);
                    articles.remove(j);
                    j--;
                }
            }
            i++;
        }
        long count = Arrays.stream(packages).filter(num -> num > 0).count();
        System.out.println(count);

    }
}
