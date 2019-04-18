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
      if (r > numRows -1 || r < 1 || c > numCols - 1 || c < 1)
         throw new IndexOutOfBoundsException("invalid matrix indices");
      for (int i = 0; i < rows.get(r).size(); i++)
      {
         MatNode testNode = rows.get(r).listIterator().next();
         if (testNode.col == c)
            return testNode.data;
      }
      return defaultVal;
   }

   boolean set(int r, int c, E x)
   {
      if (r > numRows -1 || r < 1 || c > numCols - 1 || c < 1)
         return false;
      
      FHlinkedList<MatNode> row = rows.get(r);
      
      // remove old data
      E oldData = get(r, c);
      if (oldData != null)
         row.remove(new MatNode(c, oldData));
      
      // add new data
      if (x == defaultVal)
         return true;
      return rows.get(r).add(new MatNode(c, x));
   }

   void clear()
   {
      for (int i = 0; i < numRows; i++)
         rows.get(i).clear();
   }

   // void showSubSquare(int start, int size) throws IllegalArgumentException
   // {
   //    // if (start < 1 || size < 1 
   //    //       || start + size > numCols - 1 || start + size > numRows -1)
   //    //    throw new IllegalArgumentException("invalid subSquare dimensions");

   //    sortRow(row);
   //    StringBuilder rowString = new StringBuilder();
      
   //    for (int i = 0; i <numCols; i++)
   //    {
   //       MatNode testNode = row.listIterator().next();
   //       if (testNode.col == i)
   //          rowString.append("  " + testNode.data.toString() +"  ");
   //       else
   //          rowString.append("  " + defaultVal.toString() +"  ");
   //    }
   // }
   
   
   
   
   
   
   
   void showMatrix()
   {
      StringBuilder rowString = new StringBuilder();
      for (int i = 0; i < rows.size(); i++)
      {
         FHlinkedList<MatNode> row = rows.get(i);
         sortRow(row);
         
        // rowString.setLength(0);
         
         for (int j = 0; j < numCols; j++)
         {
            while(row.listIterator().hasNext()) 
            {
               MatNode nextNode = row.listIterator().next();
               for (int k = j; k < nextNode.col + 1; k++)
                  System.out.print("  " + defaultVal.toString() +"  ");
               System.out.print("  " + nextNode.data.toString() +"  ");
            }
            System.out.print("  " + defaultVal.toString() + "  ");
         }
         
         System.out.println("\n");
      }
   }
   
   public void sortRow(FHlinkedList<MatNode> row)
   {
      Collections.sort(row, new MatNodeComparator());
   }
   
   
   
   
   
   
   
   
   
   
   
   // public static void printRow(FHlinkedList<MatNode> row, int numCols)
   // {
   //    sortRow(row);
   //    StringBuilder rowString = new StringBuilder();
      
   //    for (int i = 0; i <numCols; i++)
   //    {
   //       MatNode testNode = row.listIterator().next();
   //       if (testNode.col == i)
   //          rowString.append("  " + testNode.data.toString() +"  ");
   //       else
   //          rowString.append("  " + defaultVal.toString() +"  ");
   //    }
      
   //    System.out.println(rowString.toString());
   // }
      
   
   


   // protected enables us to safely make col/data public
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
   
   class MatNodeComparator implements Comparator<MatNode>
   {
      @Override
      public int compare(MatNode node1, MatNode node2) 
      {
         if(node1.col < node2.col)
            return 1;
         return -1;
      }
   }
}
