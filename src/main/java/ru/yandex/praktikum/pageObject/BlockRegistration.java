package ru.yandex.praktikum.pageObject;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.model.BaseDriver;

/**
 * Для тестирования блока регистрации
 */
public class BlockRegistration extends BaseDriver {

    // локатор блока регистрация
    private static final By BLOCK_REGISTRATION = By.xpath(".//*[@class = 'Auth_form__3qKeq mb-20']");
    // локатор поля ввода name в блоке  регистрация
    private static final By NAME_LOGIN = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");
    // локатор поля ввода email в блоке  регистрация
    private static final By EMAIL_LOGIN = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    // локатор поля ввода password в блоке  регистрация
    private static final By PASSWORD_LOGIN = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");
    // локатор сообщения об ошибке "Некорректный пароль" в поле ввода пароля
    private static final By ERROR_MESSAGE_PASSWORD = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[3]/div/p");
    // локатор кнопки "Зарегистрироваться" в блоке регистрация
    private static final By LOGIN_NEW_USER = By.xpath(".//*[@id='root']/div/main/div/form/button");
    // локатор кнопки Войти в блоке регистрация напротив вопроса Уже зарегистрированы?
    private static final By BUTTON_COME_IN = By.xpath(".//*[@class = 'Auth_link__1fOlj']");
    public BlockRegistration(WebDriver driver) {
        this.driver = driver;
    }
    // метод - явное ожидание загрузки блока регистрация
    public void waitBlockRegistration() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(BLOCK_REGISTRATION));
        boolean block = driver.findElement(BLOCK_REGISTRATION).isDisplayed();
        Assert.assertTrue("Блок регистрация не загружается ", block);
    }
    // метод - явное ожидание сообщение об ошибке некорректный пароль
    public void waitErrorMessagePassword() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE_PASSWORD));
        boolean block = driver.findElement(ERROR_MESSAGE_PASSWORD).isDisplayed();
        Assert.assertTrue("Ошибка некорректный пароль не выводится ", block);
    }
    // метод заполняет поле Имя
    public void fillName(String name) {
        WebElement nameField = driver.findElement(NAME_LOGIN);
        nameField.clear();
        nameField.sendKeys(name);
    }
    // метод заполняет поле email
    public void fillEmail(String email) {
        WebElement emailField = driver.findElement(EMAIL_LOGIN);
        emailField.clear();
        emailField.sendKeys(email);
    }
    // метод заполняет поле password
    public void fillPassword(String password) {
        WebElement passwordField = driver.findElement(PASSWORD_LOGIN);
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    // метод нажимает на кнопку "Зарегистрироваться" в блоке регистрация
    public void clickButtonLoginUser() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(LOGIN_NEW_USER));
        driver.findElement(LOGIN_NEW_USER).click();
    }
    // метод нажимает на кнопку Войти напротив вопроса "Уже зарегистрированы?"
    public void clickButtonComeIn() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(BUTTON_COME_IN));
        driver.findElement(BUTTON_COME_IN).click();
    }
}
