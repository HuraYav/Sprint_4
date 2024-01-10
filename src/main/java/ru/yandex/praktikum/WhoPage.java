package ru.yandex.praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WhoPage {
    WebDriver driver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String phoneNumber;

    public WhoPage(WebDriver driver, String name, String lastName, String address, String phoneNumber) {
        this.driver = driver;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    private final By firstNameField = By.cssSelector("input[placeholder='* Имя']");
    private final By secondNameField = By.cssSelector("input[placeholder='* Фамилия']");
    private final By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private final By phoneNumberField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");

    private final By listStationMetro = By.className("select-search__input");
    private final By stationMetro = By.className("select-search__row");
    private final By nextButton = By.className("Button_Middle__1CSJM");


    public void fillFormFields() {
        driver.findElement(firstNameField).sendKeys(name);
        driver.findElement(secondNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(listStationMetro).click();
        driver.findElement(stationMetro).click();
        driver.findElement(nextButton).click();
    }
}
