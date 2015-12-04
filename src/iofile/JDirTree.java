package iofile;

import java.io.File;
import java.io.IOException;

public class JDirTree
{
	public static final String NickName = "DirTree";
	
	public static void Test()
	{
		try
		{
			File dir = init();
			dirTree(dir, 0);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static File init() throws IOException
	{
		File f = new File("data/tree_dir/sub_dir");
		if ( ! f.exists() )
			f.mkdirs();
		
		f = new File("data/tree_dir/a.txt");
		f.createNewFile();
		
		f = new File("data/tree_dir/b.txt");
		f.createNewFile();
		
		f = new File("data/tree_dir/sub_dir/c.txt");
		f.createNewFile();
		
		f = new File("data/tree_dir/sub_dir/d.txt");
		f.createNewFile();
		
		return new File("data/tree_dir");
	}
	
	private static void dirTree(File f, int depth) throws IOException
	{
		if ( ! f.exists() )
			throw new IllegalArgumentException("不存在: " + f);
		
		for (int i = 0; i < depth; i++)
			System.out.print("  ");
		System.out.println("+ " + f.getName());
		
		if ( f.isDirectory() )
		{
			File[] sub = f.listFiles();
			for (File subf : sub)
				dirTree(subf, depth+1);
		}
	}
}
