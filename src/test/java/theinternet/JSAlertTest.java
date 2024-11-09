package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JSAlertTest {

    WebDriver driver;
    @BeforeClass
    void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    void verifyAlertTest(){
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You successfully clicked an alert");
    }
    @Test
    void verifyClickOKinJsAlertConfirmSuccessfully(){
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You clicked: Ok");
    }

    @Test
    void verifyInputinJsAlertConfirmSuccessfully(){
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Huong Test");
        driver.switchTo().alert().accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You entered: Huong Test");
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
