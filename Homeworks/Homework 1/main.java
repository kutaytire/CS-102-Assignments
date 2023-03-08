import java.util.Scanner;
public class main {
        public static void main (String[] args) {
           
        // Variables
        char guessedLetter;

        // added num 
        int numOfLetter = 0;
        Scanner in = new Scanner(System.in);
        Hangman hangman = new Hangman();

        // Main

        while(!hangman.isGameOver()){  

            System.out.println("The word so far: "+ (hangman.getKnownSoFar())); 
            System.out.println("Remaining attempts: "+ ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries() ));
            System.out.println("Used letters: " + hangman.getUsedLetters());
            System.out.print("Guess a letter: ");
            guessedLetter = in.next().toUpperCase().charAt( 0 );
            System.out.println(); 

            numOfLetter = hangman.tryThis(guessedLetter);        

            if ( numOfLetter == 0 ) {
                System.out.println( "You have guessed wrong." );
                System.out.println( "You have " + ( hangman.getMaxAllowedIncorrectTries() - hangman.getNumOfIncorrectTries() ) + " tries left." );
            }
            
            else if ( numOfLetter == -1 ) {
                
                // Prints an error message if an invalid character is entered.
                System.out.println("You have entered an invalid character, try again.");
            }
            
            else if ( numOfLetter == -2 ) {
                
                // Prints an error message if the user already used a character twice.
                System.out.println("You have already entered this character, try again.");
            }
            
            else {
                System.out.println( "'" + guessedLetter + "' has been found " + numOfLetter + " times." );
            }
            System.out.println(); 

            
        }
        if(hangman.hasLost()){
            System.out.println("SORRY! YOU HAVE LOST!");
            System.out.println( "Your attempt: " + hangman.getKnownSoFar() );
            System.out.println( "The word was: " + hangman.secretWord.toString().toUpperCase());
        }
        else {
            System.out.println("YOU WIN!");
            System.out.println ( "The word was: " + hangman.getKnownSoFar() );
        }

    }
    
}


