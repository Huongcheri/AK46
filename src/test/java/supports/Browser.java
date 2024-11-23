package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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

    public static WebDriver getDriver() {
        return driver;
    }


    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }
    public static boolean isSelected(By locator){
        return  driver.findElement(locator).isSelected();
    }

    public static void screenShot(String fileName){
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File destFile=new File(String.format("target/%s-%d.png",fileName,System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getText(By locator){
        //return getElement(locator).getText();
       return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).getText();
    }

    public static String currentUrl(){
        return driver.getCurrentUrl();
    }
    public static void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public static void fill(By locator, String withText){
        getElement(locator).sendKeys(withText);
    }
    public static void check(By locator){
        if (!isSelected(locator)) click(locator);
    }

}
