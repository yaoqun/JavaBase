package iofile;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class JDataIO
{
	public static final String NickName = "Data-IO-Stream";
	
	public static void Test()
	{
		String filename = "data/a.txt";
		
		int d1 = 10, d2 = -10;
		System.out.println("写入两个整数: " + d1 + ", " + d2);
		
		try
		{
			FileOutputStream fout = new FileOutputStream(filename);
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(d1);
			dout.writeInt(d2);
			
			System.out.print("结果: ");
			JFileIO.testReadBuffer(filename);
			
			dout.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
