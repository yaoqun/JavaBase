package main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main
{
	private static String packageName = "";
	
	public static void main(String[] args)
	{
		test1202();
	}
	
	public static void test1202()
	{
		packageName = "commonclass";
		test("JEquals");
		test("JString");
		test("JStringBuilder");
		test("JStringBuffer");
		test("JToolClass");
	}
	
	public static void test1205()
	{
		packageName = "setframework";
		test("");
	}
	
	private static void test(String className)
	{
		try
		{
			Class <?> c = Class.forName(packageName + "." + className);
			
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
