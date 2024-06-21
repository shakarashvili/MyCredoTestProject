package Data;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class TestData {

    private WebDriver driver;

    private WebDriverWait wait;

    public TestData(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void RunAuthorizationPage(){
        driver.get("https://mycredo.ge/landing/main/auth");
    }

    @FindBy(xpath = "//input[contains(@id,'userName')]")
    public WebElement UserName;

    @FindBy(xpath = "//input[contains(@id,'newPass')]")
    public WebElement Password;

    @FindBy(xpath = "//button[contains(@id,'submitAuth')]")
    public WebElement AuthorizationButton;

    @FindBy(xpath = "//p[contains(@class,'mess')]")
    public WebElement InvalidMessage;

    @FindBy(xpath = "//div[contains(@class,'language-switcher-button white')]")
    public WebElement LanguageButton;

    @FindBy(xpath = "//p[text()='სვანური']")
    public WebElement Svanuri;

    @FindBy(xpath = "//p[text()='მეგრული']")
    public WebElement Megruli;

    @FindBy(xpath = "//div[contains(@class,'sub-language')][1]")
    public WebElement Kartuli;

    String randomUsername = RandomStringUtils.randomAlphabetic(8);

   // String randomEmail = RandomStringUtils.randomAlphanumeric(10) + "@example.com";
    String randomPassword = RandomStringUtils.randomAlphanumeric(10);


    @Step("login authorization Geo")
    public void SingUpGeo() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(UserName));
        UserName.sendKeys("elene-elene-elene");
        Password.sendKeys("12314132");
        AuthorizationButton.click();
        wait.until(ExpectedConditions.visibilityOf(InvalidMessage));

    }
    @Step("login authorization Meg")
    public void SingUpMeg() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(UserName));
        UserName.sendKeys("vardiskona1231321312");
        Password.sendKeys("43113232123123");
        AuthorizationButton.click();
        wait.until(ExpectedConditions.visibilityOf(InvalidMessage));

    }

    @Step("login authorization SVAN")
    public void SingUpSvan() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(UserName));
        UserName.sendKeys("tinate");
        Password.sendKeys("asdfa asdasd asd ");
        AuthorizationButton.click();
        wait.until(ExpectedConditions.visibilityOf(InvalidMessage));

    }

    @Step("login authorization Geo2")
    public void SingUpGeo2(String name, String password) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(UserName));
        UserName.sendKeys(name);
        Password.sendKeys(password);
        AuthorizationButton.click();
        wait.until(ExpectedConditions.visibilityOf(InvalidMessage));

    }



    @Step("მეგრული ენის არჩევა")
    public void ChooseMegrelianLanguage(){
        wait.until(ExpectedConditions.visibilityOf(LanguageButton));
        LanguageButton.click();
        wait.until(ExpectedConditions.visibilityOf(Megruli));
        Megruli.click();
    }

    @Step("სვანური ენის არჩევა")
    public void ChooseSvanLanguage(){
        wait.until(ExpectedConditions.visibilityOf(LanguageButton));
        LanguageButton.click();
        wait.until(ExpectedConditions.visibilityOf(Svanuri));
        Svanuri.click();
    }
    @Step("ქართული ენის არჩევა")
    public void ChooseKartvelianLanguage(){
        wait.until(ExpectedConditions.visibilityOf(LanguageButton));
        LanguageButton.click();
        wait.until(ExpectedConditions.visibilityOf(Kartuli));
        Kartuli.click();
    }
    @Step("login authorization with Random data")
    public void Randomizer() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(UserName));
        UserName.sendKeys(randomUsername);
        Password.sendKeys(randomPassword);
        AuthorizationButton.click();
        wait.until(ExpectedConditions.visibilityOf(InvalidMessage));


    }


}
