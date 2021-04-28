import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class scenario_SearchProduct_Brand extends BasePage{

    private WebDriver driver;

    public scenario_SearchProduct_Brand(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    private By searchTextBox =By.name("searchVal");
    private By menLinkText = By.xpath("//a[@title='MEN']");
    private By womenLinkText = By.xpath( "//a[@title='WOMEN']");
    private By kidsLinkText = By.xpath( "//a[@title='KIDS']");
    private By customerCareLinkText = By.xpath("//*[@id='appContainer']/div[1]/div/header/div[1]/ul/li[2]/a");


    //    Scenarios : Search  Available Product and Unavailable Product

    public void searchProduct(String searchString) {

        WebElement searchArea = driver.findElement(searchTextBox);
        searchArea.sendKeys(searchString);
        searchArea.sendKeys(Keys.ENTER);
        Reports.extentTest.log(Status.INFO, "Searched Product   " + searchString);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void verifySearchProduct(String searchString) throws Exception {
        String notFoundText = "Sorry !! No Results found for ";
        String invalidProductHeader= "Sorry! We couldn't find any matching items for";
        //Need MODIFICATION
        try{
            if(!(getText(By.xpath("//li/a/span"))).contains(notFoundText)){
                String headerDivText = getText(By.xpath("//li/a/span"));
                if ( driver.getPageSource().contains(searchString) || headerDivText.equalsIgnoreCase(searchString))
                Reports.extentTest.log(Status.PASS, "Verified Available Product  " + searchString, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

            else{
                String unAvailableProduct = driver.findElement(By.cssSelector("css=.fnl-slpsearch-firstLine']")).getText();
                Assert.assertEquals(unAvailableProduct, notFoundText);
                Reports.extentTest.log(Status.PASS, "Verified Unavailable Product  " + searchString, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
            }
            }
        }
         catch (Exception e) {
            // String notFoundDivText = driver.findElement(By.xpath("//div[@class='fnl-slpsearch-firstLine']")).getText();
             Reports.extentTest.log(Status.FAIL,e);

         }

    }

    // Scenario : Search Brand -----> PUMA

    public void verifySearchForBrandPuma(String searchBrand) throws Exception{

        searchProduct(searchBrand);
        verifySearchProduct(searchBrand);

    }

    //Scenario : Verify FAQ in Customer Care

    public void verifyFAQCustomerCare()throws Exception{

        click(customerCareLinkText);

        if (locateElement(By.xpath("//label[contains(text(),'Shipping FAQs')]")).isDisplayed()& locateElement((By.xpath("//label[contains(text(),'Cancellation FAQs')]"))).isDisplayed() ){
            Reports.extentTest.log(Status.PASS, "Verified FAQ - contains Shipping and Cancellation FAQs", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }else{
            Reports.extentTest.log(Status.FAIL, "Verified FAQ does not contains Shipping and Cancellation FAQs", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }


    }


}
