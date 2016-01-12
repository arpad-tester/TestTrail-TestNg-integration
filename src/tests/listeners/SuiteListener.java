package tests.listeners;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener extends Listeners implements ISuiteListener{

	@Override
	public void onFinish(ISuite suite) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		Properties properties = new Properties();
        InputStream resource;
		try {
			resource = getClass().getResourceAsStream("/resources/config.properties");
			properties.load(resource);
		} catch (IOException e) {
			Assert.fail("Properties file is not valid.");
		}
        
		try {
			initService(properties);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
