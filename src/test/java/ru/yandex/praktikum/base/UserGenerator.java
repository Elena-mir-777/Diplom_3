package ru.yandex.praktikum.base;

import org.apache.commons.lang3.RandomStringUtils;
import ru.yandex.praktikum.client.User;

public class UserGenerator {
    public static User getRandom() {
        String email = RandomStringUtils.randomAlphabetic(12) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        return new User(name,email,password);
    }
}
