package Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "flightData")
    public Object[][] getFlightData() throws Exception {

        String file =
                "src/test/resources/TestData.xlsx";

        int rows =
                ExcelUtils.getRowCount(
                        file,
                        "PurchaseData");

        Object[][] data =
                new Object[rows][9];

        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < 9; j++) {

                data[i - 1][j] =
                        ExcelUtils.getCellData(
                                file,
                                "PurchaseData",
                                i,
                                j);
            }
        }

        return data;
    }
}