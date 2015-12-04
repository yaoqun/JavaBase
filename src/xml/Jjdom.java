package xml;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class Jjdom
{
	public static final String NickName = "JDom解析";
	
	public static void Test()
	{
		SAXBuilder saxb = new SAXBuilder();
		
		try
		{
			// 使用指定的字符集
			InputStreamReader in = new InputStreamReader(
					new FileInputStream("xml/a.xml"),
					"utf-8");
			Document doc = saxb.build(in);
			
			// 根节点
			Element root = doc.getRootElement();
			Element tools = root.getChild("tools");
			
			// 遍历子节点
			List<Element> pens = tools.getChildren();
			for (Element pen : pens)
			{
				System.out.println("节点: " + pen.getName());
				
				// 遍历属性
				List<Attribute> attrs = pen.getAttributes();
				for (Attribute attr : attrs)
				{
					System.out.println("    属性: (" +
							attr.getName() + "," +
							attr.getValue() + ")");
				}
				
				// 遍历子节点
				List<Element> nodes = pen.getChildren();
				for (Element node : nodes)
				{
					System.out.println("    子节点: (" +
							node.getName() + "," +
							node.getValue() + ")");
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
