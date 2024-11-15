package theInternet;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.Ak46Page;

public class DragDropTest {
    @BeforeClass
    void setUp(){
        Browser.openBrowser("chrome");
    }
    @Test
    void successfullyDragA2B(){
        Ak46Page dragDrop = new Ak46Page();
        dragDrop.openDragAndDrop();

        Actions actions = new Actions(Browser.getDriver());

        actions
                .dragAndDrop(dragDrop.getColumnA(),dragDrop.getColumnB())
                .perform();

        Assert.assertEquals(dragDrop.isTagNameA(),"A");
        Assert.assertEquals(dragDrop.isTagNameB(),"B");

    }
    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
