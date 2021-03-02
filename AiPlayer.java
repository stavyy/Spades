/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import constants.Constants.Face;
import constants.Constants.Suit;

/**
 *
 * @author Stavros
 */
public class AiPlayer extends Player // Inhetit methods from Player and override
{

    @Override
    public Card playcard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int placeBid()                 // Command to ask players to place bid.
    {
        System.out.println(super.getName() + " place your bid");
        int bid = 0;
        
        for(Card card : super.getHand())
        {
            if(card.getFace() == Face.ACE || card.getFace() == Face.KING)
            {
                bid++;
            }
            else if(card.getSuit() == Suit.SPADES && card.getFace().getValue() > Face.TEN.getValue())
            {
                bid++;
            }
        }
        
        if(bid == 0)
            bid = 1;
        
        super.setBid(bid);
        
        System.out.println("Player " + this.getName() + " bid " + bid);
        return super.getBid();
    }

    @Override
    public Card playCard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}