package tt_kion.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tt_kion.BasePage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ZenMainPage extends BasePage {

    @FindBy(xpath = "//div[@class='nav-menu-item__content' and contains(., 'Видео')]")
    private WebElement videoBtn;
    @FindBy(xpath = "//div[@class='redesign-feed__feed']")
    private WebElement feedBlock;

    @FindBy(xpath = "//div[contains(@class, 'channelsCarousel')]")
    private List<WebElement> channelsCarouselBlocks;

    public ZenMainPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("'Ваша лента' отображается")
    public void feedBlockIsDisplayed() {
        feedBlock.isDisplayed();
    }

    @Step("В разделах каналы отображаются: аватарка, название, описание, кнопка «подписаться»")
    public void checkElementsOnChanelBlock() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        for (int i = 0; i <= 5; i++) {
            if (channelsCarouselBlocks.size() > 0) break;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        }
        WebElement firstBlock = channelsCarouselBlocks.get(0);
        js.executeScript("arguments[0].scrollIntoView();", firstBlock);

        WebElement title = firstBlock.findElement(By.xpath("//h2"));
        WebElement subtitle = firstBlock.findElement(By.xpath("//div[contains(@class, 'subtitle')]"));
        WebElement avatar = firstBlock.findElement(By.xpath("//div[contains(@class, 'zen-ui-avatar')]"));
        WebElement itemTitle = firstBlock.findElements(By.xpath("//div[contains(@class, 'channels-carousel-item__title')]")).get(0);
        WebElement itemDescription = firstBlock.findElements(By.xpath("//div[contains(@class, 'channels-carousel-item__description')]")).get(0);
        WebElement subscribeBtn = firstBlock.findElements(By.xpath("//button[contains(@class, 'channels-carousel-item__subscribeButton')]")).get(0);

        title.isDisplayed();
        assertThat(title.getText()).isNotEmpty();
        subtitle.isDisplayed();
        assertThat(subtitle.getText()).isNotEmpty();
        avatar.isDisplayed();
        itemTitle.isDisplayed();
        assertThat(itemTitle.getText()).isNotEmpty();
        itemDescription.isDisplayed();
        assertThat(itemDescription.getText()).isNotEmpty();
        subscribeBtn.isDisplayed();
        subscribeBtn.isEnabled();
        assertThat(subscribeBtn.getText()).isNotEmpty();
    }

    @Step("Нажать кнопку видео")
    public void clickVideoBtn() {
        videoBtn.isDisplayed();
        videoBtn.isEnabled();
        videoBtn.click();
    }
}
