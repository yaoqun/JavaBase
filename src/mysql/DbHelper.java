package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bookstore.Book;

public class DbHelper
{
	private static DbHelper m_Db = new DbHelper();
	
	public static DbHelper getInstance()
	{
		return m_Db;
	}
	
	private boolean m_initOk = false;
	
	private Connection m_conn;
	
	private DbHelper()
	{
		try
		{
			String url = "jdbc:mysql://localhost/bookstore";
			String user = "root";
			String password = "wh1991";
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			m_conn = DriverManager.getConnection(url, user, password);
			
			initDatabase();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			m_initOk = false;
		}
		m_initOk = true;
	}
	
	public boolean isInitOk()
	{
		return m_initOk;
	}
	
	public List<String> getAllBookNames()
	{
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			stmt = m_conn.createStatement();
			rs = stmt.executeQuery("select bookname from books");
			
			List<String> books = new ArrayList<String>();
			while (rs.next())
				books.add(rs.getString("bookname"));
			return books;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (rs != null)
			{
				try { rs.close(); rs = null; }
				catch (Exception e) { }
			}
			if (stmt != null)
			{
				try { stmt.close(); stmt = null; }
				catch (Exception e) { }
			}
		}
	}
	
	public Book getBook(String bookname)
	{
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{
			String sql = String.format(
				"select * from books where bookname='%s'",
				bookname);
			stmt = m_conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next())
			{
				Book b = new Book();
				b.setBookid(rs.getInt("bookid"));
				b.setBookname(rs.getString("bookname"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setPrice(rs.getFloat("price"));
				return b;
			}
			else
				return null;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (rs != null)
			{
				try { rs.close(); rs = null; }
				catch (Exception e) { }
			}
			if (stmt != null)
			{
				try { stmt.close(); stmt = null; }
				catch (Exception e) { }
			}
		}
	}
	
	private void initDatabase() throws Exception
	{
		Statement stmt = m_conn.createStatement();
		
		try { stmt.execute("drop table books"); }
		catch (Exception e) { }
		
		stmt.execute("create table books(" +
				"bookid int unsigned auto_increment not null primary key," +
				"bookname varchar(40) not null unique key," +
				"author varchar(40)," +
				"publisher varchar(40)," +
				"price float(5,2))");
		
		stmt.addBatch("insert into books values(null, 'Java编程思想', 'Bruce Eckel', '机械工业出版社', 75.60)");
		stmt.addBatch("insert into books values(null, 'Java核心技术', 'Cay S. Horstmann，Gary Cornell', '机械工业出版社', 91.40)");
		stmt.addBatch("insert into books values(null, 'Effective Java', 'Joshua Bloch', '机械工业出版社', 45.30)");
		stmt.addBatch("insert into books values(null, 'Spring实战', 'Craig Walls', '人民邮电出版社', 46.40)");
		stmt.addBatch("insert into books values(null, 'Tomcat与Java Web开发技术详解', '孙卫琴', '电子工业出版社', 67.60)");
		stmt.executeBatch();
		
		stmt.close();
	}
}
