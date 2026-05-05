package com.automation.stellarai.QA_Repo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    public void verifyLoginPageElements() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://stellarai.drivetech-ai.com/sign-in");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            WebElement signInButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//button[normalize-space()='Sign In']")
            ));

            assertTrue(email.isDisplayed());
            assertTrue(password.isDisplayed());
            assertTrue(signInButton.isDisplayed());
            assertTrue(driver.getCurrentUrl().contains("stellarai"));

        } finally {
            driver.quit();
        }
    }
}