package ru.yandex.praktikum.pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.BaseDriver;

/**
 * Для тестирования главной страницы
 */
public class MainPage extends BaseDriver {
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    // локатор кнопки "оформить заказ"
    private static final By BUTTON_ORDER = By.xpath(".//button[text() = 'Оформить заказ']");
    // локатор кнопки "войти в аккаунт"
    private static final By BUTTON_LOGIN = By.xpath(".//button[text() = 'Войти в аккаунт']");
    // локатор кнопки "личный кабинет"
    private static final By BUTTON_PERSONAL_AREA = By.xpath(".//p[text() = 'Личный Кабинет']");
    // локатор кнопки "конструктор"
    private static final By BUTTON_CONSTRUCTOR = By.xpath(".//p[text() = 'Конструктор']");
    // локатор надписи "Соберите бургер"
    private static final By INSCRIPTION_ASSEMBLE_BURGER = By.xpath(".//h1[text() = 'Соберите бургер']");
    // локатор логотипа Stellar Burgers
    private static final By LOGO = By.xpath(".//*[@xmlns='http://www.w3.org/2000/svg' and @width = '290']");
    // локатор раздела "Булки"
    private static final By SECTION_BUN = By.xpath("//span[text() ='Булки']");
    // локатор раздела "Соусы"
    private static final By SECTION_SAUCE = By.xpath("//span[text() ='Соусы']");
    // локатор раздела "Начинки"
    private static final By SECTION_FILLINGS = By.xpath("//span[text() ='Начинки']");
    // локатор активного раздела "Булки"
    private static final By ACTIVE_SECTION_BUN = By.xpath(".//div[contains(@class,'current')]/span[text() ='Булки']");
    // локатор активного раздела "Соусы"
    private static final By ACTIVE_SECTION_SAUCE = By.xpath(".//div[contains(@class,'current')]/span[text() ='Соусы']");
    // локатор активного раздела "Начинки"
    private static final By ACTIVE_SECTION_FILLINGS = By.xpath(".//div[contains(@class,'current')]/span[text() ='Начинки']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    // метод загружает веб-приложение
    public void open() {
        driver.get(PAGE_URL);
    }
    // метод нажимает кнопку "Войти в аккаунт"
    public void clickButtonLoginInMainPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(BUTTON_LOGIN));
        driver.findElement(BUTTON_LOGIN).click();
    }
    // метод нажимает на кнопку "Личный кабинет"
    public void clickButtonPersonalAreaInMainPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(BUTTON_PERSONAL_AREA));
        driver.findElement(BUTTON_PERSONAL_AREA).click();
    }
    // метод нажимает на кнопку "Конструктор"
    public void clickButtonConstructorInMainPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(BUTTON_CONSTRUCTOR));
        driver.findElement(BUTTON_CONSTRUCTOR).click();
    }
    // метод нажимает на кнопку "Логотип Stellar Burgers"
    public void clickLogoInMainPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(LOGO));
        driver.findElement(LOGO).click();
    }
    // метод - явное ожидание загрузки надписи "Соберите бургер"
    public void waitInscriptionAssembleBurgerLoading() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(INSCRIPTION_ASSEMBLE_BURGER));
        boolean block = driver.findElement(INSCRIPTION_ASSEMBLE_BURGER).isDisplayed();
        Assert.assertTrue("Надпись -Соберите бургер- не отображается",block);
    }
    // метод -  переход к разделу "Соусы" из раздела "Начинки"  c помощью клика
    public void waitSuccessTransitionSectionSauce(){
        new WebDriverWait(driver, 3).
                until(ExpectedConditions.visibilityOfElementLocated(SECTION_BUN));
        driver.findElement(SECTION_FILLINGS).click();
        driver.findElement(SECTION_SAUCE).click();
        boolean active = driver.findElement(ACTIVE_SECTION_SAUCE).isDisplayed();
        Assert.assertTrue(active);
    }
    // метод -  переход к разделу "Булки" из раздела "Соусы" c  с помощью клика
    public void waitSuccessTransitionSectionBun(){
        new WebDriverWait(driver, 3).
                until(ExpectedConditions.visibilityOfElementLocated(SECTION_BUN));
        driver.findElement(SECTION_SAUCE).click();
        driver.findElement(SECTION_BUN).click();
        boolean active = driver.findElement(ACTIVE_SECTION_BUN).isDisplayed();
        Assert.assertTrue(active);
    }
    // метод - переход к разделу "Начинки" из раздела "Булки" с помощью клика
    public void waitSuccessTransitionSectionFillings(){
        new WebDriverWait(driver, 3).
                until(ExpectedConditions.visibilityOfElementLocated(SECTION_BUN));
        driver.findElement(SECTION_FILLINGS).click();
        boolean active = driver.findElement(ACTIVE_SECTION_FILLINGS).isDisplayed();
        Assert.assertTrue(active);
    }
    // метод - ожидание кнопки "оформить заказ"
    public void waitButtonOrder(){
        new WebDriverWait(driver, 3).
                until(ExpectedConditions.visibilityOfElementLocated(BUTTON_ORDER));
        boolean active = driver.findElement(BUTTON_ORDER).isDisplayed();
        Assert.assertTrue(active);
    }

}
