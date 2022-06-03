package tt_kion.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Helpers {

    public static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

    public static By toByValue(WebElement webElement) {
        String[] data = webElement.toString().split(" -> ")[1].replace("]", "").split(": ");
        String locator = data[0];
        String term = data[1];

        switch (locator) {
            case "xpath":
                return By.xpath(term);
            case "css selector":
                return By.cssSelector(term);
            case "id":
                return By.id(term);
            case "tag name":
                return By.tagName(term);
            case "name":
                return By.name(term);
            case "link text":
                return By.linkText(term);
            case "class name":
                return By.className(term);
        }
        System.out.println("webElement" + webElement);
        return (By) webElement;
    }
}
