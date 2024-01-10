package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    private final By orderButtonUp = By.className("Button_Button__ra12g");
    private final By buttonCookies = By.className("App_CookieButton__3cvqF");
    private final By orderButtonDown = By.className("Button_Middle__1CSJM");


    public void clickOrderButtonUp() {
        driver.findElement(orderButtonUp).click();
    }

    public void clickOrderButtonDown() {
        WebElement buttonDown = driver.findElement(orderButtonDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buttonDown);
        driver.findElement(orderButtonDown).click();
    }


    public void clickButtonCookies() {
        driver.findElement(buttonCookies).click();
    }


}
