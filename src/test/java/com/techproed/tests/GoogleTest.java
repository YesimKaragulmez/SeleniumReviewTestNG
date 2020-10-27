package com.techproed.tests;

import com.techproed.pages.GooglePage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBaseFinal;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends TestBaseFinal {
    //    1. Örnek : Google Arama
//	- pages paketinin altında GooglePage adlı class oluşturalım.
//            - aramaKutusu webelementini bulalım. (@FindBy)
//            - tumLinkler List<WebElement>, sonuç sayfasındaki tüm linkleri liste şeklinde bulalım.
//	- aramaKutusu 'a techproeducation yazalım ve arama işlemi yapalım.
//            - tumLinkler 'e bakalım ve bu testlerin içerisinde techproeducation.com adlı websitesi var mı kontrol edelim.
//            - varsa testimiz BAŞARILI, yoksa BAŞARISIZ olsun.
    @Test
    public void techproeducationAramaTesti() throws InterruptedException {
        extentTest = extentReports.createTest("Techproeducation Arama"
                , "Google sonuçlarında techpreducation.com'u aradık.");
        extentTest.info("Google.com'a gidiyoruz.");
        Driver.getDriver().get(ConfigurationReader.getProperty("google"));
        extentTest.info("GooglePage class'ından nesne ürettik.");
        GooglePage googlePage = new GooglePage();
        extentTest.info("techproeducation araması yapıyoruz.");
        googlePage.aramaKutusu.sendKeys(ConfigurationReader.getProperty("aranacak_kelime") + Keys.ENTER);
        Thread.sleep(3000);
        boolean testSonucu = false;
        for (WebElement w : googlePage.tumLinkler) {
            if (w.getText().contains("techproeducation.com")) {
                testSonucu = true;
                break;
            }
        }
        extentTest.info("Assert işlemi yapıyoruz.");
        Assert.assertTrue(testSonucu);
        extentTest.pass("Testimiz PASSED(başarılı) !");
    }
}