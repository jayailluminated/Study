import org.junit.Ignore;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockPageContext;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import java.io.UnsupportedEncodingException;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 13, 2010
 * Time: 2:12:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomTagTest {

	@Ignore
	public void testCustomTag() throws JspException {

//		IncludeTag tag = new IncludeTag();
//		tag.setUrl("alert");
//		tag.setExtention("basic");
//
//		PageContext pageContext = new MockPageContext();
//		tag.setPageContext(pageContext);
//
//		assertEquals(TagSupport.EVAL_BODY_INCLUDE, tag.doStartTag());
//		assertEquals(TagSupport.EVAL_PAGE, tag.doEndTag());
//		String output = null;
//		try {
//			output = ((MockHttpServletResponse) pageContext.getResponse()).getContentAsString();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//		}
//		System.out.println(output);
//		assertTrue(output.contains("<span class='r'>"));
	}

}
