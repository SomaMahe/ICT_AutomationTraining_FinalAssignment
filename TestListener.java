import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onStart(ITestContext context) {
        System.out.println("----------Test method  Started----------");
    }

    public void onFinish(ITestContext context) {
        System.out.println("----------Test Ended----------");
    }

    public void onTestStart(ITestResult result) {
        System.out.println("----------New Test Started----------" +result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("----------Test successful----------" +result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("----------Test Failed----------" +result.getName());


    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("----------Test SKipped----------" +result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("----------Test failed within success Percentage----------" +result.getName());
    }
}
