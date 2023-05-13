package ru.yandex.praktikum.pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.BaseDriver;

/**
 * Для тестирования личного кабинета
 */
public class BlockPersonalArea extends BaseDriver {

    //  локатор надписи Профиль
    private static final By INSCRIPTION_PROFILE = By.xpath(".//*[@class = 'Account_link__2ETsJ text text_type_main-medium text_color_inactive Account_link_active__2opc9']");
    //  локатор кнопки Выход
    private static final By BUTTON_EXIT = By.xpath(".//*[@class = 'Account_button__14Yp3 text text_type_main-medium text_color_inactive']");
    public BlockPersonalArea(WebDriver driver) {
        this.driver = driver;
    }
    // метод - явное ожидание загрузки надписи Профиль
    public void waitInscriptionProfile() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(INSCRIPTION_PROFILE));
        boolean block = driver.findElement(INSCRIPTION_PROFILE).isDisplayed();
        Assert.assertTrue("Блок личный кабинет не загружается",block);
    }
    // метод нажимает на кнопку "Выход" в личном кабинете
    public void clickButtonExit() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(BUTTON_EXIT));
        driver.findElement(BUTTON_EXIT).click();
    }







}
