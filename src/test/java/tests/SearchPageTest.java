package tests;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage.SearchPageResults;
import pages.home.HomePage;

import java.time.Duration;

public class SearchPageTest extends BaseTest {

    HomePage homePAGE;
    SearchPageResults SearchPAGE;

    @BeforeMethod
        public void setUp() {

        homePAGE = new HomePage();
        SearchPAGE = new SearchPageResults();
        homePAGE.openMainUrl();
    }
    @Test
    public void SearchDressTest(){
        SearchPAGE.WaitSearchDress();
        SearchPAGE.SearchDress();
        SearchPAGE.QuickView();
        SearchPAGE.WaitTitleOfElement();
        String getProductTest = SearchPAGE.getTitleOfProduct();
        System.out.println(getProductTest);
        Assert.assertEquals(getProductTest,"Faded Short Sleeve T-Shirts","Title is not displayed");
    }
}