import java.util.Random;
import java.awt.*;

public abstract class EnemyVehicle implements Movable, Destructible {

    // Properties

    final int BASE_SPEED = 3;
    public int xCoordinate;
    public int yCoordinate;
    public double health = 100;

    // Constructor

    public EnemyVehicle(int minX, int maxX, int y) {

        yCoordinate = y;

        Random rand = new Random();
        xCoordinate = rand.nextInt((maxX - minX) + 1) + minX;

    }

    int getDistanceToBorder() {

        return yCoordinate;
    }

    abstract String getType();

    public void move() {

        yCoordinate = yCoordinate - BASE_SPEED;


    }

    public Point getLocation() {

        return new Point( xCoordinate, yCoordinate);
    }

    public boolean isDestroyed() {

        return health <= 0;
    }

    public void takeDamage (double damage) {


        health = health - damage;
    }

    
}
