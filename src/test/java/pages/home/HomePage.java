package pages.home;

import Common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.enums.Currency;


public class HomePage extends BaseTest {

    @FindBy(name = "s")
    private WebElement SearchField;

    @FindBy(xpath = "//span[contains(@class,'price')]")
    private WebElement productsPrice;

    @FindBy(xpath = "//span[contains(@class, 'expand-more _gray-darker hidden-sm-down')]")
    private WebElement currencyDropDown;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @Step("Get page Title")
    public String getTitle() {
        return driver.getTitle();
    }

    @Step("Search by word")
    public void SearchElement() {
        SearchField.sendKeys("dress");
        SearchField.submit();
    }

    @Step("Open main URL")
    public void openMainUrl() {
        driver.get(prop.getProperty("url"));
    }


    @Step("Get actual products currency")
    public String getCurrentProductCurrency() {

        if (currencyDropDown.getText().contains(Currency.UAH.toString())) {
            return Currency.UAH.toString();
        }

        if (currencyDropDown.getText().contains(Currency.USD.toString())) {
            return Currency.USD.toString();
        }

        if (currencyDropDown.getText().contains(Currency.EUR.toString())) return Currency.EUR.toString();
        return null;
    }

    @Step("Get site actual currency")
    public String getCurrentSiteCurrency() {

        if (productsPrice.getText().contains(Currency.UAH.toString())) {
            return Currency.UAH.toString();
        }
        if (productsPrice.getText().contains(Currency.USD.toString())) {
            return Currency.USD.toString();
        }
        if (productsPrice.getText().contains(Currency.EUR.toString())) {
            return Currency.EUR.toString();
        }
        return null;
    }

}
