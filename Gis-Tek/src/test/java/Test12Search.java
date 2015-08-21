import Base.TestBase;
import Helpers.ScreenFailure;
import Pages.LoginPage;
import Pages.MainMenu;
import Pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by John on 17.08.2015.
 */
@Listeners(ScreenFailure.class)
public class Test12Search extends TestBase{

    private static final String USER = "user";
    private static final String USER_PASSWORD = "password";
    private static final String GROUP = "Тестовая 3";
    private static final String DIRECTORY = "Справочник 6";

    @BeforeMethod
    public static void start() {
        open("/");
    }

    @Test
    public void search(){
        LoginPage.authorize(USER,USER_PASSWORD);
        MainMenu.goToObjectsNSI();
        MainPage.search(GROUP);
        MainPage.search(DIRECTORY);
    }
}
