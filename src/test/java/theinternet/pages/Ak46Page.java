package theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import supports.Browser;

public class Ak46Page {
    WebDriver driver;

    By columnA = By.id("column-a");
    By columnB = By.id("column-b");
    public Ak46Page() {
        this.driver = Browser.getDriver();
    }

    public void open(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    public WebElement getCheckbox(){
        return driver.findElement(By.cssSelector("#checkboxes input:nth-child(1)"));
    }
    public WebElement getCheckbox2(){
        return driver.findElement(By.cssSelector("#checkboxes input:nth-child(3)"));
    }

    public void openDragAndDrop(){
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }
    public WebElement getColumnA(){
        return driver.findElement(columnA);
    }
    public WebElement getColumnB(){
        return driver.findElement(columnB);
    }
    public String isTagNameA(){
        return driver.findElement(columnA).findElement(By.tagName("header")).getText();
    }
    public String isTagNameB(){
        return driver.findElement(columnB).findElement(By.tagName("header")).getText();
    }
}

