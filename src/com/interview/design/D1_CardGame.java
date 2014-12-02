package com.interview.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created_By: stefanie
 * Date: 14-12-2
 * Time: 下午2:38
 */
public class D1_CardGame {
    static class Card {
        public enum Suit {
            CLUBS(1), SPADES(2), HEARTS(3), DIAMONDS(4);
            int value;

            private Suit(int v) {
                value = v;
            }
        };

        private int number;
        private Suit suit;

        public Card(int r, Suit s) {
            number = r;
            suit = s;
        }

        public int value() {
            return number;
        }

        public Suit suit() {
            return suit;
        }
    }

    /**
     * Game: BlackJack
     * 该游戏由 2 到 6 个人玩，使用除大小王之外的52 张牌，游戏者的目标是使手中的牌的点数之和不超过 21 点且尽量大。有着悠久的历史。
     */
    static class BlackJackGame{
        static class BlackJackCard extends Card{

            public BlackJackCard(int r, Suit s) {
                super(r, s);
            }

            public int value(){
                int r = super.value();
                if (r == 1) return 11;
                if (r < 10) return r;
                return 10;
            }

            public boolean isAce(){
                return super.value() == value();
            }
        }
    }

    /**
     * Game: TexasPoker
     *
     * Rules:
     *  1. using total 52 cards, 13 cards in each suite.
     *  2. 2-9 players
     *  3. At the beginning, each player is given 2 hidden cards. During the game, the host will show 5 cards.
     *     At each show,
     *
     *
     * Core Object:
     *
     *
     */
    static class TexasPokerGame{

        static class Player{
            public String name;
            public Card[] cards = new Card[5];
            public int cash = 1000;
            public boolean contr = true;
            public Player(String name){
                this.name = name;
            }
        }

        int round = 0;
        int curBet = 0;
        int totalBet = 0;
        int count = 0;
        int cardOffset = 0;
        public List<Player> players;
        public List<Card> cards;

        public TexasPokerGame(){
            players = new ArrayList<>();
            cards = new ArrayList<Card>();
            for(Card.Suit suit : Card.Suit.values()){
                for(int j = 1; j <= 13; j++){
                    cards.add(new Card(j, suit));
                }
            }

        }

        public void join(Player player){
            players.add(player);
        }


        public void start(){
            shuffle();
            reset();

            while(count > 1 && round < 5){   //still at least 2 players
                for(Player player : players){
                    if(!player.contr) continue;
                    player.cards[round] = cards.get(cardOffset++);
                    if(player.cash > curBet) totalBet += curBet;
                }
            }

        }

        private void reset(){
            curBet = 0;
            totalBet = 0;
            round = 0;
            count = players.size();
            cardOffset = 0;
            for(Player player : players){
                player.contr = true;
                Arrays.fill(player.cards, null);
            }
        }

        private void shuffle(){
            Random random = new Random();
            for(int i = 0; i < cards.size(); i++){
                int r = random.nextInt(cards.size() - i);
                if(r != 0){
                    Card temp = cards.get(i);
                    cards.set(i, cards.get(i + r));
                    cards.set(i + r, temp);
                }
            }
        }

        public void printCards(){
            for(Card card : cards){
                System.out.println(card.number + " " + card.suit);
            }
        }

        public void judge(){

        }

        public static void main(String[] args){
            TexasPokerGame game = new TexasPokerGame();
            Player player1 = new Player("Summer");
            Player player2 = new Player("Robin");

            game.join(player1);
            game.join(player2);



            game.start();

        }


    }
}
