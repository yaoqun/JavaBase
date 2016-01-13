package spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifecycle implements InitializingBean, DisposableBean
{
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("BeanLifecycle.afterPropertiesSet() 接口InitializingBean");
	}

	public void initMethod() {
		System.out.println("BeanLifecycle.init() 配置项init-method");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("BeanLifecycle.destroy() 接口DisposableBean");
	}

	public void destroyMethod() {
		System.out.println("BeanLifecycle.destoryMethod() 配置项destory-method");
	}

	public void call() {
		System.out.println("BeanLifecycle.call()");
	}
}
