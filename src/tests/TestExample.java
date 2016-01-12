package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.gurock.testrail.APIClient;

public class TestExample{

	private APIClient client;
	private String server;
	private String user;
	private String password;
	private WebDriver driver;
	
	private InputStream fileInputStream;
	
//	@BeforeSuite
//	public void readProperties(){
//		try {
//		Properties properties = new Properties();
//		fileInputStream = new FileInputStream("src/utils/config.properties");
//		properties.load(fileInputStream);
//		server = properties.getProperty("server");
//		user = properties.getProperty("user");
//		password = properties.getProperty("password");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@AfterSuite
//	public void close(){
//		try {
//			fileInputStream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	@BeforeMethod
	public void before(){
		driver = new ChromeDriver();
		
	}
	
	@AfterMethod
	public void after(){
		driver.close();
	}
	
	@Test
	public void test1(){
		System.out.println("FAIL");
		driver.get("https://www.google.com/");
		Assert.assertTrue(false, "Test fail to check TestRail results");
	}
	
	@Test
	public void test2(){
		System.out.println("SUCCESS");
		driver.get("https://www.yahoo.com/");
		Assert.assertTrue(true, "Test success to check TestRail results");
	}
	
	
}
