package setframework;

// 课程类
public class Course implements Comparable<Course>
{
	private String m_name;
	
	public Course(String name)
	{
		m_name = name;
	}
	
	@Override
	public String toString()
	{
		return m_name;
	}
	
	@Override
	public int hashCode()
	{
		return m_name.charAt(0);
	}
	
	@Override
	public boolean equals(Object another)
	{
		if (another == null) return false;
		if (another == this) return true;
		if (another instanceof Course == false)
			return false;
		
		Course obj = (Course) another;
		
		if (m_name == null)
			return obj.m_name == null;
		else
			return m_name.equals( obj.m_name );
	}

	@Override
	public int compareTo(Course another) {
		if (m_name == null)
			return -1;
		if (another == null)
			return 1;
		return m_name.compareTo(another.m_name);
	}
}
