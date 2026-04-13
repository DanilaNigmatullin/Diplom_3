package pages;

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

    public void open() {
        driver.get("https://stellarburgers.education-services.ru/register");
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        driver.findElement(registerButton).click();
    }

    public void clickLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        driver.findElement(loginLink).click();
    }

    public boolean isPasswordErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(passwordError));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginPage() {
        wait.until(ExpectedConditions.urlContains("login"));
        return driver.getCurrentUrl().contains("login");
    }
}