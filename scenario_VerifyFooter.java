import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class scenario_VerifyFooter extends BasePage{
    private WebDriver driver;

    public scenario_VerifyFooter(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By whoWeAreLinkText = By.xpath( "//a[@title='Who We Are']");
    private By joinOurTeamLinkText =By.xpath( "//a[@title='Join Our Team']");
    private By termsAndConditionsLinkText = By.xpath( "//a[@title='Terms & Conditions']");

    //Scenario -----> Verify Footer
    public void verifyFooterContains() throws Exception {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");


        try {

            String whoWeAreText = driver.findElement(whoWeAreLinkText).getText();
            Assert.assertEquals(whoWeAreText, "Who We Are");

            String joinOurTeamText = driver.findElement(joinOurTeamLinkText).getText();
            Assert.assertEquals(joinOurTeamText, "Join Our Team");

            String termsAndConditionsText =driver.findElement(termsAndConditionsLinkText).getText();
            Assert.assertEquals(termsAndConditionsText, "Terms & Conditions");

            Reports.extentTest.log(Status.PASS, "Verified text Who We Are, Join Our Team,Terms & Conditions in Home page footer ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, "Verified text Who We Are, Join Our Team,Terms & Conditions not in Home page footer ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }

}
