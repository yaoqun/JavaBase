package setframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class JList
{
	public static final String NickName = "List";
	
	private static List<Course> lst = new ArrayList<Course>();
	
	public static void Test()
	{
		testAdd();
		System.out.println("-----");
		testAddAll();
		System.out.println("-----");
		testIterator();
		System.out.println("-----");
		testSet();
		System.out.println("-----");
		testRemove();
		System.out.println("-----");
		testContains();
		System.out.println("-----");
		testIndexOf();
		System.out.println("-----");
		testSort();
	}
	
	private static void testAdd()
	{
		lst.add(new Course("1-语文"));
		System.out.println("add(ele), 第0个: " + lst.get(0));
		
		lst.add(0, new Course("2-数学"));
		System.out.println("add(0, ele), 第0个: " + lst.get(0));
		
		try {
			lst.add(3, new Course("3-英语"));
			System.out.println("add(3, ele), 第3个: " + lst.get(3));
		}
		catch (Exception e) {
			System.out.println("add(3, ele)越界异常, List的size(): " + lst.size());
		}
	}
	
	private static void testAddAll()
	{
		Course[] arr = { new Course("3-英语"), new Course("4-物理") };
		int n = lst.size();
		lst.addAll(Arrays.asList(arr));
		
		System.out.println("addAll(Collection<?>)");
		System.out.print("新增加元素: ");
		for (int i = n; i < lst.size(); i++)
			System.out.print(lst.get(i) + "  ");
		System.out.println();
	}
	
	private static void testIterator()
	{
		Iterator<?> it = lst.iterator();
		
		System.out.println("Iterator<?> 遍历");
		while (it.hasNext())
		{
			System.out.print(it.next() + "  ");
		}
		System.out.println();
	}
	
	private static void testSet()
	{
		System.out.println("set(1, 1-化学) 修改元素值");
		printList("修改前: ");
		
		lst.set(1, new Course("1-化学"));
		printList("修改后: ");
	}
	
	private static void testRemove()
	{
		System.out.println("remove(2) 删除第3个元素");
		lst.remove(2);
		printList("删除后: ");
		
		System.out.println("\nremoveAll(Collection<?>) 删除第1、3个元素");
		Course[] arr = { lst.get(0), lst.get(2) };
		lst.removeAll(Arrays.asList(arr));
		printList("删除后: ");
	}
	
	private static void testContains()
	{
		printList("链表: ");
		System.out.print("contains(1-化学): ");
		System.out.println(lst.contains(new Course("1-化学")));
	}
	
	private static void testIndexOf()
	{
		Course[] arr = { new Course("4-物理"), new Course("2-数学"), new Course("3-英语") };
		lst.addAll(Arrays.asList(arr));
		printList("链表: ");
		
		System.out.print("indexOf(3-英语): ");
		System.out.println(lst.indexOf(new Course("3-英语")));
	}
	
	private static void testSort()
	{
		printList("排序前: ");
		Collections.sort(lst);  // Course实现了接口Comparable
		printList("排序后: ");
	}
	
	private static void printList(String msg)
	{
		System.out.print(msg);
		printList();
	}
	
	private static void printList()
	{
		for (Course c : lst)
			System.out.print(c + "  ");
		System.out.println();
	}
}
