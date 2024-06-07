package BasicPrograms;

public class AddTwoIntegers 
{
	    public void sum(int m, int n)                       // Non-Static Method
		{
		      int c;
		           c =m+n;
		      System.out.println("The addition of two numbers is = " +c);                     // Print Statement
		}
		 
	    public static void main(String args[])                                 // Main Method
		{
			     AddTwoIntegers rrr = new AddTwoIntegers();
		         rrr.sum(20,30);                                                         // Calling Non-Static Method
		         rrr.sum(50,30); 
		 }
}
