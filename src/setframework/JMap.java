package setframework;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JMap
{
	public static final String NickName = "Map";
	
	private static Map<Integer, String> map = new HashMap<Integer, String>();
	
	private static String s1="语文", s2="数学";
	
	public static void Test()
	{
		testPutAndGet();
		System.out.println("-----");
		testKeySet();
		System.out.println("-----");
		testRemove();
		System.out.println("-----");
		testEntrySet();
	}
	
	private static void testPutAndGet()
	{
		System.out.println("put() 和 get()");
		
		// put()的key不存在, 返回null
		String ret = map.put(1, s1);
		System.out.println(ret == null);  // true
		
		// put()的key存在, 返回旧引用, Value更新成新引用
		ret = map.put(1, s2);
		System.out.println(ret == s1);  // true
		
		ret = map.get(1);
		System.out.println(ret == s2);  // true

		ret = map.get(2);
		System.out.println(ret == null);  // true
	}
	
	private static void testKeySet()
	{
		map.clear();
		map.put(1, s1);
		map.put(2, s2);
		
		System.out.println("遍历 keySet()");
		Set<Integer> keys = map.keySet();
		for (Integer key : keys)
		{
			String s = map.get(key);
			if (s != null)
				System.out.println("<" + key + ", " + s + ">");
		}
	}
	
	private static void testRemove()
	{
		System.out.println("remove()");
		
		boolean r1 = map.remove(1, s2);
		System.out.println(r1);  // false, value的equals返回false
		
		boolean r2 = map.remove(1, s1);
		System.out.println(r2);  // true, value的equals返回false
		
		System.out.println(map.remove(2));  // 直接用key删除
	}
	
	private static void testEntrySet()
	{
		map.clear();
		map.put(1, s1);
		map.put(2, s2);
		
		System.out.println("遍历 entrySet()");
		Set<Entry<Integer, String>> entries = map.entrySet();
		for (Entry<Integer, String> entry : entries)
		{
			System.out.println("<"   +
					entry.getKey()   + ", " +
					entry.getValue() + ">"
			);
		}
	}
}
