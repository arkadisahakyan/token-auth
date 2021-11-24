package am.arkadysahakyan.tokenauth.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static am.arkadysahakyan.tokenauth.GeneralInfo.URL_PATTERN_PREFIX;
import static am.arkadysahakyan.tokenauth.AuthUtils.isAuthenticated;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		if (isAuthenticated(req.getCookies())) {
			PrintWriter out = res.getWriter();
			out.println("Hello, world!");
		} else {
			res.sendRedirect(URL_PATTERN_PREFIX + "/auth");
		}
	}
}
