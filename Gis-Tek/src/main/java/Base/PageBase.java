package Base;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;


import java.util.List;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by John on 10.08.2015.
 */
public class PageBase {
    protected static void checkExpectedElements (List<By> elements){
        for (By element : elements){
            $(element).shouldBe(Condition.visible);
        }
    }


    protected static void waitUntilLoading(){
        $(".gost-loading-overlay").waitUntil(hidden,45000);
    }

}
