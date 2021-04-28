import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class Browser {

    public static WebDriver openBrowser(String browser,String url) throws Exception {
        //setup driver path
        String driverPath = System.getProperty("user.dir");

        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", driverPath+"//src/main/resources/chromedriver.exe");
            //Disabling popups
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get(url);
            return driver;}
        else if(browser.equalsIgnoreCase("firefox")){

                System.setProperty("webdriver.gecko.driver",driverPath+"//src/main/resources/geckodriver.exe");

                WebDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(url);
                return driver;
            }
            else { throw new Exception("Invalid browser"+browser);}
        }

    public static void closeBrowser(WebDriver driver){
        driver.close();
    }
}
