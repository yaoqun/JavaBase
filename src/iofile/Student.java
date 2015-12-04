package iofile;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int m_id;
	private String m_name;
	
	private transient String m_password;
	
	public Student(int id, String name, String password)
	{
		m_id = id;
		m_name = name;
		m_password = password;
	}
	
	@Override
	public String toString()
	{
		return String.format("(%d, %s, %s)",
				m_id, m_name, m_password);
	}
	
	// 自定义序列化
	private void writeObject(ObjectOutputStream oout)
			throws IOException
	{
		oout.defaultWriteObject();
		
		byte[] buf = "xxxxxx".getBytes("utf-8");
		oout.writeInt(buf.length);
		oout.write(buf);
	}
	
	// 自定义反序列化
	private void readObject(ObjectInputStream oin)
			throws IOException, ClassNotFoundException
	{
		oin.defaultReadObject();
		
		int nBuf = oin.readInt();
		byte[] buf = new byte[nBuf];
		oin.read(buf);
		m_password = new String(buf, "utf-8");
	}
}
