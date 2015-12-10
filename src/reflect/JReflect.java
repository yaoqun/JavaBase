package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class JReflect
{
	public static final String NickName = "反射";
	
	public static void Test()
	{
		test1();
		System.out.println("-----");
		test2();
		System.out.println("-----");
		test3();
	}
	
	private static void test1()
	{
		Class<?> c1 = JReflect.class;
		
		JReflect jref = new JReflect();
		Class<?> c2 = jref.getClass();
		
		Class<?> c3 = null;
		try {
			c3 = Class.forName("reflect.JReflect");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(c1 == c2);  // true
		System.out.println(c2 == c3);  // true
		
		System.out.println(int.class);
		System.out.println(String.class);
	}
	
	private static void test2()
	{
		Class<?> c = User.class;
		
		Method[] ms = c.getDeclaredMethods(); // c.getMethods();
		for (Method m : ms)
		{
			System.out.println("方法 " + m.getName());
			
			Class<?> retType = m.getReturnType();
			System.out.println("  返回 " + retType.getName());
			
			Class<?>[] paramTypes = m.getParameterTypes();
			System.out.print("  参数 (");
			for (Class<?> pType : paramTypes)
				System.out.print(" " + pType.getName());
			System.out.println(" )");
		}
		System.out.println();
		
		Field[] fs = c.getDeclaredFields();
		for (Field f : fs)
		{
			System.out.println("字段 " + f.getName());
		}
		System.out.println();
		
		Constructor<?>[] cons = c.getConstructors();
		for (Constructor<?> con : cons)
		{
			Class<?>[] paramTypes = con.getParameterTypes();
			System.out.print("构造方法 (");
			for (Class<?> pType : paramTypes)
				System.out.print(" " + pType.getName());
			System.out.println(" )");
		}
	}
	
	private static void test3()
	{
		ArrayList<Integer> listInt =
				new ArrayList<Integer>();
		ArrayList<String> listStr =
				new ArrayList<String>();
		
		Class<?> cInt = listInt.getClass();
		Class<?> cStr = listStr.getClass();
		
		System.out.println(cInt == cStr);  // true
		
		try {
			Method add = cStr.getMethod("add", Object.class);
			add.invoke(listStr, "str");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class User
	{
		private String username;
		private int age;
		
		public User() {
			username = "无名";
			age = 0;
		}
		
		public User(String username, int age) {
			this.username = username;
			this.age = age;
		}
		
		public String getUsername() {
			return username;
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
	}
}
