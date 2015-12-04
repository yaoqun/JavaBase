package iofile;

import java.io.File;
import java.io.RandomAccessFile;

public class JRandomAccessFile
{
	public static final String NickName = "RandomAccessFile";
	
	public static void Test()
	{
		write();
		read();
	}
	
	private static void write()
	{
		try
		{
			String s = "随机访问file";
			int d = 30;
			
			File f = new File("data/rf.txt");
			f.createNewFile();
			RandomAccessFile rf = new RandomAccessFile(f, "rw");
			
			byte[] buf = s.getBytes("utf-8");
			int length = buf.length;
			rf.writeInt(length);
			rf.write(buf);
			
			for (int shift = 24; shift >= 0; shift -= 8)
				rf.write(d >> shift);
			
			rf.close();
			System.out.println("把字符串和整数写入文件: " + s + "," + d);
			System.out.println("文件字节数: " + f.length());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void read()
	{
		try
		{
			RandomAccessFile rf = new RandomAccessFile("data/rf.txt", "r");
			
			int length = rf.readInt();
			byte[] buf = new byte[length];
			rf.read(buf);
			String s = new String(buf, "utf-8");
			
			int d = 0;
			for (int shift = 24; shift >= 0; shift -= 8)
			{
				d |= ( rf.read() << shift );
			}
			
			rf.close();
			System.out.println("从文件读出: " + s + "," + d);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
