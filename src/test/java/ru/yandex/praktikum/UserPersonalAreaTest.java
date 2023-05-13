package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageObject.*;

public class UserPersonalAreaTest extends UserBaseTest {
    private BlockPersonalArea blockPersonalArea;
    @Before
    @Override
    public void setUp() {
        super.setUp();
        blockPersonalArea = new BlockPersonalArea(driver);
    }
    // ожидание загрузки личного кабинета
    private void personalAreaLoading(){
        mainPage.clickButtonPersonalAreaInMainPage();
        blockPersonalArea.waitInscriptionProfile(); //ожидание загрузки личного кабинета
    }
    @Test //   переход по клику в Личный кабинет - авторизованный пользователь
    @DisplayName("Check Entrance By Button Personal Area Authorized User")
    public void checkEntranceByButtonPersonalAreaAuthorizedUser(){
        preparingForAuthorized();
        authorizedUser();
        personalAreaLoading();
    }
    @Test //   Проверь выход по кнопке «Выйти» в личном кабинете.
    @DisplayName("Check Exit By Button Exit In Personal Area")
    public void checkExitByButtonExitInPersonalArea(){
        preparingForAuthorized();
        authorizedUser();
        personalAreaLoading();
        blockPersonalArea.clickButtonExit();
        blockInput.waitBlockInput(); // ожидание загрузки блока вход
    }

    @Test //   Переход из личного кабинета по клику в конструктор
    @DisplayName("Transition From Personal Account To Constructor")
    public void transitionFromPersonalAccountToConstructor(){
        preparingForAuthorized();
        authorizedUser();
        personalAreaLoading();
        mainPage.clickButtonConstructorInMainPage();
        mainPage.waitInscriptionAssembleBurgerLoading();//ожидание надписи Соберите бургер
    }
    @Test //    переход из личного кабинета по клику на логотип Stellar Burgers
    @DisplayName("Transition From Personal Account To Logo")
    public void transitionFromPersonalAccountToLogo(){
        preparingForAuthorized();
        authorizedUser();
        personalAreaLoading();
        mainPage.clickLogoInMainPage();
        mainPage.waitInscriptionAssembleBurgerLoading();//ожидание надписи Соберите бургер
    }
}
