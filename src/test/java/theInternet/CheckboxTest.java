package theInternet;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.Ak46Page;

public class CheckboxTest {
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
    void checkbox2isSelected() {
        Ak46Page check = new Ak46Page();
        check.open();
        WebElement checkbox2 = check.getCheckbox2();
        if (checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertFalse(checkbox2.isSelected());

    }
    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
