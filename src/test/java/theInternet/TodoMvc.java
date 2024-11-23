package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static supports.Browser.*;

public class TodoMvc {
    @BeforeClass
    public void setUp(){

        openBrowser("Chrome");
    }
    /*

     */
    @Test
    void createNewTodo(){
        visit("https://todomvc.com/examples/vanillajs/");
        fill(By.id("//*[@id='todo-input']"),"To do exercise");
        actions.keyDown(Keys.ENTER).perform();
        Assert.assertTrue();


    }
}
