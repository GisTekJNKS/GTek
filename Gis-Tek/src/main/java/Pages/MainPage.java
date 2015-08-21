package Pages;

import Base.PageBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by John on 10.08.2015.
 */
public class MainPage extends PageBase {


    private static final By BUTTON_CREATE_GROUP = By.xpath("//button[text()='Создать группу']");
    private static final By BUTTON_EDIT_GROUP = By.xpath("//button[text()='Редактировать группу']");
    private static final By BUTTON_CREATE_DIRECTORY = By.xpath("//button[text()='Создать справочник']");
    private static final By BUTTON_DELETE_GROUP = By.xpath("//button[text()='Удалить группу']");
    private static final By BUTTON_DELETE = By.xpath("//button[text()='Удалить']");
    private static final By BUTTON_DELETE_DIRECTORY = By.xpath("//button[text()='Удалить']");
    private static final By BUTTON_ADD_VERSION = By.xpath("//button[text()='Добавить версию']");
    private static final By BUTTON_EXCHANGE_VERSION = By.xpath("//button[text()='Изменить версию']");
    private static final By BUTTON_DELETE_ITEM = By.xpath("//button[text()='Удалить запись']");
    private static final By BUTTON_EDIT_DIRECTORY = By.xpath("//button[text()='Редактировать']");
    private static final By BUTTON_ADD = By.xpath("//button[text()='Добавить']");

    private static final By KEY = By.cssSelector("input[data-reactid$='.0.1.0.0.1.1']");
    private static final By SHORT_NAME = By.cssSelector("input[data-reactid$='.0.1.0.0.2.1']");
    private static final By FULL_NAME = By.cssSelector("input[data-reactid$='.0.1.0.0.3.1']");
    private static final By BUTTON_SAVE = By.xpath("//button[text()='Сохранить']");
    private static final By RECONCILIATION_PROCESS = By.id("processDefenitionId");
    private static final By FULL_NAME_ON_GROUP_INFORMATION = By.cssSelector("span[data-reactid$='0.3.1.1']");
    private static final By BUTTON_NEW_ITEM = By.xpath("//button[text()='Новая запись']");


    public static void clickButtonCreateGroup() {
        $(BUTTON_CREATE_GROUP).click();
        $(By.xpath("//h2[text()='Создать группу']")).waitUntil(visible, 20000);
    }

    public static void selectReconciliationProcess(String s) {
        $(RECONCILIATION_PROCESS).selectOption(s);
    }

    public static void inputKey(String s) {
        $(KEY).sendKeys(s);
    }

    public static void inputShortName(String s) {
        $(SHORT_NAME).clear();
        $(SHORT_NAME).sendKeys(s);
    }

    public static void inputFullName(String s) {
        $(FULL_NAME).clear();
        $(FULL_NAME).sendKeys(s);
    }

    public static void clickButtonSave() throws InterruptedException {
        $(BUTTON_SAVE).click();
        Thread.sleep(5000);
    }

    public static void fillFieldsOnCreationGroupForm(String reconciliationProcess, String key, String shortName, String fullName) throws InterruptedException {
        MainPage.selectReconciliationProcess(reconciliationProcess);
        MainPage.inputKey(key);
        MainPage.inputShortName(shortName);
        MainPage.inputFullName(fullName);
        MainPage.clickButtonSave();
    }

    public static void showGroupInformation(String s) {
        String ss = $(By.xpath("//a[text()='" + s + "']")).getText();
        waitUntilLoading();
        $(By.xpath("//a[text()='" + s + "']")).waitUntil(visible, 30000).click();
    }

    public static void clickButtonEditGroup() {
        $(BUTTON_EDIT_GROUP).click();
        $(By.xpath("//h2[text()='Редактировать группу']")).waitUntil(visible, 20000);
    }

    public static void checkFullNameOnGroupInformationForm(String s) {
        assertTrue($(FULL_NAME_ON_GROUP_INFORMATION).getText().equals(s));
    }

    public static void checkAddedGroup(String s) {
        $(By.xpath("//a[text()='" + s + "']")).shouldHave(text(s));
    }

    public static void clickButtonCreateDirectory() {
        $(BUTTON_CREATE_DIRECTORY).click();
    }



    public static void checkAddedDirectory(String s) {
        assertTrue($(By.xpath("//a[text()='" + s + "']")).getText().equals(s));
    }

    public static void clickButtonDeleteGroup() {
        $(BUTTON_DELETE_GROUP).click();
    }

    public static void clickButtonDeleteDirectory() {
        $(BUTTON_DELETE_DIRECTORY).click();
        waitUntilLoading();
    }

    public static void clickButtonDelete() {
        $(".aui-dialog2-content button").click(); //$(BUTTON_DELETE).click();
        waitUntilLoading();
    }

    public static void checkGroupWasDeleted(String s) {
        $(By.xpath("//a[text()='" + s + "']")).shouldBe(Condition.disappear);
    }

    public static void clickButtonNewItem() {
        $(BUTTON_NEW_ITEM).click();
        waitUntilLoading();
        $(".aui-dialog2-header-main").shouldBe(visible).shouldHave(text("Добавить запись"));
    }

    public static void checkAddedProperties(String firstProperty, String secondProperty, String thirdProperty) {
        ElementsCollection properties = $$(By.tagName("fieldset")).get(1).$$(By.tagName("span"));
        properties.get(0).should(exist).shouldHave(text(firstProperty));
        properties.get(1).should(exist).shouldHave(text(secondProperty));
        properties.get(3).should(exist).shouldHave(text(thirdProperty));
        properties.get(4).should(exist).shouldHave(text("Новое свойство"));
    }

    public static void showDirectoryInformation(String s) {
        $(By.xpath("//a[text()='" + s + "']")).click();
        waitUntilLoading();
        $(By.xpath("//h1[text()='" + s + "']")).shouldBe(visible);
    }

    public static void checkDirectoryWasDeleted(String s) {
        $(By.xpath("//a[text()='" + s + "']")).shouldNot(exist);
    }

    public static void inputShortNameOfNewItem(String s) {
        $$(By.tagName("fieldset")).get(0).$$(By.tagName("div")).get(0).$(".text").setValue(s);
    }

    public static void inputFullNameOfNewItem(String s) {
        $$(By.tagName("fieldset")).get(0).$$(By.tagName("div")).get(1).$(".text").setValue(s);
    }

    public static void inputStartDateNewItem(String s) {
        $$(By.tagName("fieldset")).get(0).$$(By.tagName("div")).get(2).$(By.tagName("input")).sendKeys(s);
        $(".aui-dialog2-header-main").click();
    }

    public static void inputEndDateNewItem(String s) {
        $$(By.tagName("fieldset")).get(0).$$(By.tagName("div")).get(3).$(By.tagName("input")).sendKeys(s);
        $(".aui-dialog2-header-main").click();
    }

    public static void inputNameOfNewItem(String s) {
        $$(By.tagName("fieldset")).get(1).$("#title").setValue(s);
    }

    public static void checkAddedItem(String s) {
        $(By.xpath("//a[text()='" + s + "']")).should(exist).shouldHave(text(s));
    }

    public static void clickButtonSettings() {
        $(By.cssSelector("span[class='glyphicon glyphicon-cog']")).click();
        $(".aui-dialog2-header-main").shouldBe(visible);//shouldHave(text("Добавить запись"));
    }

    public static void setOneDisplayedElement() {
        $(".form-control").setValue("1");
    }

    public static void checkCountDisplayedItemsEqualOne() {
        assertEquals($$(".standard-row>td").size(), 1);
    }

    public static void showItemInformation(String s) {
        $(By.xpath("//a[text()='" + s + "']")).click();
        waitUntilLoading();
    }

    public static void clickButtonAddVersion() {
        $(BUTTON_ADD_VERSION).click();
        $(".aui-dialog2-header-main").waitUntil(visible, 3000).shouldHave(text("Добавить версию"));
    }

    public static void inputStartDateVersion(String s) {
        $$(By.tagName("fieldset")).get(1).$$(By.tagName("div")).get(0).$(By.tagName("input")).clear();
        $$(By.tagName("fieldset")).get(1).$$(By.tagName("div")).get(0).$(By.tagName("input")).sendKeys(s);
        $(".aui-dialog2-header-main").click();
    }

    public static void inputEndDateVersion(String s) {
        $$(By.tagName("fieldset")).get(1).$$(By.tagName("div")).get(1).$(By.tagName("input")).clear();
        $$(By.tagName("fieldset")).get(1).$$(By.tagName("div")).get(1).$(By.tagName("input")).sendKeys(s);
        $(".aui-dialog2-header-main").click();
    }

    public static void inputNameOfVersion(String s) {
        $$(By.tagName("fieldset")).get(2).$("#title").clear();
        $$(By.tagName("fieldset")).get(2).$("#title").setValue(s);
    }

    public static void checkAddedVersion(String dateStart, String dateEnd) {
        $$(".aui-item").get(1).$(By.xpath("//h3[text()='Другие версии']")).shouldHave(text("Другие версии"));
        assertEquals($$(".aui-item").get(1).$(".aui-nav").$$(By.tagName("li")).size(), 2);
        StringBuffer sb = new StringBuffer();
        sb.append("с ");
        sb.append(dateStart);
        sb.append(" по ");
        sb.append(dateEnd);
        String ss = sb.toString();
        assertEquals($$(".aui-item").get(1).$(".aui-nav").$$(By.tagName("a")).get(1).getText().toString(), ss);
    }

    public static void checkEditedVersion(String name, String dateEnd) {
        $(By.cssSelector("div[class='text input--text']")).shouldHave(text(name));
        $$(".aui-item").get(1).$(By.xpath("//h3[text()='Другие версии']")).shouldHave(text("Другие версии"));
        StringBuffer sb = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedCurrentDate = new Date();
        sb.append("с ").append(sdf.format(convertedCurrentDate)).append(" по ").append(dateEnd);
        String ss = sb.toString();
        assertEquals($$(".aui-item").get(1).$(".aui-nav").$$(By.tagName("a")).get(0).getText().toString(), ss);

    }

    public static void clickButtonExchangeVersion() {
        $(BUTTON_EXCHANGE_VERSION).click();
        $(".aui-dialog2-header-main").waitUntil(visible, 3000).shouldHave(text("Изменить версию"));
    }

    public static void clickButtonDeleteItem() {
        $(BUTTON_DELETE_ITEM).click();
        $(".aui-dialog2-header-main").waitUntil(visible, 3000);
    }

    public static void checkItemWasDeleted() {
        $(".griddle.griddle-nodata").should(exist).$(By.xpath("//div[text()='Нет данных']")).should(exist);
    }

    public static void search(String nameOfDoc){
        $(".text").clear();
        $(".text").sendKeys(nameOfDoc);
        $(By.xpath("//a[text()='" + nameOfDoc + "']")).should(exist).shouldBe(visible);
    }

    public static void clickButtonEditDirectory (){
        $(BUTTON_EDIT_DIRECTORY).click();
        $(".aui-dialog2-header-main").waitUntil(visible, 30000).shouldHave(text("Редактирование справочника"));
    }

    public static void clickButtonAdd(){
        $(BUTTON_ADD).click();
    }

    public static void checkFieldsOfComplexDirectory (String firstProperty, String secondProperty){
        $(By.xpath("//span[text()='"+firstProperty+"']")).should(exist);
        $(By.xpath("//h4[text()='"+secondProperty+"']")).should(exist);
        assertEquals($(".form__list").$$(".form__sub").size(), 2);
    }

    public static void inputIndexes (int index){
        ElementsCollection indexes = $$("#indeks");
        for (SelenideElement e:indexes){
            e.setValue(String.valueOf(index));
        }
    }

    public static void selectItem(String s){
        $(".Select-arrow").click();
        $(".Select-option").shouldHave(text(s)).click();
    }

    public static void chooseHierarchicalMode(){
        $(".aui-button.active").click();
    }

    public static void openHierarchicalTree (){
        $(".aui-icon.aui-icon-small.aui-iconfont-collapsed").click();
    }

    public static void checkChildItem (String s){
        $(".child-row").should(exist).$(By.xpath("//a[text()='" + s + "']")).shouldHave(text(s));
    }

    public static void checkHierarchicalElements (){
        $(".aui-button.active").should(exist).shouldBe(visible);
        $(By.cssSelector("button[title='Табличный режим']")).should(exist).shouldBe(visible);
        $("#parentField").should(exist).shouldBe(visible);
    }

    public static void checkSubPropertyAddresCreatorBlock (){
        $(".form__sub.form__sub--error>h5 span").should(exist).shouldHave(text("Адрес"));
    }

    public static void checkSubPropertyAddresApproversBlock (){
        SelenideElement approvers = $(".form__list ");
        approvers.$(".form__sub.form__sub--error>h5 span").should(exist).shouldHave(text("Адрес"));
    }

    public static void checkImportedElementsOfItem (String title,String stroka_2,String dateStart,String dateEnd){
        SelenideElement selenideElement = $(".aui-group");
        selenideElement.$(By.xpath("//div[text()='"+title+"']")).should(exist).shouldHave(text(title));
        selenideElement.$(By.xpath("//div[text()='"+stroka_2+"']")).should(exist).shouldHave(text(stroka_2));
        selenideElement.$(By.xpath("//span[text()='"+dateStart+"']")).should(exist).shouldHave(text(dateStart));
        selenideElement.$(By.xpath("//span[text()='"+dateEnd+"']")).should(exist).shouldHave(text(dateEnd));
    }

    public static void inputFieldsOfAddedProperties (String proverka1,String proverka2,String proverka3,String proverka4){
        SelenideElement fieldsOfAddedProperties = $(".aui-dialog2-content .aui.form");
        ElementsCollection inp = $$(By.tagName("input"));
        inp.get(inp.size() - 1).setValue(proverka4);
        inp.get(inp.size() - 2).setValue(proverka3);
        inp.get(inp.size() - 3).setValue(proverka2);
        inp.get(inp.size() - 4).setValue(proverka1);
    }

    public static void checkErrorMessages (){
        $(By.xpath("//div[text()='Поле \"Проверка 1\" должно быть числом']"));
        $(By.xpath("//div[text()='Поле \"Проверка 2\" должно быть целочисленным']"));
        $(By.xpath("//div[text()='Поле \"Проверка 3\" должно быть датой в виде ГГГГ-ММ-ДД']"));
    }

}

