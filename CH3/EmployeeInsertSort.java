// EmployeeInsertSort.java
// demonstrates insertion sort using Employee objects
// Reference: Lafore p. 101
// Programmer: Dr. Stuart P. Brian
// Date written: 9/9/15
//--------------------------------------------------------------
import java.io.*;

class EmployeeInsertSort 
   {
   public Employee[] emp;                 // ref to array a
   public int nElems;               // number of data items
//--------------------------------------------------------------
   public EmployeeInsertSort(int max)          // constructor
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
		System.out.println("The array of employees is: ");
		pw.println("The array of employees is: ");

		for(int j=0; j<nElems; j++)
		{
			System.out.println(emp[j].empNo + " " + emp[j].ssno + " "
			 + emp[j].lastName + " " + emp[j].firstName);
			 
			 pw.println(emp[j].empNo + " " + emp[j].ssno + " "
			 + emp[j].lastName + " " + emp[j].firstName);

		}	// end for
	} // end delete
//--------------------------------------------------------------
   public void insertionSort()
      {
      int in, out;

      for(out=1; out<nElems; out++)     // out is dividing line
         {
         Employee temp = emp[out];            // remove marked item
         in = out;                      // start shifts at out
         while(in>0 && emp[in-1].empNo >= temp.empNo) // until one is smaller,
            {
            emp[in] = emp[in-1];            // shift item to right
            --in;                       // go left one position
            }
         emp[in] = temp;                  // insert marked item
         }  // end for
      }  // end insertionSort()
      
      
     //--------------------------------------------------------------
   }  // end class ArrayIns
////////////////////////////////////////////////////////////////
class EmployeeInsertSortApp
   {
   public static void main(String[] args) throws IOException
      {
		
		// set up printer output file
      PrintWriter pw = new PrintWriter(new BufferedWriter
           (new FileWriter("employeeSort.dat")));

		
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
		
      //arr.median(pw);
      
		pw.close();
      }  // end main()
   }  // end class InsertSortApp
