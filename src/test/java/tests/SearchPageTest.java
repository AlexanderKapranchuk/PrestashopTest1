package tests;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.home.HomePage;

import java.time.Duration;

public class SearchPageTest extends BaseTest {

    HomePage homePage;


    @BeforeMethod
    public void setUp() {
        homePage = new HomePage();
    }

}