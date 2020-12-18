package pages.blocks;

import Common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends BaseTest {

    public Header() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath ="//span[@class= \"expand-more _gray-darker hidden-sm-down\"]")
    WebElement DropDownList;

    @FindBy(xpath = "//a[contains(text(), 'EUR €')]")
    WebElement EUR;

    @FindBy(xpath = "//a[contains(text(),'USD $')]")
    WebElement USD;

    @FindBy(xpath = "//a[contains(text(), 'UAH ₴')]")
    WebElement UAH;


    @Step("Open the Currency dropdown")
    public void currencySelector() { DropDownList.click();}

    @Step("Select the EUR currency in the CurrencyDropDown")
    public void selectEURCurrency() {EUR.click(); }

    @Step("Select the USD currency in the CurrencyDropDown")
    public void selectUSDCurrency() {USD.click(); }

    @Step("Select the UAH currency in the CurrencyDropDown")
    public void selectUAHCurrency() {UAH.click();}

    @Step("Check currencyEUR")
    public String getCurrentCurrencyEUR(){ EUR.getText().contains(EUR.toString());
    return EUR.toString();}

    @Step("Check currencyESD")
    public String getCurrentCurrencyUSD(){ USD.getText();
    return USD.toString();}

    @Step("Check currencyUAH")
    public String getCurrentCurrencyUAH(){ UAH.getText();
    return UAH.toString();}

}
