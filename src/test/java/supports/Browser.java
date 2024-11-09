package supports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {
    private static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    public static void openBrowser(String browserName){

        switch (browserName.toLowerCase()){
            case "chrome":{
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            default:
                throw new IllegalArgumentException("Un Support Browser: " + browserName.toLowerCase());
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    public static void visit(String url){
        driver.get(url);
    }
    public static void quit(){
        if (driver!=null){
            driver.quit();
        }
    }
}
