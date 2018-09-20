/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driverclass;



public class User 
{
    private String  FirstName;
    private String  LastName; 
    private Account TypeRefrence; 
    
    public User( String Fname , String Lname,Account ac)
    {
    	FirstName    = Fname;
    	LastName     = Lname;
    	TypeRefrence = ac;
    	
    }
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public String GetType()
    {
    	return  TypeRefrence.GetType();
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
	public String toString() {
		return "\nFirstName =" + FirstName + "\nLastName=" + LastName+TypeRefrence.toString();
	}
    
    
}
