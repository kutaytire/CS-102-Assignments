package cardgame;

// Player - Simple card game player with name and hand of cards
// author: Kutay Tire
// date:    20.02.2022
public class Player
{
    // properties
    String name;
    public Cards hand;
    
    // constructors
    public Player( String name)
    {
        // ToDo
        this.name = name;
        
        // Creates empty set of cards for player.
       
        hand = new Cards(false);
    }
    
    // methods
    public String getName()
    {
        return name;
    }
    
    public void add( Card c)
    {
        // ToDo
        hand.addTopCard(c);
    }
    
    public Card playCard()
    {
        // ToDo
        return hand.getTopCard();
    }
    
} // end class Player
