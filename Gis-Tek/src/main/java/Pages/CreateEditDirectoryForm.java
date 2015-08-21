package Pages;

import Base.PageBase;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by John on 17.08.2015.
 */
public class CreateEditDirectoryForm extends PageBase{

    private static final By BUTTON_ADD_PROPERTY = By.xpath("//button[text()='Добавить свойство']");
    private static final By TYPE = By.xpath("//div[text()='Новый тип']");
    private static final By TYPE_NAME = By.cssSelector("input[value='Новый тип']");

    public static void showFieldsNames () {
        if ($(".glyphicon.glyphicon-menu-right").exists()){
            $(".glyphicon.glyphicon-menu-right").click();
        }
    }

    public static void inputNameOfProperty(String s){
        $("input[value='Наименование']").clear();
        $("input[value='Наименование']").setValue(s);
    }



    public static void clickButtonAddProperty() throws InterruptedException {
        $(BUTTON_ADD_PROPERTY).shouldBe(visible).click();
        $(By.cssSelector("input[value='Новое свойство']")).shouldBe(visible);
    }

    public static void inputNameOfNewAddedProperty(String s){
        $(By.cssSelector("input[value='Новое свойство']")).clear();
        ElementsCollection ec = $$(By.cssSelector("input[value='Новое свойство']"));
        ec.get(ec.size() - 1).setValue(s);
    }

    public static void selectType (String s){
        SelenideElement propertiesBlock = $(By.cssSelector(".col-lg-9 form>.panel.panel-default>.panel-body"));
        ElementsCollection properties = propertiesBlock.$$(".panel-body");
        ElementsCollection selects = properties.get(properties.size() - 1).$$(By.tagName("select"));
        selects.get(selects.size() - 1).selectOption(s);
    }



    public static void clickButtonNewType() {
        $(TYPE).click();
    }

    public static void inputTypeName(String s) {
        CreateEditDirectoryForm.showFieldsNames();
        SelenideElement se = $$(".col-lg-9 .form-group").filterBy(visible).get(1).$(By.tagName("input"));
        se.clear();
        se.setValue(s);
    }

    public static void  tapCheckboxMandatory (){
        SelenideElement propertiesBlock = $(By.cssSelector(".col-lg-9 form>.panel.panel-default>.panel-body"));
        ElementsCollection properties = propertiesBlock.$$(".panel-body");
        ElementsCollection checkboxes = properties.get(properties.size() - 1).$$(By.cssSelector("input[type='checkbox']"));
        checkboxes.get(checkboxes.size() - 1).setSelected(true);
    }

    public static void moveLastPropertyUp (String s){
        SelenideElement propertiesBlock = $(By.cssSelector(".col-lg-9 form>.panel.panel-default>.panel-body"));
        ElementsCollection properties = propertiesBlock.$$(".panel-heading");
        properties.get(properties.size()-1).$(".glyphicon.glyphicon-arrow-up").click();
        properties.get(properties.size()-2).$(By.tagName("span")).shouldHave(text(s));
    }

    public static void moveFirstPropertyDown (String s){
        SelenideElement propertiesBlock = $(By.cssSelector(".col-lg-9 form>.panel.panel-default>.panel-body"));
        ElementsCollection properties = propertiesBlock.$$(".panel-heading");
        properties.get(0).$(".glyphicon.glyphicon-arrow-down").click();
        properties.get(1).$(By.tagName("span")).shouldHave(text(s));
    }

    public static  void duplicateLastProperty (){
        SelenideElement propertiesBlock = $(By.cssSelector(".col-lg-9 form>.panel.panel-default>.panel-body"));
        ElementsCollection properties = propertiesBlock.$$(".panel-heading");
        properties.get(properties.size()-1).$(".glyphicon.glyphicon-duplicate").click();
    }

    public static void clickButtonAddType (){
        $(".glyphicon.glyphicon-plus-sign").click();
    }

    public static void chooseDataType (String s){
        $(".list-group").$(By.xpath("//div[text()='"+s+"']")).click();
    }



}
