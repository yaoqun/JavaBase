package xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Jdom4j
{
	public static final String NickName = "Dom4j解析";
	
	public static void Test()
	{
		SAXReader saxr = new SAXReader();
		
		try
		{
			Document doc = saxr.read(new File("xml/a.xml"));
			
			// 根节点
			Element root = doc.getRootElement();
			Element tools = root.element("tools");
			
			Iterator<?> it = tools.elementIterator();
			while (it.hasNext())
			{
				Element node = (Element) it.next();
				System.out.println("节点: " + node.getName());
				
				// 遍历属性
				List<?> attrs = node.attributes();
				for (Object obj : attrs)
				{
					Attribute attr = (Attribute) obj;
					System.out.println("    属性: (" +
							attr.getName() + "," +
							attr.getValue() + ")");
				}
				
				// 遍历子节点
				List<?> subNodes = node.elements();
				for (Object obj : subNodes)
				{
					Element subn = (Element) obj;
					System.out.println("    子节点: (" +
							subn.getName() + "," +
							subn.getStringValue() + ")");
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
