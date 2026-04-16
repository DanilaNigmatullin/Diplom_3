package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.xpath("(.//input[contains(@class,'input__textfield')])[1]");
    private By emailField = By.xpath("(.//input[contains(@class,'input__textfield')])[2]");
    private By passwordField = By.xpath("(.//input[contains(@class,'input__textfield')])[3]");
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private By loginLink = By.xpath(".//a[text()='Войти']");
    private By passwordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Открыть страницу регистрации")
    public void open() {
        driver.get("https://stellarburgers.education-services.ru/register");
    }

    @Step("Ввести имя")
    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести email")
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }

    @Step("Нажать ссылку Войти")
    public void clickLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        driver.findElement(loginLink).click();
    }

    @Step("Проверить что отображается ошибка пароля")
    public boolean isPasswordErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordError));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Проверить что открылась страница входа")
    public boolean isLoginPage() {
        wait.until(ExpectedConditions.urlContains("login"));
        return driver.getCurrentUrl().contains("login");
    }
}