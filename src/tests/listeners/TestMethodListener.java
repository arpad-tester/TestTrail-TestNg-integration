package tests.listeners;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testrail.entity.TestInstance;
import com.testrail.entity.TestResult;
import com.testrail.entity.TestRun;
import com.testrail.entity.TestRunCreator;
import com.testrail.entity.TestSuite;

import tests.TestBase;

public class TestMethodListener extends Listeners implements ITestListener{
	
	private TestRun testRun;
	
	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		TestSuite suite = TestBase.getService().getTestSuite(5);
		TestRunCreator testRunCreator = new TestRunCreator();
		
		testRunCreator.setName("run_from_testng_" + new Date());
		testRunCreator.setDescription("description");
		testRunCreator.setSuiteId(suite.getId());
		
		testRun = TestBase.getService().addTestRun(2, testRunCreator);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		for (TestInstance testInstance : testRun.getTests()) {
			System.out.println(testInstance.getTitle());
			System.out.println(testInstance.getCaseId());
			System.out.println(testInstance.getRunId());
			System.out.println(testInstance.getTypeId());
			
			if(testInstance.getCaseId() == 24){
				TestResult testResult = new TestResult();
				testResult.setTestId(testInstance.getId());
				testResult.setVerdict("Failed");
				testResult.setAssignedtoId(TestBase.assegnedId);
				testResult.setComment("FAIL from TestNG");
				
				TestBase.getService().addTestResult(testInstance.getId(), testResult);
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		for (TestInstance testInstance : testRun.getTests()) {
			System.out.println(testInstance.getTitle());
			System.out.println(testInstance.getCaseId());
			System.out.println(testInstance.getRunId());
			
			if(testInstance.getCaseId() == 25){
				TestResult testResult = new TestResult();
				testResult.setTestId(testInstance.getId());
				testResult.setVerdict("Passed");
				testResult.setAssignedtoId(TestBase.assegnedId);
				testResult.setComment("PASS from TestNG");
				
				TestBase.getService().addTestResult(testInstance.getId(), testResult);
			}
		}
	}

}
