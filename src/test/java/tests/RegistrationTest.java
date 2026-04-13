package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.RegisterPage;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegistrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.enterName("TestUser");
        registerPage.enterEmail("test" + System.currentTimeMillis() + "@test.ru");
        registerPage.enterPassword("password123");
        registerPage.clickRegisterButton();
        assertTrue(registerPage.isLoginPage());
    }

    @Test
    @DisplayName("Ошибка при некорректном пароле")
    public void invalidPasswordRegistrationTest() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.open();
        registerPage.enterName("TestUser");
        registerPage.enterEmail("test" + System.currentTimeMillis() + "@test.ru");
        registerPage.enterPassword("12345");
        registerPage.clickRegisterButton();
        assertTrue(registerPage.isPasswordErrorDisplayed());
    }
}
