// EmployeeBubbleSort.java
// demonstrates bubble sort
// with Employee Objects
// Programmer: Dr. Stuart P. Brian
// Date written: 9/19/15

import java.io.*;
////////////////////////////////////////////////////////////////
class EmployeeBubbleSort
   {
   private Employee[] emp;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public EmployeeBubbleSort(int max)          // constructor
      {
      emp = new Employee[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(int eNo, String sNo, String lName, String fName, PrintWriter pw)
	{
		System.out.println("Inserting employee with employee number " + eNo);
		pw.println("Inserting employee with employee number " + eNo);

		
		Employee temp = new Employee();
		temp.empNo = eNo;
		temp.ssno = sNo;
		temp.lastName = lName;
		temp.firstName = fName;
		emp[nElems] = temp;
		nElems++;
	}
//--------------------------------------------------------------
    public void display(PrintWriter pw)
	{
		
		for(int j=0; j<nElems; j++)
		{
			System.out.println(emp[j].empNo + " " + emp[j].ssno + " "
			 + emp[j].lastName + " " + emp[j].firstName);
			 
			 pw.println(emp[j].empNo + " " + emp[j].ssno + " "
			 + emp[j].lastName + " " + emp[j].firstName);

		}	
	} 
//--------------------------------------------------------------
   public void bubbleSort()
      {
      int out, in;

      for(out=nElems-1; out>1; out--)   // outer loop (backward)
         for(in=0; in<out; in++)        // inner loop (forward)
            if( emp[in].empNo > emp[in+1].empNo )       // out of order?
               swap(in, in+1);          // swap them
      }  // end bubbleSort()
//--------------------------------------------------------------
   private void swap(int one, int two)
      {
      Employee temp = emp[one];
      emp[one] = emp[two];
      emp[two] = temp;
      }
//--------------------------------------------------------------
   }  // end class ArrayBub
////////////////////////////////////////////////////////////////
class EmployeeBubbleSortApp
   {
   public static void main(String[] args)throws IOException
      {
      
      // set up printer output file
      PrintWriter pw = new PrintWriter(new BufferedWriter
           (new FileWriter("employeeBubbleSort.dat")));

      
      int maxSize = 100;            // array size
      EmployeeBubbleSort arr;                 // reference to array
      arr = new EmployeeBubbleSort(maxSize);  // create the array

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
      
      System.out.println("Unsorted data: ");
      pw.println("Unsorted data: ");

      arr.display(pw);                // display items

      arr.bubbleSort();             // bubble sort them
      
      System.out.println("Sorted data: ");
      pw.println("Sorted data: ");

      arr.display(pw);                // display them again
      
      pw.close();
      }  // end main()
   }  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
