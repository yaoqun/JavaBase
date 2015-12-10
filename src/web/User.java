package web;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionActivationListener
{
	private String username;
	private int age;
	
	// 钝化
	@Override
	public void sessionWillPassivate(HttpSessionEvent se)
	{
		HttpSession sess = se.getSession();
		User u = (User) sess.getAttribute("user");
		System.out.println(">> Session 钝化\n" +
				"    username: " + u.getUsername() + "\n" +
				"    age: " + u.getAge());
	}
	
	// 活化
	@Override
	public void sessionDidActivate(HttpSessionEvent se)
	{
		HttpSession sess = se.getSession();
		User u = (User) sess.getAttribute("user");
		System.out.println(">> Session 活化\n" +
				"    username: " + u.getUsername() + "\n" +
				"    age: " + u.getAge());
	}
	
	public User(String username, int age)
	{
		this.username = username;
		this.age = age;
	}
	
	public User() {
		this.username = "无名";
		this.age = 20;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
