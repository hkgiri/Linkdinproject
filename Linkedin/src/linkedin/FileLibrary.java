package linkedin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLibrary {
	/**
	 * @author Gaurav Modanwal
	 * @param key
	 * @return String
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./data/commondata1.property");
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data; 
	}

}
