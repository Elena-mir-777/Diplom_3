package ru.yandex.praktikum.pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.BaseDriver;

/**
 * Для тестирования блока вход
 */
public class BlockInput extends BaseDriver {

    //  локатор блока вход
    private static final By BLOCK_INPUT = By.xpath(".//h2[text() = 'Вход']");
    //  локатор кнопки "Зарегистрироваться" напротив " Вы новый пользователь?"
    private static final By BUTTON_LOGIN_NEW_USER = By.xpath(".//*[@id='root']/div/main/div/div/p[1]/a");
    //  локатор кнопки "восстановить пароль" напротив вопроса "Забыли пароль?"
    private static final By BUTTON_RECOVERY_PASSWORD = By.xpath(".//*[@id='root']/div/main/div/div/p[2]/a");
    // локатор поля ввода email в блоке  вход
    private static final By EMAIL_FIELD = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and @type ='text']");
    // локатор поля ввода password в блоке  вход
    private static final By PASSWORD_FIELD = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and @type ='password']");
    // локатор кнопки "Войти" в блоке  вход
    private static final By BUTTON_COME = By.xpath(".//*[@id='root']/div/main/div/form/button");
    public BlockInput(WebDriver driver) {
        this.driver = driver;
    }
    // метод - явное ожидание загрузки блока вход
    public void waitBlockInput() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(BLOCK_INPUT));
        boolean block = driver.findElement(BLOCK_INPUT).isDisplayed();
        Assert.assertTrue("Блок вход не загружается", block);
    }
    // метод заполняет поле email в блоке вход
    public void fillEmail(String email) {
        WebElement emailField = driver.findElement(EMAIL_FIELD);
        emailField.clear();
        emailField.sendKeys(email);
    }
    // метод заполняет поле password в блоке вход
    public void fillPassword(String password) {
        WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    // метод нажимает на кнопку "Войти" в блоке вход
    public void clickButtonComeIn() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(BUTTON_COME));
        driver.findElement(BUTTON_COME).click();
    }
    // метод нажимает на кнопку "Зарегистрироваться" напротив " Вы новый пользователь?"
    public void clickButtonLoginNewUser() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(BUTTON_LOGIN_NEW_USER));
        driver.findElement(BUTTON_LOGIN_NEW_USER).click();
    }
    // метод нажимает на кнопку "восстановить пароль" напротив вопроса "Забыли пароль?"
    public void clickButtonRecoveryPassword() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(BUTTON_RECOVERY_PASSWORD));
        driver.findElement(BUTTON_RECOVERY_PASSWORD).click();
    }
}
