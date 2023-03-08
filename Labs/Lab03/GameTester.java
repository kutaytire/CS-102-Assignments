import java.util.*;

public class GameTester {

    public static void main( String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter the difficulty: ");
        int dif = scan.nextInt();

        Game game = new Game(dif);
        EnemyVehicle veh = new Tank(5, 10, 15);
        veh.takeDamage((56));

        game.play();

        
        
        scan.close();
    }
    
}
