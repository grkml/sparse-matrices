package sparse_matrix;

import abstract_data_type.*;

public class App
{
   final static int MAT_SIZE = 10;

   public static void main(String[] args) throws Exception
   {
      // 100000 x 100000 filled with 0
      int k;
      SparseMat<Integer> mat
            = new SparseMat<Integer>(MAT_SIZE, MAT_SIZE, 0);
            
            
      mat.set(5,5, 50);
      mat.set(5,9, 50);
      mat.set(7,5, 50);
      mat.set(9,5, 50);
      mat.set(0,0, 50);
      
      mat.showSubSquare(0,10);















      // mat.showMatrix();

      // test mutators
//      for (k = 0; k < 10; k++)
//      {
//         mat.set(k, k, k*1.);
//         mat.set(4, k, k*10.);
//         mat.set(k, 4, -k*10.);
//      }
//      mat.showSubSquare(0, 12);
//      System.out.println();
//
//      SparseMat<Double> mat2 = (SparseMat<Double>)mat.clone();
//
//      for (k = 0; k < 10; k++)
//      {
//         mat.set(k, k, 1.);
//         mat.set(4, k, 10.);
//         mat.set(k, 4, -10.);
//      }
//
//      mat.showSubSquare(0, 12);
//      System.out.println();
//      mat2.showSubSquare(0, 12);
   }
}
