package iofile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JLineRW
{
	public static final String NickName = "读一行, 写一行";
	
	private static final int LineNum = 3;
	
	private static final String Filename = "data/line.txt";
	
	public static void Test()
	{
		System.out.println("写入" + LineNum + "行.");
		write();
		
		System.out.println("读入" + LineNum + "行:");
		read(Filename);
	}
	
	private static void write()
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(
					new OutputStreamWriter(
					new FileOutputStream(Filename)));
			
			for (int i = 1; i <= LineNum; i++)
			{
				writer.write(String.format("第%d行", i));
				writer.newLine();
				writer.flush();
			}
			
			writer.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void read(String filename)
	{
		try
		{
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(
					new FileInputStream(filename)));
			
			String line;
			while ( (line = reader.readLine()) != null )
			{
				System.out.println(line);
			}
			
			reader.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
