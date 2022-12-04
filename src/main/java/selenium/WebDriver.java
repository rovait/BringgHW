package selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public enum WebDriver {
    SINGLETON;

    public ChromeDriver getDriver() {
        return driver;
    }

    private ChromeDriver driver = null;

    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        try {
            driver = new ChromeDriver(options);
        }catch (Exception e){
            System.out.println("Failed to init Selenium Web Driver!" + e.getMessage());
        }
    }

    public void gotoUrl(String url) {
        driver.get(url);
    }

    public void closeBrowser() {
        driver.quit();

    }
}
