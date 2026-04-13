package tests;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу Булки")
    public void bunSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickBunSection();
        assertTrue(mainPage.isBunSectionActive());
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void sauceSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSauceSection();
        assertTrue(mainPage.isSauceSectionActive());
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void fillingSectionTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingSection();
        assertTrue(mainPage.isFillingsSectionActive());
    }
}
