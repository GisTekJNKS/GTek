package Pages;

import Base.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

/**
 * Created by John on 10.08.2015.
 */
public class MainMenu extends PageBase {

    private static final By OBJECTS_NSI = By.xpath("//a[text()='Объекты НСИ']");
    private static final By IMPORT_DIRECTORY = By.xpath("//a[text()='Импорт справочников']");
    private static final By FORMATION_REQUEST_FOR_CHANGES = By.xpath("//a[text()='Формирование запроса изменений']");
    private static final By INCOMING_REQUESTS = By.xpath("//a[text()='Входящие заявки']");
    private static final By QUIT = By.xpath("//button[text()='Выход']");

    public static void quite(){
        $(QUIT).click();
        waitUntilLoading();
        clearBrowserCache();
    }

    public static void goToObjectsNSI(){
        $(OBJECTS_NSI).click();
        waitUntilLoading();
    }

    public static void goToFormationRequestForChangesPage (){
        $(FORMATION_REQUEST_FOR_CHANGES).click();
        waitUntilLoading();
    }

    public static void goToIncomingRequestsPage (){
        $(INCOMING_REQUESTS).click();
        waitUntilLoading();
    }

    public static void goToImportDirectory (){
        $(IMPORT_DIRECTORY).click();
        waitUntilLoading();
        $(By.cssSelector("input[value='Импортировать']")).should(exist).shouldBe(visible);
    }







}
