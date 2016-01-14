package spring;

public class MyImportRes {
	
	private String url;
	
	private String username1;
	
	private String username2;
	
	private String password;
	
	public MyImportRes(String url, String username1, String username2, String password) {
		this.url = url;
		this.username1 = username1;
		this.username2 = username2;
		this.password = password;
	}
	
	public void info() {
		System.out.println("MyImportRes >>");
		System.out.println("  url: " + url);
		System.out.println("  username1: " + username1);
		System.out.println("  username2: " + username2);
		System.out.println("  password: " + password);
	}

}
