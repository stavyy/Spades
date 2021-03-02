/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author Stavros
 */
public abstract class Player implements IPlayer   
{
                                                //Getter and Setters
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tricks
     */
    public int getTricks() {
        return tricks;
    }

    /**
     * @param tricks the tricks to set
     */
    public void setTricks(int tricks) {
        this.tricks = tricks;
    }

    /**
     * @return the bid
     */
    public int getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(int bid) {
        this.bid = bid;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    private String name;          //Data type String to represent player name
    private int tricks;           //Data type int to represent number of tricks the player took
    private int bid;              //Data type int to represent the number of tricks the player bid
    private int score;            //Data type int to represent the player’s current score
    private ArrayList<Card> hand;                

    public ArrayList<Card> getHand() 
    {
        return hand;
    }
                    
     public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    
    public abstract Card playcard();    //Abstract methods 
    public abstract int placeBid();

    public Player()
    {
        hand = new ArrayList();
    }
   
    
         
   
    public void displayHand() 
    {
        System.out.println("***************************");
        System.out.println("Player " + name + " hand is ");
        System.out.println("***************************");
        
        for(Card card : hand)
        {
            System.out.println(card.getFace() + " of " + card.getSuit());
        }
            
    }
    
    public void sortBySuit()            // Sort the cards by their suit
    {
        ArrayList<Card> sortedHand = new ArrayList<Card>();
        
        while (hand.size() > 0)
        {
            int position = 0;
            Card firstCard = hand.get(0);
            
            for (int i = 1; i < hand.size(); i++)
            {
                Card nextCard = hand.get(i);
                
                if(nextCard.getSuit().getRank() < firstCard.getSuit().getRank() 
                        || (nextCard.getSuit() == firstCard.getSuit() 
                            && nextCard.getFace().getValue() < firstCard.getFace().getValue()))
                {
                    position = i;
                    firstCard = nextCard;
                }
            }
            
            hand.remove(position);
            sortedHand.add(firstCard);
        }
        
        hand = sortedHand;
    }
            
    

 
    
}
