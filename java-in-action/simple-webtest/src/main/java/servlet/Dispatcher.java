package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;

public class Dispatcher extends HttpServlet {
	
	public void doGet (HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ResourceBundle messages = (ResourceBundle) session.getAttribute("messages");
		if (messages == null) {
			Locale locale = request.getLocale();
			messages = ResourceBundle.getBundle("messages.BookstoreMessages", locale);
			session.setAttribute("messages", messages);
		}
		request.setAttribute("selectedScreen", request.getServletPath());
		try {
			request.getRequestDispatcher("/template.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void doPost (HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("selectedScreen", request.getServletPath());
		try {
			request.getRequestDispatcher("/template.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
