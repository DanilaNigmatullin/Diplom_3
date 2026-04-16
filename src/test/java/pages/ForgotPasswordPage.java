package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By loginLink = By.xpath(".//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Открыть страницу восстановления пароля")
    public void open() {
        driver.get("https://stellarburgers.education-services.ru/forgot-password");
    }

    @Step("Нажать ссылку Войти")
    public void clickLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        driver.findElement(loginLink).click();
    }

    @Step("Проверить что открылась страница входа")
    public boolean isLoginPage() {
        wait.until(ExpectedConditions.urlContains("login"));
        return driver.getCurrentUrl().contains("login");
    }
}