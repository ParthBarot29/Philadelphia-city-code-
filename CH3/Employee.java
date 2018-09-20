// File: Employee.java
// Reference Gaddis 2nd p.556, Lafore 2nd p. 65
// This file is the Employee class
// Programmer: Dr. Stuart P. Brian
// Date written: 8/28/15
//	This class stores data about an employee.

public class Employee
{
	protected int empNo;			// employee number
	protected String ssno;			// social security number
	protected String lastName;	   // Last name
	protected String firstName;	// First name
	
	//This constructor initializes the variables
		
	public Employee(int eNo, String ssn, String lName, String fName) 
	// aliases are used in the function header
	{
		empNo = eNo;	// the alias is assigned to the actual value
		ssno = ssn;
		lastName = lName;
		firstName = fName;
	}
	
	// Make a no argument constructor as well
	public Employee() 
	{
		empNo = 0;	
		ssno = "";
		lastName = "";
		firstName = "";
	}
	
	/** 
		The copy constructor initializes the object 
		as a copy of another Employee object
		@param object2 The object to copy
	*/
	
	public Employee(Employee object2)
	{
		empNo = object2.empNo;
		ssno = object2.ssno;
		lastName = object2.lastName;
		firstName = object2.firstName;
	} 
	
	// The set method sets a value for each field
	public void set(int eNo, String ssn, String lName, String fName)
	// aliases are used in the function header
	{
		empNo = eNo;	// the alias is assigned to the actual value
		ssno = ssn;
		lastName = lName;
		firstName = fName;
	}
	
	// the getKey method returns the employee number
	public int getKey()
		{ return empNo; }
      
   // the setKey method sets the employee number
   public void setKey(int id)
      { empNo = id; }
	
	// toString method
	// returns a string containing the instructor information
	public String toString()
	{
		// Create a string representing the object.
		String str = "Employee Number: " + empNo +
						 "\nSocial Security Number: " + ssno +
						 "\nLast Name: " + lastName +
						 "\nFirst Name: " + firstName;
	// Return the string;
	return str;
	}
}