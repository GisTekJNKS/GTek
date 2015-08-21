package Pages;

import Base.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

/**
 * Created by John on 10.08.2015.
 */
public class LoginPage extends PageBase {

    private static final By LOGIN = By.id("username");
    private static final By PASSWORD = By.id("password");
    private static final By BUTTON_ENTER = By.id("login");

    public static void inputLogin (String s){
        $(LOGIN).setValue(s);
    }

    public static void inputPassword(String s){
        $(PASSWORD).setValue(s);
    }

    public static void clickButtonEnter(){
        $(BUTTON_ENTER).click();
    }

    public static void authorize (String login , String password) {
        refresh();
        LoginPage.inputLogin(login);
        LoginPage.inputPassword(password);
        LoginPage.clickButtonEnter();
        waitUntilLoading();
        open("/");//УБРАТЬ ПРИ ИСПРАВЛЕНИИ БАГА С ВИСЯЩЕЙ ЗАГРУЗКОЙ
    }
}


