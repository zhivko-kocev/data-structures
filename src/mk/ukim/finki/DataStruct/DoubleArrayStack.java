package mk.ukim.finki.DataStruct;

import java.util.NoSuchElementException;

public class DoubleArrayStack<E> {
    // Stekot e pretstaven na sledniot nacin:
    // depth1 e dlabochinata na prviot stekot,
    // depth2 e dlabochinata na prviot stekot,
    // elems[0...depth-1] se elementi na prviot stek,
    // elems[maxDepth-depth2...maxDepth-1] se elementi na vtoriot stek,
    private E[] elems;
    private int depth1;
    private int depth2;

    @SuppressWarnings("unchecked")
    public DoubleArrayStack(int maxDepth) {
        // Konstrukcija na nov, prazen spodelen stek.
        elems = (E[]) new Object[maxDepth];
        depth1 = 0;
        depth2 = 0;
    }

    public boolean isEmptyFirst() {
        // Vrakja true ako i samo ako prviot stek e prazen.
        return (depth1 == 0);
    }

    public boolean isEmptySecond() {
        // Vrakja true ako i samo ako vtoriot stek e prazen.
        return (depth2 == 0);
    }

    public boolean isFull() {
        // Vrakja true ako i samo ako celata niza e polna.
        return (depth1 + depth2 == elems.length);
    }

    public E peekFirst() {
        // Go vrakja elementot na vrvot od prviot stek.
        if (depth2 == 0)
            throw new NoSuchElementException();
        return elems[depth1 - 1];
    }

    public E peekSecond() {
        // Go vrakja elementot na vrvot od vtoriot stek.
        if (depth1 == 0)
            throw new NoSuchElementException();
        return elems[elems.length - depth2];
    }

    public void clearFirst() {
        // Go prazni prviot stek.
        for (int i = 0; i < depth1; i++)
            elems[i] = null;
        depth1 = 0;
    }


    public void clearSecond() {
        // Go prazni vtoriot stek.
        for (int i = elems.length - 1; i >= elems.length - depth2; i--)
            elems[i] = null;
        depth2 = 0;
    }

    public void pushFirst(E x) {
        // Go dodava x na vrvot na prviot stek.
        if (!this.isFull())
            elems[depth1++] = x;
        else
            System.out.println("Error, the array is full");
    }

    public void pushSecond(E x) {
        // Go dodava x na vrvot na vtoriot stek.
        if (!this.isFull())
            elems[elems.length - (++depth2)] = x;
        else
            System.out.println("Error, the array is full");
    }


    public E popFirst() {
        // Go otstranuva i vrakja elementot shto e na vrvot na prviot stek.
        if (depth1 == 0)
            throw new NoSuchElementException();
        E topmost = elems[--depth1];
        elems[depth1] = null;
        return topmost;
    }

    public E popSecond() {
        // Go otstranuva i vrakja elementot shto e na vrvot na vtoriot stek.
        if (depth2 == 0)
            throw new NoSuchElementException();
        E topmost = elems[elems.length - depth2];
        elems[depth2--] = null;
        return topmost;
    }

    public String pecatiNizata() {
        StringBuilder ret = new StringBuilder("Elementite se: ");
        for (E elem : elems) ret.append(elem).append(" ");
        return ret.toString();
    }

    public static void main(String[] args) {
        DoubleArrayStack<Integer> d = new DoubleArrayStack<Integer>(6);
        d.pushFirst(1);
        d.pushFirst(2);
        d.pushFirst(3);
        d.pushSecond(-1);
        d.pushSecond(-2);
        d.pushSecond(-3);
        System.out.println("Vrv na prv: " + d.peekFirst() + ", dolzina na prv: " + d.depth1);
        System.out.println("Vrv na vtor: " + d.peekSecond() + ", dolzina na vtor: " + d.depth2);
        d.pushFirst(4);
        d.popFirst();
        d.pushFirst(4);
        System.out.println("Vrv na prv: " + d.peekFirst() + ", dolzina na prv: " + d.depth1);
        d.pecatiNizata();
    }
}
