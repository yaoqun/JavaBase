package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class AopApiTest extends SpringUnitTest {

	public AopApiTest() {
		super("classpath*:spring-aopapi.xml");
	}
	
	@Test
	public void test() {
		Log log = super.getBean("logImpl");
		log.log();
	}
	
}
