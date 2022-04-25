package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    private By acceptBy = By.name("accept");
    private By userNameBy = By.name("username");
    private By passwordBy = By.name("secretkey");
    private By loginBy = By.name("login_button");
    private By readOnlyBy = By.cssSelector("[aria-label='Login Read-Only']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public DashboardPage login(String userName, String password) {
        driver.findElement(acceptBy).click();
        driver.findElement(userNameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();

        // Set wait duration and wait until Login Read-Only button is visible
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(readOnlyBy));
        driver.findElement(readOnlyBy).click();
        return new DashboardPage(driver);
    }

}
