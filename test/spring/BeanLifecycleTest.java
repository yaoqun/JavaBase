package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class BeanLifecycleTest extends SpringUnitTest {
	
	public BeanLifecycleTest() {
		super("classpath*:spring-beanlifecycle.xml");
	}
	
	@Test
	public void testLifecycle() {
		BeanLifecycle bean = super.getBean("beanLifecycle");
		bean.call();
	}

}
