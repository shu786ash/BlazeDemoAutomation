package Testcases;

import Base.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import Pages.*;
import Utilities.ExcelUtils;
import Utilities.DataProviders;
import Utilities.ScreenshotUtils;

public class BlazeDemoTest extends Base {

    String file = "src/test/resources/TestData.xlsx";

    @Test(
            dataProvider = "flightData",
            dataProviderClass = DataProviders.class
    )
    public void fullFlowTest(

            String name,
            String country,
            String city,
            String state,
            String zip,
            String cardNo,
            String month,
            String year,
            String cardName

    ) throws Exception {

        try {

            System.out.println("===== TEST STARTED =====");

            // STEP 1 : HOME PAGE

            HomePage hp = new HomePage(driver);

            System.out.println("STEP 1: Searching Flights");

            hp.selectFromCity("Boston");
            hp.selectToCity("London");

            ScreenshotUtils.captureScreenshot(
                    driver,
                    "1_Cities_Selected_" + name);

            hp.clickFindFlights();

            Thread.sleep(2000);

            ScreenshotUtils.captureScreenshot(
                    driver,
                    "2_Flights_Found_" + name);

            // STEP 2 : FLIGHT PAGE

            System.out.println("STEP 2: Selecting Flight");

            FlightSearchPage fp =
                    new FlightSearchPage(driver);

            fp.highlightAndSelectFlight(name);

            Thread.sleep(2000);

            ScreenshotUtils.captureScreenshot(
                    driver,
                    "4_Purchase_Page_" + name);

            // STEP 3 : PURCHASE PAGE

            System.out.println("STEP 3: Filling Purchase Details");

          

            PurchasePage pp =
                    new PurchasePage(driver);

            pp.fillForm(
                    name,
                    country,
                    city,
                    state,
                    zip,
                    cardNo,
                    month,
                    year,
                    cardName
            );

            Thread.sleep(3000);

            ScreenshotUtils.captureScreenshot(
                    driver,
                    "5_Form_Filled_" + name);

            pp.clickPurchase();

            System.out.println("STEP 4: Final Confirmation Page");

            Thread.sleep(3000);

            ScreenshotUtils.captureScreenshot(
                    driver,
                    "6_Confirmation_" + name);

            // STEP 5 : WRITE RESULT TO EXCEL

            System.out.println("STEP 5: Writing Excel Data");

            if (name.equals("Ashish")) {

                ExcelUtils.setCellData(
                        file,
                        "PurchaseData",
                        1,
                        9,
                        "SUCCESS");
            }

            else if (name.equals("Virat")) {

                ExcelUtils.setCellData(
                        file,
                        "PurchaseData",
                        2,
                        9,
                        "SUCCESS");
            }

            else if (name.equals("Rohit")) {

                ExcelUtils.setCellData(
                        file,
                        "PurchaseData",
                        3,
                        9,
                        "SUCCESS");
            }

            System.out.println(
                    "===== TEST COMPLETED SUCCESSFULLY =====");

        }

        catch (Exception e) {

            System.out.println(
                    "===== TEST FAILED =====");

            e.printStackTrace();

            ScreenshotUtils.captureScreenshot(
                    driver,
                    "FAILED_TEST_" + name);

            throw new RuntimeException(e);
        }
    }
}