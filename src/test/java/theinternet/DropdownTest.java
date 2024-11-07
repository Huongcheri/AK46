package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

/*

Open browser

Navigate to https://the-internet.herokuapp.com/dropdown

Select "option 1"

Validate "option 1" is selected
*/

public class DropdownTest {
    @Test
    void Checkbox1isSelected() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
//        select.selectByVisibleText("Option 1"); chon 1 option
//        select.selectByIndex(1);
        select.selectByValue("1");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='dropdown']/option[@value = '1']")).isSelected());

        driver.quit();
    }
    @Test
    void ableSelectMultipleOptions() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));

        Assert.assertTrue(select.isMultiple());
        System.out.println(select.isMultiple());
        // select banana and apple
        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        // verify able select banana and apple
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());
        // Deselect banana
        select.deselectByVisibleText("Banana");
        // verify able select banana and apple
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());
        // deselect all
        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='grape']")).isSelected());
        driver.quit();
    }
}
