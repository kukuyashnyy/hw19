package org.itstep;

public class Player {
    public Deck deck = new Deck(7);

    public int getScore() {
        int sum = 0;
        for (int i = 0; i < this.deck.cards.length; i++) {
            if (this.deck.cards[i] != null){
                sum += this.deck.cards[i].getValue();
            }
        }
        return sum;

    }
}
