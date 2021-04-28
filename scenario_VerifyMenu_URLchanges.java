import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class scenario_VerifyMenu_URLchanges extends BasePage{
    private WebDriver driver;

    public scenario_VerifyMenu_URLchanges(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    private By menLinkText = By.xpath("//a[@title='MEN']");
    private By womenLinkText = By.xpath( "//a[@title='WOMEN']");
    private By kidsLinkText = By.xpath( "//a[@title='KIDS']");
    private By homeKitchenLinkText = By.xpath( "//a[@title='HOME AND KITCHEN']");

    //Scenario : Verify URL changes


    public void verifyUrlChangeForMenClick() throws Exception {

        try {
            click(menLinkText);
            WebDriverWait wait = new WebDriverWait(driver, 5);

            String URL = driver.getCurrentUrl();

            Assert.assertEquals(URL, "https://www.ajio.com/shop/men");
            Reports.extentTest.log(Status.PASS, "Verified URL change when MEN is clicked ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());


        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, "Verified no URL change when MEN is clicked", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }

    public void verifyUrlChangeForWomenClick() throws Exception {

        try {
            //driver.findElement(womenLinkText).click();
            click(womenLinkText);
            WebDriverWait wait = new WebDriverWait(driver, 5);

            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, "https://www.ajio.com/shop/women");
            Reports.extentTest.log(Status.PASS, "Verified URL change when WOMEN is clicked ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());


        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, "Verified no URL change when WOMEN is clicked ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }

    }

    public void verifyUrlChangeForKidsClick() throws Exception {

        try {
            click(kidsLinkText);
            WebDriverWait wait = new WebDriverWait(driver, 5);

            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, "https://www.ajio.com/shop/kids");
            Reports.extentTest.log(Status.PASS, "Verified URL change when WOMEN is clicked ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        } catch (Exception e) {

            Reports.extentTest.log(Status.FAIL, "Verified no URL change when KIDS is clicked ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }

    }


    //Scenario : Verify Menu items for Men


    public void verifyMenuItemsForMen() throws Exception{

        try {
            Actions actions = new Actions(driver);
            WebElement menuOption = locateElement(menLinkText);
            Action mouseHoverMenu = actions.moveToElement(menuOption).build();
            mouseHoverMenu.perform();
            ;
            Thread.sleep(2000);

            WebElement subMenuOption = locateElement(By.xpath("//li[@class='catg inactive-text']//a[1]"));
            Action mouseHoverSubMenu = actions.moveToElement(subMenuOption).build();
            mouseHoverSubMenu.perform();


            WebElement jeansOption = locateElement(By.xpath("//span//a[@title='Jeans']"));
            Action mouserHoverOption1 = actions.moveToElement(jeansOption).build();
            mouserHoverOption1.perform();

            Thread.sleep(1000);

            WebElement shirtsOption = locateElement(By.xpath("//span//a[@title='Shirts']"));
            Action mouserHoverOption2 = actions.moveToElement(shirtsOption).build();
            mouserHoverOption2.perform();

            Reports.extentTest.log(Status.PASS, "Verified sub-category Jeans & Shirts in Men's Categories ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());


        }

        catch(Exception e)
        {
            Reports.extentTest.log(Status.FAIL, "Verified Category Men with no sub-categories -Jeans and Shirts", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }}

        //Scenario: Verify Menu

    public void verifyMenuBarContains() throws Exception {

        try {
            // String menLinkString = driver.findElement(menLinkText).getText();
            String menLinkString =getText(menLinkText);
            Assert.assertEquals("MEN", menLinkString);

            // String womenLinkString = driver.findElement(womenLinkText).getText();
            String womenLinkString =getText(womenLinkText);
            Assert.assertEquals("WOMEN", womenLinkString);

            //String kidsLinkString = driver.findElement(kidsLinkText).getText();
            String kidsLinkString =getText(kidsLinkText);
            Assert.assertEquals("KIDS", kidsLinkString);

            //String homeKitchenLinkString = driver.findElement(homeKitchenLinkText).getText();
            String homeKitchenLinkString =getText(homeKitchenLinkText);
            Assert.assertEquals("HOME AND KITCHEN", homeKitchenLinkString);


            Reports.extentTest.log(Status.PASS, "Verified Menu bar contains-Men,Women,Kids,Home and Kitchen ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());


        } catch (Exception e) {

            Reports.extentTest.log(Status.FAIL, "Verified Menu bar does not contains Men,Women,Kids,Home and Kitchen ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }



}





