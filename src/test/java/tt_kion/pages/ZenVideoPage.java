package tt_kion.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ZenVideoPage extends ZenMainPage {

    @FindBy(xpath = "//a[@class='zen-ui-logo__container']")
    private WebElement zenVideoLogoContainer;

    @FindBy(xpath = "//input[@class='video-site-suggest__input']")
    private WebElement searchInput;

    public ZenVideoPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Логотип Zen Video отображается")
    public void checkZenVideoLogo() {
        zenVideoLogoContainer.isDisplayed();
        zenVideoLogoContainer.isEnabled();
    }

    @Step("Ввести в поле поиска название 'Синий трактор'")
    public void enterANameInSearchField(String text) {
        searchInput.isDisplayed();
        searchInput.sendKeys(text);
        assertThat(searchInput.getText()).isEqualTo(text);
        searchInput.sendKeys(Keys.RETURN);
    }

    @Step("Отображение вкладок: Все, Статьи, Видео, Каналы, Интересы")
    public void checkTabs() {
        throw new AssertionError("Вкладка с категориями не отображается, уточнить актуальность тест кейса");
    }

    @Step("Воспроизвести видео из найденного списка")
    public void playVideoInSearchListByIndex(int index) {

    }

    @Step("Проверить что видео запущено, и элементы проверить элементы плеера")
    public void checkVideoIsPlayAndPlayerElements() {

    }

    @Step("Развернуть плеер в полноэкранный режим")
    public void expandPlayerToFullScreenMode() {

    }
}
