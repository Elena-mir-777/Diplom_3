package ru.yandex.praktikum;


import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.model.User;
import ru.yandex.praktikum.model.UserCredentials;
import ru.yandex.praktikum.pageObject.BlockRegistration;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;

/**
 * тест регистрации нового пользователя
 */
public class UserCreateTest extends UserBaseTest {
   private BlockRegistration blockRegistration;
   @Before
   @Override
   public void setUp() {
      super.setUp();
      blockRegistration = new BlockRegistration(driver);
   }
   // метод подготовка к регистрации нового пользователя
    private void preparingRegistration(){
      mainPage.open();
      mainPage.clickButtonLoginInMainPage();
      blockInput.waitBlockInput();
      blockInput.clickButtonLoginNewUser();
      blockRegistration.waitBlockRegistration();
   }
   @Test// проверка успешной регистрации нового пользователя-API запрос-(name,email,password валидные)
   @DisplayName("Check Success Registration New User")
   public void checkSuccessRegistrationNewUser(){
      preparingRegistration();
      ValidatableResponse response = userClient.createUser(user);
      setToken(response);
      response.assertThat()
              .statusCode(SC_OK)
              .assertThat().body("success", is(true))
              .assertThat().body("user", notNullValue())
              .assertThat().body("accessToken", notNullValue());
      blockRegistration.clickButtonComeIn();
      blockInput.waitBlockInput();//User зарегистрирован,если блок вход загружается
   }
   @Test //  проверка  вывода ошибки для некорректного пароля (< 6 символов) при регистрации нового пользователя через UI
   @DisplayName("Wait Message Error For Incorrect Password ")
   public void waitErrorForIncorrectPassword(){
      preparingRegistration();

      String invalidPassword = RandomStringUtils.randomAlphabetic(5);
      blockRegistration.fillName(user.getName());
      blockRegistration.fillEmail(user.getEmail());
      blockRegistration.fillPassword(invalidPassword);
      blockRegistration.clickButtonLoginUser();
      blockRegistration.waitErrorMessagePassword(); // ожидаем ошибку

      ValidatableResponse resp = userClient.logInUser(new UserCredentials(user.getEmail(), invalidPassword)); // пробуем залогиниться
      setToken(resp);
      Assert.assertNull(userClient.accessToken);//ожидаем null токен
      // если токен не пустой, то пользователь будет удален
    }
}
