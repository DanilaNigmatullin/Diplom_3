package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String BASE_URL = "https://stellarburgers.education-services.ru";

    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private By bunSection = By.xpath(".//span[text()='Булки']");
    private By sauceSection = By.xpath(".//span[text()='Соусы']");
    private By fillingSection = By.xpath(".//span[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public void clickPersonalAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        driver.findElement(personalAccountButton).click();
    }

    public void clickBunSection() {
        wait.until(ExpectedConditions.elementToBeClickable(bunSection));
        WebElement element = driver.findElement(bunSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickSauceSection() {
        wait.until(ExpectedConditions.elementToBeClickable(sauceSection));
        WebElement element = driver.findElement(sauceSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickFillingSection() {
        wait.until(ExpectedConditions.elementToBeClickable(fillingSection));
        WebElement element = driver.findElement(fillingSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isBunSectionActive() {
        String classAttr = driver.findElement(By.xpath(".//span[text()='Булки']/..")).getAttribute("class");
        return classAttr.contains("tab_tab_type_current");
    }

    public boolean isSauceSectionActive() {
        String classAttr = driver.findElement(By.xpath(".//span[text()='Соусы']/..")).getAttribute("class");
        return classAttr.contains("tab_tab_type_current");
    }

    public boolean isFillingsSectionActive() {
        String classAttr = driver.findElement(By.xpath(".//span[text()='Начинки']/..")).getAttribute("class");
        return classAttr.contains("tab_tab_type_current");
    }
}