package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest {
    /*

     */
    @Test
    void Checkbox1isSelected() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox = driver.findElement(By.cssSelector("#checkboxes input:nth-child(1)"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        Assert.assertTrue(checkbox.isSelected());

        driver.quit();
    }
    @Test
    void Checkbox2isSelected() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox2 =  driver.findElement(By.cssSelector("#checkboxes input:nth-child(3)"));
        if (checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertFalse(checkbox2.isSelected());

//        driver.quit();
    }
}
