package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentPage {
    WebDriver driver;

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By calendarField = By.className("react-datepicker__input-container");
    private final By dayCalendar = By.className("react-datepicker__day");
    private final By rentalPeriod = By.className("Dropdown-control");
    private final By dayPeriod = By.className("Dropdown-option");
    private final By placeOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By acceptButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    public void fillFormFields() {
        driver.findElement(calendarField).click();
        driver.findElement(dayCalendar).click();
        driver.findElement(rentalPeriod).click();
        driver.findElement(dayPeriod).click();
        driver.findElement(placeOrder).click();
        driver.findElement(acceptButton).click();
    }
  public String orderComplete() {
      return driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
  }
}
