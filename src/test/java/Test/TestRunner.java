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
    public void Test1() throws InterruptedException {

    testData.RunAuthorizationPage();
    testData.ChooseKartvelianLanguage();
    testData.SingUpGeo();

}

    @Test
    @Feature("ნეგატიური ქეისი მეგრული ენისთვის, მომხმარებლის სახელს გადავცემთ ციფრებთან ერთად")
    public  void Test2() throws InterruptedException {

        testData.RunAuthorizationPage();
        testData.ChooseMegrelianLanguage();
        testData.SingUpMeg();
    }

    @Test
    @Feature("ნეგატიური ქეისი სვანური ენისთვის, პაროლის ველში ვიყენებთ სფეისებს")
    public  void Test3() throws InterruptedException {

        testData.RunAuthorizationPage();
        testData.ChooseSvanLanguage();
        testData.SingUpSvan();
    }

    @Test(dataProvider = "loginParameters" )
    @Feature("ტესტში გამოყენებულია დატა პროვაიდერი ")
    public  void Test4(String name , String password) throws InterruptedException {

        testData.RunAuthorizationPage();
        testData.ChooseKartvelianLanguage();
        testData.SingUpGeo2(name,password);

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
        testData.RunAuthorizationPage();
        testData.ChooseMegrelianLanguage();
        testData.Randomizer();
        softAssert.assertTrue(testData.InvalidMessage.isDisplayed());
        softAssert.assertAll();

    }

}




