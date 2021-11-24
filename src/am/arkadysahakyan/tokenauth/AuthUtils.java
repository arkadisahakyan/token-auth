package am.arkadysahakyan.tokenauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthUtils {
	
	public static final String AUTH_TOKEN = "java";
	
	public static boolean isAuthenticated(Cookie[] cks) {
		if (cks != null) {
			for (Cookie ck: cks) {
				if (AUTH_TOKEN.equals(ck.getValue())) return true;
			}
		}
		return false;
	}
}
