package tests.US_011;

import org.apache.logging.log4j.core.config.Order;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;


public class TC_01 extends TestBaseReport {


    TradylinnPage trdPage=new TradylinnPage();


    @Test(priority = 1)
    public void girisYapUrunSekmesineGec() throws InterruptedException {
        extentTest = extentReports.createTest("Pozitif Login", "Geçerli Username ve Password İle Giriş Yapabılabilmeli");
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        Driver.getDriver().get(ConfigReader.getProperty("trUrl"));
        Thread.sleep(5000);
        jse.executeScript("arguments[0].click();", trdPage.girisYap);
        trdPage.kullanıcıAdıBox.sendKeys(ConfigReader.getProperty("validUserName"));
        trdPage.parolaBox.sendKeys(ConfigReader.getProperty("validPassword"));
        trdPage.girisİkiButonu.click();
        extentTest.info("Başarılı Giriş Yapıldı.");

        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();",trdPage.hesabım);
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.storeManager);
        extentTest.info("Store Manager Sayfasına Geçildi.");
        Thread.sleep(10000);

        jse.executeScript("arguments[0].click();", trdPage.urun);
        jse.executeScript("arguments[0].click();", trdPage.yeniEkle);
        Thread.sleep(10000);
        extentTest.info("Ürün Sayfasına Geçildi.");
    }

    @Test(dependsOnMethods = "girisYapUrunSekmesineGec", priority = 2)
    public void userStoriesTest() throws InterruptedException, AWTException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", trdPage.productTitleBox);
        trdPage.productTitleBox.sendKeys("deneme");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys("250").sendKeys(Keys.TAB).sendKeys("200").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("deneme").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("deneme").perform();

        jse.executeScript("arguments[0].click();", trdPage.categories);
        Thread.sleep(5000);
        jse.executeScript("arguments[0].click();", trdPage.productBrands);
        Thread.sleep(5000);
        jse.executeScript("arguments[0].click();",trdPage.toptanUrunGosterme);
        Thread.sleep(5000);
        extentTest.info("Test Case'ler Öncesi Girişler Yapıldı.");

        Assert.assertTrue(trdPage.pieceTypeDDM.isDisplayed());
        Assert.assertTrue(trdPage.unitPerPiece.isDisplayed());
        Assert.assertTrue(trdPage.minOrderQuantity.isDisplayed());
        extentTest.info("User Story'de Belirtilen Elementler Görüldü.");


        Select select=new Select(trdPage.pieceTypeDDM);
        select.selectByIndex(2);
        actions.sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("20").perform();
        extentTest.info("Test Case 1 - Piece Type Veri Girildi");
        extentTest.info("Test Case 2 - Units Per Piece Veri Girildi");
        extentTest.info("Test Case 3 - Min Order Quantity Veri Girildi");

        //burdan
        jse.executeScript("arguments[0].click();", trdPage.featuredImgButton);
        Thread.sleep(5000);

        jse.executeScript("arguments[0].scrollIntoView(true);", trdPage.dosyaSeçButton);
        trdPage.dosyaSeçButton.click();
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

        Thread.sleep(10000);

        ReusableMethods.switchToWindow("Choose Image");
        jse.executeScript("arguments[0].click();", trdPage.fotoSecButton);
        extentTest.info("Büyük Foto Seçildi");

        ReusableMethods.switchToWindow("Product Manager");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(15);
        jse.executeScript("arguments[0].click();", trdPage.galleryImgButton);
        ReusableMethods.waitFor(5);

        ReusableMethods.switchToWindow("Add to Gallery");
        jse.executeScript("arguments[0].click();",trdPage.galleryImgFotosu);

        ReusableMethods.waitFor(10);

        jse.executeScript("arguments[0].click();", trdPage.addToGalleryButton);
        ReusableMethods.switchToWindow("Product Manager");
        ReusableMethods.waitFor(5);
        extentTest.info("Küçük Foto Seçildi");

/*
        jse.executeScript("arguments[0].click();", trdPage.buyukResimEkle);
        Thread.sleep(5000);
        trdPage.ortamKutuphanesi.click();
        Thread.sleep(5000);
        trdPage.ortamKutuphanesiUrunSec.click();
        Thread.sleep(5000);
        jse.executeScript("arguments[0].click();", trdPage.ortamKutuphanesiSecButonu);
        ReusableMethods.switchToWindow("Add to Gallery");
        jse.executeScript("arguments[0].click();", trdPage.kucukResimUrunSec);
        jse.executeScript("arguments[0].click();", trdPage.kucukResimUrunSec);
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.addToGallery);
        ReusableMethods.switchToWindow("Product Manager");

*/

    }

    @Test(dependsOnMethods ="userStoriesTest",priority = 3)
    public void submitTıkla() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.urunSubmit);
        extentTest.info("Submit Yapıldı");
    }


}
