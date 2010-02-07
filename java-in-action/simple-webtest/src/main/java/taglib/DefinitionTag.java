package taglib;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DefinitionTag extends TagSupport {
	private String screenName = null;
	private String definitionName = null;
	private String screenId;

	public DefinitionTag () {
		super();
	}

	public void setName (String name) {
		this.definitionName = name;
	}

	public void setScreen (String screenId) {
		this.screenId = screenId;
	}

	public int doStartTag () {
		HashMap screens = null;

		screens = (HashMap) pageContext.getAttribute("screens", pageContext.APPLICATION_SCOPE);
		if (screens == null) {
			pageContext.setAttribute("screens", new HashMap(), pageContext.APPLICATION_SCOPE);
		}
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag () throws JspTagException {
		try {
			Definition definition = new Definition();
			HashMap screens = null;
			ArrayList params = null;
			TagSupport screen = null;

			screens = (HashMap) pageContext.getAttribute("screens", pageContext.APPLICATION_SCOPE);
			if (screens != null) {
				params = (ArrayList) screens.get(screenId);
			} else {
				System.err.println("DefinitionTag: screens null.");
			}

			if (params == null) {
				System.err.println("DefinitionTag: params are not defined.");
			}

			Iterator ir = null;

			if (params != null) {
				ir = params.iterator();
			}

			while ((ir != null) && ir.hasNext()) {
				definition.setParam((Parameter) ir.next());
			}

			// put the definition in the page context
			pageContext.setAttribute(definitionName, definition);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public void release () {
		screenName = null;
		definitionName = null;
		screenId = null;
		super.release();
	}
}
