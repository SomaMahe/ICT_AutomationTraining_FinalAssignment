import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AjioHomePage extends BasePage {

        private WebDriver driver;

        public AjioHomePage(WebDriver driver){
            super(driver);
            this.driver = driver;
        }

        private By searchTextBox =By.name("searchVal");
        private By menLinkText = By.xpath("//a[@title='MEN']");
        private By womenLinkText = By.xpath( "//a[@title='WOMEN']");
        private By kidsLinkText = By.xpath( "//a[@title='KIDS']");
        private By whoWeAreLinkText = By.xpath( "//a[@title='Who We Are']");
        private By homeKitchenLinkText = By.xpath( "//a[@title='HOME AND KITCHEN']");
        private By joinOurTeamLinkText =By.xpath( "//a[@title='Join Our Team']");
        private By termsAndConditionsLinkText = By.xpath( "//a[@title='Terms & Conditions']");

    public void searchProduct(String searchString) {

        WebElement searchArea = driver.findElement(searchTextBox);
        searchArea.sendKeys(searchString);
        searchArea.sendKeys(Keys.ENTER);
        Reports.extentTest.log(Status.INFO, "Searched Product   " + searchString);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void verifySearchProduct(String searchString) throws Exception {
        String notFoundText = "Sorry! We couldn't find any matching items for";
        try {
            String headerDivText = getText(By.xpath("//div[@class='header2']"));
            if ( driver.getPageSource().contains(searchString) || headerDivText.equalsIgnoreCase(searchString))
                Reports.extentTest.log(Status.PASS, "Verified Available Product  " + searchString, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

            else{
                String notFoundDivText = driver.findElement(By.xpath("//div[@class='fnl-slpsearch-firstLine']")).getText();
                Assert.assertEquals(notFoundDivText, notFoundText);
                Reports.extentTest.log(Status.PASS, "Verified Unavailable Product  " + searchString, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
            }
        } catch (Exception e) {
            Reports.extentTest.log(Status.FAIL,e);

        }
    }

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


    public  void clickMenuMen(){

        click(menLinkText);
        //driver.findElement(By.linkText("MEN")).click();

    }


    public void verifyUrlChangeForMenClick() throws Exception {

        try {
            clickMenuMen();
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
            //driver.findElement(kidsLinkText).click();
            click(kidsLinkText);
            WebDriverWait wait = new WebDriverWait(driver, 5);

            String URL = driver.getCurrentUrl();
            Assert.assertEquals(URL, "https://www.ajio.com/shop/kids");
            Reports.extentTest.log(Status.PASS, "Verified URL change when WOMEN is clicked ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());


        } catch (Exception e) {

            Reports.extentTest.log(Status.FAIL, "Verified no URL change when KIDS is clicked ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }

    }

    public void selectDropDown() throws Exception {
        WebElement dropdown = driver.findElement(By.cssSelector("select"));
    }

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

    public void verifySearchForBrandPuma(String searchBrand) throws Exception{

        searchProduct(searchBrand);
        verifySearchProduct(searchBrand);

    }

    public void verifyMenuItemsForMen(String subCategory1, String subCategory2) throws Exception{

            Actions actions = new Actions(driver);
            WebElement menuOption =driver.findElement(menLinkText);
            actions.moveToElement(menuOption).build().perform();


            WebDriverWait wait = new WebDriverWait(driver,20);
            WebElement subMenuOption=driver.findElement(By.xpath("//a[contains(text(),'CATEGORIES')]'"));
            actions.moveToElement(subMenuOption).build().perform();

            //WebElement categoryJeans =driver.findElement(By.xpath("//span//a[@title='Jeans']"));
            //WebElement categoryShirts = driver.findElement(By.xpath("//span//a[@title='Shirts']"));
            try{
            //Checking if Jeans option is available
             click(By.xpath("//span//a[@title='Jeans']"));
             Assert.assertTrue(driver.getCurrentUrl().equals("https://www.ajio.com/men-jeans/c/830216001"));
             Reports.extentTest.log(Status.PASS, "Verified sub-category Jeans in Men's Categories ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

             driver.navigate().back();
             click(By.xpath("//span//a[@title='Shirts']"));
             Assert.assertTrue(driver.getCurrentUrl().equals("https://www.ajio.com/men-shirts/c/830216013"));
             Reports.extentTest.log(Status.PASS, "Verified sub-category Shirts in Men's Categories ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());



            }
            catch (Exception e){
            Assert.fail("Category Men with no sub-categories -Jeans");
            Reports.extentTest.log(Status.FAIL, "Verified Category Men with no sub-categories -Jeans and Shirts", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());

        }
    }


    public void verifyReturnPolicy(String searchItem) throws Exception{

        try {

            searchProduct(searchItem);
            click(By.cssSelector(".imgHolder"));

            String returnPolicyText = "Easy 30 days return and exchange. Return Policies may vary based on products and promotions. For full details on our Returns Policies, please ";

            WebElement returnDescription = locateElement(By.cssSelector(".return-desc > span:nth-child(1)"));
            returnDescription.click();

            String verifyText = returnDescription.getText();
            System.out.println(verifyText);
            Assert.assertEquals(returnPolicyText, returnDescription);
            Reports.extentTest.log(Status.PASS, "Verified Return Policy ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        catch(Exception e){
            Assert.fail(" No return Policy found");
            Reports.extentTest.log(Status.FAIL, "Verified No Return Policy ", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
    }


    public void verifyAddTOCart(String searchItem) throws Exception{

        searchProduct(searchItem);



    }



}
