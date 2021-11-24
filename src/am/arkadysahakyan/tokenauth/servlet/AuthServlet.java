package am.arkadysahakyan.tokenauth.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static am.arkadysahakyan.tokenauth.AuthUtils.AUTH_TOKEN;
import static am.arkadysahakyan.tokenauth.AuthUtils.isAuthenticated;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (isAuthenticated(req.getCookies())) {
			PrintWriter out = res.getWriter();
			out.println("That is unnecessary.");
		} else {
			req.getRequestDispatcher("auth.jsp").forward(req, res);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String target = req.getParameter("token");
		PrintWriter out = res.getWriter();
		if (AUTH_TOKEN.equals(target)) {
			res.addCookie(new Cookie("token", AUTH_TOKEN));
			out.println("Success");
		} else {
			out.println("Failure");
		}
	}
}
