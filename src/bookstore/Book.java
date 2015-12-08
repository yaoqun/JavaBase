package bookstore;

public class Book
{
	private String bookname;
	private String author;
	private String publisher;
	private float price;
	
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
