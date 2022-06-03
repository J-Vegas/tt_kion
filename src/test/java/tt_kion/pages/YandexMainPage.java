package tt_kion.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tt_kion.BasePage;

public class YandexMainPage extends BasePage {

    @FindBy(xpath = "//a[@data-id='all']")
    private WebElement allServicesBtn;

    @FindBy(xpath = "//div[@class='services-new-more__popup-content']")
    private WebElement morePopUpBlock;

    @FindBy(xpath = "//a[@data-id='zen']")
    private WebElement zenPopupItem;

    public YandexMainPage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Нажать пункт 'ЕЩЕ'")
    public YandexMainPage clickAllServicesBtn() {
        allServicesBtn.isDisplayed();
        allServicesBtn.click();
        return this;
    }

    @Step("Выбрать раздел 'Дзен'")
    public YandexMainPage clickZen() {
        morePopUpBlock.isDisplayed();
        zenPopupItem.isDisplayed();
        zenPopupItem.click();
        return this;
    }

}
