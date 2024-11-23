package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

import static supports.Browser.wait;

public class Ak46Page {
    WebDriver driver;

    public Ak46Page() {

        this.driver = Browser.getDriver();
    }

//    public Ak46Page(WebDriver driver) {
//        this.driver = driver;
//    }

    By checkbox1 = By.cssSelector("#checkboxes input:nth-child(1)");
    public void open(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    public WebElement getCheckbox(){
        return driver.findElement(checkbox1);
    }
    public WebElement getCheckbox2(){
        return driver.findElement(By.cssSelector("#checkboxes input:nth-child(3)"));
    }

    By columnA = By.id("column-a");
    By columnB = By.id("column-b");
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



    public void openDropDown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    public void selectOption(String option){
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByValue(option);
    }
    public  boolean isSelected(String option){
        return driver.findElement(By.xpath(String.format("//*[@id='dropdown']/option[@value = '%s']",option))).isSelected();
    }


    public void openMulti(){
        driver.get("https://output.jsbin.com/osebed/2");
    }
    public void selectMulti(String option){
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByVisibleText(option);
    }
    public void deSelectMulti(String option){
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByVisibleText(option);
    }
    public boolean isSelectedOption(String option){
        return driver.findElement(By.xpath(String.format("//option[@value='%s']",option))).isSelected();
    }


    public void openHorizonSlider(){
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
    }
    public WebElement getPointer(){
        return driver.findElement(By.cssSelector(".sliderContainer input"));
    }
    public boolean isLocator5(){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("range"),"5"));
    }
    public void openHorizonScroll(){
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
    }
    public void openContextClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }
    public WebElement getContent(){
        return driver.findElement(By.id("hot-spot"));
    }
    public void openKeyPress(){
        driver.get("https://the-internet.herokuapp.com/key_presses");
    }
   public String getKeyPress(){
        return driver.findElement(By.id("result")).getText();
   }
   public void openDataProvider(){
       driver.get("https://the-internet.herokuapp.com/hovers");
   }
   public WebElement getImage(){
       return (WebElement) driver.findElements(By.cssSelector("#content .figure"));
   }
    public WebElement getImageText(){
        return (WebElement) driver.findElements(By.cssSelector(".figcaption h5"));
    }
}

