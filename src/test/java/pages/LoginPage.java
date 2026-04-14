package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.xpath("(.//input[contains(@class,'input__textfield')])[1]");
    private By passwordField = By.xpath("(.//input[contains(@class,'input__textfield')])[2]");
    private By loginButton = By.xpath(".//button[text()='Войти']");
    private By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    private By forgotPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Ввести email")
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.urlContains("login"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку Войти")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("Нажать ссылку Зарегистрироваться")
    public void clickRegisterLink() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();
    }

    @Step("Нажать ссылку Восстановить пароль")
    public void clickForgotPasswordLink() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        driver.findElement(forgotPasswordLink).click();
    }

    @Step("Дождаться успешного входа")
    public boolean waitForLoginSuccess() {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
        return !driver.getCurrentUrl().contains("login");
    }
}