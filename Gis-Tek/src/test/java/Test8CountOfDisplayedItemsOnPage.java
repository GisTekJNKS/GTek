import Base.TestBase;
import Helpers.ScreenFailure;
import Pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by John on 14.08.2015.
 */
@Listeners(ScreenFailure.class)
public class Test8CountOfDisplayedItemsOnPage extends TestBase {

    private static final String USER = "user";
    private static final String USER_PASSWORD = "password";
    private static final String MANAGER = "manager";
    private static final String MANAGER_PASSWORD = "manager";
    private static final String RECONCILIATION_PROCESS = "Подтверждение одним менеджером (ETL) - 14";

    private static final String END_DATE_OF_NEW_ITEM = "2016-08-14";


    private static String SHORT_NAME_OF_ITEM = "Краткое имя";
    private static String FULL_NAME_OF_ITEM = "Полное имя";
    private static String SHORT_NAME_OF_ITEM_1 = "Краткое имя";
    private static String FULL_NAME_OF_ITEM_1 = "Полное имя";
    private static String NAMES = "Ядерная энергетика";
    private static String KEY = "nuclear";
    private static String TYPE = "Всё о ядерной энергии";
    private static String REQUEST_NAME = "ЯДЕРНАЯ";
    private static String NAME_OF_NEW_ITEM ="Тест";
    private static String NAME_OF_NEW_ITEM_2 ="Тест";


    @BeforeMethod
    public static void start() {
        open("/");
        Random r = new Random();
        NAMES += r.nextInt(9999);
        KEY += r.nextInt(9999);
        TYPE+= r.nextInt(9999);
        REQUEST_NAME+= r.nextInt(9999);
        NAME_OF_NEW_ITEM+= r.nextInt(9999);
        NAME_OF_NEW_ITEM_2+= r.nextInt(9999);
        SHORT_NAME_OF_ITEM+= r.nextInt(9999);
        FULL_NAME_OF_ITEM+= r.nextInt(9999);
        SHORT_NAME_OF_ITEM_1+= r.nextInt(9999);
        FULL_NAME_OF_ITEM_1+= r.nextInt(9999);

    }

    @Test
    public static void countOfDisplayedItems () throws InterruptedException {
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
        MainPage.clickButtonNewItem();
        MainPage.inputShortNameOfNewItem(SHORT_NAME_OF_ITEM);
        MainPage.inputFullNameOfNewItem(FULL_NAME_OF_ITEM);
        MainPage.inputEndDateNewItem(END_DATE_OF_NEW_ITEM);
        MainPage.inputNameOfNewItem(NAME_OF_NEW_ITEM);
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
        MainMenu.goToObjectsNSI();
        MainPage.showGroupInformation(NAMES);
        MainPage.showDirectoryInformation(TYPE);
        MainPage.checkAddedItem(NAME_OF_NEW_ITEM);
        MainPage.clickButtonNewItem();
        MainPage.inputShortNameOfNewItem(SHORT_NAME_OF_ITEM_1);
        MainPage.inputFullNameOfNewItem(FULL_NAME_OF_ITEM_1);
        MainPage.inputEndDateNewItem(END_DATE_OF_NEW_ITEM);
        MainPage.inputNameOfNewItem(NAME_OF_NEW_ITEM_2);
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
        MainMenu.goToObjectsNSI();
        MainPage.showGroupInformation(NAMES);
        MainPage.showDirectoryInformation(TYPE);
        MainPage.checkAddedItem(NAME_OF_NEW_ITEM_2);
        MainPage.clickButtonSettings();
        MainPage.setOneDisplayedElement();
        MainPage.clickButtonSave();
        MainPage.checkCountDisplayedItemsEqualOne();
    }

}
