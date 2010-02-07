/* 
 * ========================================================================
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ========================================================================
 */
package cactus.sample.servlet.unit;

import java.io.IOException;

import org.apache.cactus.JspTestCase;
import org.apache.cactus.server.HttpServletRequestWrapper;
import org.apache.cactus.server.ServletConfigWrapper;

/**
 * Test the usage of the <code>pageContext</code> implicit object when using
 * <code>JspTestCase</code>.
 *
 * @version $Id: TestJspPageContext.java 238816 2004-02-29 16:36:46Z vmassol $
 */
public class TestJspPageContext extends JspTestCase
{
    /**
     * Verify that the page context is not null and that we can use it.
     * 
     * @exception java.io.IOException on test failure
     */
    public void testPageContext() throws IOException
    {        
        assertNotNull("Page context should not be null", pageContext);

        HttpServletRequestWrapper wrappedRequest =
            (HttpServletRequestWrapper) pageContext.getRequest();           
        assertSame(request.getOriginalRequest(), 
            wrappedRequest.getOriginalRequest()); 

        assertSame(response, pageContext.getResponse());

        ServletConfigWrapper wrappedConfig =
            (ServletConfigWrapper) pageContext.getServletConfig();           
        assertSame(config.getOriginalConfig(), 
            wrappedConfig.getOriginalConfig());        
    }
}
