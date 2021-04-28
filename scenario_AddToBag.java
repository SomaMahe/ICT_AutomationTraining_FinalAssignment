import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class scenario_AddToBag extends BasePage{
    private WebDriver driver;

    public scenario_AddToBag(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public  void verifyAddTOBag() throws InterruptedException, IOException {


        try {
            String parentWIndow = driver.getWindowHandle();
            click(By.cssSelector("div > div:nth-child(1) > a > div > div.contentHolder > div.brand"));

            Set<String> childWIndows = driver.getWindowHandles();


            for (String child : childWIndows) {

                if (!parentWIndow.equalsIgnoreCase(child)) {

                    driver.switchTo().window(child);
                    click(By.xpath("//*[@id='appContainer']/div[2]/div/div/div[2]/div/div[3]/div/div[6]/div[2]/div/div/div[3]/div"));

                    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                    javascriptExecutor.executeScript("window.scrollBy(0,300)");

                    click(By.cssSelector(".btn-gold"));
                    Thread.sleep(2000);

                    Actions actions = new Actions(driver);
                    WebElement cart = locateElement(By.className("ic-cart"));
                    Action mouseHoverCart = actions.moveToElement(cart).build();
                    mouseHoverCart.perform();


                    Thread.sleep(2000);
                    Reports.extentTest.log(Status.PASS, "Verified Add to Bag ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
                    driver.close();
                    driver.switchTo().window(parentWIndow);


                }

            }

        } catch (Exception e) {

            Assert.fail("Exception " + e);
            Reports.extentTest.log(Status.FAIL, " Add to Bag not working ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }

    }

    }


