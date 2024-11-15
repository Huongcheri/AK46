package theInternet;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import supports.Browser;
import theInternet.pages.FormAuthenticationPage;

public class FormAuthenticationTest {
    @BeforeClass
    void setUp(){
        Browser.openBrowser("chrome");
    }
    @Test
    void ShouldSuccessfully() {

        FormAuthenticationPage login = new FormAuthenticationPage();
        login.open();
        login.login("tomsmith","SuperSecretPassword!");

        Assert.assertTrue(login.isSuccessLogin());
    }
    @Test
    void UsernameFail() {

        FormAuthenticationPage login = new FormAuthenticationPage();
        login.open();
        login.login("tomsmith01","SuperSecretPassword!");

        Assert.assertTrue(login.isUsernameFai());

    }
    @Test
    void PasswordFail() {

        FormAuthenticationPage login = new FormAuthenticationPage();
        login.open();
        login.login("tomsmith","SuperSecretPassword");

        Assert.assertTrue(login.isPasswordFai());
    }
    @AfterClass
    void tearDown(){
        Browser.quit();
    }
}
