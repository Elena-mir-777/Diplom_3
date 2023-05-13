package ru.yandex.praktikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

/**
 * тесты  раздела конструктор
 */
public class ConstructorTest extends BaseTest {
    @Test // проверка успешного перехода к разделу "Булки"
    @DisplayName("Check Transition In Section Bun")
    public void checkTransitionInSectionBun(){
        mainPage.open();
        mainPage.waitSuccessTransitionSectionBun(); // ожидаем активный раздел Булки
    }
    @Test // проверка успешного перехода к разделу "Соусы"
    @DisplayName("Check Transition In Section Sauce")
    public void checkTransitionInSectionSauce(){
        mainPage.open();
        mainPage.waitSuccessTransitionSectionSauce(); // ожидаем активный раздел Соусы
    }
    @Test // проверка успешного перехода к разделу "Начинки"
    @DisplayName("Check Transition In Section Fillings")
    public void checkTransitionInSectionFillings(){
        mainPage.open();
        mainPage.waitSuccessTransitionSectionFillings();// ожидаем активный раздел Начинки
    }

}
