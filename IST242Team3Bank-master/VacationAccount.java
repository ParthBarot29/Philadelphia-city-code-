/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driverclass;

/**
 *
 * @author barot
 */
public class VacationAccount implements Account
{
	 
	private double id;
	private String Type;
	
	

	public VacationAccount()
	{
		id =Math.random();
		Type="Vacation Account";
	}
	
	
	public double getId() {
		return id;
	}

	public String GetType() {
		return Type;
	}

	public void SetId(double id) {
		 this.id=id;
	}

	public void SetType(String Type) {
		this.Type=Type;
	}
	public String toString() {
		return "\nID =" + id + "\n Type  = " + Type;
	}

}

