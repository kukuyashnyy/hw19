package org.itstep;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App1 {
    public static void main(String[] args) {
        Deck deck = new Deck(36);
        Player player = new Player();
        Player dealer = new Player();
        boolean exit = true;

        Scanner scanner = new Scanner(System.in);

        do {

            printMainMenu();

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Начало игры");

                    deck.genDeck();
                    player.deck.clrDeck();
                    dealer.deck.clrDeck();

                    boolean playerWin = false;
                    boolean dealerWin = false;
                    boolean playerLoose = false;
                    boolean dealerLoose = false;
                    boolean contin = true;

                    do {
                        player.deck.putCard(deck.popCard());
                        System.out.print("Ваши карты : ");
                        player.deck.printDeck();
                        System.out.println("Очки : " + player.getScore());

                        if (player.getScore() > 21) {
                            System.out.println("Вы проиграли");
                            playerLoose = true;
                            break;
                        }
                        if (player.getScore() == 21) {
                            System.out.println("Вы выиграли!");
                            playerWin = true;
                            break;
                        }
                        if (reqCmd("1. Взять карту?\n" +
                                "2. Пас.") != 1) {
                            contin = false;
                        }
                    } while (contin);

                    contin = true;

                    if (playerWin | playerLoose) break;

                    do {
                        dealer.deck.putCard(deck.popCard());

                        if (dealer.getScore() > 21) {
                            System.out.println("У диллера " + dealer.getScore() + " очков.");
                            System.out.println("Диллер проиграл");
                            dealerLoose = true;
                            break;
                        }
                        if (player.getScore() == 21) {
                            System.out.println("У диллера " + dealer.getScore() + " очков.");
                            System.out.println("Диллер выиграл!");
                            dealerWin = true;
                            break;
                        }
                        if (dealer.getScore() > 17) {
                            contin = false;
                        }
                    } while (contin);

                    if (dealerWin | dealerLoose) break;

                    System.out.println("У диллера " + dealer.getScore() + " очков.");

                    if (player.getScore() > dealer.getScore()) {
                        System.out.println("Вы выиграли");
                    }
                    if (player.getScore() == dealer.getScore()) {
                    System.out.println("Ничья!");
                    }
                    if(player.getScore() < dealer.getScore()) {
                        System.out.println("Вы проиграли");
                    }

                    break;
                case 2:
                    exit = false;
            }
        } while (exit);
    }

    public static int reqCmd(String msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printMainMenu() {
        System.out.println("1. Начать новую игру.\n" +
                "2. Выход.");
    }
}