package ru.yandex.praktikum.pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.model.BaseDriver;

/**
 * Для тестирования блока восстановления пароля
 */
public class BlockForgotPassword extends BaseDriver {

    // локатор вопроса "Вспомнили пароль?" в блоке Восстановление пароля
    private static final By QUESTION_RECOVERY_PASSWORD = By.xpath(".//*[@class = 'undefined text text_type_main-default text_color_inactive mb-4']");
    // локатор кнопки "Войти" в блоке Восстановление пароля
    private static final By BUTTON_COME_RECOVERY_PASSWORD = By.xpath(".//*[@id='root']/div/main/div/div/p/a");
    public BlockForgotPassword(WebDriver driver) {
        this.driver = driver;
    }
    // метод -явное ожидание загрузки вопроса "Вспомнили пароль?"
    public void waitQuestionRecoveryPassword() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(QUESTION_RECOVERY_PASSWORD));
        boolean block = driver.findElement(QUESTION_RECOVERY_PASSWORD).isDisplayed();
        Assert.assertTrue("Блок осстановления пароля не загружается", block);
    }
    // метод нажимает на кнопку "войти" в блоке Восстановление пароля
    public void clickButtonComeInBlockForgotPassword() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(BUTTON_COME_RECOVERY_PASSWORD));
        driver.findElement(BUTTON_COME_RECOVERY_PASSWORD).click();
    }
}
