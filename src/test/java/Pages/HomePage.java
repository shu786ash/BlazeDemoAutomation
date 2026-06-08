package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By fromPort = By.name("fromPort");
    By toPort = By.name("toPort");
    By findFlightsBtn = By.xpath("//input[@value='Find Flights']");

    public void selectFromCity(String fromCity) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(fromPort));

        Select from =
                new Select(driver.findElement(fromPort));

        from.selectByVisibleText(fromCity);
    }

    public void selectToCity(String toCity) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(toPort));

        Select to =
                new Select(driver.findElement(toPort));

        to.selectByVisibleText(toCity);
    }

    public void clickFindFlights() {

        wait.until(
                ExpectedConditions.elementToBeClickable(findFlightsBtn));

        driver.findElement(findFlightsBtn).click();
    }

    // Optional - old method
    public void searchFlights(String fromCity, String toCity) {

        selectFromCity(fromCity);

        selectToCity(toCity);

        clickFindFlights();
    }
}