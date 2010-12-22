package jjseo.test.container;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * A sample servlet to demonstrate how to unit test servlets with Cactus.
 */
public class SampleServlet extends HttpServlet {

    /**
     * Default serial version ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Checks to see if the authenticated attribute has been setup with value of
     * true.
     *
     * @param request
     * @return
     */
    public boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return false;
        }

        String authenticationAttribute = (String) session.getAttribute("authenticated");

        return Boolean.valueOf(authenticationAttribute).booleanValue();
    }
}
