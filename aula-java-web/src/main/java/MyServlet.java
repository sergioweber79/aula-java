
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name="/servlet")
public class MyServlet extends HttpServlet {
	
	
	
	/**
	 *
	 * seriaID
	 */
	private static final long serialVersionUID = -7065261186534307667L;

	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String birthDay = req.getParameter("birthDay");
		
		
		StringBuilder sb = new StringBuilder();
		
		resp.setContentType("text/json");
		
		sb.append("{'nome' : "+"'"+name+"',");
		sb.append("'email' : "+"'"+email+"',");
		sb.append("'address' : "+"'"+address+"',");
		sb.append("'birthDay' : "+"'"+birthDay+"'}");
		
		resp.getWriter().append(sb);
		
		
		
	}

}
