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

public class SearchPageResults extends BaseTest {

    private static WebDriverWait wait;
    public SearchPageResults(){
        PageFactory.initElements(driver, this);

        int timeOutInSeconds = 10;
        wait = new WebDriverWait(driver,timeOutInSeconds);
    }

    @FindBy(xpath ="//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    private WebElement product;

    @FindBy(css =".quick-view")
    private WebElement productLink;

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/input[2]")
    private WebElement SearchDress;

    @Step("Wait Search dress")
    public void WaitSearchDress(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"search_widget\"]/form/input[2]")));
           }
    @Step("Type in Search dress")
    public void SearchDress(){
    SearchDress.sendKeys("dress");
    SearchDress.submit();}

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
