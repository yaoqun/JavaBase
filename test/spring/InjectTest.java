package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class InjectTest extends SpringUnitTest {
	
	public InjectTest() {
		super("classpath*:spring-inject.xml");
	}
	
	@Test
	public void testSetterInject() {
		Inject inject = super.getBean("inject");
		inject.save("setter注入方式");
	}
	
}
