package xml;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class JDomW
{
	public static final String NickName = "JDom生成xml";
	
	public static void Test()
	{
		DocumentBuilderFactory domf = DocumentBuilderFactory.newInstance();
		
		try
		{
			DocumentBuilder db = domf.newDocumentBuilder();
			Document doc = db.newDocument();
			
			// 创建根节点, 并添加到DOM树
			Element root = doc.createElement("store");
			doc.appendChild(root);
			
			// 子节点
			Element book = doc.createElement("book");
			book.setAttribute("id", "1001");
			root.appendChild(book);
			
			Element bookName = doc.createElement("name");
			Text bookNameText = doc.createTextNode("数据结构");
			bookName.appendChild(bookNameText);
			book.appendChild(bookName);
			
			//File xmlFile = new File("xml/books.xml");
			OutputStreamWriter writer = new OutputStreamWriter(
					new FileOutputStream("xml/books.xml"),
					"utf-8");
			StreamResult sret = new StreamResult(writer);
			
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			tf.transform(new DOMSource(doc), sret);
			
			System.out.println("生成成功");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
