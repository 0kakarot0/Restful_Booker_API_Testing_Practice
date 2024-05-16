package base;

import org.testng.annotations.BeforeClass;
import utils.rest_assured_config.RestConfig;

public class TestBase {
    protected String token  ="";

    @BeforeClass
    public void setUp() {
        RestConfig.setUp();
    }


}
