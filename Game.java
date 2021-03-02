/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Stavros
 */
import constants.Constants;            //Constants
import constants.Constants.Suit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;



public class Game 
{
                                     // Getter and Setters
    public Suit getTrump() {
        return trump;
    }

    public void setTrump(Suit trump) {
        this.trump = trump;
    }

    public Player getLeadPlayer() {
        return leadPlayer;
    }

    public void setLeadPlayer(Player leadPlayer) {
        this.leadPlayer = leadPlayer;
    }

    public Player getDealer() {
        return dealer;
    }

    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    public Player getWonHand() {
        return wonHand;
    }

    public void setWonHand(Player wonHand) {
        this.wonHand = wonHand;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }
     
    public ArrayList<Player> getTable() {
        return table;
    }

    public void setTable(ArrayList<Player> table) {
        this.table = table;
    }

    public int getDealerIdx() {
        return dealerIdx;
    }

    public void setDealerIdx(int dealerIdx) {
        this.dealerIdx = dealerIdx;
    }
    
    
    private Suit trump = Suit.SPADES;      //Data type enumeration Suit to represent the trump suite of spades
    private Player leadPlayer;             //Data type class Player to represent the lead player for each hand
    private Player dealer;                 //Data type class Player to represent the dealer for each hand
    private Player wonHand;                //Data type class Player to represent which player won the current trick/hand
    private int round;                     //Data type int to represent the current round of the game
    private ArrayList<Team> teams;         //Data type ArrayList<Team> to represent the two teams of the game
    private Deck deck;                     //Data type class Deck to represent the deck of cards for the game
    private Scanner scan;                  //Data class Scanner to get information from the user
    private ArrayList<Player> table;
    private int dealerIdx;
   
    public Game()                          // Custom constructos
    {
        createTeams();
        //outputTeams();
        generateDeck();
        setTable();
        dealHand();
        displayHands();
        play();
        playHand();
    }
    private void createTeams()                         //Method
    {
        teams = new ArrayList();   //Instantiate the member variable
        
        Team teamOne = new Team();
        teamOne.setTeamName("Team one");
        teams.add(teamOne);
        
        Team teamTwo = new Team();
        teamTwo.setTeamName("Team Two");
        teams.add(teamTwo);
        
        scan = new Scanner(System.in);
        System.out.println("Enter human player name");
        String name = getScan().next();
        
        HumanPlayer hp = new HumanPlayer();
        hp.setName(name);
        System.out.println("Human player added to Team one");
        teamOne.getTeam().add(hp);
        
        
        for(int p = 1; p <= Constants.NUM_AI_PLAYERS; p++)    //Loop to generate three AI players
        {
            AiPlayer aip = new AiPlayer ();
            aip.setName("AI "+p);
            
            
            if(teamOne.getTeam().size() < 2)
                teamOne.getTeam().add(aip);
            else
                teamTwo.getTeam().add(aip);
        }
    }
    
//    private void outputTeams()                    //Method 
//    {
//        for (Team team : teams)
//        {
//            System.out.println(team.getTeamName() + " includes players: ");
//            
//            for(Player player : team.getTeam())++
//            {
//                System.out.println("Player: " + player.getName());
//            }
//        }
//    }

    
    private void generateDeck()  // Return void
    {
         deck = new Deck(); // Instantiates the member variable of class Deck
    }

    private void setTable() 
    {
        table = new ArrayList();
        
        
        Team teamOne = teams.get(Constants.ONE);
        Team teamTwo = teams.get(Constants.TWO);
        
        Player teamOnePlayerOne = teamOne.getTeam (). get(Constants.ONE);
        Player teamOnePlayerTwo = teamOne.getTeam (). get(Constants.TWO);
        Player teamTwoPlayerOne = teamTwo.getTeam (). get(Constants.ONE);
        Player teamTwoPlayerTwo = teamTwo.getTeam (). get(Constants.TWO);
        
        table.add(0, teamOnePlayerOne);
        table.add(1, teamTwoPlayerOne);
        table.add(2, teamOnePlayerTwo);
        table.add(3, teamTwoPlayerTwo);
        
        Random random = new Random();
        dealerIdx = random.nextInt(Constants.NUM_PLAYERS);
        dealer = table.get(dealerIdx);
        
        System.out.println("Player at the table are");
        for(Player player : table)
        {
            System.out.println(player.getName());
        }
    }

    private void dealHand()
    {
        System.out.println("Player " + dealer.getName() + " will deal the hand");
             
        int playerIdx;
        
        if (dealerIdx < 3)
            playerIdx = dealerIdx++;
        else
            playerIdx = 0;
        for(Iterator<Card> currentCard = deck.getDeck().iterator(); currentCard.hasNext();)
        {
        
            Card card = currentCard.next();
            
//            System.out.println("Dealing " + card.getFace() + " of " + card.getSuit());
//            System.out.println("Adding to player " + table.get(playerIdx).getName() + " 's hand is");
            
            table.get(playerIdx).getHand().add(card);
            
            if(playerIdx == 3)
                    playerIdx = 0;
            else
                playerIdx++;
            
            currentCard.remove();
        }
                 
    }
    

    private void displayHands() 
    {
        for (Team team : teams)
        {
                 
            System.out.println("***************************");
            System.out.println("         " + team.getTeamName().toUpperCase());
            System.out.println("***************************");
        
            for(Player player : team.getTeam())
            {
                System.out.println("Sortting hand by the suit and face");
                player.sortBySuit();
                
                if(player instanceof HumanPlayer)
                {
                    player.displayHand();
                }
            }
        }
        
    }
    
    private void play()
    {
        System.out.println("**************");
        System.out.println("Play the game!");
        System.out.println("**************\n");
        System.out.println("**************");
        System.out.println("Get player bids");
        System.out.println("**************");
            
        getBids();
    }
    
       
        
    private void getBids()      // Declares who is the leaderand gets the bid from each player.
    {
        int bidsPlaced = 0;
            
        int leadIdx;
            
        if(dealerIdx < 3)
            leadIdx = ++dealerIdx;
        else
            leadIdx = 0;
            
        leadPlayer = table.get(leadIdx);
            
        System.out.println("Lead player is player " + leadPlayer.getName());
            
        if(leadPlayer instanceof HumanPlayer)
        {
            HumanPlayer hp = (HumanPlayer)leadPlayer;
            hp.placeBid();
        }
        else
        {
            AiPlayer ai = (AiPlayer)leadPlayer;
            ai.placeBid();
        }
            
        bidsPlaced++;
            
        int playerIdx;
            
        if(leadIdx < 3)
            playerIdx = ++leadIdx;
        else
            playerIdx = 0;
        Player nextPlayer = table.get(playerIdx);
        
        while(bidsPlaced < Constants.NUM_PLAYERS)
        {
            System.out.println("Getting bid from player " + nextPlayer.getName());
            if(nextPlayer instanceof HumanPlayer)
            {
                HumanPlayer hp = (HumanPlayer)nextPlayer;
                hp.placeBid();
            }
            else
            {
                AiPlayer ai = (AiPlayer)nextPlayer;
                ai.placeBid();
            }
                
            bidsPlaced++;
            
            if(playerIdx < 3)
                playerIdx++;
            else
                playerIdx = 0;
            
            nextPlayer = table.get(playerIdx);
        }
                
            
    }
        
        
    private void playHand()
    {
        
    }

   

   
   
    
            
}