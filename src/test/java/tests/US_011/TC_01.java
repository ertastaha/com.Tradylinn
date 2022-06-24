package tests.US_011;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class TC_01 {
    TradylinnPage trdPage=new TradylinnPage();
    @Test
    public void urun() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        Driver.getDriver().get(ConfigReader.getProperty("trUrl"));
        Thread.sleep(5);
        trdPage.girisYap.click();
        trdPage.kullanıcıAdıBox.sendKeys(ConfigReader.getProperty("validUserName"));
        trdPage.parolaBox.sendKeys(ConfigReader.getProperty("validPassword"));
        trdPage.girisİkiButonu.click();
        Thread.sleep(10000);
        trdPage.hesabım.click();
        Thread.sleep(10000);
        trdPage.storeManager.click();
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.urun);
        jse.executeScript("arguments[0].click();", trdPage.yeniEkle);
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.productTitleBox);
        trdPage.productTitleBox.sendKeys("deneme");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys("250").sendKeys(Keys.TAB).sendKeys("200").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("deneme").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("deneme").perform();

        jse.executeScript("arguments[0].click();", trdPage.categories);
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.productBrands);
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();",trdPage.toptanUrunGosterme);
        Thread.sleep(10000);
        Select select=new Select(trdPage.pieceTypeDDM);
        select.selectByIndex(2);
        actions.sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("20").perform();




        jse.executeScript("arguments[0].click();", trdPage.buyukResimEkle);
        Thread.sleep(10000);
        trdPage.ortamKutuphanesi.click();
        Thread.sleep(10000);
        trdPage.ortamKutuphanesiUrunSec.click();
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.ortamKutuphanesiSecButonu);


        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.kucukResimEkle);//küçük resim sekmesi için

        Thread.sleep(10000);


        trdPage.kucukResimUrunSec.click();
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.addToGallery);



        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.urunSubmit);

    }
}
