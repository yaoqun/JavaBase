package iofile;

import java.io.File;
import java.io.IOException;

public class JFile
{
	public static final String NickName = "File";
	
	public static void Test()
	{
		testDir();
		System.out.println("-----");
		testFile();
	}
	
	private static void testDir()
	{
		File f = new File("data/null_dir");
		if (f.exists())
		{
			System.out.print("null_dir目录存在, ");
			if ( ! f.delete() )
			{
				System.out.println("删除失败");
				return;
			}
			else
				System.out.println("删除成功");
		}
		f.mkdir();
		System.out.println("mkdir()后, " +
				"isDirectory():" + f.isDirectory() + ", " +
				"isFile():" + f.isFile());
	}
	
	private static void testFile()
	{
		File f1 = new File("data/xxx/a.txt");
		File f2 = new File("data/a.txt");
		if ( f1.exists() )
			f1.delete();
		if ( f2.exists() )
			f2.delete();
		
		try {
			f1.createNewFile();
			System.out.println("创建文件成功: " + f1.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("创建文件失败: " + f1.getAbsolutePath());
		}
		
		try {
			f2.createNewFile();
			System.out.println("创建文件成功: " + f2.getAbsolutePath());
			System.out.println("文件已存在, createNewFile():" + f2.createNewFile());
			System.out.println("上层目录路径: " + f2.getParentFile().getAbsolutePath());
		} catch (IOException e) {
			System.out.println("创建文件失败: " + f2.getAbsolutePath());
		}
	}
}
