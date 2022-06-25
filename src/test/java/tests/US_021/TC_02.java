package tests.US_021;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RaporlarPage;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_02 {

    TradylinnPage trdPage=new TradylinnPage();
    RaporlarPage raporPage=new RaporlarPage();
    @Test
    public void lastMonthRapor() throws InterruptedException, IOException {
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

        jse.executeScript("arguments[0].click();", raporPage.lastMonthRapor);
        Thread.sleep(10000);

        Thread.sleep(10000);
        jse.executeScript("arguments[0].scrollIntoView(true);",raporPage.raporTitle);
        String expRaporTitle="Sales by Date - Last Month";
        String actRaporTitle=raporPage.raporTitle.getText();

        Assert.assertEquals(expRaporTitle,actRaporTitle);

        jse.executeScript("arguments[0].scrollIntoView(true);",raporPage.chart);
        ReusableMethods.getScreenshot("LastMonth");
    }
}
