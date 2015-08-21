package Pages;

import Base.PageBase;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.$;


/**
 * Created by John on 10.08.2015.
 */
public class IncomingRequestsPage extends PageBase {

    private static final By BUTTON_SEND_FOR_RECONCILIATION = By.xpath("//button[text()='Отправить на согласование']");
    private static final By BUTTON_APPROVE_REQUEST = By.xpath("//button[text()='Утвердить']");
    private static final By BUTTON_EDIT = By.xpath("//button[text()='Редактировать']");
    private static final By FIRST_REQUEST = By.cssSelector("div[data-reactid='.0.1.0.2.0.0:0']");
    private static final By BUTTON_SAVE = By.xpath("//button[text()='Сохранить']");

    public static void sendToReconciliation (String s) throws InterruptedException {
        SelenideElement firstRequest = $(FIRST_REQUEST).shouldBe(visible);
        firstRequest.$(By.xpath("//h2[text()='" + s + "']")).waitUntil(visible, 30000);
        assertTrue(firstRequest.$(By.xpath("//h2[text()='" + s + "']")).getText().equals(s));
        firstRequest.$(BUTTON_SEND_FOR_RECONCILIATION).click();
    }

    public static void approveRequest (String s) {
        SelenideElement firstRequest = $(FIRST_REQUEST);
        firstRequest.$(By.xpath("//h2[text()='" + s + "']")).waitUntil(visible, 35000);
        assertTrue(firstRequest.$(By.xpath("//h2[text()='" + s + "']")).getText().equals(s));
        firstRequest.$(BUTTON_APPROVE_REQUEST).waitUntil(visible, 30000).click();
        firstRequest.$(By.xpath("//h2[text()='" + s + "']")).shouldNotHave(text(s));
        waitUntilLoading();
    }

    public static void approveImport (String s) {
        SelenideElement firstRequest = $(FIRST_REQUEST);
        String ef = firstRequest.$(By.tagName("h2")).waitUntil(visible, 35000).getText();
        assertTrue(ef.contains(s));
        firstRequest.$(BUTTON_APPROVE_REQUEST).waitUntil(visible,30000).click();
        waitUntilLoading();
    }


    public static void clickButtonEdit (String s){
        SelenideElement firstRequest = $(FIRST_REQUEST);
        firstRequest.$(By.xpath("//h2[text()='" + s + "']")).waitUntil(visible, 35000);
        assertTrue(firstRequest.$(By.xpath("//h2[text()='" + s + "']")).getText().equals(s));
        firstRequest.$(BUTTON_EDIT).waitUntil(visible,40000).click();
        waitUntilLoading();
    }





    public static void clickButtonSave () throws InterruptedException {
        $(BUTTON_SAVE).click();
        waitUntilLoading();
        Thread.sleep(2500);
    }



}
