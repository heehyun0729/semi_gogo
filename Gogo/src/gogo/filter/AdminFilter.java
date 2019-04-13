package gogo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/admin/*")
public class AdminFilter implements Filter {
    public AdminFilter() {}
	public void destroy() {}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		String id = (String)req.getSession().getAttribute("mem_id");
		if (id == null || id.equals("")) {
			req.setAttribute("spage", "/mem/login.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}else if(id.equals("admin")){
			chain.doFilter(request, response);
		}else{
			// 오류처리
			System.out.println("잘못된 사용자가 admin 페이지 접근: 회원 id [" + id + "]");
			req.setAttribute("spage", "/main.jsp");
			req.getRequestDispatcher("/home.jsp").forward(req, resp);
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {}
}
