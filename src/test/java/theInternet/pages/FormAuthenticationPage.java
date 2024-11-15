package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import supports.Browser;

public class FormAuthenticationPage {
    WebDriver driver;

    By usernameTextBox = By.id("username");
    By passwordTextBox = By.id("password");
    By loginButton = By.cssSelector("button[type=submit]");
    By messSuccess = By.className("success");
    By messFail = By.className("error");
    public FormAuthenticationPage() {

        this.driver = Browser.getDriver();
    }
    public void open(){
        driver.get("https://the-internet.herokuapp.com/login"); // hàm không trả ve ten la danh tu
    }
    public void login(String username, String password) {
        driver.findElement(usernameTextBox).sendKeys(username);
        driver.findElement(passwordTextBox).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    public boolean isSuccessLogin(){ // ham tra ve get is
       return driver.findElement(messSuccess).getText().contains("You logged into a secure area!");
    }
    public boolean isUsernameFai(){ // ham tra ve get is
        return driver.findElement(messFail).getText().contains("Your username is invalid!");
    }
    public boolean isPasswordFai(){ // ham tra ve get is
        return driver.findElement(messFail).getText().contains("Your password is invalid!");
    }
}
