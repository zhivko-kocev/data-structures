package mk.ukim.finki.LinkedLists;

import mk.ukim.finki.DataStruct.SLL;
import mk.ukim.finki.DataStruct.SLLNode;

import java.util.Scanner;
class Card {
    private int type;
    private int health;
    private int magicPower;

    public Card(int type, int health, int magicPower) {
        this.type = type;
        this.health = health;
        this.magicPower = magicPower;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public int significance() {
        return health * magicPower;
    }


    @Override
    public String toString() {
        return String.valueOf(type);
    }
}
public class MysticalCardGame {

    public static SLLNode<Card> getMostSignificant(SLL<Card> set){
        SLLNode<Card> max=set.getFirst();
        for (SLLNode<Card> i = set.getFirst(); i!=null ; i=i.succ) {
            if(max.element.significance()<i.element.significance()){
                max=i;
            }
        }
        return max;
    }
    public static void startDuel(SLL<Card> firstSorcererCards, SLL<Card> secondSorcererCards) {
        SLLNode<Card> cardToAdd=getMostSignificant(firstSorcererCards);
        firstSorcererCards.delete(cardToAdd);
        int cnt=0;
        for (SLLNode<Card> i = secondSorcererCards.getFirst(); i !=null ; i=i.succ) {
            if(cnt==(secondSorcererCards.size()/2)){
                secondSorcererCards.insertBefore(cardToAdd.element,i);
            }
            cnt++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SLL<Card> firstSorcererCards = new SLL<Card>();
        SLL<Card> secondSorcererCards = new SLL<Card>();

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            firstSorcererCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        for (int i = 0; i < 8; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");
            secondSorcererCards.insertLast(new Card(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
        }

        startDuel(firstSorcererCards, secondSorcererCards);
        System.out.println(firstSorcererCards);
        System.out.println(secondSorcererCards);
    }
}
