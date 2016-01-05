package homework;

public class TestValidCodeLineNumber
{
	private TestValidCodeLineNumber()
	{
		// invalid
		// /* invalid
		// /* invalid */
		/* invalid */ // invalid
		/* invalid */
		/* invalid */ /* invalid */
		/* invalid */ /* invalid *//* invalid */
		/* valid */ return; /* test */
	}
	
	public static void Test()
	{
		String filename = "src/homeword/TestValidCodeLineNumber.java";
		int linenum = ValidCodeLineNumber.CountValidCodeLineNumber(filename);
		boolean isSuccess = linenum == 15;
		System.out.println("TestValidCodeLineNumber : " + isSuccess);
	}
}