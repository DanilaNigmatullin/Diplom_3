package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import java.time.Duration;

import static org.junit.Assert.assertFalse;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    public void loginFromMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser@diplom.ru");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
        assertFalse(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void loginFromPersonalAccountTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser@diplom.ru");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
        assertFalse(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegisterFormTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.clickLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser@diplom.ru");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
        assertFalse(driver.getCurrentUrl().contains("login"));
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordFormTest() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.open();
        forgotPasswordPage.clickLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("testuser@diplom.ru");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
        assertFalse(driver.getCurrentUrl().contains("login"));
    }
}