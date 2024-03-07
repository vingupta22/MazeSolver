import java.io.*;
import java.util.*;
public class Maze
{
   
   private static Square[][] maze;
   private static Square start;
   private static Square end;
   
   public Maze()
   {

   }
   
   public static boolean loadMaze(String fileName)
   {
      Scanner input = null;
      try {
         input = new Scanner(new File(fileName));
         int rows = input.nextInt();
         int cols = input.nextInt();
         maze = new Square[rows][cols];
         
         while(input.hasNextInt())
         {
         for(int r = 0; r < rows; r++)
         {
         for(int c = 0; c < cols; c++)
         {
            maze[r][c] = new Square(r, c, input.nextInt());
            if(maze[r][c].getType() == Square.START) start = maze[r][c];
            if(maze[r][c].getType() == Square.EXIT) end = maze[r][c];
         }
        }
        }

      }
      catch(IOException e) {
         System.out.print("Error!");
         return false;
      }
      return true;
   }
   
   public static List<Square> getNeighbors(Square s)
   { 
      ArrayList<Square> n = new ArrayList<Square>();
      if(s.getRow() != 0) n.add(maze[s.getRow()-1][s.getCol()]);
      if(s.getCol() < maze[0].length-1) n.add(maze[s.getRow()][s.getCol()+1]);
      if(s.getRow() < maze.length-1) n.add(maze[s.getRow()+1][s.getCol()]);
      if(s.getCol() != 0) n.add(maze[s.getRow()][s.getCol()-1]);
      return n;
   } 
   //wrong use instance variable and return
   public static Square getStart()
   {
      return start;
   }
   //wrong as well
   public static Square getExit()
   {
      return end;
   }
   
   public static void reset()
   {
      for(int r = 0; r < maze.length; r++)
      {
         for(int c = 0; c < maze[0].length; c++)
         {
            maze[r][c].reset();
         }
      }
   }
   
   public String toString()
   {
      String ret = "";
      for(int r = 0; r < maze.length; r++)
      {
         for(int c = 0; c < maze[0].length; c++)
         {
            ret += maze[r][c].toString() + " ";
         }
         ret += "\n";
      }
      return ret;
   }
}