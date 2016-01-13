package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class MyAwareTest extends SpringUnitTest {
	
	public MyAwareTest() {
		super("classpath*:spring-aware.xml");
	}
	
	@Test
	public void testAware() {
		MyAware aware = super.getBean("myAware");
		System.out.println("MyAwareTest.testAware(), hash: " +
				aware.hashCode());
	}

}
