


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;



 class User 
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
	public void AddAmount(double b)
	{
		this.TypeRefrence.setBalance( this.TypeRefrence.getbal()+b);
	}
	public void Deposit(double bal)
	{
		this.TypeRefrence.Deposit(bal);
		
	}
	public boolean Withdraw (double bal)
	{
		return this.TypeRefrence.Withdraw(bal);
	}
	public boolean Transfer( User b,double amount)
	{
		return this.TypeRefrence.Transfer(b, amount);
		
	}
    
}


 interface Account {

	public void SetId(double id);
	public void SetType(String Type);
	public double getId();
	public String GetType();
	public void setBalance(double bal) ;
	public double getbal() ;
	
	
	public void Deposit(double bal);
	public boolean Withdraw (double bal);
	public boolean Transfer( User b,double amount);
	
	
	
	
	
}
 class CheckingAccount implements Account
{
	 
	private double id;
	private String Type;
	private double Balance;
	

	public CheckingAccount(double b)
	{
		id =Math.random();
		Type="Checking Account";
		Balance =b;
	}
        @Override
	public void setBalance(double bal) {
		 this.Balance=bal;
	}
        @Override
	public double getbal() {
		return Balance;
	}
	
        @Override
	public double getId() {
		return id;
	}

        @Override
	public String GetType() {
		return Type;
	}

        @Override
	public void SetId(double id) {
		 this.id=id;
	}

        @Override
	public void SetType(String Type) {
		this.Type=Type;
	}
        @Override
	public String toString() {
		return "\nID =" + id + "\n Type  = " + Type + "\n Balance  = " + this.Balance;
	}
        @Override
	public void Deposit(double bal) {
		this.Balance=this.Balance+bal;
		
	}
        @Override
	public boolean Withdraw(double bal) {
		if(this.Balance-bal>=0)
		{
			this.Balance=this.Balance-bal;
			return true;
		}
		return false;
	}

    @Override
	public boolean Transfer(User b,double am) {
		 if(this.Balance-am>=0)
		 {
			 this.Balance=this.Balance-am;
			 b.AddAmount(am);
			 return true;
		 }
			return false;
		
	}

}
class VacationAccount implements Account
{
	 
	private double id;
	private double Balance;
	private String Type;
	
	
	public void setBalance(double bal) {
		 this.Balance=bal;
	}
	public double getbal() {
		return Balance;
	}
	

	public VacationAccount(double b)
	{
		id =Math.random();
		Type="Vacation Account";
		Balance= b;
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
		return "\nID =" + id + "\n Type  = " + Type + "\n Balance  = " + this.Balance;
	}
	public void Deposit(double bal) {
		this.Balance=this.Balance+bal;
		
	}
	public boolean Withdraw(double bal) {
		if(this.Balance-bal>=0)
		{
			this.Balance=this.Balance-bal;
			return true;
		}
		return false;
	}
	public boolean Transfer(User b,double am) {
		 if(this.Balance-am>=0)
		 {
			 this.Balance=this.Balance-am;
			 b.AddAmount(am);
			 return true;
		 }
			return false;
		
	}

}
class Transactions 
{
	ArrayList <String>Transactions;
	public Transactions()
	{
		Transactions= new ArrayList();
	}
	public void Deposit(User us,double bal)
	{
		us.Deposit(bal);
		MakeTrannAction(us.toString()+"\n has deposites" ,  bal);
	}
	public void Withdraw (User us,double bal)
	{
		if(us.Withdraw(bal)==true)
			MakeTrannAction(us.toString()+"\n has withdraw" ,  bal);
		else
				MakeTrannAction(us.toString()+" insuffuecent balance " ,  bal);
	}
	public void Transfer( User a,User b,double amount)
	{
		 if(a.Transfer(b, amount)==true )
		      MakeTrannAction(a.toString()+" \nhas transferd  to "+b.toString() ,amount);
		 else
			 MakeTrannAction(a.toString()+" \nhas failed  t "+b.toString() ,amount);
	
	}
	public void seealltransaction()
	{
		for(String s:Transactions)
		{
			System.out.println(s);
		}
	}
	void MakeTrannAction(String info,double Amount)
	{
		 Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	       
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	        LocalDate localDate = LocalDate.now();
	    
		
		String T= sdf.format(cal.getTime())+"\n"+dtf.format(localDate)+info+" "+Amount+"  $ \n";
		this.Transactions.add(T);
	
	//	System.out.println(T);
		
		
		
	}

}
class SavingAccount implements Account
{
 
	private double id;
	private double Balance;
	private String Type;
	
	public SavingAccount(double b)
	{
		id =Math.random();
		Type="Saving Account";
		Balance=b;
	}
	public void Balance(double bal) {
		 this.Balance=bal;
	}
	public double getbal() {
		return Balance;
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
		return "\nID =" + id + "\n Type  = " + Type + "\n Balance  = " + this.Balance;
	}
	public void Deposit(double bal) {
		this.Balance=this.Balance+bal;
		
	}
	public boolean Withdraw(double bal) {
		if(this.Balance-bal>=0)
		{
			this.Balance=this.Balance-bal;
			return true;
		}
		return false;
	}
	public boolean Transfer(User b,double am) {
		 if(this.Balance-am>=0)
		 {
			 this.Balance=this.Balance-am;
			 b.AddAmount(am);
			 return true;
		 }
			return false;
		
	}
	public void setBalance(double bal) {
		// TODO Auto-generated method stub
		
	}
	

}


public class IST242Team3Bank 
{
    public static void main(String[] args) 
	{
		
	   	Scanner sc = new Scanner(System.in);
                String Fname ;
                String Lastname ;
                System.out.print("Enter Firstname of user 1 ");
                Fname= sc.nextLine();
                 System.out.print("Enter lastname of user 1 ");
                Lastname = sc.nextLine();
                
                
                
                    User us=new  User(Fname, Lastname,new CheckingAccount(30));
		    System.out.println(us);
                    
                    
                 System.out.print("Enter Firstname of user 2 ");
                Fname= sc.nextLine();
                 System.out.print("Enter lastname of user 2  ");
                Lastname = sc.nextLine();
                
                    User us2=new  User(Fname, Lastname,new VacationAccount(55));
		    System.out.println(us2);
		    	    
		
                   System.out.print("Enter Firstname of user 3 ");
                Fname= sc.nextLine();
                 System.out.print("Enter lastname of user 3 ");
                Lastname = sc.nextLine();
                
		    User us3=new  User(Fname, Lastname,new SavingAccount(555));
		    System.out.println(us3);
		  
                    
                    
                    // Tranactionn   person part
		/*    Transactions trans= new Transactions();
		
		    
		    trans.Deposit(us, 30);
		    trans.Withdraw(us, 20);
		    trans.Transfer(us, us2, 1033);
		    
		    trans.seealltransaction();
		    */    
	}
    
}
	public Transactions()
	{
		Transactions= new ArrayList();
	}
	public void Deposit(User us,double bal)
	{
		us.Deposit(bal);
		MakeTrannAction(us.toString()+"\n has deposites" ,  bal);
	}
	public void Withdraw (User us,double bal)
	{
		if(us.Withdraw(bal)==true)
			MakeTrannAction(us.toString()+"\n has withdraw" ,  bal);
		else
				MakeTrannAction(us.toString()+" insuffuecent balance " ,  bal);
	}
	public void Transfer( User a,User b,double amount)
	{
		 if(a.Transfer(b, amount)==true )
		      MakeTrannAction(a.toString()+" \nhas transferd  to "+b.toString() ,amount);
		 else
			 MakeTrannAction(a.toString()+" \nhas failed  t "+b.toString() ,amount);
	
	}
	public void seealltransaction()
	{
		for(String s:Transactions)
		{
			System.out.println(s);
		}
	}
	void MakeTrannAction(String info,double Amount)
	{
		 Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	       
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	        LocalDate localDate = LocalDate.now();
	    
		
		String T= sdf.format(cal.getTime())+"\n"+dtf.format(localDate)+info+" "+Amount+"  $ \n";
		this.Transactions.add(T);
	
	//	System.out.println(T);
		
		
		
	}

}
class SavingAccount implements Account
{
 
	private double id;
	private double Balance;
	private String Type;
	
	public SavingAccount(double b)
	{
		id =Math.random();
		Type="Saving Account";
		Balance=b;
	}
	public void Balance(double bal) {
		 this.Balance=bal;
	}
	public double getbal() {
		return Balance;
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
		return "\nID =" + id + "\n Type  = " + Type + "\n Balance  = " + this.Balance;
	}
	public void Deposit(double bal) {
		this.Balance=this.Balance+bal;
		
	}
	public boolean Withdraw(double bal) {
		if(this.Balance-bal>=0)
		{
			this.Balance=this.Balance-bal;
			return true;
		}
		return false;
	}
	public boolean Transfer(User b,double am) {
		 if(this.Balance-am>=0)
		 {
			 this.Balance=this.Balance-am;
			 b.AddAmount(am);
			 return true;
		 }
			return false;
		
	}
	public void setBalance(double bal) {
		// TODO Auto-generated method stub
		
	}
	

}


public class IST242Team3Bank 
{
    public static void main(String[] args) 
	{
		
	   	Scanner sc = new Scanner(System.in);
                String Fname ;
                String Lastname ;
                System.out.print("Enter Firstname of user 1 ");
                Fname= sc.nextLine();
                 System.out.print("Enter lastname of user 1 ");
                Lastname = sc.nextLine();
                
                
                
                    User us=new  User(Fname, Lastname,new CheckingAccount(30));
		    System.out.println(us);
                    
                    
                 System.out.print("Enter Firstname of user 2 ");
                Fname= sc.nextLine();
                 System.out.print("Enter lastname of user 2  ");
                Lastname = sc.nextLine();
                
                    User us2=new  User(Fname, Lastname,new VacationAccount(55));
		    System.out.println(us2);
		    	    
		
                   System.out.print("Enter Firstname of user 3 ");
                Fname= sc.nextLine();
                 System.out.print("Enter lastname of user 3 ");
                Lastname = sc.nextLine();
                
		    User us3=new  User(Fname, Lastname,new SavingAccount(555));
		    System.out.println(us3);
		  
                    
                    
                    // Tranactionn   person part
		/*    Transactions trans= new Transactions();
		
		    
		    trans.Deposit(us, 30);
		    tra