package tests.US_011;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.List;

public class TC_01_UrunCesidi {

    TradylinnPage trdPage=new TradylinnPage();

    @Test
    public void deneme() throws InterruptedException {

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
        Thread.sleep(5000);
        trdPage.urun.click();
        Thread.sleep(5000);
        trdPage.yeniEkle.click();
        Thread.sleep(5000);
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();",trdPage.toptanUrunGosterme );
        Thread.sleep(5000);

        Select select=new Select(trdPage.pieceTypeDDM);
        List<WebElement> pieceTypeOptions= select.getOptions();
        for (WebElement w:pieceTypeOptions){
            System.out.println(w.getText());
        }




    }
}
