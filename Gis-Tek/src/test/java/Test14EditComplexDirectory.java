import Base.TestBase;
import Helpers.ScreenFailure;
import Pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by John on 18.08.2015.
 */
@Listeners(ScreenFailure.class)
public class Test14EditComplexDirectory extends TestBase {

    private static final String USER = "user";
    private static final String USER_PASSWORD = "password";
    private static final String MANAGER = "manager";
    private static final String MANAGER_PASSWORD = "manager";
    private static final String RECONCILIATION_PROCESS = "Подтверждение одним менеджером (ETL) - 14";
    private static final String TYPE_OF_PROPERTY1 = "Составной";
    private static final String TYPE_OF_PROPERTY2 = "Список";
    private static final String TYPE_OF_PROPERTY = "ФИО";

    private static String NAMES = "Ядерная энергетика";
    private static String KEY = "nuclear";
    private static String TYPE = "Утверждение документа";
    private static String REQUEST_NAME = "ЯДЕРНАЯ";
    private static String PROPERTY= "Создатель";
    private static String ADDED_PROPERTY="Утверждающие";


    @BeforeMethod
    public static void start() {
        open("/");
        Random r = new Random();
        NAMES += r.nextInt(9999);
        KEY += r.nextInt(9999);
        TYPE+= r.nextInt(9999);
        REQUEST_NAME+= r.nextInt(9999);
        PROPERTY+= r.nextInt(9999);
        ADDED_PROPERTY+= r.nextInt(9999);
    }

    @Test
    public static void  editComplexDirectory () throws InterruptedException {
        LoginPage.authorize(USER, USER_PASSWORD);
        MainMenu.goToObjectsNSI();
        MainPage.clickButtonCreateGroup();
        MainPage.selectReconciliationProcess(RECONCILIATION_PROCESS);
        MainPage.inputKey(KEY);
        MainPage.inputShortName(NAMES);
        MainPage.inputFullName(NAMES);
        MainPage.clickButtonSave();
        MainMenu.goToFormationRequestForChangesPage();
        FormationRequestForChangesPage.tapAddedGroupCheckbox(NAMES);
        FormationRequestForChangesPage.clickButtonSendChosen();
        FormationRequestForChangesPage.inputNameOfRequest(NAMES);
        FormationRequestForChangesPage.clickButtonSendRequest();
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.sendToReconciliation(NAMES);
        MainMenu.quite();
        LoginPage.authorize(MANAGER, MANAGER_PASSWORD);
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.approveRequest(NAMES);
        MainMenu.quite();
        LoginPage.authorize(USER, USER_PASSWORD);
        MainMenu.goToObjectsNSI();
        MainPage.showGroupInformation(NAMES);
        MainPage.clickButtonCreateDirectory();
        CreateEditDirectoryForm.clickButtonNewType();
        CreateEditDirectoryForm.inputTypeName(TYPE);
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty(PROPERTY);
        CreateEditDirectoryForm.tapCheckboxMandatory();
        CreateEditDirectoryForm.selectType(TYPE_OF_PROPERTY1);
        CreateEditDirectoryForm.selectType(TYPE_OF_PROPERTY);
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty(ADDED_PROPERTY);
        CreateEditDirectoryForm.tapCheckboxMandatory();
        CreateEditDirectoryForm.selectType(TYPE_OF_PROPERTY2);
        CreateEditDirectoryForm.selectType(TYPE_OF_PROPERTY);
        MainPage.clickButtonSave();
        MainMenu.goToFormationRequestForChangesPage();
        FormationRequestForChangesPage.tapAddedDirectoryCheckbox(TYPE);
        FormationRequestForChangesPage.clickButtonSendChosen();
        FormationRequestForChangesPage.inputNameOfRequest(REQUEST_NAME);
        FormationRequestForChangesPage.clickButtonSendRequest();
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.sendToReconciliation(REQUEST_NAME);
        MainMenu.quite();
        LoginPage.authorize(MANAGER, MANAGER_PASSWORD);
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.approveRequest(REQUEST_NAME);
        MainMenu.quite();
        LoginPage.authorize(USER, USER_PASSWORD);
        MainMenu.goToObjectsNSI();
        MainPage.showGroupInformation(NAMES);
        MainPage.showDirectoryInformation(TYPE);
        MainPage.clickButtonEditDirectory();
        CreateEditDirectoryForm.clickButtonAddType();
        CreateEditDirectoryForm.inputTypeName("Адрес");
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty("Индекс");
        CreateEditDirectoryForm.selectType("Целое");
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty("Город");
        CreateEditDirectoryForm.selectType("Строка");
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty("Улица");
        CreateEditDirectoryForm.selectType("Строка");
        CreateEditDirectoryForm.chooseDataType("ФИО");
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty("Адрес");
        CreateEditDirectoryForm.selectType("Составной");
        CreateEditDirectoryForm.selectType("Адрес");
        CreateEditDirectoryForm.chooseDataType(TYPE);
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty("Вышестоящий запрос");
        CreateEditDirectoryForm.selectType("Справочник");
        CreateEditDirectoryForm.selectType(TYPE);
        MainPage.clickButtonSave();
        MainMenu.goToFormationRequestForChangesPage();
        FormationRequestForChangesPage.tapEditedDirectoryCheckbox(TYPE);
        FormationRequestForChangesPage.clickButtonSendChosen();
        FormationRequestForChangesPage.inputNameOfRequest(REQUEST_NAME);
        FormationRequestForChangesPage.clickButtonSendRequest();
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.sendToReconciliation(REQUEST_NAME);
        MainMenu.quite();
        LoginPage.authorize(MANAGER, MANAGER_PASSWORD);
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.approveRequest(REQUEST_NAME);
        MainMenu.quite();
        LoginPage.authorize(USER, USER_PASSWORD);
        MainMenu.goToObjectsNSI();
        MainPage.showGroupInformation(NAMES);
        MainPage.showDirectoryInformation(TYPE);
        MainPage.checkHierarchicalElements();//87 Отображаются кнопки "Иерархический режим" и "Табличный режим". Отображается выпадающий список "Родительское поле"
        MainPage.clickButtonNewItem();
        MainPage.checkSubPropertyAddresCreatorBlock();//88В блоке "создатель" существует блок "Адрес"
        MainPage.inputShortNameOfNewItem("Краткое имя");
        MainPage.inputNameOfNewItem("Имя");
        MainPage.clickButtonAdd();
        MainPage.checkSubPropertyAddresApproversBlock();//Блок "адрес " отображается в блоке "Утверждающий"
        MainPage.inputIndexes(220030);
        MainPage.clickButtonSave();
        MainMenu.goToFormationRequestForChangesPage();
        FormationRequestForChangesPage.tapAddedNewItemCheckbox(TYPE);
        FormationRequestForChangesPage.clickButtonSendChosen();
        FormationRequestForChangesPage.inputNameOfRequest(REQUEST_NAME);
        FormationRequestForChangesPage.clickButtonSendRequest();
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.sendToReconciliation(REQUEST_NAME);
        MainMenu.quite();
        LoginPage.authorize(MANAGER, MANAGER_PASSWORD);
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.approveRequest(REQUEST_NAME);
        MainMenu.quite();
        LoginPage.authorize(USER, USER_PASSWORD);
        MainPage.showGroupInformation(NAMES);
        MainPage.showDirectoryInformation(TYPE);
        MainPage.checkAddedItem("Имя"); //Запись "привет" находиться в видимой части экрана
        MainPage.clickButtonNewItem();
        MainPage.inputShortNameOfNewItem("Краткое имя2");
        MainPage.inputNameOfNewItem("Имя2");
        MainPage.clickButtonAdd();
        MainPage.inputIndexes(220031);
        MainPage.selectItem("Краткое имя");
        MainPage.clickButtonSave();
        MainMenu.goToFormationRequestForChangesPage();
        FormationRequestForChangesPage.tapAddedNewItemCheckbox(TYPE);
        FormationRequestForChangesPage.clickButtonSendChosen();
        FormationRequestForChangesPage.inputNameOfRequest(REQUEST_NAME);
        FormationRequestForChangesPage.clickButtonSendRequest();
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.sendToReconciliation(REQUEST_NAME);
        MainMenu.quite();
        LoginPage.authorize(MANAGER, MANAGER_PASSWORD);
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.approveRequest(REQUEST_NAME);
        MainMenu.quite();
        LoginPage.authorize(USER, USER_PASSWORD);
        MainPage.showGroupInformation(NAMES);
        MainPage.showDirectoryInformation(TYPE);
        MainPage.chooseHierarchicalMode();
        MainPage.openHierarchicalTree();
        MainPage.checkChildItem("Имя2");
    }
}
