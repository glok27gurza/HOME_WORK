package com.ucp.qa;

import com.codeborne.selenide.Selenide;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public void login() {
        open("http://admin.rtgk-test.cloud.internal.egp.com.ua/");
        Selenide.Wait()
                .withTimeout(Duration.ofSeconds(10))
                .until(wd -> wd.getCurrentUrl().equals("http://admin.rtgk-test.cloud.internal.egp.com.ua/"));
        $x("//input[@id='login']").setValue("supervisor");
        $x("//input[@id='password']").setValue("Qwerty-123");
        $x("//button[@class='btn btn-primary btn-lg login__btn']").shouldBe(visible).click();
    }


}
