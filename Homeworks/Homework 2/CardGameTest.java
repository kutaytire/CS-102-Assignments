import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: Kutay Tire
// date: 20.02.2022
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        CardGame   game;
        Player     p , p1, p2, p3 , p4;
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card( 1);
        System.out.println( c);
        System.out.println();
        
        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);

        //cards.testOnlyPrint();  // remove method after testing!
        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class
        // ToDo

        p = new Player("Kutay");
        System.out.println(p.getName());
        p.add(c);
        p.playCard();
        
        // test CardGame class too?
        // Todo

        p1 = new Player("Jack");
        p2 = new Player("Joe");
        p3 = new Player("Anna");
        p4 = new Player("Elizabeth");
        game = new CardGame( p1, p2, p3, p4 );
        
        
        game.playTurn(p4 , c);
        game.isTurnOf(p2);
        game.isGameOver();
        game.getScore(2);
        game.getName(3);
        game.getRoundNo();
        game.getTurnOfPlayerNo();
        game.getWinners();
        game.showScoreCard();
        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        System.out.println( "\nEnd of CardGameTest\n" );
        scan.close();
    }
    
} // end of class CardGameTest
