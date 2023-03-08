import java.util.ArrayList;

//********************************************************************
//  MazeSearch.java       Author: Lewis/Loftus
//
//  Demonstrates recursion.
//********************************************************************

public class MazeSearch
{
   //-----------------------------------------------------------------
   //  Creates a new maze, prints its original form, attempts to
   //  solve it, and prints out its final form.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      Maze labyrinth = new Maze();
      Point point1 = new Point(1,0);
      Point point2 = new Point(3,0);

      Point point3 = new Point(5,1);
      Point point4 = new Point(0,4);

      Point point5 = new Point(1,4);
      Point point6 = new Point(4,4);
      
      System.out.println (labyrinth);
      ArrayList<Point> portals = new ArrayList<Point>(); 

      portals.add(point1);
      portals.add(point2);
      portals.add(point3);
      portals.add(point4);
      portals.add(point5);
      portals.add(point6);

      if (labyrinth.traverse (0, 0, portals))
         System.out.println ("The maze was successfully traversed!");
      else
         System.out.println ("There is no possible path.");

      System.out.println (labyrinth);
   }
}
