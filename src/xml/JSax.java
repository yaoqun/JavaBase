package xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class JSax extends DefaultHandler
{
	public static final String NickName = "SAX解析";
	
	public static void Test()
	{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		
		try
		{
			SAXParser saxp = spf.newSAXParser();
			
			JSax handler = new JSax();
			saxp.parse("xml/a.xml", handler);
			System.out.println("ok.");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private int m_state = 0;
	private String m_value;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attrs) throws SAXException
	{
		super.startElement(uri, localName, qName, attrs);
		
		if (qName.equals("pen"))
		{
			// 获取属性
			System.out.print("pen (id," + attrs.getValue("id") + ") ");
			
			// 遍历属性
			int nAttr = attrs.getLength();
			for (int i = 0; i < nAttr; i++)
			{
				System.out.print("(" + attrs.getQName(i) + "," + attrs.getValue(i) + ")");
			}
			System.out.println();
		}
		else if (qName.equals("name"))
		{
			m_state = 1;
		}
		else if (qName.equals("price"))
		{
			m_state = 1;
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException
	{
		super.characters(ch, start, length);
		
		if (m_state == 1)
		{
			m_value = new String(ch, start, length);
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException
	{
		super.endElement(uri, localName, qName);
		
		if (qName.equals("pen"))
		{
			System.out.println(qName + " end \n");
		}
		
		if (m_state == 1)
		{
			m_state = 0;
			System.out.println("    (" + qName + "," + m_value + ")");
		}
	}
	
	@Override
	public void startDocument() throws SAXException
	{
		super.startDocument();
		System.out.println("parse start ...\n");
	}
	
	@Override
	public void endDocument() throws SAXException
	{
		super.endDocument();
		System.out.println("parse end.");
	}
}
