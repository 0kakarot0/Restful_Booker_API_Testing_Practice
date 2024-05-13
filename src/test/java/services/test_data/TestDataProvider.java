package services.test_data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "testData")
    public Object[][] getData() {
        return new Object[][] {
                {"data1", "data2"},
                {"data3", "data4"}
        };
    }
}