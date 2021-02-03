package pages.SearchPage;

import Common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPageResults extends BaseTest {

    private static WebDriverWait wait;
    public SearchPageResults(){
        PageFactory.initElements(driver, this);

        int timeOutInSeconds = 10;
        wait = new WebDriverWait(driver,timeOutInSeconds);
    }

    @FindBy(xpath = "//div[contains(@id, 'js-product-list-top')]")
    private WebElement searchResultTitle;

    @FindBy(xpath ="//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    private WebElement product;

    @FindBy(css =".quick-view")
    private WebElement productLink;

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/input[2]")
    private WebElement SearchDress;

    @FindBy(xpath = "//article[contains(@class, 'product-miniature js-product-miniature')]")
    private List<WebElement> productList;

    public String getWebElemntText(WebElement element){
        return element.getText();
    }

    @Step("Get search result amount")
    public int getSearchResultTitleAmount(){
        return Integer.parseInt(getWebElemntText(searchResultTitle).replaceAll("[\\D]",""));
    }
    @Step("Get list size")
    public int getWebElementListSize(List<WebElement> element){
        return element.size();
    }
    @Step("Get product list size")
    public int getProductListSize() {
        return getWebElementListSize(productList);
    }

    @Step("Wait Search dress")
    public void WaitSearchDress(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search_widget\"]/form/input[2]")));
           }
    @Step("Quick view")
    public void QuickView() {
        Actions actions = new Actions(driver);
        actions.moveToElement(product).pause(Duration.ofSeconds(5)).click(productLink).build().perform(); }

    @Step("Wait title of element")
    public void WaitTitleOfElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class, 'h1')]")));
    }
    @Step("Get title of Product")
    public String getTitleOfProduct(){return product.getText(); }

}
