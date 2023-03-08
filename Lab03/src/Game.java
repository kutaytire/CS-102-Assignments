import java.util.*;

public class Game implements Difficulty {
    // Properties

    int gameDifficulty;
    int STARTING_DISTANCE = 30;
    Player player;
    ArrayList<EnemyVehicle> enemies;
    EnemyVehicle vehicle;
    Scanner scan;
    int score;
    int missedEnemies;
    final int MAX_NO_OF_PASSING_ENEMIES = 3;
    boolean over;
    GamePlotter plotter = new GamePlotter(this);
    
    Random rand;

    // Constructor

    public Game(int difficulty) {

        gameDifficulty = difficulty;
        player = new Player();
        enemies = new ArrayList<EnemyVehicle>();
        rand = new Random();
        scan = new Scanner(System.in);
        score = 0;
        missedEnemies = 0;
        over = false;

        for ( int i = 0; i < gameDifficulty * 2; i++) {

            boolean chance = rand.nextBoolean();

            if (chance) {

                vehicle = new Tank(0, 5 * gameDifficulty, STARTING_DISTANCE);
            }

            else {

                vehicle = new Helicopter(0, 5 * gameDifficulty, STARTING_DISTANCE);
            }

            enemies.add(vehicle);

        }

    }

    // Methods

    public void setDifficulty(int difficulty) {

        gameDifficulty = difficulty;
    }

    public int getDifficulty() {

        return gameDifficulty;
    }

    public void play() {

        plotter.plot();

        while (missedEnemies < MAX_NO_OF_PASSING_ENEMIES) {

            System.out.println("Please enter the x coordinate to attack: ");
            int x = scan.nextInt();

            System.out.println("Please enter the y coordinate to attack: ");
            int y = scan.nextInt();

            player.attack(x, y, enemies);

            enemiesTurn();

            for (int a = 0; a < enemies.size(); a++) {

                (enemies.get(a)).move();
            }

            enemiesTurn();

            if (missedEnemies >= MAX_NO_OF_PASSING_ENEMIES) {

                break;
            }

            plotter.plot();
            printGameState();
        }

        System.out.println("Your final score: " + score);

        over = true;



    }

    public ArrayList<EnemyVehicle> getEnemies() {

        return enemies;
    }

    public EnemyVehicle getNewRandomVehicle() {

        EnemyVehicle newVehicle;

        int chance = rand.nextInt(1);

        if (chance == 1) {

            newVehicle = new Tank(0, 5 * gameDifficulty, STARTING_DISTANCE);
        }

        else {

            newVehicle = new Helicopter(0, 5 * gameDifficulty, STARTING_DISTANCE);
        }

        return newVehicle;


    }

    private void enemiesTurn() {

        for (int a = 0; a < enemies.size(); a++) {

            if ((enemies.get(a)).isDestroyed() ) {

                score++;
                enemies.remove(a);
                EnemyVehicle newVehicle = getNewRandomVehicle();
                enemies.add(newVehicle);
            }
            else if ((enemies.get(a)).getDistanceToBorder() <= 0) {

                missedEnemies++;
                enemies.remove(a);
                a--;
                EnemyVehicle newVehicle = getNewRandomVehicle();
                enemies.add(newVehicle);

            }
  
        }


    }

    public boolean isGameOver() {

        return over;
    }


    private void printGameState() {

        System.out.println("Your score is: " + score);
        System.out.println("Number of escaped enemies: " + missedEnemies );


        for (int k = 0; k < enemies.size(); k++ ) {

            System.out.println(enemies.get(k));
        }
    }

    
}
