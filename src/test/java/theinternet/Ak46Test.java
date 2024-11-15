package theinternet;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theinternet.pages.Ak46Page;

import static supports.Browser.actions;
import static supports.Browser.wait;

public class Ak46Test {
    @BeforeClass
    void setUp(){
        Browser.openBrowser("chrome");
    }

    @Test
    void checkbox1isSelected() {

        Ak46Page check = new Ak46Page();
        check.open();
        WebElement checkbox = check.getCheckbox();
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        Assert.assertTrue(checkbox.isSelected());

    }
    @Test
    void Checkbox2isSelected() {
        Ak46Page check = new Ak46Page();
        check.open();
        WebElement checkbox2 = check.getCheckbox2();
        if (checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertFalse(checkbox2.isSelected());

    }
    @Test
    void ableSelectDropDown() {
        Ak46Page dropDown = new Ak46Page();
        dropDown.openDropDown();

        Select select = new Select(dropDown.getDropDown());
        select.selectByValue("1");
        Assert.assertTrue(dropDown.isSelected());
    }
    @Test
    void ableSelectMultipleOptions() { // url nay k vao duoc
        Ak46Page dropDown = new Ak46Page();
        dropDown.openMulti();
        Select select = new Select(dropDown.getMulti());

        Assert.assertTrue(select.isMultiple());
        System.out.println(select.isMultiple());
        // select banana and apple
        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        // verify able select banana and apple
        Assert.assertTrue(dropDown.getSelectedBanana().isSelected());
        Assert.assertTrue(dropDown.getSelectedApple().isSelected());
        // Deselect banana
        select.deselectByVisibleText("Banana");
        // verify able select banana and apple
        Assert.assertFalse(dropDown.getSelectedBanana().isSelected());
        Assert.assertTrue(dropDown.getSelectedApple().isSelected());
        // deselect all
        select.deselectAll();
        Assert.assertFalse(dropDown.getSelectedBanana().isSelected());
        Assert.assertFalse(dropDown.getSelectedApple().isSelected());
        Assert.assertFalse(dropDown.getSelectedOrange().isSelected());
        Assert.assertFalse(dropDown.getSelectedGrape().isSelected());
    }
    @Test
    void ableToHorizontalSlidePointer() {
        Ak46Page horizontal = new Ak46Page();
        horizontal.openHorizonSlider();

        WebElement pointer = horizontal.getPointer();
        int offsetWidth = pointer.getSize().getWidth();
        int offsetHeight = pointer.getSize().getHeight();
        System.out.printf("%d %d", offsetHeight,offsetWidth);
        actions.clickAndHold(pointer)
                .moveByOffset(offsetWidth,0)
                .perform();

        Browser.setWait(60);
        Assert.assertTrue(horizontal.isLocator5());
    }

//    @Test(dataProvider = "testData")
//    void ableToHoverImage(int imageIndex,String expectedImageName) {
//        ak46.openDataProvider();
//
//        Actions actions = new Actions(Browser.getDriver());
//
//        actions
//                .moveToElement(ak46.getImage().get(imageIndex))
//                .perform();
//
//        String imageName = ak46.getImageText().get(imageIndex).getText();
//        Assert.assertEquals(imageName, expectedImageName);
//    }
        @Test
    void ableScrollDown() throws InterruptedException {

        Ak46Page ak46 = new Ak46Page();
        ak46.openHorizonScroll();
        for (int i = 0; i < 5; i++) {
            actions.scrollByAmount(0,1000).perform();
            Thread.sleep(1000);
        }

    }
    @Test
    void contextClick(){
        Ak46Page ak46 = new Ak46Page();
        ak46.openContextClick();

        actions.contextClick(ak46.getContent()).perform();
        Browser.setWait(10);
        wait.until(ExpectedConditions.alertIsPresent()).accept();

    }
    @Test
    void keyPress(){
        Ak46Page ak46 = new Ak46Page();
        ak46.openKeyPress();

        actions.keyDown(Keys.ESCAPE).perform();

        Assert.assertEquals(ak46.getKeyPress(),"You entered: ESCAPE");
    }
    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
