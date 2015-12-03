package commonclass;

import java.lang.reflect.Method;

public class JStringBuffer
{
	public static final String NickName
			= "比较 StringBuffer 和 StringBuilder";
	
	private static final int ThreadNum = 500;
	
	public static void Test()
	{
		try {
			test("StringBuffer");
			test("StringBuilder");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test(String className) throws Exception
	{
		Class<?> c = Class.forName("java.lang." + className);
		Object obj = c.newInstance();
		
		Method append = c.getMethod("append", Class.forName("java.lang.String"));
		
		Thread[] ths = new Thread[ThreadNum];
		long time = System.currentTimeMillis();
		
		for (int i = 0; i < ThreadNum; i++)
		{
			Thread t = new Thread(new Runnable() {
				@Override
				public void run()
				{
					for (int i = 0; i < 100; i++)
					{
						try { append.invoke(obj, "a"); }
						catch (Exception e) { e.printStackTrace(); }
					}
				}
			});
			t.start();
			ths[i] = t;
		}
		
		for (Thread t : ths)
			t.join();
		
		time = System.currentTimeMillis() - time;
		Method getLength = c.getMethod("length");
		System.out.println(className +
				"\tlength: " + getLength.invoke(obj) +
				"  runtime: " + time + "ms" );
	}
}
