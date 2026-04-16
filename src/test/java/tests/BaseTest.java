package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;
    private static final String BROWSER = System.getProperty("browser", "chrome");

    @Before
    public void setUp() {
        if (BROWSER.equals("yandex")) {
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\Danyaa\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            WebDriverManager.chromedriver().browserVersion("144").forceDownload().setup();
            driver = new ChromeDriver(options);
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}