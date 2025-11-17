package in.co.rays.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class FrontCtl extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("Intercepting request");

		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			request.setAttribute("errorMessage", "Session Expired..! Please Login Again");
			RequestDispatcher rd = request.getRequestDispatcher("/LoginCtl");
			rd.forward(request, response);

			return false;
		}
		return true;

	}
}
