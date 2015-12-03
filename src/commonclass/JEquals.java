package commonclass;

public class JEquals
{
	public static final String NickName = "重写 equals()";
	
	public static void Test()
	{
		JEquals a = new JEquals(1);
		JEquals b = new JEquals(1);
		JEquals c = new JEquals(2);
		
		System.out.println( a.equals(null) );  // false
		System.out.println( a.equals(a) );     // true
		System.out.println( a.equals(b) );     // true
		System.out.println( a.equals(c) );     // false
	}
	
	private int m_val = 0;
	
	public JEquals(int val)  { m_val = val; }
	
	public int get()  { return m_val; }
	
	@Override
	public boolean equals(Object another)
	{
		if (another == null)  return false;
		if (another == this)  return true;
		// if ( another instanceof JEquals == false )
		if (another.getClass() != this.getClass())
			return false;
		
		JEquals f = (JEquals) another;
		return f.get() == this.get();
	}
}
