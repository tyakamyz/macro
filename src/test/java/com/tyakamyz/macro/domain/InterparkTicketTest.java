package com.tyakamyz.macro.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class InterparkTicketTest {
    private static ChromeDriver driver;
    private static String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    private static String WEB_DRIVER_PATH = "D:\\IdeaProjects\\macro\\src\\main\\resources\\chromedriver.exe"; // 드라이버 경로
    private String id = "";
    private String pw = "";
    private String targetUrl = "https://tickets.interpark.com/goods/22015806";

    @BeforeAll
    static void setting(){
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        // Secret Mod
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    @Test
    void interparkLoginForm() {
        InterparkTicket interparkTicket = new InterparkTicket(id, pw, targetUrl, driver);
        interparkTicket.start();
    }
}
