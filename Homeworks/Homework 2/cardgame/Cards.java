package cardgame;
import java.util.Random;

// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author:  Kutay Tire
// date:    20.02.2022
public class Cards
{
    final int NOOFCARDSINFULLPACK = 52;
    
    // properties
    Card[] cards;
    int    valid;  // number of cards currently in collection
    
    // constructors
    public Cards( boolean fullPack)
    {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    
    // methods
    public Card getTopCard()
    {
        Card tmp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned?
            valid++;
            return true;
        }
        return false;
    }
    
    private void createFullPackOfCards()
    {
        // Todo
        for ( int i = 0; i < 52; i++) {
            
            addTopCard( new Card(i) );
        }
    }
    
    /*
        This method shuffles the cards with a simple swap algorithm.
        For each card, it assigns a random index in the deck.
    */
    public void shuffle()
    {
        // Todo
        Card ca;
        Random shuffle = new Random();
        for ( int i = 0; i < cards.length; i++ ) {
            int index = shuffle.nextInt(cards.length);
            ca = cards[i];
            cards[i] = cards[index];
            cards[index] = ca;
        }
    }
    
    /*
    // For testOnly... remove from production version!
    public void testOnlyPrint()
    {
        for ( int i =0; i < valid; i++)
        {
            System.out.println( cards[i] );
        }
    }
    */
    
} // end class Cards
