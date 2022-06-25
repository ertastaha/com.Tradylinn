package tests.US_021;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RaporlarPage;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

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
        Driver.getDriver().get(ConfigReader.getProperty("trUrl"));
        Thread.sleep(5000);
        jse.executeScript("arguments[0].click();",trdPage.girisYap);
        trdPage.kullanıcıAdıBox.sendKeys(ConfigReader.getProperty("validUserName"));
        trdPage.parolaBox.sendKeys(ConfigReader.getProperty("validPassword"));
        trdPage.girisİkiButonu.click();
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.hesabım);
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", trdPage.storeManager);
        Thread.sleep(10000);

        jse.executeScript("arguments[0].click();", raporPage.raporlar);
        Thread.sleep(10000);

        jse.executeScript("arguments[0].click();", raporPage.yearRapor);
        Thread.sleep(10000);
        jse.executeScript("arguments[0].scrollIntoView(true);",raporPage.raporTitle);
        String expRaporTitle="Sales by Date - Year";
        String actRaporTitle=raporPage.raporTitle.getText();

        Assert.assertEquals(expRaporTitle,actRaporTitle);

        jse.executeScript("arguments[0].scrollIntoView(true);",raporPage.chart);
        ReusableMethods.getScreenshot("Year");








/*
        File tumSayfaResim= new File("target/screenshots/allPage/year"+tarih+".jpeg");
        File geciciDosya= ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya, tumSayfaResim);

*/

/*
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", raporPage.lastMonthRapor);
        ReusableMethods.getScreenshot("lastMonth");
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", raporPage.thisMonthRapor);
        ReusableMethods.getScreenshot("thisMonthRapor");
        Thread.sleep(10000);
        jse.executeScript("arguments[0].click();", raporPage.last7DaysRapor);
        ReusableMethods.getScreenshot("last7DaysRapor");
        Thread.sleep(10000);
        ReusableMethods.setValueByJS(raporPage.customRapor, "2022-06-20 to 2022-06-25");
        ReusableMethods.getScreenshot("customDate");

*/




    }
}
