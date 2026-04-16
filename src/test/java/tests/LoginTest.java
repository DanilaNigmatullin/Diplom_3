package tests;

import api.UserApiClient;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private UserApiClient userApiClient = new UserApiClient();
    private String email;
    private String password;
    private String accessToken;

    @Before
    public void createUser() {
        email = "testuser" + System.currentTimeMillis() + "@diplom.ru";
        password = "password123";
        accessToken = userApiClient.createUser(email, password, "TestUser");
    }

    @After
    public void deleteUser() {
        if (accessToken != null) {
            userApiClient.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    @Description("Проверяет вход через кнопку Войти в аккаунт на главной странице")
    public void loginFromMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        assertTrue(loginPage.waitForLoginSuccess());
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    @Description("Проверяет вход через кнопку Личный кабинет в шапке сайта")
    public void loginFromPersonalAccountTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        assertTrue(loginPage.waitForLoginSuccess());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверяет вход через ссылку Войти на странице регистрации")
    public void loginFromRegisterFormTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.clickLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        assertTrue(loginPage.waitForLoginSuccess());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяет вход через ссылку Войти на странице восстановления пароля")
    public void loginFromForgotPasswordFormTest() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.open();
        forgotPasswordPage.clickLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        assertTrue(loginPage.waitForLoginSuccess());
    }
}