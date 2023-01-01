package com.tyakamyz.macro.domain;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InterparkTicket {
    private final String id;
    private final String pw;
    private final String targetUrl;
    /**
     * Chrome Version : 108.0.5359.125(공식 빌드) (64비트)
     * Chrome Version 에 맞는 Driver 설치
     * https://chromedriver.chromium.org/downloads
     */
    private final ChromeDriver driver;

    //private static final String INTERPARK_URL = "http://ticket.interpark.com";
    private static final String INTERPARK_LOGIN_URL = "https://ticket.interpark.com/Gate/TPLogin.asp";

    public InterparkTicket(String id, String pw, String targetUrl) {
        this.id = id;
        this.pw = pw;
        this.targetUrl = targetUrl;
        this.driver = setDriver();
    }

    public InterparkTicket(String id, String pw, String targetUrl, ChromeDriver driver) {
        this.id = id;
        this.pw = pw;
        this.targetUrl = targetUrl;
        this.driver = driver;
    }

    public ChromeDriver setDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }

    public void start(){
        login();
        purchase();
    }

    private void login(){
        driver.get(INTERPARK_LOGIN_URL);
        //WebElement loginBtn = driver.findElement(By.id("aLogin"));
        //loginBtn.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='leftLoginBox']/iframe[@title='login']")));
        driver.findElement(By.id("userId")).sendKeys(id);
        driver.findElement(By.id("userPwd")).sendKeys(pw);
        driver.findElement(By.id("btn_login")).click();
    }

    private boolean purchase() {
        try {
            driver.get(targetUrl);

        }catch (Exception e){
            System.out.println("실패");
            return false;
        }
        return true;
    }
}
