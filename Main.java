import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String driverPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", driverPath + "//src/main/resources/chromedriver.exe");
        //Disabling popups
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.ajio.com/");


        String notFoundText = "Sorry! We couldn't find any matching items for";
        String unAvailableProductMsg = "Sorry !! No Results found for";
        String searchString = "Shoes";

        /*WebElement searchArea = driver.findElement(By.name("searchVal"));
        searchArea.sendKeys(searchString);
        searchArea.sendKeys(Keys.ENTER);
        //try {
            String headerDivText = driver.findElement(By.xpath("//div[@class='header2']")).getText();
            if (!driver.getPageSource().contains(unAvailableProductMsg)) {
                if (driver.getPageSource().contains(searchString) || headerDivText.equalsIgnoreCase(searchString))
                    //Reports.extentTest.log(Status.PASS, "Verified Available Product  " + searchString, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
                    System.out.println("Product foundt" + headerDivText);
                else if (driver.getPageSource().contains(notFoundText)) {
                    String notFoundDivText = driver.findElement(By.xpath("//div[@class='fnl-slpsearch-firstLine']")).getText();
                    // Assert.assertEquals(notFoundDivText, notFoundText);
                    System.out.println("Product not found " + notFoundDivText);
                }
            } else {

                String unAvailableError = driver.findElement(By.xpath("//div[@class='fnl-slpsearch-firstLine']")).getText();
                System.out.println("Product Unavailable" + unAvailableError);
                // Reports.extentTest.log(Status.PASS, "Verified Unavailable Product  " + searchString, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
            }
            //  } catch (Exception e) {
            //Reports.extentTest.log(Status.FAIL,e);
            // System.out.println("Search FAILED" + e);

            //   }*/


        // FOR MEN MENU------------------------------------------------------------------------

        /*driver.findElement(By.xpath("//a[@title='MEN']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        String URL = driver.getCurrentUrl();

        Assert.assertEquals(URL, "https://www.ajio.com/shop/men");

        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(By.xpath("//a[@title='MEN']"));
        Action mouseHoverMenu = actions.moveToElement(menuOption).build();
        mouseHoverMenu.perform();
        System.out.println("In MEN section");
        Thread.sleep(2000);


        //Thread.sleep(2000);

        WebElement subMenuOption = driver.findElement(By.xpath("//li[@class='catg inactive-text']//a[1]"));
        Action mouseHoverSubMenu = actions.moveToElement(subMenuOption).build();
        mouseHoverSubMenu.perform();
        System.out.println("In categories section");

        Thread.sleep(2000);



        WebElement jeansOption = driver.findElement(By.xpath("//span//a[@title='Jeans']"));
        Action mouserHoverOption1 = actions.moveToElement(jeansOption).build();
        mouserHoverOption1.perform();
        System.out.println("Jeans section present");

       Thread.sleep(2000);

       WebElement shirtsOption = driver.findElement(By.xpath("//span//a[@title='Shirts']"));
       Action mouserHoverOption2 = actions.moveToElement(shirtsOption).build();
       mouserHoverOption2.perform();

        System.out.println("Shirts section present");
        Thread.sleep(1000);
*/

        //Scenario : Add to bag

      /*  WebElement searchArea = driver.findElement(By.name("searchVal"));
        searchArea.sendKeys(searchString);
        searchArea.sendKeys(Keys.ENTER);

        String currrentWIndow = driver.getWindowHandle();
        driver.findElement(By.cssSelector("div > div:nth-child(1) > a > div > div.contentHolder > div.brand")).click();

        Set<String> childWIndows = driver.getWindowHandles();

        System.out.println("Number of windows opened "+childWIndows.size());

        for (String child: childWIndows){

            if(!currrentWIndow.equalsIgnoreCase(child)){

                driver.switchTo().window(child);
                //driver.findElement(By.xpath("//*[@id='appContainer']/div[2]/div/div/div[2]/div/div[3]/div/div[6]/div[3]/div")).click(); //new selector
                driver.findElement(By.xpath("//*[@id='appContainer']/div[2]/div/div/div[2]/div/div[3]/div/div[6]/div[2]/div/div/div[3]/div")).click();
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                javascriptExecutor.executeScript("window.scrollBy(0,300)");
                driver.findElement(By.cssSelector(".btn-gold")).click();
                Thread.sleep(2000);

                Actions actions = new Actions(driver);
                WebElement cart = driver.findElement(By.className("ic-cart"));
                Action mouseHoverCart = actions.moveToElement(cart).build();
                mouseHoverCart.perform();


                Thread.sleep(2000);


            }
            driver.close();

        }

        /*Iterator<String> it = ids.iterator();
        String childId = it.next();
        driver.switchTo().window(childId);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,300)");




/* -- REturn Policy -working code

             WebElement searchArea = driver.findElement(By.name("searchVal"));
             searchArea.sendKeys(searchString);
             searchArea.sendKeys(Keys.ENTER);

            driver.findElement(By.cssSelector(".imgHolder")).click();
            Thread.sleep(1000);

            String parentWindow = driver.getWindowHandle();
            String returnPolicyText = "Easy 30 days return and exchange. Return Policies may vary based on products and promotions. For full details on our Returns Policies, please ";
            Set<String> windowHandles = driver.getWindowHandles();

            Iterator<String>  iter= windowHandles.iterator();

            while(iter.hasNext()) {

                String child_window = iter.next();


                if (!parentWindow.equals(child_window)) {
                    driver.switchTo().window(child_window);
                    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                    javascriptExecutor.executeScript("window.scrollBy(0,300)");
                    WebElement returnDescription = driver.findElement(By.xpath("//div[@class='return-desc']//span"));
                    //returnDescription.click();

                   // String verifyText = returnDescription.getText();
                    if(returnDescription.isDisplayed())
                        System.out.println(returnDescription.getText());
                    Thread.sleep(2000);
                    //System.out.println(verifyText);
                    //Assert.assertEquals(returnPolicyText, verifyText);


                    driver.close();
                }
            }
                    driver.switchTo().window(parentWindow);

*/


        //  SEARCH PRoduct - AVailable & Unavailable










        }
    }


