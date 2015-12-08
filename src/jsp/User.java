package jsp;

public class User
{
	private String userName = "未设置";
	private int userAge;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String name) {
		/*
		try {
			byte[] buf = name.getBytes("ISO-8859-1");
			this.userName = new String(buf, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		this.userName = name;
	}
	
	public int getUserAge() {
		return userAge;
	}
	
	public void setUserAge(int age) {
		this.userAge = age;
	}
}
