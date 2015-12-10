package main;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.catalina.startup.Tomcat;

import mysql.DbHelper;

public class Main
{
	private static String packageName = "";
	
	public static void main(String[] args) throws Exception
	{
		test0109();
	}
	
	public static void test0109()
	{
		packageName = "reflect";
		test("JReflect");
	}
	
	public static void test1231()
	{
		// testTomcat("web/3.0");
		testTomcat("web/4.0");
	}
	
	public static void test1226()
	{
		// testTomcat("web/1.0");
		
		if ( DbHelper.getInstance().isInitOk() )
		{
			testTomcat("web/2.0");
		}
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
	
	public static void testTomcat(String appPath)
	{
		if (appPath != null)
			appPath = new File("").getAbsolutePath() + "/" + appPath;
		else
			appPath = "D:/apache-tomcat-9/webapps/examples";
		
		try
		{
			Tomcat tomcat = new Tomcat();
			tomcat.addWebapp("/", appPath);
			
			tomcat.getConnector().setURIEncoding("utf-8");
			
			tomcat.start();
			System.out.println("tomcat started");
			
			System.in.read();
			tomcat.stop();
			System.out.println("tomcat stoped");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
