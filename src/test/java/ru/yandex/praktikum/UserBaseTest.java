package ru.yandex.praktikum;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import ru.yandex.praktikum.base.UserGenerator;
import ru.yandex.praktikum.client.User;
import ru.yandex.praktikum.client.UserClient;
import ru.yandex.praktikum.pageObject.BlockInput;

public class UserBaseTest extends BaseTest {
    protected UserClient userClient;
    protected User user;
    protected BlockInput blockInput;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        user = UserGenerator.getRandom();
        userClient = new UserClient();
        blockInput = new BlockInput(driver);
    }

    @After
    @Override
    public void tearDown() {
        if (userClient.accessToken != null) {
            userClient.delete();
        }
        super.tearDown();
    }

    // метод получения токена пользователя
    protected void setToken(ValidatableResponse response) {
        String accessToken = response.extract().path("accessToken");
        if (accessToken != null) {
            userClient.accessToken = accessToken.substring(7);
        }
    }

    // метод авторизации
    protected void authorizedUser(){
        blockInput.fillEmail(user.getEmail());
        blockInput.fillPassword(user.getPassword());
        blockInput.clickButtonComeIn();
    }

    // метод подготовка к авторизации пользователя
    protected void preparingForAuthorized(){
        mainPage.open();
        mainPage.clickButtonLoginInMainPage();
        blockInput.waitBlockInput();
        ValidatableResponse response = userClient.create(user);
        setToken(response);
    }

}
