package spring;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class SpringUnitTest
{
	private ClassPathXmlApplicationContext mContext;
	
	private String mSpringXmlPath;
	
	public SpringUnitTest() {
	}
	
	public SpringUnitTest(String springXmlPath) {
		mSpringXmlPath = springXmlPath;
	}
	
	@Before
	public void before() {
		if (StringUtils.isEmpty(mSpringXmlPath)) {
			mSpringXmlPath = "classpath*:spring-*.xml";
		}
		try {
			mContext = new ClassPathXmlApplicationContext(
					mSpringXmlPath.split("[,\\s]+"));
			mContext.start();
		}
		catch (BeansException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void after() {
		mContext.destroy();
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T getBean(String beanId) {
		try {
			return (T)mContext.getBean(beanId);
		}
		catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	protected <T> T getBean(Class<T> c) {
		try {
			return mContext.getBean(c);
		}
		catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}
}
