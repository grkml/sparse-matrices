package sparse_matrix;

import abstract_data_type.FHarrayList;
import abstract_data_type.FHlinkedList;

import java.util.ListIterator;

public class SparseMat<E>
{
   protected int numRows, numCols;
   protected E defaultVal;
   protected FHarrayList<FHlinkedList<MatNode>> rows;

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

   // constructor
   public SparseMat(int numRows, int numCols, E defaultVal)
   {
      this.numRows = numRows;
      this.numCols = numCols;
      this.defaultVal = defaultVal;
      allocateEmptyMatrix();
   }

   private void allocateEmptyMatrix()
   {
      rows = new FHarrayList<FHlinkedList<MatNode>>();
      for (int r = 0; r < numRows; r++)
      {
         rows.add(new FHlinkedList<MatNode>());
      }
   }

   E get(int r, int c)
   {
      for (int i = 0; i < rows.get(r).size(); i++)
      {
         MatNode node = rows.get(r).listIterator().next();
         if (node.col == c)
            return node.data;
      }
      return defaultVal;
   }

   boolean set(int r, int c, E x)
   {
      return rows.get(r).add(new MatNode(c, x));
   }

   void clear()
   {
      for (int r = 0; r < numRows; r++)
         rows.get(r).clear();
   }

//   void showSubSquare(int start, int size)
//   {
//   }
}
