/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Stavros
 */
public class Team 
{

    private ArrayList<Player> team;  //Data type ArrayList<Player> to represent a team
    private int teamBid;             //Data type int to represent the team’s bid
    private int teamScore;           //Data type int to represent the team’s score
    private int teamHand;            //Data type int to represent the team’s tricks taken for each hand
    private int teamBag;             //Data type int to represent the team’s bags
    private String teamName;         //Data type String to represent the team’s name
    private Scanner scan;

    
    public Team()                //Custom Constructor
        {
            team = new ArrayList();
        }
    
    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }
        

    public ArrayList<Player> getTeam() {               //Getter and Setters
        return team;
    }

    public void setTeam(ArrayList<Player> team) {
        this.team = team;
    }

    public int getTeamBid() {
        return teamBid;
    }

    public void setTeamBid(int teamBid) {
        this.teamBid = teamBid;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    public int getTeamHand() {
        return teamHand;
    }

    public void setTeamHand(int teamHand) {
        this.teamHand = teamHand;
    }

    public int getTeamBag() {
        return teamBag;
    }

    public void setTeamBag(int teamBag) {
        this.teamBag = teamBag;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    
    
    
    
    
    
}
