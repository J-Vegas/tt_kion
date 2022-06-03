package tt_kion.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.opentest4j.AssertionFailedError;
import tt_kion.BasePage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ZenPlayerPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'zen-ui-video-video-controls _template_desktop-viewer')]")
    private WebElement playerContainer;

    @FindBy(xpath = "//div[@class='zen-ui-video-video-timeline__clickable-zone']")
    private WebElement timeline;

    @FindBy(xpath = "//div[@class='zen-ui-cover__container']")
    private List<WebElement> bottomBtnPlayerContainer;

    @FindBy(xpath = "//div[@class='zen-ui-cover__item _right _bottom']/ancestor::div[contains(@class, 'zen-ui-video-video-controls__cover')]")
    private WebElement rightBottomPlayerItemsContainer;

    @FindBy(xpath = "//div[@class='zen-ui-cover__item _right _bottom']/ancestor::div[contains(@class, 'zen-ui-video-video-controls__cover')]")
    private WebElement leftBottomPlayerItemsContainer;

    public ZenPlayerPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Видео плеер отображается, таббар отображается")
    public void playerIsVisible() {
        playerContainer.isDisplayed();
        timeline.isDisplayed();
        bottomBtnPlayerContainer.get(0).isDisplayed();
        rightBottomPlayerItemsContainer.isDisplayed();
        leftBottomPlayerItemsContainer.isDisplayed();
    }

    @Step("Таббар не отображается")
    public void tabbarIsInvisible() {
        for (int i = 0; i <= 500; i++) {
            try {
                assertThat(timeline.isDisplayed()).isFalse();
                assertThat(rightBottomPlayerItemsContainer.isDisplayed()).isFalse();
                assertThat(leftBottomPlayerItemsContainer.isDisplayed()).isFalse();
                return;
            } catch (AssertionFailedError e) {
                e.getStackTrace();
            }
        }
    }
}
