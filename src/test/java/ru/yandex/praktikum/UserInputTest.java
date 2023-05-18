package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageObject.BlockForgotPassword;
import ru.yandex.praktikum.pageObject.BlockRegistration;
public class UserInputTest  extends UserBaseTest {
    private BlockRegistration blockRegistration;
    private BlockForgotPassword blockForgotPassword;
    @Before
    @Override
    public void setUp() {
        super.setUp();
        blockRegistration = new BlockRegistration(driver);
        blockForgotPassword = new BlockForgotPassword(driver);
    }
    @Test //  вход по кнопке «Войти в аккаунт» на главной
    @DisplayName("Check Entrance By Button Login In Main Page")
    public void checkEntranceByButtonLoginInMainPage(){
        preparingForAuthorized();
        authorizedUser();
        mainPage.waitButtonOrder();// ожидание кнопки оформить заказ
    }
    @Test //  вход через кнопку «Личный кабинет»
    @DisplayName("Check Entrance By Button Personal Area In MainPage")
    public void checkEntranceByButtonPersonalAreaInMainPage(){
        mainPage.open();
        mainPage.clickButtonPersonalAreaInMainPage();
        blockInput.waitBlockInput();
        ValidatableResponse response = userClient.createUser(user);
        setToken(response);
        authorizedUser();
        mainPage.waitButtonOrder();// ожидание кнопки оформить заказ
    }
    @Test //  вход через кнопку «Войти» в блоке Регистрация
    @DisplayName("Check Entrance By Button Come In Block Registration")
    public void checkEntranceByButtonComeInBlockRegistration(){
        preparingForAuthorized();
        blockInput.clickButtonLoginNewUser();
        blockRegistration.waitBlockRegistration();
        blockRegistration.clickButtonComeIn();
        authorizedUser();
        mainPage.waitButtonOrder();// ожидание кнопки оформить заказ
    }
    @Test //  вход через кнопку «Восстановить пароль?» в блоке Вход
    @DisplayName("Check Entrance By Button Recovery Password In Block Input")
    public void checkEntranceByButtonRecoveryPasswordInBlockInput(){
        preparingForAuthorized();
        blockInput.clickButtonRecoveryPassword();
        blockForgotPassword.waitQuestionRecoveryPassword();
        blockForgotPassword.clickButtonComeInBlockForgotPassword();
        authorizedUser();
        mainPage.waitButtonOrder();// ожидание кнопки оформить заказ
    }

}
