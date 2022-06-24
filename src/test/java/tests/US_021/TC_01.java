package tests.US_021;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.RaporlarPage;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TC_01 {
    TradylinnPage trdPage=new TradylinnPage();
    RaporlarPage raporPage=new RaporlarPage();
    @Test
    public void test() throws InterruptedException, IOException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        TakesScreenshot ss = (TakesScreenshot) Driver.getDriver();
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(dtf);

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

        jse.executeScript("arguments[0].click();", raporPage.raporlar);
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", raporPage.yearRapor);
        Thread.sleep(10000);

        File tumSayfaResim= new File("target/screenshots/allPage/"+tarih+".jpeg");
        File geciciDosya= ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya, tumSayfaResim);

    }
}
