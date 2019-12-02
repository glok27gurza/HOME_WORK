package com.ucp.qa;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {
    @AfterEach
    public void dispouse() {
        close();
    }

    @BeforeEach
    public void setUp() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();

    }

    @Test
    public void test() {
        open("https://github.com");
        $x("//h1")
                .shouldBe(visible)
                .shouldHave(text("Built for developers"));


    }

    @Test
    public void testMy() {

        open("https://github.com");

        $x("//input[@name='q']")
                .setValue("selenide")
                .pressEnter();
        $$x("//ul[@class='repo-list']/li")
                .shouldHaveSize(10)
                .first()
                .shouldHave(text("Concise UI Tests with Java!"));


    }

    @Test
    public void userCanToSeaText() {
        open("https://github.com/");

        $x("//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']")
                .click();
        assertEquals("https://github.com/join", WebDriverRunner.url(), "ne ok");

        $x("//div[@class='flash flash-error my-3']")
                .shouldHave(text("There were problems creating your account."));
        $x("//dd[contains(text(),\"Username can't be blank\")]")
                .shouldHave(text("Username can't be blank"));
        $x("//dd[contains(text(),\"Email can't be blank\")]")
                .shouldHave(text("Email can't be blank"));
        $x("//dd[contains(text(),\"Password can't be blank\")]")
                .shouldHave(text("Password can't be blank"));


    }

    @Test
    public void userCanSeeError() {

        open("https://github.com/");
        $x("//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']")
                .click();
        assertEquals("https://github.com/join", WebDriverRunner.url(), "ne ok");
        $x("//*[@id=\"user_login\"]")
                .setValue("selenide")
                .pressEnter();
        String result =
                $x("//*[@id=\"signup-form\"]/auto-check[1]/dl/dd[2]/div")
                        .shouldHave(visible).getText();
        System.out.println(result);
        assertTrue(result.startsWith("Username selenide is not available."));
    }


    @Test

    public void userCanSeeCount() {
        open("https://github.com/");
        $x("//input[@placeholder='Search GitHub']")
                .setValue("selenide");
        $x("//*[@class='octicon octicon-search flex-shrink-0 js-jump-to-octicon-search']")
                .click();
        assertEquals("https://github.com/search?q=selenide", WebDriverRunner.url(), "ne ok");
        String result = $x("//div[@class='col-12 col-md-9 float-left px-2 pt-3 pt-md-0 codesearch-results']")
                .shouldHave(visible).getText();
        System.out.println(result);
       // assertTrue(result.startsWith("866"));

    }

    @Test
    public void userCanSeeJava() {
        open("https://github.com/");
        $x(" //input[@placeholder='Search GitHub']")
                .setValue("selenide");
        $x("//*[@class='octicon octicon-search flex-shrink-0 js-jump-to-octicon-search']")
                .click();

        String result = $x("//li[1]//div[2]//div[1]//div[1]//span[1]//span[2]")
                .shouldHave(visible).getText();
        System.out.println(result);
        assertTrue(result.startsWith("Java"));

    }

    @Test
    public void userCanSeeC() {
        open("https://github.com/");
        $x(" //input[@placeholder='Search GitHub']")
                .setValue("selenide");
        $x("//*[@class='octicon octicon-search flex-shrink-0 js-jump-to-octicon-search']")
                .click();

        String result = $x("//span[contains(text(),'C#')]")
                .shouldHave(visible).getText();
        System.out.println(result);
        assertTrue(result.startsWith("C#"));
    }


    @Test
    public void canSeeYouTube() {
        open("https://github.com");
        assertEquals("https://github.com/", WebDriverRunner.url(), "Invalid url");
        $x("//summary[contains(text(), 'Why GitHub?')]").hover().click();
        $x("//a[@href='/features/code-review/']").click();
        assertEquals("https://github.com/features/code-review/", WebDriverRunner.url(), "Invalid url");
        $x("//button[contains(@class,'js-video-play ')]").click();
        assertTrue($("iframe").is(visible), "Element YouTube video is`n visible");

       // Version Anton


        //$x("//div[contains(@class,'HeaderMenu')]//summary").hover();
        //sleep(2000);
        //sleep(2000);
        // $x("//div[contains(@class,'jumbotron-video')]//button").click();
        //assertTrue($x("//div//h1").is(visible),"Element - 'Write better code' in`t visible");
    }

 @Test
 public void vers(){
            open("https://github.com/");
            assertEquals("https://github.com/", "https://github.com/", "Incorect URL");
            $x("//summary[contains(@class,'HeaderMenu')]").hover().click();
            $$x("/html/body/div[1]/header/div/div[2]/nav/ul/li[1]/details/div/ul[1]/li")
                    .find(text("Code Review")).shouldBe(visible).click();
            $x("//h1[@class='h000-mktg lh-condensed-ultra mb-3']")
                    .shouldBe(text("Write better code")).shouldHave(visible).getText();
            $x("//p[@class='togglevideo-hidewhenexpanded text-shadow-dark text-center']//button[1]").click();

        // Виден встроенный видеоблок YouTube

            assertTrue($("iframe").is(visible),"Element YouTube video is`n visible");

         //Mi Version


    }
@Test

    public void loginContext() {

        open("http://rtgk-test.cloud.internal.egp.com.ua/login");
        assertEquals("http://rtgk-test.cloud.internal.egp.com.ua/login",
                WebDriverRunner.url(), "NO OK!!!!!!!!!!!!!");
        $x("//input[@id='login']").setValue("supervisor");
        $x("//input[@id='password']").setValue("Qwerty-123");
        $x("//button[@class='btn btn-primary btn-lg login__btn pull-right']").click();
        assertEquals("http://rtgk-test.cloud.internal.egp.com.ua/citizens",
                "http://rtgk-test.cloud.internal.egp.com.ua/citizens", "NO OK!!!!!!!!!!!!!");

        //Вход на РТГК новый тестовый сервер под supervisor с паролем Qwerty-123

        $x("//li[3]//a[1]//span[1]").shouldBe(visible).click();
        $x("//div[1]/ul[1]/li[2]/a[1]").shouldBe(visible).click();
        $x("//select[@id='statementStatus']").click();
        $x("//div/select[contains(@id,'statementStatus')]/option[contains(@value,'чернетка')]").click();
        $x("//tr[1]//td[4]").click();
        $x("//button[@id='statementCancelMenu__BV_toggle_']").click();
        $x("//textarea[@class='form-control']").setValue("Автотєст");
        $x("//button[@class='btn btn-sm btn-primary col']").click();
    }
        //Вызов заявы в статусе чернетка ввод причин и отказ от проведения
    @Test
        public void adminPass() {

                open("http://admin.rtgk-test.cloud.internal.egp.com.ua/");
        assertEquals("http://admin.rtgk-test.cloud.internal.egp.com.ua/",
                WebDriverRunner.url(), "NO OK!!!!!!!!!!!!!");
        $x("//input[@id='login']").setValue("supervisor");
        $x("//input[@id='password']").setValue("Qwerty-123");
        $x("//button[@class='btn btn-primary btn-lg login__btn']").shouldBe(visible).click();
        assertEquals("http://admin.rtgk-test.cloud.internal.egp.com.ua/",
                "http://admin.rtgk-test.cloud.internal.egp.com.ua/", "NO OK!!!!!!!!!!!!!");
       //Вход Админка новый тестовый сервер под supervisor с паролем Qwerty-123
        $x("//a[@class='top__item nav-link active']").click();
        $x("//i[@class='fa fa-plus fa-lg']").click();
        $x("//input[@name='name']").setValue("supervisor");
        $x("//button[@class='btn btn-outline-primary']").click();
      //Проверка на дубликаты ролей в админке -отмена Відміна

            //$x("//div[@class='modal-footer Flex Right']//button[@class='btn btn-primary']").click();
            //Согласие Створити

    }

@Test
    public  void Vizibl(){
    LoginPage loginPage = new LoginPage();
    loginPage.login();


}


    }


//@Test
//public void ProRun(){
//
//    FirstTest firstTest = new FirstTest();
//    firstTest.AdminPass();
//
//  AdminPassAdminPass  }



// Пример использования:
//        $(byText("Login")).shouldBe(visible));
//        $(By.xpath("//div[text()='Login']")).shouldBe(visible); // можно использовать любой org.openqa.selenium.By.* селектор
//        $(byXpath("//div[text()='Login']")).shouldBe(visible); // или его аналог из Selectors
//        present | exist // условия присутствия элемента в DOM
//        $("#header").find("#menu").findAll(".item")можно пошагово уточнять - какой внутренний элемент необходимо получить внутри внешнего элемента,
//        строя цепочку последовательних вызовов
//        $("input").should(exist);
//        $("input").shouldBe(visible);
//        $("input").shouldHave(exactText("Some text"));
