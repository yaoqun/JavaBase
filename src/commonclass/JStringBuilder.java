package commonclass;

public class JStringBuilder
{
	public static final String NickName = "StringBuilder";
	
	public static void Test()
	{
		StringBuilder str = new StringBuilder("helloworld");
		
		// 从后往前每3个字符插入一个','
		int pos = str.length() - 3;
		while (pos > 0)
		{
			str.insert(pos, ',');
			pos -= 3;
		}
		
		System.out.println(str.toString());
	}
}
