package jjseo.test.http;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

public class EasyMockSampleServletTest {


    private SampleServlet servlet;
    private HttpServletRequest mockHttpServletRequest;
    private HttpSession mockHttpSession;

    @Before
    public void setUp() {
        servlet = new SampleServlet();
        mockHttpServletRequest =  createStrictMock(HttpServletRequest.class);
        mockHttpSession = createStrictMock(HttpSession.class);
    }

    @Test
    public void testIsAuthenticated () {
        expect(mockHttpServletRequest.getSession(eq(false))).andReturn(mockHttpSession);
        expect(mockHttpSession.getAttribute(eq("authenticated"))).andReturn("true");
        replay(mockHttpServletRequest);
        replay(mockHttpSession);

        assertTrue(servlet.isAuthenticated(mockHttpServletRequest));
    }
}
