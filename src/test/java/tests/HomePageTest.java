package tests;

import Common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.blocks.Header;
import pages.home.HomePage;
import utils.enums.Currency;

public class HomePageTest extends BaseTest {

    HomePage homePAGE;
    Header header;


    @BeforeMethod
    public void setUp() {
        homePAGE = new HomePage();
        header = new Header();
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
    @Test(priority = 3)
    public void changeCurrentCurrencyToUsdTest() {
        header.currencySelector();
        header.selectEURCurrency();
        Assert.assertEquals(homePAGE.getCurrentProductCurrency(), Currency.EUR.toString(), "Currency is not EUR");
    }

}
