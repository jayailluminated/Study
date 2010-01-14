/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 13, 2010
 * Time: 2:12:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomTagTest {


	@Test
	public void testCustomTag() {

		IncludeTag tag = new IncludeTag();
		tag.setUrl("alert");
		tag.setExtention("basic");

		PageContext pageContext = new MockPageContext();
		tag.setPageContext(pageContext);

		assertEquals(TagSupport.EVAL_BODY_INCLUDE, tag.doStartTag());
		assertEquals(TagSupport.EVAL_PAGE, tag.doEndTag());
		String output = ((MockHttpServletResponse) pageContext.getResponse()).getContentAsString();
		System.out.println(output);
		assertTrue(output.contains("<span class='r'>"));
	}
}
