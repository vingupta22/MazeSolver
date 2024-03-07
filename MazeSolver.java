import java.util.*;

public abstract class MazeSolver
{
   private Maze m;
   private boolean solved;
   
   public MazeSolver(Maze maze)
   {
      m = maze;
      makeEmpty();
      add(maze.getStart());
   }
   
   public abstract void makeEmpty();
   public abstract boolean isEmpty();
   public abstract void add(Square s);
   public abstract Square next();
   
   public String getPath()
   {
      if(solved == false && isEmpty() == true) return ("unsolvable");
      else if(solved == true) return ("solved");
      else return ("not yet solved");
   }
   
   public boolean isSolved()
   {
      return solved;
   }
   
   public void step()
   {
      Square next = next();
      if(isEmpty()) 
      {
         System.out.print("not solvable"); 
         
      }
      else if(next.getType() == Square.EXIT)
      {
        solved = true;
        next.setStatus('.');
        return;
      }
      else
      {
         
         List<Square> neigh = m.getNeighbors(next);
         for(int i = 0; i < neigh.size(); i++)
         {
            if(neigh.get(i).getStatus() != 'o' && neigh.get(i).getStatus() != '.' && neigh.get(i).getType() != Square.WALL)
            {
                add(neigh.get(i));
                neigh.get(i).setStatus('o');
            }
         }
         next.setStatus('.');
      }
     }
        
     
     
     
   
   public void solve()
    {
      while(!(isSolved())) step();
    }

}

