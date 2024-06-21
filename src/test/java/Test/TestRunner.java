package Test;

import Data.TestData;
import Driver.SetUpDriver;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestRunner {
static WebDriver driver;
static WebDriverWait wait;
static TestData testData;

    @BeforeMethod
    public void DriverRunner(){
   driver = SetUpDriver.SetUpdriver();
   testData = new TestData(driver);
   wait = new WebDriverWait(driver , Duration.ofSeconds(10));
}

@AfterMethod
    public void quit(){
    if (driver != null){
        driver.quit();
    }
}
@Test
@Feature("ნეგატიური ქეისი ქართული ენისთვის, გადავცემთ არარსებული მომხმარებლის სახელს")
    public static void Test1() throws InterruptedException {
        TestData Maindata = new TestData(driver);
        Maindata.RunAuthorizationPage();
        Maindata.ChooseKartvelianLanguage();
        Maindata.SingUpGeo();
}

    @Test
    @Feature("ნეგატიური ქეისი მეგრული ენისთვის, მომხმარებლის სახელს გადავცემთ ციფრებთან ერთად")
    public static void Test2() throws InterruptedException {
        TestData Maindata = new TestData(driver);
        Maindata.RunAuthorizationPage();
        Maindata.ChooseMegrelianLanguage();
        Maindata.SingUpMeg();
    }

    @Test
    @Feature("ნეგატიური ქეისი სვანური ენისთვის, პაროლის ველში ვიყენებთ სფეისებს")
    public static void Test3() throws InterruptedException {
        TestData Maindata = new TestData(driver);
        Maindata.RunAuthorizationPage();
        Maindata.ChooseSvanLanguage();
        Maindata.SingUpSvan();
    }

    @Test(dataProvider = "loginParameters" )
    @Feature("ტესტში გამოყენებულია დატა პროვაიდერი ")
    public  void Test4(String name , String password) throws InterruptedException {
        TestData Maindata = new TestData(driver);
        Maindata.RunAuthorizationPage();
        Maindata.ChooseKartvelianLanguage();
        Maindata.SingUpGeo2(name,password);
       // Maindata.AuthorizationButton.click();
    }
    @DataProvider(name= "loginParameters")
    public Object[][] loginParameters(){
        return new Object[][]{
                {"avto123", "33"}, {"irakli-ირაკლი", "332244"}, {"gio", "3443-დათო"},
                 {"mycredo@gmail.com", "1q2w3e"}, {"1234567890","qwertyuiop"},
                {"Shaqarashvili25@gmail.com","1q2w3e4r"}, {"DAVID", "123441234"}, {"Giorgi,gio","12341234"}
        };
    }

    @Test
    @Feature("რენდომ ფუნქციით ტესტირება")
    public void Test5() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        TestData Maindata = new TestData(driver);
        Maindata.RunAuthorizationPage();
        Maindata.ChooseMegrelianLanguage();
        Maindata.Randomizer();
        softAssert.assertTrue(Maindata.InvalidMessage.isDisplayed());
        softAssert.assertAll();

    }

}




