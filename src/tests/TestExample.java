package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.gurock.testrail.APIClient;

public class TestExample {

	private APIClient client;
	private String server;
	private String user;
	private String password;
	
	private InputStream fileInputStream;
	
	@BeforeSuite
	public void readProperties(){
		try {
		Properties properties = new Properties();
		fileInputStream = new FileInputStream("src/utils/config.properties");
		properties.load(fileInputStream);
		server = properties.getProperty("server");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void close(){
		try {
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void before(){
//		client = new APIClient(server);
//		client.setUser(user);
//		client.setPassword(password);
	}
	
	@AfterMethod
	public void after(){
		
	}
	
	@Test
	public void test1(){
		
	}
	
	@Test
	public void test2(){
		
	}
	
	
}
