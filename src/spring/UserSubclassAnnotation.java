package spring;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class UserSubclassAnnotation extends UserAnnotation {
	
	public void say() {
		System.out.println("UserSubclassAnnotation.say()");
	}

}
