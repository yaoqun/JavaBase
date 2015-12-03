package commonclass;

public class JString
{
	public static final String NickName = "String";
	
	public static void Test()
	{
		compare();
		System.out.println("-----");
		replace();
		System.out.println("-----");
		convertToString();
		System.out.println("-----");
		match();
	}
	
	private static void compare()
	{
		String s1 = "hello";
		String s2 = s1 + " world";
		String s3 = s1 + " world";
		String s4 = s1 + " worla";
		String s5 = s1 + " worlg";
		
		System.out.println(s2 == s3);       // false
		System.out.println(s2.equals(s3));  // true
		
		System.out.println(s4.compareTo(s2));  // < 0
		System.out.println(s5.compareTo(s2));  // > 0
	}
	
	private static void replace()
	{
		String s1 = "hello xxx";
		
		// must capture return value
		String s2 = s1.replace("xxx", "world");
		
		System.out.println(s1);  // "hello xxx"
		System.out.println(s2);  // "hello world"
	}
	
	private static void convertToString()
	{
		int i = 2015;
		
		String s1 = String.valueOf(i);
		String s2 = String.format("%d", i);
		
		System.out.println(s1);
		System.out.println(s2);
	}
	
	// regular expression
	private static void match()
	{
		String s1 = "707-827-7019";  // American phone number
		String s2 = "707.827.7019";
		String s3 = "707_827_7019";
		
		String regex = "(\\d{3}[.-]){2}\\d{4}";
		
		System.out.println( s1.matches(regex) );  // true
		System.out.println( s2.matches(regex) );  // true
		System.out.println( s3.matches(regex) );  // false
	}
}
