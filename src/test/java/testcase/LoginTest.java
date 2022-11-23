package testcase;

import pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest {

    public WebDriver driver;
    public BasePage basePage;
    public LoginPage loginPage;


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);

        basePage.goToUrl();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void loginTest() throws IOException {
        loginPage.getEmail().sendKeys("caminic@test.com");
        loginPage.getPassword().sendKeys("password123");
        loginPage.getLoginBtn().click();

        basePage.takeScreenshot();
    }
}
