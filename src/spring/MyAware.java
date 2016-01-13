package spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyAware implements ApplicationContextAware, BeanNameAware {
	
	private String mBeanName;
	
	@Override
	public void setBeanName(String beanName) {
		mBeanName = beanName;
		System.out.println("MyAware.setBeanName(), beanName: " + beanName);
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		System.out.println("ApplicationContext.setApplicationContext(), hash: " +
				context.getBean(mBeanName).hashCode());
	}

}
