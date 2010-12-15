package jjseo.test.http;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.After;
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

    @Test
    public void testIsAuthenticatedNotAuthenticated() {
        expect(mockHttpSession.getAttribute(eq("authenticated"))).andReturn("false");
        replay(mockHttpSession);
        expect(mockHttpServletRequest.getSession(eq(false))).andReturn(mockHttpSession);
        replay(mockHttpServletRequest);

        assertFalse(servlet.isAuthenticated(mockHttpServletRequest));
    }

    @Test
    public void testIsAuthenticateNoSession() {
        expect(mockHttpServletRequest.getSession(eq(false))).andReturn(null);
        replay(mockHttpServletRequest);
        replay(mockHttpSession);

        assertFalse(servlet.isAuthenticated(mockHttpServletRequest));
    }

    @After
    public void tearDown() {
        verify(mockHttpServletRequest);
        verify(mockHttpSession);
    }
}
