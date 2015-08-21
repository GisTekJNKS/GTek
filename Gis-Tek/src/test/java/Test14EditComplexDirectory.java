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
    private static final String RECONCILIATION_PROCESS = "������������� ����� ���������� (ETL) - 14";
    private static final String TYPE_OF_PROPERTY1 = "���������";
    private static final String TYPE_OF_PROPERTY2 = "������";
    private static final String TYPE_OF_PROPERTY = "���";

    private static String NAMES = "������� ����������";
    private static String KEY = "nuclear";
    private static String TYPE = "����������� ���������";
    private static String REQUEST_NAME = "�������";
    private static String PROPERTY= "���������";
    private static String ADDED_PROPERTY="������������";


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
        CreateEditDirectoryForm.inputTypeName("�����");
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty("������");
        CreateEditDirectoryForm.selectType("�����");
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty("�����");
        CreateEditDirectoryForm.selectType("������");
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty("�����");
        CreateEditDirectoryForm.selectType("������");
        CreateEditDirectoryForm.chooseDataType("���");
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty("�����");
        CreateEditDirectoryForm.selectType("���������");
        CreateEditDirectoryForm.selectType("�����");
        CreateEditDirectoryForm.chooseDataType(TYPE);
        CreateEditDirectoryForm.clickButtonAddProperty();
        CreateEditDirectoryForm.inputNameOfNewAddedProperty("����������� ������");
        CreateEditDirectoryForm.selectType("����������");
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
        MainPage.checkHierarchicalElements();//87 ������������ ������ "������������� �����" � "��������� �����". ������������ ���������� ������ "������������ ����"
        MainPage.clickButtonNewItem();
        MainPage.checkSubPropertyAddresCreatorBlock();//88� ����� "���������" ���������� ���� "�����"
        MainPage.inputShortNameOfNewItem("������� ���");
        MainPage.inputNameOfNewItem("���");
        MainPage.clickButtonAdd();
        MainPage.checkSubPropertyAddresApproversBlock();//���� "����� " ������������ � ����� "������������"
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
        MainPage.checkAddedItem("���"); //������ "������" ���������� � ������� ����� ������
        MainPage.clickButtonNewItem();
        MainPage.inputShortNameOfNewItem("������� ���2");
        MainPage.inputNameOfNewItem("���2");
        MainPage.clickButtonAdd();
        MainPage.inputIndexes(220031);
        MainPage.selectItem("������� ���");
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
        MainPage.checkChildItem("���2");
    }
}
