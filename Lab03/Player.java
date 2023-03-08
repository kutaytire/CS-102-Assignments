import java.util.ArrayList;

public class Player {
    //Properties

    final double BOMB_RADIUS = 2.0;
    final double DAMAGE = 50.0;

    // Constructor

    public Player() {

    }

    // metods 

    void attack(int x, int y, ArrayList<EnemyVehicle> enemies) {

        for ( int a = 0; a < enemies.size(); a++) {

            double checkX = Math.pow(enemies.get(a).xCoordinate - x, 2);
            double checkY = Math.pow(enemies.get(a).yCoordinate - y, 2);

            if (checkX + checkY <  BOMB_RADIUS ) {

                (enemies.get(a)).takeDamage(DAMAGE);
            }


        }


    }
    
}
