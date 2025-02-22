package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HoverTest {
    @DataProvider
    Object[][] testData(){
        return new Object[][]{
                {0,"name: user1"},
                {1,"name: user2"},
                {2,"name: user3"},
        };
    }

    @Test(dataProvider = "testData")
    void ableToHoverImage(int imageIndex,String expectedImageName){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);

        actions
                .moveToElement(
                        driver
                                .findElements(By.cssSelector("#content .figure"))
                                .get(imageIndex))
                .perform();

        String imageName = driver.findElements(By.cssSelector(".figcaption h5")).get(imageIndex).getText();
        Assert.assertEquals(imageName,expectedImageName);

//    @Test
//    void ableToHoverImage1(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/hovers");
//
//        Actions actions = new Actions(driver);
//
//        actions
//                .moveToElement(
//                        driver
//                                .findElements(By.cssSelector("#content .figure"))
//                                .get(0))
//                .perform();
//
//        String imageName = driver.findElements(By.cssSelector(".figcaption h5")).get(0).getText();
//        Assert.assertEquals(imageName,"name: user1");
//    }
//
//    @Test
//    void ableToHoverImage2(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/hovers");
//
//        Actions actions = new Actions(driver);
//
//        actions
//                .moveToElement(
//                        driver
//                                .findElements(By.cssSelector("#content .figure"))
//                                .get(1))
//                .perform();
//
//        String imageName = driver.findElements(By.cssSelector(".figcaption h5")).get(1).getText();
//        Assert.assertEquals(imageName,"name: user2");
//    }
//
//    @Test
//    void ableToHoverImage3() {
//            WebDriver driver = new ChromeDriver();
//            driver.get("https://the-internet.herokuapp.com/hovers");
//
//            Actions actions = new Actions(driver);
//
//            actions
//                    .moveToElement(
//                            driver
//                                    .findElements(By.cssSelector("#content .figure"))
//                                    .get(2))
//                    .perform();
//
//            String imageName = driver.findElements(By.cssSelector(".figcaption h5")).get(2).getText();
//            Assert.assertEquals(imageName, "name: user3");
//        }
    }
}
