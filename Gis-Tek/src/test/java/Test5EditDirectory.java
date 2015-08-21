import Base.TestBase;
import Helpers.ScreenFailure;
import Pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by John on 12.08.2015.
 */
@Listeners(ScreenFailure.class)
public class Test5EditDirectory extends TestBase {

    private static final String USER = "user";
    private static final String USER_PASSWORD = "password";
    private static final String MANAGER = "manager";
    private static final String MANAGER_PASSWORD = "manager";
    private static final String RECONCILIATION_PROCESS = "Подтверждение одним менеджером (ETL) - 14";

    private static String NAMES = "Ядерная энергетика";
    private static String KEY = "nuclear";
    private static String TYPE = "Всё о ядерной энергии";
    private static String REQUEST_NAME = "Ядерная";
    private static String PROPERTY= "Излучение";
    private static String ADDED_PROPERTY="Эквивалентная доза";
    private static String ADDED_PROPERTY_2="Экспозиционная доза";
    private static String TYPE_OF_PROPERTY="Число";

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
        ADDED_PROPERTY_2+= r.nextInt(9999);
    }

    @Test
    public static void  editDirectory () throws InterruptedException {
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
        MainPage.clickButtonSave();
        MainMenu.goToFormationRequestForChangesPage();
        FormationRequestForChangesPage.clickButtonEdit(TYPE);
        CreateEditDirectoryForm.showFieldsNames();
        CreateEditDirectoryForm.inputNameOfProperty(PROPERTY);
        CreateEditDirectoryForm.selectType(TYPE_OF_PROPERTY);
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty(ADDED_PROPERTY);
        CreateEditDirectoryForm.selectType(TYPE_OF_PROPERTY);
        FormationRequestForChangesPage.clickButtonSave();
        FormationRequestForChangesPage.tapAddedDirectoryCheckbox(TYPE);
        FormationRequestForChangesPage.clickButtonSendChosen();
        FormationRequestForChangesPage.inputNameOfRequest(REQUEST_NAME);
        FormationRequestForChangesPage.clickButtonSendRequest();
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.clickButtonEdit(REQUEST_NAME);
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty(ADDED_PROPERTY_2);
        CreateEditDirectoryForm.selectType(TYPE_OF_PROPERTY);
        CreateEditDirectoryForm.moveLastPropertyUp(ADDED_PROPERTY_2);
        CreateEditDirectoryForm.moveFirstPropertyDown(PROPERTY);
        IncomingRequestsPage.clickButtonSave();
        IncomingRequestsPage.sendToReconciliation(REQUEST_NAME);
        MainMenu.quite();
        LoginPage.authorize(MANAGER, MANAGER_PASSWORD);
        MainMenu.goToIncomingRequestsPage();
        IncomingRequestsPage.clickButtonEdit(REQUEST_NAME);
        CreateEditDirectoryForm.duplicateLastProperty();
        IncomingRequestsPage.clickButtonSave();
        IncomingRequestsPage.approveRequest(REQUEST_NAME);
        MainMenu.quite();
        LoginPage.authorize(USER, USER_PASSWORD);
        MainMenu.goToObjectsNSI();
        MainPage.showGroupInformation(NAMES);
        MainPage.showDirectoryInformation(TYPE);
        MainPage.clickButtonNewItem();
        MainPage.checkAddedProperties(ADDED_PROPERTY_2, PROPERTY, ADDED_PROPERTY);
    }
}
