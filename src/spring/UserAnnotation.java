package spring;

import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
@Order(value=2)
public class UserAnnotation {
	
	public void say() {
		System.out.println("UserAnnotation.say()");
	}

}
