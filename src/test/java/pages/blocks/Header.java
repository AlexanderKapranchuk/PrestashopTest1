package pages.blocks;

import Common.BaseTest;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BaseTest {
    private static WebDriverWait wait;
    public Header() {
        PageFactory.initElements(driver, this);

        int timeOutInSeconds = 10;
        wait = new WebDriverWait(driver,timeOutInSeconds);
    }

    @FindBy(xpath ="//span[@class= \"expand-more _gray-darker hidden-sm-down\"]")
    private WebElement DropDownList;

    @FindBy(xpath = "//a[contains(text(), 'EUR €')]")
    private WebElement EUR;

    @FindBy(xpath = "//a[contains(text(),'USD $')]")
    private WebElement USD;

    @FindBy(xpath = "//a[contains(text(), 'UAH ₴')]")
    private WebElement UAH;
    
    @FindBy(xpath = "//*[contains(@class,'price')]//*[contains(text(), '€')]")
    private WebElement Products;

    @FindBy(xpath = "//*[contains(@class,'price')]//*[contains(text(), '$')]")
    private  WebElement ProductsUSD;

    @FindBy(xpath = "//*[contains(@class,'price')]//*[contains(text(), '₴')]")
    private  WebElement ProductsUAH;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a/span")
    private WebElement Registration;

    @Step("Registration click")
    public void RegistrationClick(){
        Registration.click();
    }
    @Step("Verify product EUR")
    public String verifyEUR(){
        return Products.getText();}

    @Step("Verify product USD")
    public String verifyUSD(){
        return ProductsUSD.getText();}

    @Step("Verify product UAH")
    public String verifyUAH(){
        return ProductsUAH.getText();}

    @Step("Open the Currency dropdown")
    public void currencySelector() { DropDownList.click();}

    @Step("Select the EUR currency in the CurrencyDropDown")
    public void selectEURCurrency() {EUR.click(); }

    @Step("Select the USD currency in the CurrencyDropDown")
    public void selectUSDCurrency() {USD.click(); }

    @Step("Wait for USD")
    public void waitCurrencyClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'USD $')]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'UAH ₴')]")));   }

    @Step("Select the UAH currency in the CurrencyDropDown")
    public void selectUAHCurrency() {UAH.click();}

    @Step("Check currencyEUR")
    public String getCurrentCurrencyEUR(){ return EUR.getText();}

    @Step("Check currencyESD")
    public String getCurrentCurrencyUSD(){ return USD.getText();}

    @Step("Check currencyUAH")
    public String getCurrentCurrencyUAH(){ return UAH.getText();}

}
