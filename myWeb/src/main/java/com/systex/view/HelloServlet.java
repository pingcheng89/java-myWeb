package com.systex.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String croot = request.getContextPath();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet HelloServlet</title>");
		out.println("<link href=\"../myStyle/style.css\" rel=\"stylesheet\"></link>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border='1' style='margin:auto'>");
		out.println("<tbody>");
		for (int i=1;i<=9;i++) {
			out.println("<tr>");
			for (int j=1;j<=9;j++) {
				out.println("<td>" + i + "*" + j + "=</td><td>" + i*j + "</td>");
			}
			out.println("</tr>");
		}
		
		out.println("</tbody>");
		out.println("</table>");
		out.println("<img src='"+croot+"/image/ghost.jpg'>");
		out.println("<br><a href='"+croot+"/'>Home</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
