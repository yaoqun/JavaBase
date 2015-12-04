package iofile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class JBufferedIO
{
	public static final String NickName = "Buffered-IO-Stream";
	
	private static long time;
	
	public static void Test()
	{
		try
		{
			File f = new File("data/bigfile");
			System.out.println("原文件大小: " + f.length());
			
			startTime("无缓存复制: ");
			JFileIO.copyFile(f);
			endTime();
			
			startTime("带缓存复制: ");
			JBufferedIO.copyFile(f);
			endTime();
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
		
		File dstFile = new File(srcFile.toString() + ".bufed.copy");
		dstFile.delete();
		dstFile.createNewFile();
		
		BufferedInputStream bin = new BufferedInputStream(
				new FileInputStream(srcFile), 8096 );
		BufferedOutputStream bout = new BufferedOutputStream(
				new FileOutputStream(dstFile), 8096 );
		
		int c;
		while ( (c = bin.read()) != -1 )
		{
			bout.write(c);
		}
		bout.flush();
		
		bin.close();
		bout.close();
	}
	
	private static void startTime(String msg)
	{
		System.out.print(msg);
		time = System.currentTimeMillis();
	}
	
	private static void endTime()
	{
		time = System.currentTimeMillis() - time;
		System.out.println("用时" + time + "ms");
	}
}
