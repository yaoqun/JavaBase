package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class MyImportResourceTest extends SpringUnitTest {
	
	public MyImportResourceTest() {
		//super("classpath*:spring-importresource.xml");
	}
	
	@Test
	public void test() {
		MyImportRes res = super.getBean("myImportRes");
		res.info();
	}

}
