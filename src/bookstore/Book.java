package bookstore;

public class Book
{
	private int bookid;
	private String bookname;
	private String author;
	private String publisher;
	private float price;
	
	public void setBookid(int id)
	{
		this.bookid = id;
	}
	
	public int getBookid()
	{
		return this.bookid;
	}
	
	public void setBookname(String name)
	{
		this.bookname = name;
	}
	
	public String getBookname()
	{
		return this.bookname;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	
	public String getPublisher()
	{
		return this.publisher;
	}
	
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public float getPrice()
	{
		return this.price;
	}
}
