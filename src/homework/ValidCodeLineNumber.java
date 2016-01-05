package homework;

import java.io.*;

public class ValidCodeLineNumber
{
	public static int CountValidCodeLineNumber(String filename)
	{
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(filename)));
			
			int linenum = 0;
			String line = null;
			while ( (line = reader.readLine()) != null )
			{
				if (isCodeLineValid(line))
					linenum++;
			}
			
			return linenum;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (reader != null) {
				try { reader.close(); }
				catch (IOException e) { e.printStackTrace(); }
			}
		}
		
		return -1;
	}
	
	private static boolean isCodeLineValid(String line)
	{
		int p = 0, len = line.length();
		char ch;
		
		while (p < len)
		{
			ch = line.charAt(p);
			if (ch <= ' ')  // 跳过空白字符
			{
				p++;
				continue;
			}
			else if (ch == '/')
			{
				p++;
				if (p >= len)
					return true;
				
				ch = line.charAt(p);
				if (ch == '*')
				{
					p = line.indexOf("*/", p+1);
					if (p < 0)  // 多行注释
						return true;
					else if (p == len-2)
						return false;
					p += 2;
				}
				else
					return ch != '/';  // ch=='/'是"//"的整行注释
			}
			else
				return true;
		}
		
		return false;
	}
}
