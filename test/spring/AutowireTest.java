package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class AutowireTest extends SpringUnitTest {
	
	public AutowireTest() {
		super("classpath*:spring-autowire.xml");
	}
	
	@Test
	public void testSave() {
		Autowire autowire = super.getBean("autowire");
		autowire.save("byName");
	}

}
