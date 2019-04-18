package sparse_matrix;

import abstract_data_type.*;

public class App
{
   final static int MAT_SIZE = 1000000;

   public static void main(String[] args) throws Exception
   {
      // 100000 x 100000 filled with 0
      int k;
      SparseMat<Double> mat
            = new SparseMat<Double>(MAT_SIZE, MAT_SIZE, 0.);

      mat.set(5,6, 56.0);
      mat.set(4,5, 45.0);
      mat.set(10,11, 9911.00);
      mat.set(999999,999999, 9911.00);

      System.out.println(mat.get(5,6));
      System.out.println(mat.get(4,5));
      System.out.println(mat.get(9,1));
      System.out.println(mat.get(999999,999999));


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
