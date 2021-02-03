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
        homePAGE.searchElement("Dress");
        SearchPAGE.QuickView();
        SearchPAGE.WaitTitleOfElement();
        String getProductTest = SearchPAGE.getTitleOfProduct();
        System.out.println(getProductTest);
        Assert.assertEquals(getProductTest,"Faded Short Sleeve T-Shirts","Title is not displayed");
    }
    @Test
    public void searchProductTest(){
        homePAGE.openMainUrl();
        homePAGE.searchElement("Dress");//передаєм string в метод (по такому принципу можна і інші значення)
    }
    @Test
    public void countSearchProductTest(){ //визначаємо чи відповідає кількість елементів тайтлу
    homePAGE.searchElement("printed");
    Assert.assertEquals(SearchPAGE.getProductListSize(),
            SearchPAGE.getSearchResultTitleAmount(),
            "Search result and title of product does not equals");




    }
}