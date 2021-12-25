package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

public class WebElementFactory {

    public static WebElement getWebElementBySelector(How by, String selector) {
        switch (by) {
            case ID:
                return getWebElementById(selector);
            case XPATH:
                return getWebElementByXpath(selector);
            default:
                return null;
        }
    }

    private static WebElement getWebElementById(String id){
        WebElement element = null;
        try {
            element = WebDriver.SINGLETON.getDriver().findElement(By.id(id));
        } catch (Exception e) {
            System.out.println("Failed to find WebElement by id: " + id + "\n" + e.getMessage());
        }
        return element;
    }

    private static WebElement getWebElementByXpath(String xpath) {
        WebElement element = null;
        try {
            element = WebDriver.SINGLETON.getDriver().findElement(By.xpath(xpath));
        } catch (Exception e) {
            System.out.println("Failed to find WebElement by xpath: " + xpath + "\n" + e.getMessage());
        }
        return element;
    }
}
