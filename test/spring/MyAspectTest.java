package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class MyAspectTest extends SpringUnitTest {
	
	public MyAspectTest() {
		super("classpath*:spring-aop.xml");
	}
	
	@Test
	public void test() {
		MyBussiness buss = super.getBean("myBussiness");
		buss.bussiness();
		buss.set("whiker", 20);
	}

}
