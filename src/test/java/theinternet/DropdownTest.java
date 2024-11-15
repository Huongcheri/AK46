package theinternet;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theinternet.pages.Ak46Page;

public class DropdownTest {

    @BeforeClass
    void setUp(){
        Browser.openBrowser("chrome");
    }
    @Test
    void Checkbox1isSelected() {
        Ak46Page dropDrown = new Ak46Page();
        dropDrown.openDropDown();

        Select select = new Select(dropDrown.getDropDown());
        select.selectByValue("1");
        Assert.assertTrue(dropDrown.isSelected());
    }
    @Test
    void ableSelectMultipleOptions() { // url nay k vao duoc
        Ak46Page dropDrown = new Ak46Page();
        dropDrown.openMulti();
        Select select = new Select(dropDrown.getMulti());

        Assert.assertTrue(select.isMultiple());
        System.out.println(select.isMultiple());
        // select banana and apple
        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        // verify able select banana and apple
        Assert.assertTrue(dropDrown.getSelectedBanana().isSelected());
        Assert.assertTrue(dropDrown.getSelectedApple().isSelected());
        // Deselect banana
        select.deselectByVisibleText("Banana");
        // verify able select banana and apple
        Assert.assertFalse(dropDrown.getSelectedBanana().isSelected());
        Assert.assertTrue(dropDrown.getSelectedApple().isSelected());
        // deselect all
        select.deselectAll();
        Assert.assertFalse(dropDrown.getSelectedBanana().isSelected());
        Assert.assertFalse(dropDrown.getSelectedApple().isSelected());
        Assert.assertFalse(dropDrown.getSelectedOrange().isSelected());
        Assert.assertFalse(dropDrown.getSelectedGrape().isSelected());
    }
    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
