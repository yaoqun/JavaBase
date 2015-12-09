package web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private String admin;
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)
	{
		try {
			rsp.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = rsp.getWriter();
			out.print("servlet doGet()<br><hr>");
			
			out.println("初始化参数 admin: " + admin);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse rsp)
	{
		try {
			rsp.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = rsp.getWriter();
			out.print("servlet doPost()<br><hr>");
			
			out.println("初始化参数 admin: " + admin);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init()
	{
		admin = getInitParameter("admin");
	}
}
