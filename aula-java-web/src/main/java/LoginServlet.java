import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8431430892643244256L;

	
	private static final User ADMIN = User
			.builder()
			.name("admin")
			.pass("admin")
			.build();
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
		
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		
		User sessionUser = User
				.builder()
				.name(name)
				.pass(pass)
				.build();
		
		if (ADMIN.equals(sessionUser)){
			req.getSession().setAttribute("user", sessionUser);
			RequestDispatcher rd = req.getRequestDispatcher("/logged/index.html");
			rd.forward(req, resp);

			
		}else{
			req.getSession().setAttribute("user", null);
			
			RequestDispatcher rd = req.getRequestDispatcher("/unlogged/login.html");
			rd.forward(req, resp);
			
		}
		
	}
	
	
}
