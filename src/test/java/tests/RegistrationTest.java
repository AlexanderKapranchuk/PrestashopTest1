package tests;

import Common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchPage.SearchPageResults;
import pages.blocks.Header;
import pages.home.HomePage;
import pages.home.RegistrationPage;

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
    }
}
