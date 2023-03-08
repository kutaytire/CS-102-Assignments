
public class Hangman 
{

    
    public StringBuffer secretWord;
    private StringBuffer allLetters;
    private StringBuffer usedLetters;
    private int numOfIncorrectTries;
    private final int maxAllowedIncorrectTries = 6;
    private StringBuffer knownSoFar;

    //Constructor
    
    public Hangman() {

        //the method will initialize the variable secretWord
    
        secretWord = new StringBuffer("");

        // added secret word
        secretWord.append(chooseSecretWord());
        allLetters = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUWXYZ");
        usedLetters = new StringBuffer(" ");
        knownSoFar = new StringBuffer("");

        numOfIncorrectTries = 0;
        
        //Adds asterix character in place of all characters of the choosen secretWord.
        
        for( int i = 0; i < secretWord.length(); i++){
            knownSoFar.append("*");
        }

        // Initialization of StringBuffer 
        // Added number of Incorrect Tries
        
       
    }

     /** This method takes a char as a parameter and returns 
     * the number of occcurences of the letters in secretWord
     * updates the knownSoFar variable
     * updates numberOfIncorrectTries variable
     * updates usedLetters variable
     * updates allLetter variable **/

    public int tryThis(char inputChar)
    {
        //Variables
        int count = 0;

    
        // replaced contains method
        if( !Character.isLetter( inputChar ))
        {
            count = -1;
            return count;
        }

        else if ( usedLetters.indexOf(String.valueOf(inputChar)) != -1) {
            
            count = -2;
        }

        else if ( isGameOver() ) {
            
            count = -3;
        }
        else
        {

            this.usedLetters.append(inputChar);

            // deleted the part which deletes from all letters, instead addded a part to check if the word is reused

            //This loop is to see if the input letter is contained by the secretWord
            for(int i = 0; i < this.secretWord.length(); i++)
            {
                if(secretWord.toString().toUpperCase().charAt(i) == inputChar)
                {

                    //If the input letter is a correct guess count will be increased and knownSoFar will be updated accordingly
                    this.knownSoFar.setCharAt(i, inputChar);
                    count++;
                } 
            }

            //If the input letter is not contained by the secretWord count that guess as incorrect
            if(count == 0)
            {
                numOfIncorrectTries++;
                // have to use it as a variable 
            }
        }
        return count;
    }

    // used math rand instead of usinf the class Random
    public String chooseSecretWord() { 
        
        // made the small 
        String[] words = { "embareassment","fluorescent", "accomodate","psychiatrist",
        "questionnaire","necessary","mischevious","occasionally","pneumonia","restaurant",
        "millenium","ridiculous","phenomenon", "sixth","rural", "colonel", "ironic","irregardless",
        "lieutenant", "didactic", "february","behaviour", "development" }; // Some random words
        int index;
        String chosenWord;
        
        // Assigns random index in the range of the array
        index = (int) ( Math.random() * words.length ) ;
        
        // Gets the word from the array at that index and returns it.
        chosenWord = words[index];
        
        return chosenWord;
    }

    public StringBuffer getSecretWord(){

        return secretWord;
    }
    public String getKnownSoFar(){

        return knownSoFar.toString();

        // converted to a string
    }
    public String getUsedLetters(){

        return usedLetters.toString();

        //converted to a string
    }
    public String getAllLetters(){

        return allLetters.toString();
    }
    public int getNumOfIncorrectTries(){

        return numOfIncorrectTries;
    }
    public int getMaxAllowedIncorrectTries(){
        return maxAllowedIncorrectTries;
    }
   
    // removed set secret words vs. methods

    public boolean hasLost(){

        return numOfIncorrectTries == maxAllowedIncorrectTries;
    }

    public boolean isGameOver(){
        if(hasLost() == true ||secretWord.toString().toUpperCase().equals( getKnownSoFar() )){
            return true;
        }
        else{
            return false;
        }
    }
}