package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@JAnno(name="JUseAnno类-class")
public class JUseAnno extends JAUseAnno implements JIUseAnno
{
	public static final String NickName = "注解";
	
	public static void Test()
	{
		try {
			Class<?> c = Class.forName("annotation.JUseAnno");
			Class<? extends Annotation> cAnno = JAnno.class;
			
			// 类上的注解
			if (c.isAnnotationPresent(cAnno))
			{
				JAnno anno = (JAnno) c.getAnnotation(cAnno);
				System.out.println(anno.name() + "  " + anno.age());
			}
			
			// 方法上的注解
			Method[] ms = c.getMethods();
			for (Method m : ms)
			{
				if (m.isAnnotationPresent(cAnno))
				{
					JAnno anno = (JAnno) m.getAnnotation(cAnno);
					System.out.println(anno.name() + "  " + anno.age());
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@JAnno(name="JUseAnno类-method-plainMethod()", age=25)
	public void plainMethod()
	{
	}
	
	@Override
	public void interfaceAnno()
	{
	}
	
	@Override
	public void abstractAnno()
	{
	}
}
