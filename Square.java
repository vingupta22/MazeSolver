public class Square
{
   public static final int EMPTY = 0;
   public static final int WALL = 1;
   public static final int START = 2;
   public static final int EXIT = 3;
   private int type;
   private int row, col;
   private char status;
   private Square previous;
   
   public Square(int row, int col, int type)
   {
      this.row = row;
      this.col = col;
      this.type  = type;
      previous = null;
   }
   
   public String toString()
   {
       if(type == 0) return "" + status;
       if(type == 1) return "#";
       if(type == 2) return "S";
       else return "E";
   }
   
   public boolean equals(Object obj)
   {
       Square temp = (Square) obj;
       return temp.getRow() == row && temp.getCol() == col;
   }
   
   public int getRow()
   {
      return row;
   }
   
   public int getCol()
   {
      return col;
   }
   
   public int getType()
   {
      return type;
   }
   
   public char getStatus()
   {
      return status;
   }
   
   public void setStatus(char c)
   {
      status = c;
   }
   
   public void reset()
   {
      status = '_';
      previous = null;
   }
   
   public Square getPrevious()
   {
      return previous;
   }
   
   public void setPrevious(Square s)
   {
      previous = s;
   }
}