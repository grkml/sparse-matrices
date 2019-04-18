package sparse_matrix;

import abstract_data_type.FHarrayList;
import abstract_data_type.FHlinkedList;

public class SparseMat<E>
{
   protected int numRows, numCols;
   protected E defaultVal;
   protected FHarrayList<FHlinkedList<MatNode>> rowVectors;

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
      // allocate rows
      rowVectors = new FHarrayList<FHlinkedList<MatNode>>(numRows);
      for (int rowVectorIndex = 0; rowVectorIndex < numRows; rowVectorIndex++)
      {
         FHlinkedList<MatNode> nodesInRowVector = new FHlinkedList<MatNode>();

         // allocate nodes in each row
         for (int colNum = 0; colNum < numCols; colNum++)
         {
            MatNode node = new MatNode(colNum, defaultVal);
            nodesInRowVector.add(node);
         }
         rowVectors.add(rowVectorIndex, nodesInRowVector);
      }
   }

   E get(int r, int c)
   {
      return rowVectors.get(r).get(c).data;
   }

   boolean set(int r, int c, E x)
   {
      try { rowVectors.get(r).get(c).data = x; }
      catch (Exception e) { return false; }
      return true;
   }

   void clear()
   {
      for (int rowVectorIndex = 0; rowVectorIndex < numRows; rowVectorIndex++)
         rowVectors.get(rowVectorIndex).clear();
   }

//   void showSubSquare(int start, int size)
//   {
//   }

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
}
