package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HyperLinkTest {
    @Test
    void tc04() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        String href = driver.findElement(By.linkText("200")).getAttribute("href");
        driver.findElement(By.linkText("200")).click();
        Assert.assertEquals(driver.getCurrentUrl(), href);
//    driver.findElement(By.linkText("here")).click();
        driver.navigate().back();
        Thread.sleep(1000);

        driver.findElement(By.linkText("301")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/301");
        driver.findElement(By.linkText("here")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("404")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/404");
        driver.findElement(By.linkText("here")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("500")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/status_codes/500");
        driver.findElement(By.linkText("here")).click();
        Thread.sleep(1000);

        driver.quit();
    }

}
