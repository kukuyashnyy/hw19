package org.itstep;

import java.util.Random;

class Deck {
    Card[] cards;

    public Deck(int cardNumber) {
        cards = new Card[cardNumber];
    }

    public Card[] getCards() {
        return cards;
    }

    public void genDeck() {
        int i = 0;
        for (Card.Suite sute : Card.Suite.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards[i++] = new Card(sute, rank);
            }
        }
        shuffle();
    }

    public void clrDeck() {
        for (int i = 0; i < cards.length - 1; i++) {
            cards[i] = null;
        }
    }

    private void shuffle() {
        Random random = new Random();

        for (int i = 0; i < cards.length * 2; i++) {
            int a = random.nextInt(36);
            int b = random.nextInt(36);

            Card temp = cards[a];
            cards[a] = cards[b];
            cards[b] = temp;
        }
    }

    public void putCard(Card card) {
        for (int i = 0; i < this.cards.length; i++) {
            if (this.cards[i] == null) {
                this.cards[i] = card;
                break;
            }
        }
    }

    public Card popCard() {
        for (int i = cards.length - 1; i > 0; i--) {
            if (cards[i] != null) {
                Card card = cards[i];
                cards[i] = null;
                return card;
            }
        }
        return null;
    }

    public void printDeck() {
        for (Card card : cards) {
            if (card != null)
            System.out.printf("%s ", card.toString());
        }
        System.out.println();
    }

    public static class Card {
        private Suite sute;
        private Rank rank;

        public Card(Suite sute, Rank rank) {
            this.sute = sute;
            this.rank = rank;
        }

        public int getValue() {
            return rank.value;
        }

        @Override
        public String toString() {
            return String.valueOf(sute.suite) + rank.symbol;
        }

        enum Suite {
            Heart('♡'), Diamond('♢'), Club('♤'), Spade('♧');

            final char suite;

            Suite(char suite) {
                this.suite = suite;
            }
        }

        enum Rank {
            SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9),
            TEN("10", 10), JACK("J", 2), QUEEN("Q", 3), KING("K", 4),
            ACE("T", 11);

            final int value;
            final String symbol;

            Rank(String symbol, int value) {
                this.symbol = symbol;
                this.value = value;
            }

            public int getValue() {
                return value;
            }
        }
    }
}

