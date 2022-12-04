package calculator;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import selenium.WebDriver;
import selenium.WebElementFactory;

import java.util.ArrayList;
import java.util.List;

public class CalculatorHandler {

    protected List<String> operationsHistory = new ArrayList<>();

    public CalculatorHandler() {
        WebDriver.SINGLETON.initWebDriver();
    }

    public void clickButtonById(String id) throws Exception{
        WebElement element = WebElementFactory.getWebElementBySelector(How.ID, id);
        if(element == null){
            throw new Exception("Failed to find WebElement for: " + id);
        }
        element.click();
    }
    public void validateResult(String expectedResult, String selector) throws Exception{
        String actualResult = WebElementFactory.getWebElementBySelector(How.ID, selector).getAttribute("value");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    public void clickButtonByText(String text) throws Exception{
        clickButtonByText(text, false);
    }

    public void clickButtonByText(String text, boolean ignoreFailure) throws Exception{
        String xpath = "//p[text()='" + text + "']";
        WebElement element = WebElementFactory.getWebElementBySelector(How.XPATH, xpath);
        if(!ignoreFailure && element == null){
            throw new Exception("Failed to find WebElement for: " + text);
        }
        element.click();
    }

    public void openBrowser(String url){
        WebDriver.SINGLETON.gotoUrl(url);
    }


    public void closeBrowser(){
        WebDriver.SINGLETON.closeBrowser();
    }

    public List<String> getOperationsHistory() {
        return operationsHistory;
    }

    public void addOperationToHistory(String operation){
        operationsHistory.add(operation);
    }

    public void printHistory(){
        operationsHistory.stream().forEach(operation -> {
            System.out.println(operation);
        });
    }
}
