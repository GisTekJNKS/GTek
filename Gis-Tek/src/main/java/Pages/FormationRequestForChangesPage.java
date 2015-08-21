package Pages;

import Base.PageBase;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;




/**
 * Created by John on 10.08.2015.
 */
public class FormationRequestForChangesPage extends PageBase {


    private static final By BUTTON_SEND_CHOSEN = By.xpath("//button[text()='Отправить выбранное']");
    private static final By BUTTON_EDIT = By.xpath("//button[text()='Редактирование']");
    private static final By NAME_OF_REQUEST = By.className("editor__validation-rule");
    private static final By BUTTON_SEND_REQUEST = By.xpath("//button[text()='Оправить заявку']");
    private static final By TABLE = By.tagName("table");
    private static final By TABLE_ROWS = By.tagName("tr");
    private static final By TABLE_COLUMNS = By.tagName("td");
    private static final By CHECKBOX = By.cssSelector("input[type='checkbox']");
    private static final By BUTTON_SAVE = By.xpath("//button[text()='Сохранить']");



    public static void tapAddedGroupCheckbox(String s) throws InterruptedException {
        String ss= "Создание новой группы \""+s+"\"";
        $(By.xpath("//span[text()='" + ss + "']")).waitUntil(visible,20000);
        SelenideElement table = $(TABLE);
        ElementsCollection tr= table.$$(TABLE_ROWS);
        SelenideElement headerRow = tr.get(1);
        ElementsCollection tc = headerRow.$$(TABLE_COLUMNS);
        assertEquals(tc.get(1).getText(),ss);
        headerRow.$(CHECKBOX).click();
    }

    public static void tapAddedDirectoryCheckbox(String s) {
        String ss= "Создание нового справочника \""+s+"\"";
        //String ss= "Редактирование справочника \""+s+"\"";
        $(By.xpath("//span[text()='" + ss + "']")).waitUntil(visible,20000);
        SelenideElement table = $(TABLE);
        ElementsCollection tr= table.$$(TABLE_ROWS);
        SelenideElement headerRow = tr.get(1);
        ElementsCollection tc = headerRow.$$(TABLE_COLUMNS);
        assertEquals(tc.get(1).getText(), ss);
        headerRow.$(CHECKBOX).click();
    }

    public static void tapEditedDirectoryCheckbox(String s) {
        //String ss= "Создание нового справочника \""+s+"\"";
        String ss= "Редактирование справочника \""+s+"\"";
        $(By.xpath("//span[text()='" + ss + "']")).waitUntil(visible,20000);
        SelenideElement table = $(TABLE);
        ElementsCollection tr= table.$$(TABLE_ROWS);
        SelenideElement headerRow = tr.get(1);
        ElementsCollection tc = headerRow.$$(TABLE_COLUMNS);
        assertEquals(tc.get(1).getText(), ss);
        headerRow.$(CHECKBOX).click();
    }

    public static void tapAddedNewItemCheckbox(String s) {
        String ss= "Добавление новой записи справочника \""+s+"\"";
        $(By.xpath("//span[text()='" + ss + "']")).waitUntil(visible,20000);
        SelenideElement table = $(TABLE);
        ElementsCollection tr= table.$$(TABLE_ROWS);
        SelenideElement headerRow = tr.get(1);
        ElementsCollection tc = headerRow.$$(TABLE_COLUMNS);
        assertEquals(tc.get(1).getText(), ss);
        headerRow.$(CHECKBOX).click();
    }

    public static void tapAddedNewVersionOfDirectory (String s) {
        String ss= "Добавление новой версии записи справочника \""+s+"\"";
        $(By.xpath("//span[text()='" + ss + "']")).waitUntil(visible,20000);
        SelenideElement table = $(TABLE);
        ElementsCollection tr= table.$$(TABLE_ROWS);
        SelenideElement headerRow = tr.get(1);
        ElementsCollection tc = headerRow.$$(TABLE_COLUMNS);
        assertEquals(tc.get(1).getText(), ss);
        headerRow.$(CHECKBOX).click();
    }

    public static void tapEditedVersionOfDirectory (String s) {
        String ss= "Редактирование версии записи справочника \""+s+"\"";
        $(By.xpath("//span[text()='" + ss + "']")).waitUntil(visible,20000);
        SelenideElement table = $(TABLE);
        ElementsCollection tr= table.$$(TABLE_ROWS);
        SelenideElement headerRow = tr.get(1);
        ElementsCollection tc = headerRow.$$(TABLE_COLUMNS);
        assertEquals(tc.get(1).getText(), ss);
        headerRow.$(CHECKBOX).click();
    }

    public static void clickButtonEdit (String s){
        String ss= "Создание нового справочника \""+s+"\"";
        SelenideElement table = $(TABLE);
        ElementsCollection tr= table.$$(TABLE_ROWS);
        SelenideElement headerRow = tr.get(1);
        ElementsCollection tc = headerRow.$$(TABLE_COLUMNS);
        assertEquals(tc.get(1).getText(), ss);
        headerRow.$(BUTTON_EDIT).click();
        $(".aui-dialog2-header-main").waitUntil(visible, 30000).shouldHave(text(ss));
    }

    public static void clickButtonSendChosen() {
        $(BUTTON_SEND_CHOSEN).click();
        $(By.xpath("//h2[text()='Создание заявки на изменений']")).waitUntil(visible,30000).shouldHave(text("Создание заявки на изменений"));
    }

    public static void inputNameOfRequest (String s){
        $(NAME_OF_REQUEST).setValue(s);
    }

    public static void clickButtonSendRequest () throws InterruptedException {
        $(BUTTON_SEND_REQUEST).click();
        Thread.sleep(3000);
    }


    public static void clickButtonSave () throws InterruptedException {
        $(BUTTON_SAVE).click();
        waitUntilLoading();
        Thread.sleep(2500);
    }

}
