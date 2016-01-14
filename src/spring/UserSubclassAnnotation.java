package spring;

import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("subUser")
@Scope("prototype")
@Order(value=1)
public class UserSubclassAnnotation extends UserAnnotation {
	
	public void say() {
		System.out.println("UserSubclassAnnotation.say()");
	}

}
