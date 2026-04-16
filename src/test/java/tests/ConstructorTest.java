package tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void openPage() {
        mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("Проверяет активацию раздела Булки после клика по нему")
    public void bunSectionTest() {
        mainPage.clickSauceSection();
        mainPage.clickBunSection();
        assertTrue(mainPage.isBunSectionActive());
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Проверяет активацию раздела Соусы после клика по нему")
    public void sauceSectionTest() {
        mainPage.clickSauceSection();
        assertTrue(mainPage.isSauceSectionActive());
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    @Description("Проверяет активацию раздела Начинки после клика по нему")
    public void fillingSectionTest() {
        mainPage.clickFillingSection();
        assertTrue(mainPage.isFillingsSectionActive());
    }
}