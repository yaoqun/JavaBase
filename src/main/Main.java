package main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main
{
	public static void main(String[] args)
	{
		test1203();
	}
	
	private static void test1203()
	{
		test("JEquals");
		test("JString");
		test("JStringBuilder");
		test("JStringBuffer");
		test("JToolClass");
	}
	
	private static void test(String className)
	{
		try
		{
			Class <?> c = Class.forName("main." + className);
			
			Field f = c.getField("NickName");
			System.out.println(">> " + f.get(null));
			
			Method m = c.getMethod("Test");
			m.invoke(null);
			System.out.println("<<\n");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
