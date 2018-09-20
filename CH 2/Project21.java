// File: Project21.java
// Chapter 2 Programming Project 1 p.76
// This program adds a method called getMax() 
// to the highArray.java program
// that returns the record with the highest employee number in the array
// and shows it's location
// Programmer: Dr. Stuart P. Brian
// Date written: 9/2/15

import java.io.*;

public class Project21 extends HighArrayObject		//reference Gaddis p.658
{
	public Project21 (int max)		// subclass constructor
	{
		super(max);						// call superclass constructor
	}
	
	public int removeMax(PrintWriter pw)  // new functionality as required by the assignment
   {
      int maxIndex = -1;  // not found yet
      
   	if(nElems == 0)
      {
   		System.out.println("Number of elements is 0");
         return -1;
      }
     	else
   	{
   		int max = emp[0].empNo;  // assume the first value is the largest
         maxIndex = 0;
         
   		for (int i = 1; i < nElems; i++)  //now check the rest of the values for largest
   		{
   			if(emp[i].empNo > max)
            {
               maxIndex = i;
               max = emp[i].empNo; // line added
             }
         }
         

         System.out.println("The largest value is " + emp[maxIndex].empNo + " " + emp[maxIndex].ssno + 
            " " + emp[maxIndex].lastName + " " + emp[maxIndex].firstName);
		   pw.println("The largest value is " + emp[maxIndex].empNo + " " + emp[maxIndex].ssno + 
            " " + emp[maxIndex].lastName + " " + emp[maxIndex].firstName);
         System.out.println("at location " + maxIndex);
         pw.println("at location " + maxIndex);
         delete (max , pw);
                return max;
     	}
      
   }
// modified find method follows   
   public void find( int searchKey, PrintWriter pw)
   { 
      System.out.println("Trying to find item with employee number " + searchKey);
      pw.println("Trying to find item with employee number " + searchKey);
      
      int j;
      Boolean found = false;
      for(j=0; j < nElems; j++)
         if(emp[j].empNo == searchKey)
         {
            found = true;
            System.out.println("Found " + emp[j].empNo + " " + emp[j].ssno + " " + emp[j].lastName + " " + emp[j].firstName);
            pw.println("Found " + emp[j].empNo + " " + emp[j].ssno + " " + emp[j].lastName + " " + emp[j].firstName);
            System.out.println("at location " + j);
            pw.println("at location " + j);
         }
         if(found == false)
         {
            System.out.println(searchKey + " Not found");
            pw.println(searchKey + " Not found");
         }
    }
}

class Project21App
{
   public static void main(String[] args) throws IOException
   {
		// set up printer output file
      PrintWriter pw = new PrintWriter(new BufferedWriter
           (new FileWriter("output21.dat")));

      int maxSize = 100;            // array size
      Project21 arr;                // reference to array
      arr = new Project21(maxSize); // create the array

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
		
      arr.display(pw);                // display items

      int searchKey = 35;           // search for item
      arr.find(searchKey, pw); 				
		searchKey = 22;           // search for item
      arr.find(searchKey, pw);
		
      arr.delete(00, pw);               // delete 3 items
      arr.delete(55, pw);
      arr.delete(99, pw);

      arr.display(pw);                // display items again

	  // new functionality follows  
      arr.removeMax(pw); 
      arr.display(pw);
     
      
      
            		
		pw.close();

   }  // end main()
}  // end class Project21RevApp
