package theInternet;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import theInternet.pages.Ak46Page;
import theInternet.pages.FruitsPage;

import static supports.Browser.openBrowser;

public class DropdownTest extends BaseTest {

    @BeforeClass
    void setUp(){
        openBrowser("chrome");
    }

    @Test
    void Checkbox1isSelected() {
        Ak46Page dropDrown = new Ak46Page();
        dropDrown.openDropDown();

        dropDrown.selectOption("1");
        dropDrown.isSelected("1");
    }

    @Test
    void ableSelectMultipleOptions() {
        FruitsPage fruitsPage = new FruitsPage();

        fruitsPage.open();
        Assert.assertTrue(fruitsPage.isMultipleSelect());

        fruitsPage
                .select("banana")
                .select("apple");
        Assert.assertTrue(fruitsPage.isOptionSelected("banana"));
        Assert.assertTrue(fruitsPage.isOptionSelected("apple"));

        fruitsPage.deselect("banana");
        Assert.assertFalse(fruitsPage.isOptionSelected("banana"));
        Assert.assertTrue(fruitsPage.isOptionSelected("apple"));

        fruitsPage.deselectAll();
        Assert.assertFalse(fruitsPage.isOptionSelected("banana"));
        Assert.assertFalse(fruitsPage.isOptionSelected("apple"));
        Assert.assertFalse(fruitsPage.isOptionSelected("orange"));
        Assert.assertFalse(fruitsPage.isOptionSelected("grape"));
    }


}
