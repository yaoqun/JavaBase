package spring;

public class MyBussiness {
	
	public void bussiness() {
		System.out.println("MyBussiness.bussiness()");
	}
	
	public void set(String name, int age) {
		System.out.println("MyBussiness.set()");
		System.out.println("  name=" + name + ", age=" + age);
	}

}
