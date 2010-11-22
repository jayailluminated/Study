package servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 7, 2010
 * Time: 10:31:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyServletToTest extends HttpServlet {

	Logger logger = LoggerFactory.getLogger(MyServletToTest.class);

	public void doGet (HttpServletRequest request, HttpServletResponse response) {
		logger.debug("doGet()");
		HttpSession session = request.getSession();
		session.setAttribute("session", request.getServletPath());
		request.setAttribute("request", request.getServletPath());

		try {
			request.getRequestDispatcher("/template.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
