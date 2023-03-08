package cardgame;
import java.util.*;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author: Kutay Tire
// date:    20.02.2022
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    public int[] getWinners()
    {
        // ToDo
        int highest = -1;
        int count;
        count = 0;    
        ArrayList<Integer> winner =  new ArrayList<Integer>();
        
        
        for ( int i = 0; i < scores.length ; i++) {
            
            if ( scores[i] >= highest ) {
                
                highest = scores[i];
                
            }
        }
      
        for ( int i = 0; i <scores.length; i++) {
            
            if ( scores[i] == highest ) {
                
                count = count + 1;
                winner.add(i);
            }
            
            
        }
        
        int[] winners = new int[winner.size()];
     
        
        for ( int k = 0; k < count; k ++) {
            
            winners[k] = winner.get(k);
        }
       
        
        return winners;
    }
    
    
} // end class ScoreCard
