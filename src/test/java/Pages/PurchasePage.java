package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }

    By name = By.id("inputName");
    By address = By.id("address");
    By city = By.id("city");
    By state = By.id("state");
    By zip = By.id("zipCode");

    By cardNumber = By.id("creditCardNumber");
    By cardMonth = By.id("creditCardMonth");
    By cardYear = By.id("creditCardYear");
    By cardHolderName = By.id("nameOnCard");

    By purchaseBtn = By.xpath("//input[@value='Purchase Flight']");

    // FORM FILL ONLY
    public void fillForm(
            String n,
            String a,
            String c,
            String s,
            String z,
            String cardNo,
            String month,
            String year,
            String holderName
    ) throws Exception {

        System.out.println("Name = " + n);
        System.out.println("Address = " + a);
        System.out.println("City = " + c);
        System.out.println("State = " + s);
        System.out.println("Zip = " + z);

        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(n);
        Thread.sleep(500);

        driver.findElement(address).clear();
        driver.findElement(address).sendKeys(a);
        Thread.sleep(500);

        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(c);
        Thread.sleep(500);

        driver.findElement(state).clear();
        driver.findElement(state).sendKeys(s);
        Thread.sleep(500);

        driver.findElement(zip).clear();
        driver.findElement(zip).sendKeys(z);
        Thread.sleep(500);

        driver.findElement(cardNumber).clear();
        driver.findElement(cardNumber).sendKeys(cardNo);
        Thread.sleep(500);

        driver.findElement(cardMonth).clear();
        driver.findElement(cardMonth).sendKeys(month);
        Thread.sleep(500);

        driver.findElement(cardYear).clear();
        driver.findElement(cardYear).sendKeys(year);
        Thread.sleep(500);

        driver.findElement(cardHolderName).clear();
        driver.findElement(cardHolderName).sendKeys(holderName);

        Thread.sleep(2000);
    }

    // PURCHASE BUTTON CLICK
    public void clickPurchase() {

        driver.findElement(purchaseBtn).click();
    }
}