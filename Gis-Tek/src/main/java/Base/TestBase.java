package Base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;


/**
 * Created by John on 10.08.2015.
 */
public class TestBase {

    public static String BASE_URL="http://gis-tek.gost-group.com";

    @BeforeMethod
    public static void setup(){
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.startMaximized=true;
        Configuration.baseUrl = System.getProperty("baseUrl",BASE_URL);
        Configuration.timeout = Long.parseLong(System.getProperty("selenide.timeout","3000"));
        clearBrowserCache();
    }

    @AfterMethod
    public static void tearDown(){
        closeWebDriver();
        clearBrowserCache();
    }

}
