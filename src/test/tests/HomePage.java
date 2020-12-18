import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    @Test
    public void HomePageTest() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src/test/resources/drivers/chromedriver87.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://prestashop-automation.qatestlab.com.ua/ru/");

        //driver.getTitle(); "prestashop-automation"
        System.out.println("Page titel is: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "prestashop-automation", "prestashop-automation");

        WebElement element = driver.findElement(By.name("s"));
        element.sendKeys("dress");
        element.submit();

        WebDriverWait waitDress = new WebDriverWait(driver, 5);
        waitDress.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id=\"main\"]/h2")));

        WebElement product = driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]"));
        WebElement productLink = driver.findElement(By.cssSelector(".quick-view"));

        Actions actions = new Actions(driver);
        actions.moveToElement(product).pause(Duration.ofSeconds(3)).click(productLink).build().perform();

        driver.quit();
    }
}
