// File: HighArrayObject.java  reference Lafore p 49
// Demonstrates array class with objects
// Programmer: Dr. Stuart P. Brian
// Date written: 8/28/15

import java.io.*;

class HighArrayObject
{
	protected Employee[] emp;
	protected int nElems;
	
	public HighArrayObject(int max)	// constructor
	{
		emp = new Employee[max];
		nElems = 0;
	}
	
	// The createEmployees method creates an Employee object
	// for each element of the array

	public static void createEmployees(Employee[] emp, int maxsize)
	{
		int empNo;
		String ssno;
		String lastName;
		String firstName;
					
		// Create the employees
		for(int index = 0; index < emp.length; index++)
		{
		// Get the employee data
			emp[index] = new Employee();
		}
	}
	
	public boolean find(long searchKey, PrintWriter pw)
	{
		System.out.println("Trying to find item with employee number " + searchKey);
		pw.println("Trying to find item with employee number " + searchKey);

		int j;
		for(j=0; j<nElems; j++)
			if(emp[j].empNo == searchKey)		// == ok since empNo is a primative
				break;							// exit loop before end
			if(j == nElems)					// gone to end?
				return false;
			else
				return true;					// no, found it
	}  // end find()
		
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
	
	public boolean delete(int value, PrintWriter pw)
	{
		System.out.println("Deleting employee number " + value);
		pw.println("Deleting employee number " + value);
		
		int j;
		for(j=0; j < nElems; j++)				// look for it
			if(value == emp[j].empNo)
				break;								// can't find it
			if(j==nElems)
				return false;
			else										// found it
			{
				for(int k=j; k<nElems; k++)	// move higher ones down
				{
					emp[k]=emp[k+1];				
				}
			nElems--;								// decrement size
			return true;
		}
	} // end delete
	
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
} // end HighArrayObject