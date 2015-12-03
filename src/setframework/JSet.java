package setframework;

import java.util.HashSet;
import java.util.Set;

public class JSet
{
	public static final String NickName = "Set";
	
	private static Set<Course> set = new HashSet<Course>();
	
	public static void Test()
	{
		Course[] arr = {
				null,
				new Course("1-语文"),
				new Course("2-数学"),
				new Course("3-英语"),
				new Course("4-物理")
		};
		
		System.out.println("按照{2,1,4,3,2}顺序 add(ele)");
		set.add(arr[2]);
		set.add(arr[1]);
		set.add(arr[4]);
		set.add(arr[3]);

		set.add(arr[2]);  // 引用相同
		set.add(new Course("2-数学"));  // 值相同, 重写了equals()
		
		printSet();  // 有序输出, 重写了hashCode()
	}
	
	private static void printSet()
	{
		for (Course c : set)
			System.out.print(c + "  ");
		System.out.println();
	}
}
