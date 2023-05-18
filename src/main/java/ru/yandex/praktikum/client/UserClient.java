package ru.yandex.praktikum.client;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.praktikum.model.User;
import ru.yandex.praktikum.model.UserCredentials;
import ru.yandex.praktikum.base.StellarBurgersRestClient;
import static io.restassured.RestAssured.given;
public class UserClient extends StellarBurgersRestClient {
    public String accessToken;
    @Step("Create {user}")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getBaseRecSpec())
                .and()
                .body(user)
                .when()
                .post(BASE_URI+"auth/register")
                .then();
    }
    @Step("Login {user}")
    public ValidatableResponse logInUser(UserCredentials userCredentials) {
        return given()
                .spec(getBaseRecSpec())
                .and()
                .body(userCredentials)
                .when()
                .post(BASE_URI+"auth/login")
                .then();
    }
    @Step("Delete {user}")
    public ValidatableResponse deleteUser() {
        return given()
                .auth().oauth2(accessToken)
                .when()
                .delete(BASE_URI+ "auth/user")
                .then();
    }
}
