package ru.yandex.praktikum;

import org.junit.After;
import org.junit.Before;
import ru.yandex.praktikum.base.WebDriverFactory;
import ru.yandex.praktikum.pageObject.MainPage;

public class BaseTest extends BaseDriver {
    protected MainPage mainPage;
    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        mainPage = new MainPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
