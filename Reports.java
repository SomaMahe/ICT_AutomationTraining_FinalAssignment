import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Reports {

    public static ExtentSparkReporter extentSparkReporter ;
    public static ExtentReports extentReports ;
    public static ExtentTest extentTest ;

    @BeforeTest
    public void initialiseReport(){
        String baseDirectory=System.getProperty("user.dir");
        extentSparkReporter =new ExtentSparkReporter(baseDirectory+"/Report/extentreport.html");
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

    }

    public static void createReport(String testcaseName){
        extentTest=extentReports.createTest(testcaseName);
    }
    @AfterTest
    public void closeReport(){
        extentReports.flush();
    }
}




