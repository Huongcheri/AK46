package theinternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * TC01: Form  Authentication :  Login successful with valid credentials
 * Open browser
 * <p>
 * Navigate to https://the-internet.herokuapp.com/login
 * <p>
 * Fill in username with tomsmith
 * <p>
 * Fill in the password with SuperSecretPassword!
 * <p>
 * Click on Login button
 * <p>
 * And the home page is appear
 */
public class FormAuthenticationTest {
    @Test
    void ShouldSuccessfully() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        // visual locator string -có ý nghĩa hình dung ra duoc thao tac và ngắn nhất

        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));

        driver.quit();
    }

    @Test
    void UsernameFail() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith01");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));

        driver.quit();
    }
    @Test
    void PasswordFail() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));

        driver.quit();
    }
}
