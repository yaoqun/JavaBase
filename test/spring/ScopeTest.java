package spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class ScopeTest extends SpringUnitTest {
	
	public ScopeTest() {
		super("classpath*:spring-beanscope.xml");
	}
	
	@Test
	public void testSingletonScope() {
		SingletonUser u1 = super.getBean("singletonUser");
		
		SingletonUser u2 = super.getBean(SingletonUser.class);
		
		assertEquals(u1.hashCode(), u2.hashCode());
	}
	
	@Test
	public void testPrototypeScope() {
		PlainUser u1 = super.getBean("plainUser");
		
		PlainUser u2 = super.getBean("plainUser");
		
		assertFalse(u1.hashCode() != u2.hashCode());
	}

}
