package sparse_matrix;

import abstract_data_type.FHarrayList;
import abstract_data_type.FHlinkedList;

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
         for (int c = 0; c < numCols; c++)
            rows.get(r).push(new MatNode(c, defaultVal));
            //rows.get(r).set(c, new MatNode(c, defaultVal));
            //rows.get(r).set(new MatNode(c, defaultVal));
      }
   }

   E get(int r, int c)
   {
      return rows.get(r).get(c).data;
   }

   boolean set(int r, int c, E x)
   {
      try { rows.get(r).set(c, new MatNode(c, x)); }
      catch (Exception e) { return false; }
      return true;
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
