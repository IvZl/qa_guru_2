import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTest {
    @BeforeAll
    static void beforeAll () {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $(byId("firstName")).setValue("TestFirstName");
        $(byId("lastName")).setValue("TestLastName");
        $(byId("userEmail")).setValue("test@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").scrollTo().click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $("[class*='react-datepicker__day--030']").click();
//      $("[aria-label$='March 1st, 1992']").click(); //Don't work?!
//      $("[aria-label='Choose Sunday, March 1st, 1992']").click(); // Also don't work?????!
        $("#subjectsInput").setValue("Economics").pressEnter();
//      $(byId("hobbiesWrapper")).$(byText("Sport")).click(); //Don't work?
        $("[for=hobbies-checkbox-1]").click();
        $("#currentAddress").setValue("TestAddress");
//      $("uploadPicture").uploadFile(new File("src/test/resources/images/test.png"));
        $("#uploadPicture").uploadFromClasspath("images/test.png");
//      $("[for=uploadPicture]").uploadFromClasspath("images/test.png");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#react-select-4-input").setValue("Karnal").pressEnter();

//      $("submit").click();// don't work
        $("[id=submit]").click();

        $(".table-responsive").shouldHave(Condition.text("TestFirstName"),
                Condition.text("TestLastName"),
                Condition.text("test@mail.ru"),
                Condition.text("Male"),
                Condition.text("1234567890"),
                Condition.text("30 November,1998"),
                Condition.text("Economics"),
                Condition.text("Sports"),
                Condition.text("test.png"),
                Condition.text("TestAddress"),
                Condition.text("Haryana"),
                Condition.text("Karnal"));
    }
}