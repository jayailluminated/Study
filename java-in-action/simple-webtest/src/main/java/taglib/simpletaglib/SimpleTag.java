package taglib.simpletaglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: moretajoo
 * Date: Feb 7, 2010
 * Time: 4:03:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTag extends SimpleTagSupport{
	private String[] movieList;

	public void setMovieList(String[] movieList) {
		this.movieList = movieList;
	}

	public void doTag() throws JspException, IOException {
		for(String movie : movieList){
			getJspContext().setAttribute("movie", movie);
			getJspBody().invoke(null);
		}
	}
}
