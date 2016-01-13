package spring;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class AnnotationTest extends SpringUnitTest {
	
	public AnnotationTest() {
		super("classpath*:spring-annotation.xml");
	}
	
	@Test
	public void testDefineBean() {
		BeanAnnotation bean1 = super.getBean("beanAnnotation");
		bean1.say();
		BeanAnnotation bean2 = super.getBean("beanAnnotation");
		System.out.println("hashCode相同: " + bean1.hashCode() + ", " + bean2.hashCode());
		assertFalse(bean1.hashCode() != bean2.hashCode());
		
		UserAnnotation user1 = super.getBean("userAnnotation");
		UserAnnotation user2 = super.getBean("userAnnotation");
		System.out.println("hashCode不同: " + user1.hashCode() + ", " + user2.hashCode());
		assertFalse(user1.hashCode() == user2.hashCode());
	}
	
	@Test
	public void testAutoWire() {
		BeanAnnotation bean = super.getBean("beanAnnotation");
		UserAnnotation user = bean.getUserAnnotation();
		user.say();
	}
	
	@Test
	public void testAutoWireMap() {
		BeanAnnotation bean = super.getBean("beanAnnotation");
		Map<String, UserAnnotation> userMap = bean.getUserMap();
		for (Map.Entry<String, UserAnnotation> e : userMap.entrySet()) {
			System.out.print(e.getKey() + "\n    ");
			e.getValue().say();
		}
	}
	
	@Test
	public void testAutoWireList() {
		BeanAnnotation bean = super.getBean("beanAnnotation");
		List<UserAnnotation> userList = bean.getUserList();
		System.out.println("有序:");
		for (UserAnnotation e : userList) {
			e.say();
		}
	}

}
