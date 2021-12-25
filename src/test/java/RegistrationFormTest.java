import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

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

        $(".table-responsive").shouldHave(text("TestFirstName"),
                text("TestLastName"),
                text("test@mail.ru"),
                text("Male"),
                text("1234567890"),
                text("30 November,1998"),
                text("Economics"),
                text("Sports"),
                text("test.png"),
                text("TestAddress"),
                text("Haryana"),
                text("Karnal"));
    }
}