/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import constants.Constants.Color;
import constants.Constants.Face;
import constants.Constants.Suit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Stavros
 */
public class Deck 
{
       
    private Set<Card> deck;        //Represent the deck of cards
    

    public Set<Card> getDeck() {   //Getter and setters for deck
        return deck;
    }

    public void setDeck(Set<Card> Deck) {
        this.deck = Deck;
    }
    

    
    public Deck()  // Calling methonds generateDeck, displayDeck and shuffleDeck
    {
        System.out.println("***************************");
        System.out.println("------Generating deck------");
        System.out.println("***************************");
        System.out.println("");
        generateDeck();
        System.out.println("***************************");
        System.out.println("------Displaying deck------");
        System.out.println("***************************");
        System.out.println("");
        displayDeck();
        System.out.println("");
        System.out.println("***************************");
        System.out.println("------Shuffling deck-------");
        System.out.println("***************************");
        System.out.println("");
        shuffleDeck();
        System.out.println("***************************");
        System.out.println("------Displaying Deck------");
        System.out.println("***************************");
        System.out.println("");
        displayDeck();
    }
    
    
    private void generateDeck()    // Return type void
    {
        deck = new HashSet<Card>(Constants.CARDS); //Instantiates the member variable of type Set calling the constructor for class HashSet
        
        for(Face face: Face.values()) //Loops through the values of enumeration Face
        {
            for(Suit suit : Suit.values()) //Loops through the values of enumeration Suit
            {
                Card card = new Card(); //Instantiates an instance of class Card
                card.setFace(face); // Sets the face value of the card
                card.setSuit(suit); //Sets the suit of the card
                
             if(suit == Suit.DIAMONDS || suit == Suit.HEARTS) //Determines the color of the card based on the suit and sets the color of the card
                 card.setColor(Color.BLACK);
             else
                 card.setColor(Color.RED); // 
             boolean success;
             if(!deck.contains(card)) //Verifies the instance of Card created is not contained in the HashSet of cards
                success = deck.add(card);
                
            }
        }
    }
    
    private void displayDeck()   // Return void
    {
        System.out.println("Deck size:" + deck.size() + " cards");    //Iterates through the HashSet collection outputting to the console the face value, suit, and color of each card
        System.out.println("Deck includes");
        
        for(Card card: deck)
        {
            System.out.println("Card: " + card.getFace() + " of " + card.getSuit() + " is color " + card.getColor());
        }
    }
    
    private void shuffleDeck()  //Return void
    {
        List<Card> cardList = new ArrayList<>(deck);          //Instantiates an instance of class ArrayList, explicitly for data type of class Card passing the member variable of interface Set as an argument
        
        Collections.shuffle(cardList);                        //Call static method Collections.shuffle passing the ArrayList from abouve as an argument
        deck = new HashSet<>(cardList);                       //Reinstantiate the member variable of interface Set by calling the constructor for class HashSet passing the ArrayList above as an argument
    }

    
    
    
}


