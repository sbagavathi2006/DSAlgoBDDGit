package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerImpl implements ITestListener {//This tells TestNG to attach a custom listener to your test suite execution. Let me break it down:

	  /* @Override
       public void onStart(ITestContext context) {
           System.out.println("Test Suite started: " + context.getName());//when testcase is execute before this system line is printed
        }
        @Override
        public void onFinish(ITestContext context) {
            System.out.println("Test Suite started: " + context.getName());
        }*/
	    @Override
	    public void onTestStart(ITestResult result) {//this all methods tell us the functionality of each testcase
	        System.out.println("Test Started: " + result.getName());
	    }
	    @Override
	    public void onTestSuccess(ITestResult result) {//when perticular test case is excute successfully this system out line is print
	        System.out.println("Test Passed");
	    }
	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("Test Failed");
	    }
	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test Skipped: " + result.getName());
	    }
	    // Other overridden methods
	}


