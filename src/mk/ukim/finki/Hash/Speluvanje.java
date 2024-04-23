//package mk.ukim.finki.Hash;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {
//    K key;
//    E value;
//
//    public MapEntry (K key, E val) {
//        this.key = key;
//        this.value = val;
//    }
//    public int compareTo (K that) {
//        @SuppressWarnings("unchecked")
//        MapEntry<K,E> other = (MapEntry<K,E>) that;
//        return this.key.compareTo(other.key);
//    }
//    public String toString () {
//        return "(" + key + "," + value + ")";
//    }
//}
//
//
//class OBHT<K extends Comparable<K>,E> {
//
//    private MapEntry<K,E>[] buckets;
//    static final int NONE = -1; // ... distinct from any bucket index.
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    private static final MapEntry former = new MapEntry(null, null);
//    private int occupancy = 0;
//
//    @SuppressWarnings("unchecked")
//    public OBHT (int m) {
//        buckets = (MapEntry<K,E>[]) new MapEntry[m];
//    }
//
//    private int hash (K key) {
//        return Math.abs(key.hashCode()) % buckets.length;
//    }
//
//    public MapEntry<K,E> getBucket(int i){
//        return buckets[i];
//    }
//
//    public int search (K targetKey) {
//        int b = hash(targetKey); int n_search=0;
//        for (;;) {
//            MapEntry<K,E> oldEntry = buckets[b];
//            if (oldEntry == null)
//                return NONE;
//            else if (targetKey.equals(oldEntry.key))
//                return b;
//            else{
//                b = (b + 1) % buckets.length;
//                n_search++;
//                if(n_search==buckets.length)
//                    return NONE;
//            }
//        }
//    }
//
//    public void insert (K key, E val) {
//        MapEntry<K,E> newEntry = new MapEntry<K,E>(key, val);
//        int b = hash(key); int n_search=0;
//
//        for (;;) {
//            MapEntry<K,E> oldEntry = buckets[b];
//            if (oldEntry == null) {
//                if (++occupancy == buckets.length) {
//                    System.out.println("Hash tabelata e polna!!!");
//                }
//                buckets[b] = newEntry;
//                return;
//            } else if (oldEntry == former
//                    || key.equals(oldEntry.key)) {
//                buckets[b] = newEntry;
//                return;
//            } else{
//                b = (b + 1) % buckets.length;
//                n_search++;
//                if(n_search==buckets.length)
//                    return;
//
//            }
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    public void delete (K key) {
//        int b = hash(key); int n_search=0;
//        for (;;) {
//            MapEntry<K,E> oldEntry = buckets[b];
//
//            if (oldEntry == null)
//                return;
//            else if (key.equals(oldEntry.key)) {
//                buckets[b] = former;
//                return;
//            } else{
//                b = (b + 1) % buckets.length;
//                n_search++;
//                if(n_search==buckets.length)
//                    return;
//
//            }
//        }
//    }
//
//    public String toString () {
//        String temp = "";
//        for (int i = 0; i < buckets.length; i++) {
//            temp += i + ":";
//            if (buckets[i] == null)
//                temp += "\n";
//            else if (buckets[i] == former)
//                temp += "former\n";
//            else
//                temp += buckets[i] + "\n";
//        }
//        return temp;
//    }
//}
//
//
//class Zbor implements Comparable<Zbor>{
//    String zbor;
//
//    public Zbor(String zbor) {
//        this.zbor = zbor;
//    }
//    @Override
//    public boolean equals(Object obj) {
//        Zbor pom = (Zbor) obj;
//        return this.zbor.equals(pom.zbor);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(zbor);
//    }
//
//    @Override
//    public String toString() {
//        return zbor;
//    }
//    @Override
//    public int compareTo(Zbor arg0) {
//        return zbor.compareTo(arg0.zbor);
//    }
//}
//
//public class Speluvanje {
//    public static void main(String[] args) throws IOException {
//        OBHT<Zbor, String> tabela;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        //---Vie odluchete za goleminata na hesh tabelata----
//        tabela = new OBHT<Zbor,String>(N*2);
//
//        List<String> dict = br.lines().collect(Collectors.toList());
//
//        String [] check = dict.remove(dict.size()-1).split("\\s+");
//
//        dict.forEach(word -> tabela.insert(new Zbor(word),word));
//
//        List<String> wrong = new ArrayList<>();
//
//        Arrays.stream(check).forEach(word -> {
//            if(tabela.search(new Zbor(word.toLowerCase().replaceAll("[.,?!]","")))==OBHT.NONE){
//                wrong.add(word.toLowerCase().replaceAll("[.,?!]",""));
//            }
//        });
//
//        if(wrong.isEmpty() || wrong.stream().allMatch(String::isEmpty)){
//            System.out.println("Bravo");
//            return;
//        }
//
//        wrong.forEach(System.out::println);
//
//    }
//}