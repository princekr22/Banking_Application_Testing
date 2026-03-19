package utilities;

import org.testng.ITestNGListener;
import org.testng.internal.annotations.IList

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener implements ITestListener {
    // Overriding methods allows custom actions during test execution
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
    }
    // Implement other ITestListener methods as needed
}

	
}
