package dependency.injection.model.email;

import java.lang.annotation.Annotation;

/**
 * Created by IntelliJ IDEA.
 * User: jungjooseo
 * Date: Jan 12, 2010
 * Time: 1:10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class French implements Annotation {
	@Override
	public boolean equals(Object obj) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int hashCode() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String toString() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Class<? extends Annotation> annotationType() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
