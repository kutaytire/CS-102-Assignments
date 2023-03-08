
import java.util.Random;

public class Tank extends EnemyVehicle {

    Random rand;

    // Constructor

    Tank(int minX, int maxX, int y) {

        super(minX, maxX, y);
    }

    public String getType() {

        return "Tank";
    }

    public String toString() {

        String result = "A Tank is at location (" + xCoordinate + "," + yCoordinate + "). It has " + health + " points left.";
        return result;
        
    }

    public void takeDamage( double damage) {

        rand = new Random();
        double deflection = rand.nextInt((int) damage/2);

        health = health - damage + deflection;
    }

    
}
