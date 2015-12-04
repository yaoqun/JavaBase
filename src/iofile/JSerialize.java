package iofile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JSerialize
{
	public static final String NickName = "序列化和反序列化";
	
	private static final String Filename = "data/serialize.txt";
	
	public static void Test()
	{
		Student src = new Student(1001, "学生A", "密码123");
		
		System.out.println("序列化一个学生类对象: " + src);
		saveObject(src, Filename);
		
		Student ret = (Student) readObject(Filename);
		System.out.println("反序列化出学生类对象: " + ret);
	}
	
	private static void saveObject(Object obj, String filename)
	{
		try
		{
			ObjectOutputStream oout = new ObjectOutputStream(
					new FileOutputStream(filename));
			
			oout.writeObject(obj);
			
			oout.flush();
			oout.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static Object readObject(String filename)
	{
		try
		{
			ObjectInputStream oin = new ObjectInputStream(
					new FileInputStream(filename));
			
			Object obj = oin.readObject();
			
			oin.close();
			return obj;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
