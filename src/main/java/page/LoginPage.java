package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By email = By.cssSelector("#input-email");
    By password = By.cssSelector("#input-password");
    By loginBtn = By.xpath("//input[@class='btn btn-primary']");

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getLoginBtn() {
        return driver.findElement(loginBtn);
    }
}
