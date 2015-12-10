package web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessListener implements HttpSessionListener
{
	private static int onlineUsernum = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent se)
	{
		Date now = new Date();
		
		HttpSession sess = se.getSession();
		Date sessCTime = new Date(sess.getCreationTime());
		
		++onlineUsernum;
		ServletContext sctx = sess.getServletContext();
		sctx.setAttribute("usernum", new Integer(onlineUsernum));
		
		sess.setAttribute("isSetIP", false);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(">> Http-Sess-Listener create\n" +
				"    session-ctime:  " + sdf.format(sessCTime) + "\n" +
				"    listener-ctime: " + sdf.format(now));
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se)
	{
		HttpSession sess = se.getSession();
		
		if (onlineUsernum > 0)
			--onlineUsernum;
		
		ServletContext sctx = sess.getServletContext();
		sctx.setAttribute("usernum", new Integer(onlineUsernum));
		
		@SuppressWarnings("unchecked")
		Map<String, String> userip = (Map<String, String>) sctx.getAttribute("userip");
		userip.remove(sess.getId());
		
		System.out.println(">> Http-Sess-Listener destory");
	}
}
