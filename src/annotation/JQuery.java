package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JQuery
{
	public static final String NickName = "生成SQL语句";
	
	public static void Test()
	{
		QueryFilter f1 = new QueryFilter();
		f1.setUsername("张三");
		System.out.println(query(f1));
		
		QueryFilter f2 = new QueryFilter();
		f2.setAge(20);
		System.out.println(query(f2));
		
		QueryFilter f3 = new QueryFilter();
		f3.setUsername("李四");
		f3.setAge(25);
		System.out.println(query(f3));
		
		QueryFilter f4 = new QueryFilter();
		System.out.println(query(f4));
	}
	
	private static String query(QueryFilter filter)
	{
		Class<?> c = filter.getClass();
		if ( ! c.isAnnotationPresent(Table.class) )
			return null;
		
		// 获取表名
		Table table = c.getAnnotation(Table.class);
		String tableName = table.value();
		
		StringBuilder sql = new StringBuilder(
				"select * from " + tableName + " where 1=1");
		
		Field[] fs = c.getDeclaredFields();
		for (Field f : fs)
		{
			// 获取列名
			if ( ! f.isAnnotationPresent(Column.class) )
				continue;
			Column col = f.getAnnotation(Column.class);
			String colName = col.value();
			
			// 获取字段值
			Object fieldValue = null;
			String fieldName = f.getName();
			String getMethodName = "get" +
					fieldName.substring(0, 1).toUpperCase() +
					fieldName.substring(1);
			try {
				Method getMethod = c.getMethod(getMethodName);
				fieldValue = getMethod.invoke(filter);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			if (fieldValue != null)
			{
				sql.append(" and ").append(colName).append("=");
				if (fieldValue instanceof String)
				{
					sql.append("'").append(fieldValue).append("'");
				}
				else
					sql.append(fieldValue);
			}
		}
		
		return sql.toString();
	}
}
