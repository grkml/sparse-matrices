package sparse_matrix;

import abstract_data_type.*;

public class App
{
   final static int MAT_SIZE = 1000000;

   public static void main(String[] args) throws Exception
   {
      int k;
      SparseMat<Double> mat
            = new SparseMat<Double>(MAT_SIZE, MAT_SIZE, 0.);
            
      System.out.println("testing set() -------------------------------------");
      for (k = 0; k < 10; k++)
      {
         System.out.println(">> mat.set(" + k + ", " + k + ", " + k*1. + ")\n"
               + mat.set(k, k, k*1.));
         System.out.println(">> mat.set(" + 4 + ", " + k + ", " + k*10. + ")\n" 
               + mat.set(4, k, k*10.));
         System.out.println(">> mat.set(" + k + ", " + 4 + ", " + -k*10. + ")\n" 
               + mat.set(k, 4, -k*10.));
      }
      System.out.println(">> mat.set(MAT_SIZE, MAT_SIZE, " + 1. + ")\n" 
               + mat.set(MAT_SIZE, MAT_SIZE, 1.)); // expect false
      System.out.println();
      
      System.out.println("print upper left ----------------------------------");
      System.out.println(">> mat.showSubSquare(0, 12)");
      mat.showSubSquare(0, 12);
      System.out.println();

      System.out.println("print lower right ---------------------------------");
      System.out.println(">> mat.showSubSquare(MAT_SIZE - 13, 12)");
      mat.showSubSquare(MAT_SIZE - 13, 12);
      System.out.println();
      
      System.out.println("testing get() -------------------------------------");
      for (k = 0; k < 10; k++)
      {
         System.out.println(">> mat.get(" + k + ", " + k + ")\n" 
               + mat.get(k, k));
         System.out.println(">> mat.get(" + 4 + ", " + k + ")\n" 
               + mat.get(4, k));
         System.out.println(">> mat.get(" + k + ", " + 4 + ")\n" 
               + mat.get(k, 4));
      }
      try 
      {
         System.out.println(">> mat.get(MAT_SIZE, MAT_SIZE)");
         System.out.println(mat.get(MAT_SIZE, MAT_SIZE));
      }
      catch (IndexOutOfBoundsException error)
      {
         System.out.println("" + error); // expect IndexOutOfBoundsException
      }
      System.out.println();
      
      System.out.println("testing set() overwrite capability ----------------");
      for (k = 0; k < 10; k++)
      {
         System.out.println(">> mat.set(" + k + ", " + k + ", " + 1. + ")\n"
               + mat.set(k, k, 1.));
         System.out.println(">> mat.set(" + 4 + ", " + k + ", " + 10. + ")\n" 
               + mat.set(4, k, 10.));
         System.out.println(">> mat.set(" + k + ", " + 4 + ", " + -10. + ")\n" 
               + mat.set(k, 4, -10.));
      }
      System.out.println(">> mat.showSubSquare(0, 12)");
      mat.showSubSquare(0, 12);
      System.out.println();
     
      System.out.println("testing clear() -----------------------------------");
      System.out.println(">> mat.clear()");
      mat.clear();
      System.out.println(">> mat.showSubSquare(0, 12)");
      mat.showSubSquare(0, 12);
   }
}
