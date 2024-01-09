import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.HomePage;
import ru.yandex.praktikum.RentPage;
import ru.yandex.praktikum.WhoPage;
import static org.hamcrest.CoreMatchers.containsString;


@RunWith(Parameterized.class)
public class OrderTest {
    WebDriver driver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    public OrderTest(String name, String lastName, String address, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Гоша","Рубчинский","Улица Пушкина", "89999999999"},
                {"Миша","Прорубчинский","Улица Мушкина", "89998887766"},

        };
    }

    @Before
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void clickButtonUpTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonCookies(); // Клик на кнопку согласия с  Cookies
        homePage.clickOrderButtonUp(); // Клик на верхнюю кнопку "Заказать"
        WhoPage whoPage = new WhoPage(driver, name, lastName, address, phoneNumber);
        whoPage.fillFormFields();
        RentPage rentPage = new RentPage(driver);
        rentPage.fillFormFields();
        MatcherAssert.assertThat("Заказ не оформлен",rentPage.orderComplete(), containsString("Заказ оформлен"));
        driver.quit();
    }
    @Test
    public void clickButtonDownTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickButtonCookies(); // Клик на кнопку согласия с Cookies
        homePage.clickOrderButtonDown(); // Клик на нижнюю кнопку "Заказать"
        WhoPage whoPage = new WhoPage(driver, name, lastName, address, phoneNumber);
        whoPage.fillFormFields();
        RentPage rentPage = new RentPage(driver);
        rentPage.fillFormFields();
        MatcherAssert.assertThat("Заказ не оформлен",rentPage.orderComplete(), containsString("Заказ оформлен"));
        driver.quit();

    }
}
