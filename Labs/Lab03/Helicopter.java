public class Helicopter extends EnemyVehicle {

    // Properties

    int speed = 3;

    // Constructor

    Helicopter(int minX, int maxX, int y) {

        super(minX, maxX, y);
    }

    public String getType() {

        return "Helicopter";
    }

    public String toString() {

        String result = "A Helicopter is at location (" + xCoordinate + "," + yCoordinate + "). Its speed modifier is " + speed + "  It has " + health + " points left.";
        return result;
    }

    public void move() {

        yCoordinate = yCoordinate - speed;
        speed++;

    }

    
}
