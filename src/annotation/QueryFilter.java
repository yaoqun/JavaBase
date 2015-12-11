package annotation;

@Table("user")
public class QueryFilter
{
	@Column("name")
	private String username;

	@Column("age")
	private Integer age;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
