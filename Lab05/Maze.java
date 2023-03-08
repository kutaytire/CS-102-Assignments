import java.util.*;

public class Maze
{
   private final int TRIED = 3;
   private final int PATH = 7;

  /* private int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                            {1,0,1,1,1,0,1,1,1,1,0,0,1},
                            {0,0,0,0,1,0,1,0,1,0,1,0,0},
                            {1,1,1,0,1,1,1,0,1,0,1,1,1},
                            {1,0,1,0,0,0,0,1,1,1,0,0,1},
                            {1,0,1,1,1,1,1,1,0,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1} };
*/

    private int [][] grid = {{1,1,0,1,1,1},
                            {0,0,0,0,0,1},
                            {0,0,0,1,0,0},
                            {0,0,0,0,0,0},
                            {1,1,0,0,1,1}};
   //-----------------------------------------------------------------
   //  Attempts to recursively traverse the maze. Inserts special
   //  characters indicating locations that have been tried and that
   //  eventually become part of the solution.
   //-----------------------------------------------------------------
   public boolean traverse (int row, int column, ArrayList<Point> portals)
   {
      boolean done = false;
      //Point portal = new Point(portals.get(index).getX(), portals.get(index).getY());
      
      if (valid (row, column))
      {
         grid[row][column] = TRIED;  // this cell has been tried

         if (row == grid.length-1 && column == grid[0].length-1) {
            done = true;  // the maze is solved
         }

         for (int i = 0; i < portals.size(); i = i + 2) {

            

            if( column == portals.get(i).getX() && row == portals.get(i).getY()) {


                System.out.println("a");

                done = traverse (portals.get(i+1).getY(), portals.get(i+1).getX(), portals);
            }

    

         }

         if(!done) {
            done = traverse (row+1, column, portals);     // down
            if (!done)
               done = traverse (row, column+1, portals);  // right
            if (!done)
               done = traverse (row-1, column, portals);  // up
            if (!done)
               done = traverse (row, column-1, portals);  // left
         }

         if (done)  // this location is part of the final path
            grid[row][column] = PATH;
      }
      
      return done;
   }
   
   //-----------------------------------------------------------------
   //  Determines if a specific location is valid.
   //-----------------------------------------------------------------
   private boolean valid (int row, int column)
   {
      boolean result = false;
 
      // check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[row].length)

         //  check if cell is not blocked and not previously tried
         if (grid[row][column] == 1)
            result = true;

      return result;
   }

   //-----------------------------------------------------------------
   //  Returns the maze as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result = "\n";

      for (int row=0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + "";
         result += "\n";
      }

      return result;
   }
}
