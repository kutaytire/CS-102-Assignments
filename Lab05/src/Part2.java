import java.util.*;

public class Part2 {
    public static void main(String[] args) throws Exception {

        
        Game game1 = new Game("a", 45, 50);
        Game game2 = new Game("a", 10, 85);
        Game game3 = new Game("a", 15, 45);
        Game game4 = new Game("a", 20, 100);
        Game game5 = new Game("a", 25,6);

        ArrayList<Integer> gamelist = new ArrayList<Integer>();
        ArrayList<Integer> maxlist = new ArrayList<Integer>();
        Game game6 = new Game("a", 100, 100);

        Game arr[] = {game1, game2, game3, game4, game5, game6};
        
        /*
        ArrayList<Integer> gamelist = new ArrayList<Integer>();
        ArrayList<Integer> maxlist = new ArrayList<Integer>();

        

        Game game1 = new Game("a", 100, 50);
        Game game2 = new Game("a", 50, 10);
        Game game3 = new Game("a", 60, 45);

        Game arr[] = {game1, game2, game3};
        */

        System.out.println(findMax(arr, 0, 0, 1000, arr.length, gamelist, maxlist));

    }

    public static ArrayList<Integer> findMax(Game arr [], int index, int sumStor, int limit,
    int size, ArrayList<Integer> gamelist, ArrayList<Integer> maxList) {

        int max = 0;
        int sum = 0;

        //System.out.println(gamelist);
        //System.out.println(maxList);

        for (int k = 0; k < maxList.size(); k++) {

            max = max + maxList.get(k);

        }

        for (int m = 0; m < gamelist.size(); m++) {

            sum = sum + gamelist.get(m);

        }
     
        if (sum > max && sumStor <= limit) {

            while (! maxList.isEmpty()) {

                maxList.remove(0);
            }

           for (int i = 0; i < gamelist.size(); i++) {

                maxList.add(gamelist.get(i));
           }

        }

        if (size == index) {

            return maxList;
        }

        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (int i = 0; i < gamelist.size(); i++) {

            newList.add(gamelist.get(i));
       }

        newList.add(arr[index].getScore());

        maxList = findMax(arr, index + 1, sumStor + arr[index].getStorage(), limit, size, newList, maxList );
        maxList = findMax(arr, index + 1, sumStor, limit, size, gamelist, maxList);

        return  maxList;
                

    }
}