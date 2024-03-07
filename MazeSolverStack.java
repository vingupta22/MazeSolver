public class MazeSolverStack extends MazeSolver
{
  private MyStack worklist;
  public MazeSolverStack(Maze maze)
  {
     super(maze);
     worklist.push(maze.getStart());
  }
  
  @Override
  public void makeEmpty()
  {
     worklist = new MyStack();
     
  }
  
  @Override
  public boolean isEmpty()
  {
     if(worklist.isEmpty()) return true;
     return false;
  }
  
  @Override
  public void add(Square s)
  {
     worklist.push(s);
  }
  
  @Override
  public Square next()
  {
     return worklist.pop();
  }
  
  
} 



