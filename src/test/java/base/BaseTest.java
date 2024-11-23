package base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import static supports.Browser.quit;
import static supports.Browser.screenShot;

public class BaseTest {
    @AfterMethod(alwaysRun = true)
    protected void tearDown(ITestResult iTestResult){
        if (!iTestResult.isSuccess()){
            screenShot(iTestResult.getMethod().getMethodName());
        }
        quit();
    }
}
