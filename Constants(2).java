/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author Stavros
 */
public class Constants 
{
   public static final int NUM_AI_PLAYERS = 3;       //Constant for number of AI players
   public static final int CARDS = 52;               //Constant for the number of cards in a standard deck  
   public static final int CARDS_PER_PLAYER = 13;    //Constant for the number of cards each player is dealt
   public static final int NUM_ROUNDS = 13;          //Constant for the number of rounds in a game 
   public static final int MIN_BID = 1;              //Constant for the minimum bid value
   public static final int WINNING_SCORE = 200;      //Constant for the number of cards in a standard deck 
   public static final int ONE = 0;
   public static final int TWO = 1;
   public static final int NUM_PLAYERS = 4;
   
   
   public enum Color                                   
    {
        RED, BLACK;                                  // Card colors
    }

    public enum Suit                                // Card suits
    {
        CLUBS (0), 
        DIAMONDS (1), 
        HEARTS (2), 
        SPADES (3);             
        
        private int rank;

        public int getRank() {
            return rank;
        }

        private Suit(int rank) {
            this.rank = rank;
        }
    }

    public enum Face                       // Card faces and values    
    {
        TWO (2), 
        THREE (3), 
        FOUR (4), 
        FIVE (5), 
        SIX (6), 
        SEVEN (7), 
        EIGHT (8), 
        NINE (9), 
        TEN (10), 
        JACK (11), 
        QUEEN (12), 
        KING (13), 
        ACE (14);  

        public int getValue() {
            return value;
        }

        private Face(int value) {
            this.value = value;
        }
        
        private int value;
    }
    
    
}