package pages.home;

import Common.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class RegistrationPage extends BaseTest {

    private static WebDriverWait wait;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);

        int timeOutInSeconds = 10;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    private WebElement CreateUser;

    @FindBy(name ="firstname")
    private WebElement FirstName;

    @FindBy(name = "lastname")
    private WebElement Lastname;

    @FindBy(name = "email")
    private WebElement Email;

    @FindBy(name = "password")
    private WebElement Password;

    @FindBy(xpath = "//*[@id='customer-form']/footer/button")
    private WebElement Save;

    @Step("Create user")
    public void createUserClick(){
        CreateUser.click();}

    @Step("Type in FirstName")
    public void typeInName(){
        FirstName.sendKeys("Auto");
        Lastname.sendKeys("Test");
        Password.sendKeys("Test1234");
    }
    @Step("Generate mail")
    public void typeMail(){
        Random random = new Random();
        int n = random.nextInt(10000) + 1;
        String generateEmail = "AutoTest" + n + "@gmail.com";
        Email.sendKeys(generateEmail);
    }
    @Step("Save new User")
    public void saveUser(){
        Save.click();
    }
}
