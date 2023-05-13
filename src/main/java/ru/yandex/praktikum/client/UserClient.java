package ru.yandex.praktikum.client;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import ru.yandex.praktikum.client.base.StellarBurgersRestClient;
import static io.restassured.RestAssured.given;
public class UserClient extends StellarBurgersRestClient {
    private static final String USER_URI = BASE_URI +  "auth/";
    public String accessToken;
    public UserClient() {
        RestAssured.baseURI = BASE_URI;
    }
    @Step("Create user")
    public ValidatableResponse create(User user) {
        return given()
                .spec(getBaseRecSpec())
                .and()
                .body(user)
                .when()
                .post(USER_URI+"register")
                .then();
    }
    @Step("Login user")
    public ValidatableResponse login(UserCredentials userCredentials) {
        return given()
                .spec(getBaseRecSpec())
                .and()
                .body(userCredentials)
                .when()
                .post(USER_URI+"login")
                .then();
    }
    @Step("Delete user")
    public ValidatableResponse delete() {
        return given()
                .auth().oauth2(accessToken)
                .when()
                .delete(USER_URI+ "user")
                .then();
    }
}
