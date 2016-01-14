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
		System.out.println(">> 测试Bean对象定义");
		BeanAnnotation bean1 = super.getBean("beanAnnotation");
		bean1.say();
		BeanAnnotation bean2 = super.getBean("beanAnnotation");
		System.out.println("hashCode相同: " + bean1.hashCode() + ", " + bean2.hashCode());
		assertFalse(bean1.hashCode() != bean2.hashCode());
		
		UserAnnotation user1 = super.getBean("baseUser");
		UserAnnotation user2 = super.getBean("baseUser");
		System.out.println("hashCode不同: " + user1.hashCode() + ", " + user2.hashCode());
		assertFalse(user1.hashCode() == user2.hashCode());
	}
	
	@Test
	public void testAutoWire() {
		System.out.println(">> 测试自动装配");
		BeanAnnotation bean = super.getBean("beanAnnotation");
		UserAnnotation user = bean.getUserAnnotation();
		user.say();
	}
	
	@Test
	public void testAutoWireMap() {
		System.out.println(">> 测试自动装配用于集合");
		BeanAnnotation bean = super.getBean("beanAnnotation");
		Map<String, UserAnnotation> userMap = bean.getUserMap();
		for (Map.Entry<String, UserAnnotation> e : userMap.entrySet()) {
			System.out.print(e.getKey() + "\n    ");
			e.getValue().say();
		}
	}
	
	@Test
	public void testAutoWireList() {
		System.out.println(">> 测试自动装配用于集合时有序");
		BeanAnnotation bean = super.getBean("beanAnnotation");
		List<UserAnnotation> userList = bean.getUserList();
		System.out.println("有序:");
		for (UserAnnotation e : userList) {
			e.say();
		}
	}
	
	@Test
	public void testQualifier() {
		System.out.println(">> 测试自动装配的Qualifier");
		BeanAnnotation bean = super.getBean("beanAnnotation");
		UserAnnotation baseUser = bean.getUserAnnotation();
		baseUser.say();
		UserAnnotation subUser = bean.getSubUserAnnotation();
		subUser.say();
	}

}
