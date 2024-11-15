package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    By valueDropDown = By.xpath("//*[@id='dropdown']/option[@value = '1']");
    By listDropDown = By.id("dropdown");
    public void openDropDown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    public WebElement getDropDown(){
        return driver.findElement(listDropDown);
    }
    public  boolean isSelected(){
        return driver.findElement(valueDropDown).isSelected();
    }
    public void openMulti(){
        driver.get("https://output.jsbin.com/osebed/2");
    }
    public WebElement getMulti(){
        return driver.findElement(By.id("fruits"));
    }

    public  WebElement getSelectedBanana(){
        return driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']"));
    }
    public  WebElement getSelectedApple(){
        return driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']"));
    }
    public  WebElement getSelectedOrange(){
        return driver.findElement(By.xpath("//*[@id='fruits']/option[@value='orange']"));
    }
    public  WebElement getSelectedGrape(){
        return driver.findElement(By.xpath("//*[@id='fruits']/option[@value='grape']"));
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

