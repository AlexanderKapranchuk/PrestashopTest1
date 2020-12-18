package pages.SearchPage;

import Common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPageResults extends BaseTest {

    @FindBy(xpath = "//*[@id=\"main\"]/h2")
    private WebDriverWait waitDress;

    @FindBy(xpath ="//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    private WebElement product;

    @FindBy(css =".quick-view")
    private WebElement productLink;

    @FindBy(xpath = "//h1[contains(@class, 'h1')]")
    private WebDriverWait waitDressName;

    @Step("Quick view")
    public void QuickView() {
        Actions actions = new Actions(driver);
        actions.moveToElement(product).pause(Duration.ofSeconds(5)).click(productLink).build().perform(); }

}
