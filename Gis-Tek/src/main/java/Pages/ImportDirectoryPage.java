package Pages;

import Base.PageBase;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by John on 19.08.2015.
 */
public class ImportDirectoryPage extends PageBase {

    private static final By KEY_OF_DIRECTORY = By.tagName("select");
    private static final By BUTTON_UPLOAD = By.cssSelector("input[value='Импортировать']");
    private static final By BROWSE = By.className("upfile");


    public static void selectKeyOfDirectory (String s){
        $(KEY_OF_DIRECTORY).selectOption(s);
    }

    public static void clickButtonUpload(){
        $(BUTTON_UPLOAD).click();
        $(By.xpath("//span[text()='Справочник успешно загружен']")).should(exist).shouldBe(visible).shouldHave(text("Справочник успешно загружен"));
    }

    public static void uploadDirectory (){
        File cv = new File("src/main/resources/test1.csv");
        $(BROWSE).uploadFile(cv);
    }

}
