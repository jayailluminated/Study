package jjseo.test.servlets;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A sample servlet for our Admin application.
 */
public class AdminServlet extends HttpServlet {

    /**
     * Default serial version ID.
     */
    private static final long serialVersionUID = 1L;
    /**
     * The command parameter that we use to pass the SQL command to execute.
     */
    public static final String COMMAND_PARAM = "command";

    /**
     * A helper method to extract the command parameter from the request object.
     *
     * @param request
     * @return
     * @throws ServletException
     */
    public String getCommand(HttpServletRequest request) throws ServletException {
        String command = request.getParameter(COMMAND_PARAM);
        if (command == null) {
            throw new ServletException("Missing parameter [" + COMMAND_PARAM + "]");
        }
        return command;
    }

    /**
     * This method calls the corresponding view to display the result.
     *
     * @param request
     */
    public void callView(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/results.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param command
     * @return
     * @throws Exception
     */
    public Collection executeCommand(String command) throws Exception {
        throw new RuntimeException("not implemented");
    }

    /**
     * Servlet's entry point.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Collection results = executeCommand(getCommand(request));
            request.setAttribute("result", results);
        } catch (Exception e) {
            throw new ServletException("Failed to execute command", e);
        }
    }
}
