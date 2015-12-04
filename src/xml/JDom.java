package xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JDom
{
	public static final String NickName = "Dom解析";
	
	public static void Test()
	{
		DocumentBuilderFactory domf = DocumentBuilderFactory.newInstance();
		
		try
		{
			DocumentBuilder db = domf.newDocumentBuilder();
			Document doc = db.parse("xml/a.xml");
			
			// 遍历节点
			NodeList pens = doc.getElementsByTagName("pen");
			int nNode = pens.getLength();
			for (int i_node = 0; i_node < nNode; i_node++)
			{
				Node pen = pens.item(i_node);
				
				// 用属性名获取属性值
				Element ele = (Element) pen;
				String id = ele.getAttribute("id");
				
				System.out.println("节点名-id: " +
						pen.getNodeName() + "-" + id);
				
				// 遍历属性
				NamedNodeMap attrs = pen.getAttributes();
				int nAttr = attrs.getLength();
				for (int i_attr = 0; i_attr < nAttr; i_attr++)
				{
					Node attr = attrs.item(i_attr);
					System.out.println("    属性: (" +
							attr.getNodeName()  + "," +
							attr.getNodeValue() + ")" );
				}
				
				// 遍历子节点
				NodeList chnodes = pen.getChildNodes();
				int n = chnodes.getLength();
				for (int i_chnode = 0; i_chnode < n; i_chnode++)
				{
					Node ch = chnodes.item(i_chnode);
					
					if (ch.getNodeType() != Node.ELEMENT_NODE)
						continue;
					
					String nodeName = ch.getNodeName();
					
					// 子节点值不能直接用getNodeValue()获得
					// 需要用子节点的第一个子节点的getNodeValue()
					String nodeValue1 = ch.getFirstChild().getNodeValue();
					
					String nodeValue2 = ch.getTextContent();
					
					System.out.println("    子节点: (" +
							nodeName + "," +
							nodeValue1 + "," +
							nodeValue2 + ")" );
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
