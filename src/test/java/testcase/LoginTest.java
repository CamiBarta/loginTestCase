package testcase;

import base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;

import java.io.IOException;

public class LoginTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public String url;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        url = "http://tutorialsninja.com/demo/index.php?route=account/login";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void loginTest() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys("caminic@test.com");
        loginPage.getPassword().sendKeys("password123");
        loginPage.getLoginBtn().click();

        BasePage basePage = new BasePage(driver);
        basePage.takeScreenshot();
    }
}
