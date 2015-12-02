package main;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class JToolClass
{
	public static final String NickName = "Date Random Integer BigDecimal";
	
	public static void Test()
	{
		testDate();
		System.out.println("-----");
		testRandom();
		System.out.println("-----");
		testInteger();
		System.out.println("-----");
		testBigDecimal();
	}
	
	private static void testDate()
	{
		// 使用format()方法将日期转换为指定格式的文本
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// 创建Date对象，表示当前时间
		Date now = new Date();
		
		// 调用format()方法，将日期转换为字符串并输出
		System.out.println(sdf1.format(now));
		System.out.println(sdf2.format(now));
		System.out.println(sdf3.format(now));
		
		// 使用parse()方法将文本转换为日期
		String d = "2014-6-1 21:05:36";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// 调用parse()方法，将字符串转换为日期
		Date date = null;
		try { date = sdf.parse(d); }
		catch (ParseException e) { e.printStackTrace(); }
		System.out.println(date);
	}
	
	private static void testRandom()
	{
		// 定义一个整型数组，长度为10
		int[] nums = new int[10];
		
		//通过循环给数组赋值
		for (int i = 0; i < nums.length; i++)
			nums[i] = (int) (Math.random() * 10);
		
		System.out.println( Arrays.toString(nums) );
	}
	
	private static void testInteger()
	{
		Integer i1 = Integer.parseInt("1000");
		System.out.println("\"1000\"转整数(十进制): " + i1);
		Integer i2 = Integer.parseInt("1000", 2);
		System.out.println("\"1000\"转整数(二进制): " + i2);
		
		// convert type
		double d1 = i1.doubleValue();
		System.out.println("转成double类型: " + d1);
		
		int m = 30, n = 30;
		i1 = new Integer(m);
		i2 = n;
		System.out.println("手动和自动装箱: " + i1 + "和" + i2);
		
		int i = i1.intValue();
		int j = i2;
		System.out.println("手动和自动拆箱: " + i + "和" + j);
	}
	
	private static void testBigDecimal()
	{
		System.out.println("正确答案: 3.000000003");
		
		BigDecimal bd1 = new BigDecimal("1.000000001");
		BigDecimal bd2 = new BigDecimal("2.000000002");
		BigDecimal bd3 = bd1.add(bd2);
		System.out.println("BigDecimal: " + bd3);
		
		Double d1 = new Double("1.000000001");
		Double d2 = new Double("2.000000002");
		Double d3 = d1 + d2;
		System.out.println("Double: " + d3);
	}
}
