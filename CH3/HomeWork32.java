/*
Parth Barot
9/16/2015
Progammar Homework 3.2
*/

import java.io.*;

public class HomeWork32 extends EmployeeInsertSort
{
   public HomeWork32 (int max)		// subclass constructor
	   {
		super(max);						// call superclass constructor
	   }
   public Employee median(int arrayMax)
      {
         Employee theMedian = emp[arrayMax/2];
         return theMedian;
      }
      
      /* public double median(PrintWriter pw)  //Creating median value
      {
       
      int top = nElems;   //declared the top 
      double mid = (nElems - 1) / 2.0;      //declared 
      int bottom = 0;
      double middle =  -1; // this will going to evaluate the median size
      
      while (top > mid)
         top--;
      while (bottom < mid)
         bottom++;
      
      if (emp[top].empNo == emp[bottom].empNo)
            middle = emp[(int)mid].empNo;
         
      else 
            middle = (emp[bottom].empNo + emp[top].empNo) / 2.0;
      
      System.out.println("The median value of the array is " + middle + ".");
      pw.println("The median value of the array is " + middle + ".");

      return nElems;
      }
**/

}
class HomeWork32App
   {  
      public static void main (String[] args) throws IOException
         {
            PrintWriter pw = new PrintWriter (new BufferedWriter(new FileWriter("HomeWork32.dat")));
            
         int maxSize = 100;            // array size
      EmployeeInsertSort arr;
      arr = new EmployeeInsertSort(maxSize);
      
      arr.insert(77,"A","B","C",pw);
		arr.insert(99,"D","E","F",pw);
		arr.insert(44,"G","H","I",pw);
		arr.insert(55,"J","K","L",pw);
		arr.insert(22,"M","N","O",pw);
		arr.insert(88,"P","Q","R",pw);
		arr.insert(11,"S","T","U",pw);
		arr.insert(00,"V","W","X",pw);
		arr.insert(66,"Y","Z","AA",pw);
		arr.insert(33,"BB","CC","DD",pw);
		
		System.out.println("Before sorting ");
		pw.println("Before sorting ");

      arr.display(pw);                // display items
            // display items

      arr.insertionSort();          // insertion-sort them
		
		System.out.println("After sorting ");
		pw.println("After sorting ");

      arr.display(pw);                // display them again
		double size = arr.nElems;
     System.out.println("The median is " + arr.median(size));
     pw.println("The median is " + arr.median(size));

      
		pw.close();
      }  // end main()
   }  // end class InsertSortApp

         
         