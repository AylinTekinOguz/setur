
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ReusableMethods {
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. https://www.setur.com.tr/ sayfasına gidilir.
        driver.get("https://www.setur.com.tr/");
    }

    @AfterAll
    public static void close(){
        driver.quit();
    }

    public void visibleElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement find(By locator) {
        visibleElement(locator);
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void clickJS(By locator) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", button);
    }

    public void showYellowElement(By locator) {
        visibleElement(locator);
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid yellow'",element);
    }

    public void untilVisibleClick(By locatorOne, By locatorTwo) {
        boolean check = true;
        while (check) {
            try {
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
                wait.until(ExpectedConditions.visibilityOfElementLocated(locatorOne));
                check=false;
            } catch (Exception e) {
                showYellowElement(locatorTwo);
                find(locatorTwo).click();
            }
        }
    }

    public void scrollDownUntilFindElement(By locator) {
        boolean check = true;
        while (check) {
            try {
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                WebElement element = driver.findElement(locator);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", element);
                check=false;
            } catch (Exception e) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0, 250);");
            }
        }
    }

    public void click(By locator) {
        showYellowElement(locator);
        driver.findElement(locator).click();
    }

    public void wait(String mSaniye) throws InterruptedException {
        Thread.sleep(Long.parseLong(mSaniye));
    }
}
