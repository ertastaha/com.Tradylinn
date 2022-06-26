package tests.US_011;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UrunPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

public class TC_03 extends TestBaseReport {

    UrunPage urunPage = new UrunPage();
    SoftAssert softAssert = new SoftAssert();
    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void US05_TC03Testi() throws InterruptedException, AWTException {
        extentTest=extentReports.createTest("US05_TC03","price,sale price ve urun fotografi eklenebilmeli ve gorunur olmali");

        //1- https://tradylinn.com/ sitesine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("trUrl"));
        extentTest.info("Sayfaya gidildi");

        //2-Giris Yap/Uye Ol butonuna basiniz
        jse.executeScript("arguments[0].click();", urunPage.girisYap);
        extentTest.info("Giris Yap/Uye ol butonuna tiklandi");

        //3-Uygun email ve sifre giriniz.
        urunPage.kullaniciAdi.sendKeys(ConfigReader.getProperty("validUserName"));
        extentTest.info("Gecerli email girildi");
        urunPage.password.sendKeys(ConfigReader.getProperty("validPassword")+ Keys.ENTER);
        extentTest.info("Gecerli password girildi");

        //4-hesabim butonuna tiklayin
        ReusableMethods.waitFor(10);
        jse.executeScript("arguments[0].click();", urunPage.hesabim);
        extentTest.info("Hesabim butonuna tiklandi");

        //5-Store Manager sekmesine tiklayin
        jse.executeScript("arguments[0].click();", urunPage.storeManager);
        extentTest.info("Store manager sekmesine tiklandi");

        //6- urunler sekmesine tiklayin
        jse.executeScript("arguments[0].click();", urunPage.urun);
        extentTest.info("Urunler sekmesine tiklandi");

        //7-Yeni ekle butonuna tiklayin
        jse.executeScript("arguments[0].click();", urunPage.yeniEkle);
        extentTest.info("Yeni Ekle butonuna tiklandi");

        //8-product title'a urun ismini girin
        jse.executeScript("arguments[0].scrollIntoView(true);",urunPage.productTitleButton);
        urunPage.productTitleButton.sendKeys("Tabak");
        extentTest.info("Product title'a urun ismi girildi");

        //9-price ve sale price miktari girin
        jse.executeScript("arguments[0].scrollIntoView(true);",urunPage.priceButton);
        urunPage.priceButton.sendKeys("1000");
        extentTest.info("Price miktari girildi");
        urunPage.salePriceButton.sendKeys("950");
        extentTest.info("Sale Price miktari girildi");


        //10-Featured img kismina urun fotografi girin

        jse.executeScript("arguments[0].click();", urunPage.featuredImgButton);
        extentTest.info("featured img butonuna tiklandi");


        jse.executeScript("arguments[0].scrollIntoView(true);", urunPage.dosyaSeçButton);
        urunPage.dosyaSeçButton.click();
        extentTest.info("Dosya sec butonuna tiklandi");
        ReusableMethods.waitFor(2);
        Robot rb = new Robot();

        StringSelection str = new StringSelection("\"C:\\Users\\nertas\\Desktop\\Selenium\\images1.jpeg\"");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        ReusableMethods.waitFor(10);
        ReusableMethods.switchToWindow("Choose Image");
        jse.executeScript("arguments[0].click();", urunPage.fotoSecButton);
        extentTest.info("Sec butonuna tiklandi");

        //11-Gallery Images kismina urun fotografi girin
        ReusableMethods.switchToWindow("Product Manager");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(15);
        jse.executeScript("arguments[0].click();", urunPage.galleryImgButton);
        extentTest.info("GalleryImg butonuna tiklandi");
        ReusableMethods.waitFor(5);

        ReusableMethods.switchToWindow("Add to Gallery");
        jse.executeScript("arguments[0].click();",urunPage.galleryImgFotosu);
        extentTest.info("Galleryimg icin fotograf secildi");
        ReusableMethods.waitFor(10);

        jse.executeScript("arguments[0].click();", urunPage.addToGalleryButton);
        extentTest.info("Add To Gallery butonuna tiklandi");
        ReusableMethods.switchToWindow("Product Manager");
        ReusableMethods.waitFor(4);

        //12-Categories secin
        jse.executeScript("arguments[0].click();", urunPage.besinTakviyeleriButton);
        extentTest.info("Categories besin takviyeleri'ne tiklandi");
        String ilkWindowHandle=Driver.getDriver().getWindowHandle();

        //13-Submit butonuna tiklayin

        jse.executeScript("arguments[0].click();",urunPage.submitButton);
        extentTest.info("Submit butonuna click yapildi");



/*
        //14-views'e tiklayin
        ReusableMethods.waitFor(8);
        jse.executeScript("arguments[0].click();", urunPage.viewsButton);
        extentTest.info("views butonuna tiklandi");

        //15-price ve sale price miktarinin gorunur oldugunu test edin
        Set<String> windowHandles=Driver.getDriver().getWindowHandles();
        String ikinciHandle="";
        for (String w:windowHandles
        ) {
            if (!w.equals(ilkWindowHandle)){
                ikinciHandle=w;
            }
        }
        Driver.getDriver().switchTo().window(ikinciHandle);


        softAssert.assertTrue(urunPage.priceMiktari.isDisplayed());
        extentTest.info("Price miktari gorununurluk testi yapildi");
        softAssert.assertTrue(urunPage.salePriceMiktari.isDisplayed());
        extentTest.info("sale price gorununurluk testi yapildi");

        //16- yuklenen fotograflarin gorunur oldugunu test edin

        softAssert.assertTrue(urunPage.featuredImgGorunuyorMu.isDisplayed());
        extentTest.info("featured img gorununurluk testi yapildi");
        js.executeScript("window.scrollBy(0,400)");
        softAssert.assertTrue(urunPage.galleryImgGorunuyorMu.isDisplayed());
        extentTest.info("gallery img gorununurluk test yapildi");
        extentTest.pass("price,sale price ve urun fotografi eklenebiliyor ve gorunur durumda");


 */

    }
}
