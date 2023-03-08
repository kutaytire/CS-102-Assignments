package cardgame;

import java.util.ArrayList;
// Cardgame
// author: Kutay Tire
// date: 20.02.2022
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        // ToDo

        players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        
        scoreCard = new ScoreCard(players.size());
        
        // Creates a fullPack and shuffles it.
        fullPack = new Cards(true);
        fullPack.shuffle();
        
        // Deals the cards between the players.
        for ( int  k = 0; k < 52; k++) {
                
            if ( k / 13 == 0  ) {
                p1.add(fullPack.getTopCard());
            }
            else if ( k / 13 == 1) {
                p2.add(fullPack.getTopCard());
            }
            else if ( k / 13 == 2) {
                p3.add(fullPack.getTopCard());
            }
            else if ( k / 13 == 3) {
                p4.add(fullPack.getTopCard());
            }
        }
        
        
        cardsOnTable = new Cards[players.size()];    
        
        // Creates empty piles for the players.
        Cards pileOne = new Cards(false);
        Cards pileTwo = new Cards(false);
        Cards pileThree = new Cards(false);
        Cards pileFour = new Cards(false);

        cardsOnTable[0] = pileOne;
        cardsOnTable[1] = pileTwo;
        cardsOnTable[2] = pileThree;
        cardsOnTable[3] = pileFour;
    }
    
    // methods
    public boolean playTurn( Player p, Card c)
    {
        // Todo
        int number = players.indexOf(p);
    
        if ( !isTurnOf(p) || isGameOver()  ) { 
            return false;
        }
        else {
        
            cardsOnTable[number].addTopCard( c);
    
                if ( !isGameOver() ) {

                    turnOfPlayer = turnOfPlayer + 1;
                    if ( turnOfPlayer == 4) {
                
                        turnOfPlayer = 0;
                        roundNo++;
                        updateScore();
                    }
                }
            }
            return true;
    }

    
    public boolean isTurnOf( Player p)
    {
        // ToDo
        int number = players.indexOf(p);
        
        if ( number == turnOfPlayer ) {
            
            return true;
        }
        else {
            
            return false;
        }
    }
    
    public boolean isGameOver()
    {
        // ToDo
        // İf last player plays at last round, ends the game
        if ( roundNo == 13 && turnOfPlayer == 0 ) {
            
            return true;
        }  
        else {
            
            return false;
        } 
    }
    
    public int getScore( int playerNumber)
    {
        // ToDo
        return scoreCard.getScore( playerNumber);
    }
    
    public String getName( int playerNumber)
    {
        // ToDo
        return players.get(playerNumber).getName();
    }
    
    public int getRoundNo()
    {
        // ToDo
        return roundNo;
    }
    
    public int getTurnOfPlayerNo()
    {
        // ToDo
        return turnOfPlayer;
    }
    
    public Player[] getWinners()
    {
        // ToDo
        int [] winners= scoreCard.getWinners(); 
       
       
        Player[] winnerPlayers = new Player[winners.length];

        for (int k = 0; k < winners.length; k++) {
            
            winnerPlayers[k] =  players.get(winners[k]);
        }
        return winnerPlayers;
    }

    /**
     * This method shows the winners with their names.
     * @return String winners
     */
    public String showWinners()
    {
        String winnerNames = "";
        Player[] winners = getWinners();
        for (int p = 0; p < winners.length; p++) {
             
            winnerNames = winnerNames + winners[p].getName() +  " ";
        } 
        return winnerNames;
    }  
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }

     /**
     * This method updates the scores at the end of every round.
     */
    public void updateScore() 
    {  
       
        int max = 0;
        Card[] cardsPile = new Card[players.size()];

        System.out.println();
        System.out.println("Played cards this round are: ");
        
        for ( int k = 0; k < players.size(); k++ ) {
          
            cardsPile[k]= cardsOnTable[k].getTopCard();

            System.out.println(cardsPile[k]);
            
            if (cardsPile[k].getFaceValue() > max ) {
                    
                max = cardsPile[k].getFaceValue();
            }
        }
        for ( int a = 0; a < players.size(); a++ ) {
            
            if ( cardsPile[a].getFaceValue() == max ) {
                scoreCard.update(a,1);
                
            }
        }
           
    }
    
    public ScoreCard getScoreCard() {

        return scoreCard;
    }
}