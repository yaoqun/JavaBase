package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class MyResourceTest extends SpringUnitTest {
	
	public MyResourceTest() {
		super("classpath*:spring-resource.xml");
	}
	
	@Test
	public void testGetResource() {
		MyResource r = super.getBean("myResource");
		r.getResource();
	}

}
