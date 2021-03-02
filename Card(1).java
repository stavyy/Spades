/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants.Color;  // Constants
import constants.Constants.Face;
import constants.Constants.Suit;
import java.util.Objects;

/**
 *
 * @author Stavros
 */
public class Card 
{
   private Face face;      //Varibles imported from constants
   private Suit suit;
   private Color color;

    public Face getFace() {             //Getter and setters for the varibles
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

   
    public int hashCode() //Methond hash
    {
        int hash = 0;
       
        return hash;
    }
    


    public boolean equals(Object obj) // Return boolean
    {
        if (obj instanceof Card)                // If the parameter is an instance of class card
        {
        Card card = (Card)obj;
        
        return (card.face.equals(this.face) && 
                    card.color.equals(this.color) &&  
                    card.suit.equals(this.suit));
        }
        else
        {
            return false;                           // If not return false
        }
        

    }
}