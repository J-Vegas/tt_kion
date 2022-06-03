package tt_kion.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tt_kion.BaseTest;
import tt_kion.pages.ZenMainPage;
import tt_kion.pages.ZenVideoPage;

import static tt_kion.utils.Constants.ZEN_URL;
import static tt_kion.utils.PropertyFileReader.getProperty;

public class ZenTests extends BaseTest {

    private ZenMainPage zmp;
    private ZenVideoPage zvp;

    @BeforeEach
    private void openPage() {
        driver.get(getProperty(ZEN_URL));
        zmp = new ZenMainPage();
        zvp = new ZenVideoPage();
    }

    @Test
    @DisplayName("Отображение элементов в каруселе ленты")
    public void checkNewsLineElements() {
        zmp.feedBlockIsDisplayed();
        zmp.checkElementsOnChanelBlock();
    }

    @Test
    @DisplayName("Проверка работы поиска в разделе 'Видео'")
    public void checkSearchWorkIsCorrect() {
        String text = "Синий трактор";
        zmp.clickVideoBtn();
        zvp.checkZenVideoLogo();
        zvp.enterANameInSearchField(text);
        zvp.checkTabs();
    }
}
