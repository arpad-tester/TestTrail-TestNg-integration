package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import com.testrail.service.TestRailService;

public class TestBase {

	protected static TestRailService testRailService = new TestRailService();
	public static Integer assegnedId;

	public static TestRailService getService(){
		return testRailService;
	}
	
	
}
