package spring;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("MyBeforeAdvice.before()");
		System.out.println(
				"    方法名: " + method.getName() +
				", 目标对象类名: " + target.getClass().getName());
		method.invoke(target, args);
	}

}
