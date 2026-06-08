package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ScreenshotUtils;

public class FlightSearchPage {

    WebDriver driver;

    public FlightSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By chooseFlight =
            By.xpath("(//input[@value='Choose This Flight'])[1]");

    public void highlightAndSelectFlight(String name) {

        WebElement btn =
                driver.findElement(chooseFlight);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].style.border='3px solid red';" , btn);

        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ScreenshotUtils.captureScreenshot(
                driver,
                "3_Flight_Button_Highlighted_" + name);

        btn.click();
    }
}