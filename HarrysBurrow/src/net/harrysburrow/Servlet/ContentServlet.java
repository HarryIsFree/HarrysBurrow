package net.harrysburrow.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.harrysburrow.Bean.Blog;
import net.harrysburrow.DAO.BurrowDAO;

public class ContentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ContentServlet() {
		super();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BurrowDAO dao = new BurrowDAO();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//System.out.println("Request Received");
		String id = request.getParameter("id");
		int ID = 0;
		try{
			ID = Integer.parseInt(id);
		}catch(Exception e){
			out.write("Parameter Error");
			return;
		}
		ArrayList<Blog> list = dao.getBlogs();
		if(ID>0&&ID<=list.size()){
			for(Blog blog: list){
				if(ID == blog.getID()){
					out.write(blog.getContent());
					return;
				}
			}
			out.write("Parameter Error");
			return;
		}
		else{
			out.write("Parameter Error");
			return;
		}
	}

}
