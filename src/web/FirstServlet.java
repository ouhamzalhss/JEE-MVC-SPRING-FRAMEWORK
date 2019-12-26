package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name="cs", urlPatterns = "/fs")
public class FirstServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nom = req.getParameter("nom");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>nom est:"+ nom + "</h1>");
		out.println("<h1>nom est:"+ req.getProtocol() + "</h1>");
		out.println("</html></body>");
		
	}
	

}
