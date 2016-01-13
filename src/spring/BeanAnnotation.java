package spring;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("beanAnnotation")
@Scope("singleton")
public class BeanAnnotation {
	
	public void say() {
		System.out.println("BeanAnnotation.say()");
	}
	
	private UserAnnotation userAnnotation;
	
	@Autowired
	public void setUserAnnotation(UserAnnotation userAnnotation) {
		this.userAnnotation = userAnnotation;
	}
	
	public UserAnnotation getUserAnnotation() {
		return this.userAnnotation;
	}
	
	@Autowired
	private Map<String, UserAnnotation> userMap;
	
	public Map<String, UserAnnotation> getUserMap() {
		return this.userMap;
	}
	
	@Autowired
	private List<UserAnnotation> userList;
	
	public List<UserAnnotation> getUserList() {
		return this.userList;
	}

}
