import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class scenario_SortByPrice_lowest_Highest extends BasePage {
    private WebDriver driver;

    public scenario_SortByPrice_lowest_Highest(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void selectDropDown() throws Exception {
        WebElement dropdown = driver.findElement(By.cssSelector("select"));
    }

    // Scenario : Sort By Price-Lowest
    public void sortPriceAscending() throws Exception {

        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement dropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[. = 'Price (lowest first)']")));
        dropdownList.click();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,300)");

        Thread.sleep(5000);

        List<WebElement> price = driver.findElements(By.xpath("//span[@class='price  ']"));

        String priceListString;
        List<String> priceArrayList =new ArrayList<String>();

        for (int i = 0; i < price.size(); i = i + 1) {

            priceListString = price.get(i).getText();

            String trimPriceListString = priceListString.replaceAll("Rs. ","");
            String commaRemovedPriceList= trimPriceListString.replaceAll(",","");
            priceArrayList.add(commaRemovedPriceList);

        }
        ArrayList<Float> priceList = new ArrayList<Float>();
        for (String stringValue : priceArrayList) {
            priceList.add(Float.parseFloat(stringValue));
        }
        if (!ascendingCheck(priceList)) {
            Assert.fail("Item price not in ascending order");
            Reports.extentTest.log(Status.FAIL, "Verified Items not displayed as Lowest to highest Price   ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
        else{
            Reports.extentTest.log(Status.PASS, "Verified Items displayed as Lowest Price first   ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }

    }

    public Boolean ascendingCheck(ArrayList<Float> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            if (data.get(i) > data.get(i + 1)) {
                return false;
            }
        }
        return true;
    }


    // Scenario : Sort By Price-Highest

    public void sortPriceDescending() throws Exception {

        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement dropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[@value='prce-desc']")));
        dropdownList.click();

        Thread.sleep(2000);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,350)");
        List<WebElement> price = driver.findElements(By.xpath("//span[@class='price  ']"));

        String priceListString;
        List<String> priceArrayList =new ArrayList<String>();

        for (int i = 0; i < price.size(); i = i + 1) {

            priceListString = price.get(i).getText();

            String trimPriceListString = priceListString.replaceAll("Rs. ","");
            String commaRemovedPriceList= trimPriceListString.replaceAll(",","");
            priceArrayList.add(commaRemovedPriceList);

        }
        ArrayList<Float> priceList = new ArrayList<Float>();
        for (String stringValue : priceArrayList) {
            priceList.add(Float.parseFloat(stringValue));
        }
        if (descendingCheck(priceList)) {
            Reports.extentTest.log(Status.PASS, "Verified Items displayed as Highest Price first  ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
        else{
            Assert.fail("Item price not in descending order");
            Reports.extentTest.log(Status.FAIL, "Verified Items not displayed as Highest Price first   ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }

    }



    public Boolean descendingCheck(ArrayList<Float> data) {
        for (int i = 0; i < data.size() - 1; i++) {
            if (data.get(i) > data.get(i + 1)) {
                return true;
            }
        }
        return false;
    }


}
