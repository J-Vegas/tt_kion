package tt_kion;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

abstract public class BasePage {
    protected static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    @Step("Текущий url соотвутсвует ожидаемому")
    public void checkCurrentUrl(String url) {
        assertThat(driver.getCurrentUrl()).isEqualTo(url);
    }
}
