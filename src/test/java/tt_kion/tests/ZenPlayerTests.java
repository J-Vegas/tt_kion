package tt_kion.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tt_kion.BaseTest;
import tt_kion.pages.ZenPlayerPage;

import static tt_kion.utils.Constants.ZEN_URL;
import static tt_kion.utils.PropertyFileReader.getProperty;

public class ZenPlayerTests extends BaseTest {

    private ZenPlayerPage zpp;

    @BeforeEach
    private void openPage() {
        driver.get(getProperty(ZEN_URL) + "video/watch/62617d639e39fd2df8228dcd");
        zpp = new ZenPlayerPage();
    }

    @Test
    @DisplayName("Видео запущено, таббар (контрол панель) вначале видима, затем пропадает")
    public void checkVideoPlayerTabbarIsVisible() {
        zpp.playerIsVisible();
        zpp.tabbarIsInvisible();
    }
}
