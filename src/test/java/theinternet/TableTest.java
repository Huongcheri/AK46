package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TableTest {
    @Test
    void tc6(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        double[] dueValue = driver
                .findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(WebElement -> Double.parseDouble(WebElement.getText().replace("$","")))
                .toArray();

        double maxValue = driver
                .findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[4]")) //table[@id = "table1"]/tbody/tr[1]/td - lấy hàng đầu tiên cột đầu tiên là ô 1
                .stream()
                .mapToDouble(WebElement -> Double.parseDouble(WebElement.getText().replace("$",""))) //.forEach(WebElement -> System.out.println(WebElement.getText().replace("$","")));
                .max()
                .getAsDouble();
        System.out.println(maxValue);

        int indexOfMaxValue = 0;
        for (int i = 0; i < dueValue.length ; i++) {
            if (dueValue[i] == maxValue){
                indexOfMaxValue = i+1;
            }
        }
        System.out.println(indexOfMaxValue);
        String cellLocator = "//table[@id ='table1']/tbody/tr[%d]/td[%d]";
        String firsName = driver.findElement(By.xpath(String.format(cellLocator,indexOfMaxValue,2))).getText(); // 2 -> cot firstName
        String lastName = driver.findElement(By.xpath(String.format(cellLocator,indexOfMaxValue,1))).getText(); // 1 -> cot lastName
//        System.out.printf("%s %s",firsName,lastName);
        Assert.assertEquals(String.format("%s %s",firsName,lastName),"Jason Doe");
        driver.quit();

    }
}
