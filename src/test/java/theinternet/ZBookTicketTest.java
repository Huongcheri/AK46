package theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ZBookTicketTest {

    @Test
    void selectADate(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.vietnamairlines.com/vn/en/home");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree"))).click();
        // select depart date
        wait.until(ExpectedConditions.elementToBeClickable(By.id("roundtrip-date-depart"))).click();

        wait
                .until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By
                                                .cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                .get(0) // get current month
                .findElements(By.tagName("td"))
                .stream()
                .filter(cell -> cell.getText().contains("31"))
                .findFirst()
                .ifPresent(WebElement::click);

        wait
                .until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By
                                                .cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                .get(1) // get next month
                .findElements(By.tagName("td"))
                .stream()
                .filter(cell -> cell.getText().contains("5"))
                .findFirst()
                .ifPresent(WebElement::click);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Done')]"))).click();
    }
}
