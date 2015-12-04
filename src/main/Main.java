package main;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main
{
	private static String packageName = "";
	
	public static void main(String[] args)
	{
		test1211();
	}
	
	public static void test1211()
	{
		packageName = "iofile";
		test("JFile");
		test("JDirTree");
		test("JRandomAccessFile");
		test("JFileIO");
		test("JDataIO");
		test("JBufferedIO");
		test("JCharIO");
		test("JLineRW");
		test("JSerialize");
		
		packageName = "xml";
		test("JDom");
		test("JSax");
		test("Jjdom");
		test("Jdom4j");
		test("JDomW");
	}
	
	public static void test1205()
	{
		packageName = "commonclass";
		test("JEquals");
		test("JString");
		test("JStringBuilder");
		test("JStringBuffer");
		test("JToolClass");
		
		packageName = "setframework";
		test("JList");
		test("JSet");
		test("JMap");
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
