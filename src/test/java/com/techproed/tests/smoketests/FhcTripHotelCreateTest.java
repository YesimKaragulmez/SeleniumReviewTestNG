package com.techproed.tests.smoketests;

import com.techproed.tests.pages.FhcTripHotelCreatePage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FhcTripHotelCreateTest extends TestBase {

    // her test methodundan önce çalışır.
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!" + Keys.ENTER);

    }
    @Test
    public void test() throws InterruptedException {
        FhcTripHotelCreatePage createPage=new FhcTripHotelCreatePage(driver);

        createPage.code.sendKeys("1234");
        createPage.name.sendKeys("Ottoman Hotel");
        createPage.adress.sendKeys("Hatay");
        createPage.phone.sendKeys("654322890");
        createPage.email.sendKeys("aws@hotmail.com");

        Select select=new Select(createPage.selectGroup);
        select.selectByIndex(1);
        createPage.saveButton.click();


        WebDriverWait wait=new WebDriverWait(driver,60);
        WebElement message=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bootbox-body")));
        Assert.assertTrue(message.isDisplayed());

    }



}
