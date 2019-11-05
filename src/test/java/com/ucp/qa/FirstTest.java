package com.ucp.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {
//      @AfterEach
//    public void dispouse() {
//        close();
//    }

    @Test
    public void test() {
        open("https://github.com");
        $x("//h1")
                .shouldBe(visible)
                .shouldHave(Condition.text("Built for developers"));


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
                .shouldHave(Condition.text("Concise UI Tests with Java!"));


    }

    @Test
    public void userCanToSeaText() {
        open("https://github.com/");

        $x("//button[@class='btn-mktg btn-primary-mktg btn-large-mktg f4 btn-block my-3']")
                .click();
        assertEquals("https://github.com/join", WebDriverRunner.url(), "ne ok");

        $x("//div[@class='flash flash-error my-3']")
                .shouldHave(Condition.text("There were problems creating your account."));
        $x("//dd[contains(text(),\"Username can't be blank\")]")
                .shouldHave(Condition.text("Username can't be blank"));
        $x("//dd[contains(text(),\"Email can't be blank\")]")
                .shouldHave(Condition.text("Email can't be blank"));
        $x("//dd[contains(text(),\"Password can't be blank\")]")
                .shouldHave(Condition.text("Password can't be blank"));


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

    public void uzerCanSeeCount() {
        open("https://github.com/");
        $x("//input[@placeholder='Search GitHub']")
                .setValue("selenide");
        $x("//*[@class='octicon octicon-search flex-shrink-0 js-jump-to-octicon-search']")
                .click();
        assertEquals("https://github.com/search?q=selenide", WebDriverRunner.url(), "ne ok");
        String result = $x("//div[@class='col-12 col-md-9 float-left px-2 pt-3 pt-md-0 codesearch-results']")
                .shouldHave(visible).getText();
        System.out.println(result);
        assertTrue(result.startsWith("848"));

    }

    @Test
    public void uzerCanSeeJava() {
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
    public void uzerCanSeeC()
    {
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

    public void uzerCanSeeYouTube()
    {
        open("https://github.com/");
         $x("//li[1]/details[1]/summary[1]")
                 .pressEnter();
          $$x("/html/body/div[1]/header/div/div[2]/nav/ul/li[1]/details/div/ul[1]/li")
                 .find(text("Code Review"))
                 .click();
          $x("//h1[@class='h000-mktg lh-condensed-ultra mb-3']")
                   .shouldBe(Condition.text("Write better code"))
                   .shouldHave(visible).getText();

//                    System.out .println(result);
//                    assertTrue(result.startsWith("ok"));
          $x("//p[@class='togglevideo-hidewhenexpanded text-shadow-dark text-center']//button[1]")
                  .click();

                  // Виден встроенный видеоблок YouTube

                 String result = $x("//div[@class='togglevideo-hidewhencollapsed togglevideo-showwhenexpanded video-responsive']")
                        .shouldHave(visible).getText();
                  System.out.println(result);
                  assertTrue(result.startsWith("YouTube"));

    }

}





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
