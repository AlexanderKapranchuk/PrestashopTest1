package tests;

import Common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage.SearchPageResults;
import pages.blocks.Header;
import pages.home.HomePage;
import utils.enums.Currency;

public class HomePageTest extends BaseTest {

    HomePage homePAGE;
    Header header;
    SearchPageResults SearchPAGE;

    @BeforeMethod
    public void setUp() {
        homePAGE = new HomePage();
        header = new Header();
        SearchPAGE = new SearchPageResults();
        homePAGE.openMainUrl();
    }

    @Test
    public void verifyHomePageTitleTest() {
        String homePageTitle = homePAGE.getTitle();
        Assert.assertEquals(homePageTitle, "prestashop-automation", "Home page title does not matched");
    }

    @Test
    public void verifySiteCurrencyEqualsProductsCurrencyTest() {
        Assert.assertEquals(homePAGE.getCurrentProductCurrency(),
                homePAGE.getCurrentSiteCurrency(), "Currency does not match");

    }
    @Test
    public void changeCurrentCurrencyToUsdTest() {
        header.currencySelector();
        header.waitCurrencyClickable();
        header.selectUSDCurrency();
        Assert.assertEquals(homePAGE.getCurrentProductCurrency(), Currency.USD.toString(), "Currency is not EUR");
    }
    @Test
    public void changeCurrencyAndVerify(){
        homePAGE.openMainUrl();
        header.currencySelector();
        String getCurrencyEUR = header.getCurrentCurrencyEUR();
        Assert.assertEquals(getCurrencyEUR,"EUR €"," EUR € Currency is not displayed");
        header.currencySelector();
        String getCurrencyUSD = header.getCurrentCurrencyUSD();
        Assert.assertEquals(getCurrencyUSD,"USD $"," USD $ Currency is not displayed");
        String getCurrencyUAH = header.getCurrentCurrencyUAH();
        Assert.assertEquals(getCurrencyUAH,"UAH ₴", " UAH ₴ Currency is not displayed");
        //Change and verify EUR
        header.currencySelector();
        header.selectEURCurrency();
        System.out.println(header.verifyEUR()+" Price of products");
        Assert.assertTrue(header.verifyEUR().contains("€"),"Product is not contain €");
        //Change and verify USD
        header.currencySelector();
        header.waitCurrencyClickable();
        header.selectUSDCurrency();
        System.out.println(header.verifyUSD()+" Price of products");
        Assert.assertTrue(header.verifyUSD().contains("$"),"Product is not contain $");
        //Change and verify UAH
        header.currencySelector();
        header.waitCurrencyClickable();
        header.selectUAHCurrency();
        System.out.println(header.verifyUAH() + " Price of products");
        Assert.assertTrue(header.verifyUAH().contains("₴"),"Product is not contain ₴");
    }
}
