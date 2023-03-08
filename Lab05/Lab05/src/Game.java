
public class Game {

    // Properties

    private int score;
    private int storage;
    private String name;

    // Constructor

    public Game(String name, int storage, int score) {

        this.score = score;
        this.storage = storage;
        this.name = name;
    }
    
    // Methods

    public int getScore() {

        return score;
    }

    public String getName() {

        return name;
    }

    public int getStorage() {

        return storage;
    }
    
}
