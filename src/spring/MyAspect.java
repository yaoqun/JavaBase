package spring;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void before() {
		System.out.println("MyAspect.before()");
	}
	
	public void afterReturning() {
		System.out.println("MyAspect.afterReturning()");
	}
	
	public void after() {
		System.out.println("MyAspect.after()");
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("MyAspect.around() start");
		
		Object ret = pjp.proceed();  // 业务方法执行, 返回void也是赋给ret

		System.out.println("MyAspect.around() end");
		return ret;
	}
	
	public Object aroundWithArgs(ProceedingJoinPoint pjp, String name, int age)
			throws Throwable {
		System.out.println("MyAspect.aroundWithArgs() start");
		
		Object ret = pjp.proceed();  // 业务方法执行, 返回void也是赋给ret

		System.out.println("MyAspect.aroundWithArgs() end");
		return ret;
	}

}
