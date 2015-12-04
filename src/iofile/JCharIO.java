package iofile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JCharIO
{
	public static final String NickName = "Char-IO-Stream";
	
	private static final String CharsetName = "utf-8";
	
	private static final String Filename = "data/char.txt";
	
	public static void Test()
	{
		String content = "学习Java的字符流";
		System.out.println("输出字符串到文件: " + content);
		write(content);
		
		System.out.print("从文件读入字符串: ");
		String ret = read();
		System.out.println(ret);
	}
	
	private static void write(String content)
	{
		try
		{
			OutputStreamWriter cout = new OutputStreamWriter(
					new FileOutputStream(Filename),
					CharsetName
			);
			
			char[] buf = content.toCharArray();
			cout.write(buf);
			
			cout.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static String read()
	{
		try
		{
			InputStreamReader cin = new InputStreamReader(
					new FileInputStream(Filename),
					CharsetName
			);
			
			char[] buf = new char[1024];
			int nRead = cin.read(buf);
			cin.close();
			
			return new String(buf, 0, nRead);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
