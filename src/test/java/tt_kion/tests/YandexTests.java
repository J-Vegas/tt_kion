package tt_kion.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tt_kion.BaseTest;
import tt_kion.pages.YandexMainPage;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static tt_kion.utils.Constants.YANDEX_URL;
import static tt_kion.utils.PropertyFileReader.getProperty;

public class YandexTests extends BaseTest {

    YandexMainPage ymp;

    @BeforeEach
    private void init() {
        driver.get(getProperty(YANDEX_URL));
        ymp = new YandexMainPage();
    }

    @Test
    @DisplayName("Успешный переход с главной страницы Yandex на Zen.Yandex")
    public void checkOpenZenFromYandex() {
        ymp.clickAllServicesBtn();
        ymp.clickZen();
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        assertThat(tabs.size()).isEqualTo(2);
        driver.switchTo().window(tabs.get(1));
        ymp.checkCurrentUrl("https://zen.yandex.ru/?utm_source=main_stripe_big");
    }

}
