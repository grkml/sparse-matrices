package sparse_matrix;

import abstract_data_type.FHarrayList;
import abstract_data_type.FHlinkedList;

import java.util.ListIterator;
import java.util.Collections;
import java.util.Comparator;

public class SparseMat<E>
{
   private int numRows, numCols;
   private E defaultVal;
   private FHarrayList<FHlinkedList<MatNode>> rows;
   
   protected class MatNode implements Cloneable
   {
      public int col;
      public E data;

      // we need a default constructor for lists
      MatNode()
      {
         col = 0;
         data = null;
      }

      MatNode(int cl, E dt)
      {
         col = cl;
         data = dt;
      }

      public Object clone() throws CloneNotSupportedException
      {
         // shallow copy
         MatNode newObject = (MatNode)super.clone();
         return (Object) newObject;
      }
   }
   
   // constructor
   public SparseMat(int numRows, int numCols, E defaultVal) 
         throws IllegalArgumentException
   {
      if (numRows < 1 || numCols < 1)
         throw new IllegalArgumentException("invalid matrix dimensions");
      this.numRows = numRows;
      this.numCols = numCols;
      this.defaultVal = defaultVal;
      allocateEmptyMatrix();
   }
   
   private void allocateEmptyMatrix()
   {
      rows = new FHarrayList<FHlinkedList<MatNode>>();
      for (int i = 0; i < numRows; i++)
         rows.add(new FHlinkedList<MatNode>());
   }

   E get(int r, int c) throws IndexOutOfBoundsException
   {
      if (r > numRows -1 || r < 0 || c > numCols - 1 || c < 0)
         throw new IndexOutOfBoundsException("invalid matrix indices");
         
      // iterate through list and node at column c
      ListIterator<MatNode> rowIterator = rows.get(r).listIterator();
      MatNode nextNode;
      while (rowIterator.hasNext())
      {
         nextNode = rowIterator.next();
         if (nextNode.col == c)
            return nextNode.data;
      }
      return defaultVal;
   }

   boolean set(int r, int c, E x)
   {
      if (r > numRows -1 || r < 0 || c > numCols - 1 || c < 0)
         return false;
      
      // keep matrix sparse without defaultVal
      if (x == defaultVal)
         return true;
      
      // add new node to empty list
      FHlinkedList<MatNode> row = rows.get(r);
      if (row.size() == 0)
         return row.add(new MatNode(c, x));
      
      // iterate through existing list to keep it sorted
      ListIterator<MatNode> rowIterator = row.listIterator();
      int nextNodeCol;
      while (rowIterator.hasNext())
      {
         nextNodeCol = rowIterator.next().col;
         if (c == nextNodeCol)
         {
            try
            { 
               // overwrite pre-existing node
               rowIterator.set(new MatNode(c, x)); 
               return true;
            }
            catch (Exception e)
            { 
               System.out.println(e);
               return false; 
            }
         }
         else if (c < nextNodeCol)
         {
            try
            {
               // add new node before next()
               rowIterator.add(new MatNode(c, x));
               return true;
            }
            catch (Exception e)
            { 
               return false; 
            }
         }
      }
      
      // add new node at the end if not added yet
      return row.add(new MatNode(c, x)); // Add new new at the end;
   }
   
   void clear()
   {
      for (int i = 0; i < numRows; i++)
         rows.get(i).clear();
   }
   
   void showSubSquare(int start, int size) throws IllegalArgumentException
   {
      if (start < 0 || size < 0 
            || start + size > numCols || start + size > numRows)
         throw new IllegalArgumentException("invalid subSquare dimensions");
         
      int i, j;
      
      for (i = start; i < start + size; i++)
      {
         for(j = start; j < start + size; j++)
         {
            System.out.print(get(i, j).toString() + "    ");
         }
         System.out.print("\n");
      }
   }
}