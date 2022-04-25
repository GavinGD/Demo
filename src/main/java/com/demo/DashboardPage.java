package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    /**
     * Gets the 2nd span with the class 'ng-star-inserted', since there
     * are 2 spans with this same class.
     */
    private By usernameBy = By.xpath("(//span[@class='ng-star-inserted'])[2]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        if (!driver.getTitle().equals("FortiGate - NGFW_PRI")) {
            throw new IllegalStateException("This is not the dashboard." +
                    "Current page is:" + driver.getTitle());
        }
    }

    /**
     * Gets the logged in users profile name.
     * @return string
     */
    public String getProfileName() {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(usernameBy));
        return driver.findElement(usernameBy).getText();
    }

}
