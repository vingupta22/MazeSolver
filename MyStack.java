import java.util.EmptyStackException;

public class MyStack
{
   private Square[] stack;
   private int size;       
   public MyStack()
   {
      stack = new Square[10];
      size = 0;
   }
    
   public MyStack(int initCap)
   {
      stack = new Square[initCap];
      size = 0;
   }
    
   public boolean isEmpty()
   {
      if(size == 0) 
         return true;
      return false;
   }
    
   public Square peek()
   {
      if(size <= 0) 
         throw new EmptyStackException();
      else
         return stack[size-1];
   }
    
   public Square pop()
   {
      if(size <= 0) 
         throw new EmptyStackException();
      else 
      {
         Square i = stack[size-1];
         size--;
         return i;
      }
   }
    
   public void push(Square item)
   {
      if(size+1 >= stack.length)
      {
         doubleCapacity();
         stack[size] = item;
         size++;
      } 
      else{
         stack[size] = item;
         size++;
      }
      
   }
    
   private void doubleCapacity()
   {
      Square[] temp = new Square[stack.length*2];
      for(int i = 0; i < size; i++)
      {
         temp[i] = stack[i];
      }
      stack = temp;
      
   }
    
   public String toString()
   {
      String ret = "";
      for(int i = 0; i < size; i++)
      {
         ret+= (stack[i] + ", ");
      }
      return ret.substring(0, ret.length()-2);
   }
   
   
}