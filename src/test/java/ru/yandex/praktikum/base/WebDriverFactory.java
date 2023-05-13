package ru.yandex.praktikum.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver getDriver() {
        // получаем строку, которой задается режим
        String browser = System.getProperty("browser");
        if ("yandex".equalsIgnoreCase(browser)) {
            // для тестирования Yandex, запускать так:
            // mvn test -Dbrowser=yandex -Dyandex-driver=F:\Users\Elena\WebDriver\yandex-110\chromedriver.exe
            // здесь yandex-driver показывает на драйвер, совместимый по версии с установленным в системе браузером яндекс
            ChromeOptions opts = new ChromeOptions();
            // путь к исполняемому файлу яндекс-браузера
            opts.setBinary(System.getenv("LOCALAPPDATA") + "\\Yandex\\YandexBrowser\\Application\\browser.exe");
            // путь к драйверу, совместимому по версии с яндекс-браузером
            System.setProperty("webdriver.chrome.driver", System.getProperty("yandex-driver"));
            return new ChromeDriver(opts);
        } else {
            // для тестирования Chrome
            return new ChromeDriver();
        }
    }
}
