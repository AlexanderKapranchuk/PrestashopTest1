package tests;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage.SearchPageResults;
import pages.blocks.Header;
import pages.home.HomePage;
import pages.home.RegistrationPage;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    HomePage homePAGE;
    Header header;
    RegistrationPage registrationPAGE;

    @BeforeMethod
    public void setUp() {

        homePAGE = new HomePage();
        header = new Header();
        registrationPAGE = new RegistrationPage();
        homePAGE.openMainUrl();
    }
    @Test
    public void registrationTest(){
        header.RegistrationClick();
        registrationPAGE.createUserClick();
        registrationPAGE.typeInName();
        registrationPAGE.typeMail();
        registrationPAGE.saveUser();
        //Check registration
        registrationPAGE.loginUserVerify();
        Assert.assertTrue(registrationPAGE.elementIsDisplayed1());
    }
}
