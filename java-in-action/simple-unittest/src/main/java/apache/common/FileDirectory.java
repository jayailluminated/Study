package apache.common;

import java.io.File;
import java.io.IOException;

/**
 * User: moretajoo
 * Date: May 18, 2010
 * Time: 1:29:29 AM
 */
public class FileDirectory {

	public String  getDirectoryPath() throws IOException {
		File currDir = new File(".");
        return currDir.getCanonicalPath();	
	}

}
