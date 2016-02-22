import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/filter")
public class MyFilter implements Filter{

	public void destroy() {
		System.out.println("+++ MyFilter destruindo..."+new Date());
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("+++ doFilter..."+req.getRemoteHost());
		
		HttpServletRequest request= (HttpServletRequest) req;
		HttpServletResponse response= (HttpServletResponse) resp;
		HttpSession session= request.getSession();
		
		
		
		
		User user = (User)session.getAttribute("user");
		
		if (user!=null){
			chain.doFilter(req, resp);	
		}else{
			response.sendRedirect("./unlogged/login.html");
		}
			
		
		
		
		
		
		
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
		//localizar usuario
		//localizar admin/perfil
		
		System.out.println("+++ MyFilter iniciado..."+new Date());
	}
	
	

}