package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    WebDriver driver;

    // Locators
    By txtName = By.name("name");
    By txtCompany = By.name("company");
    By txtEmail = By.name("email");
    By txtPassword = By.name("password");
    By txtConfirmPassword = By.name("password_confirmation");
    By btnRegister = By.xpath("//button[@type='submit']");

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    // Actions

    public void enterName(String name) {
        driver.findElement(txtName).sendKeys(name);
    }

    public void enterCompany(String company) {
        driver.findElement(txtCompany).sendKeys(company);
    }

    public void enterEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(txtConfirmPassword).sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(btnRegister).click();
    }
}