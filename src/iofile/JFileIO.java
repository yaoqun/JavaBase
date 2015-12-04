package iofile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class JFileIO
{
	public static final String NickName = "File-IO-Stream";
	
	private static final int Bufsize = 8;
	
	public static void Test()
	{
		String filename = "data/rf.txt";
		
		System.out.println("逐个字节地读");
		testReadByte(filename);
		System.out.println("-----");
		
		System.out.println("一次读入到字节缓存数组");
		testReadBuffer(filename);
		System.out.println("-----");
		
		File f = new File("data/rf.txt");
		System.out.println("复制文件");
		try { copyFile(f); }
		catch (Exception e) { e.printStackTrace(); }
		System.out.println("复制完成");
	}
	
	public static void testReadByte(String filename)
	{
		try
		{
			FileInputStream fin = new FileInputStream(filename);
			
			int b, i = 1;
			
			for (; (b = fin.read()) != -1; i++)
			{
				System.out.print(String.format("%02x", b) + "  ");
				if (i%Bufsize == 0)
					System.out.println();
			}
			
			if ( (i-1)%Bufsize != 0 )
				System.out.println();
			
			fin.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void testReadBuffer(String filename)
	{
		try
		{
			FileInputStream fin = new FileInputStream(filename);
			
			byte[] buf = new byte[Bufsize];
			int nRead;
			
			while ( (nRead = fin.read(buf, 0, Bufsize)) > 0 )
			{
				for (int i = 0; i < nRead; i++)
					System.out.print(String.format("%02x", buf[i]) + "  ");
				System.out.println();
			}
			
			fin.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void copyFile(File srcFile) throws Exception
	{
		if ( ! srcFile.exists() )
			throw new IllegalArgumentException("文件不存在: " + srcFile);
		if ( ! srcFile.isFile() )
			throw new IllegalArgumentException("不是文件: " + srcFile);
		if ( ! srcFile.canRead() )
			throw new IllegalArgumentException("文件不可读: " + srcFile);
		
		File dstFile = new File(srcFile.toString() + ".nobuf.copy");
		dstFile.delete();
		dstFile.createNewFile();
		
		FileInputStream fin = new FileInputStream(srcFile);
		FileOutputStream fout = new FileOutputStream(dstFile);
		
		int b;
		while ( (b = fin.read()) != -1 )
		{
			fout.write(b);
		}
		
		fin.close();
		fout.close();
	}
}
