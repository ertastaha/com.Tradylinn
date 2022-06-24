package tests.US_011;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TradylinnPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.Set;

public class sl {
    @Test
    public void test() throws InterruptedException {
        TradylinnPage trdPage=new TradylinnPage();

        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        trdPage.girisYap.click();
        trdPage.kullanıcıAdıBox.sendKeys(ConfigReader.getProperty("validUserName"));
        trdPage.parolaBox.sendKeys(ConfigReader.getProperty("validPassword"));
        trdPage.girisİkiButonu.click();
        Thread.sleep(10000);
        trdPage.hesabım.click();
        Thread.sleep(10000);
        trdPage.storeManager.click();
   //    WebElement storeManager = Driver.getDriver().findElement(By.xpath("//a[@href='https://tradylinn.com/store-manager/']"));
   //    executor.executeScript("arguments[0].click();", storeManager);
        WebElement urun = Driver.getDriver().findElement(By.xpath("(//span[@class='text'])[4]"));
        executor.executeScript("arguments[0].click();", urun);
        WebElement yeniEkle = Driver.getDriver().findElement
                (By.xpath("//a[@href='https://tradylinn.com/store-manager/products-manage/']"));
        executor.executeScript("arguments[0].click();", yeniEkle);
        WebElement urunresmi = Driver.getDriver().findElement(By.xpath("//img[@id='featured_img_display']"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        executor.executeScript("arguments[0].click();", urunresmi);
        WebElement ortamkutuphane = Driver.getDriver().findElement(By.xpath("//button[@id='menu-item-browse']"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        executor.executeScript("arguments[0].click();", ortamkutuphane);
        WebElement seciliurun = Driver.getDriver().findElement
                (By.xpath("//div[@class='attachment-preview js--select-attachment type-image subtype-jpeg portrait']"));
        executor.executeScript("arguments[0].click();", seciliurun);
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement secbutton = Driver.getDriver().findElement(
                By.xpath("//button[@class='button media-button button-primary button-large media-button-select']"));
        executor.executeScript("arguments[0].click();", secbutton);
        WebElement addgaleri = Driver.getDriver().findElement(By.xpath("//img[@id='gallery_img_gimage_0_display']"));
        executor.executeScript("arguments[0].click();", addgaleri);
        WebElement seciliurun2 = Driver.getDriver().findElement(By.xpath("(//div[@class='attachment-preview js--select-attachment type-image subtype-jpeg portrait'])[20]"));
        executor.executeScript("arguments[0].click();", seciliurun2);
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement addgaleri2 = Driver.getDriver().findElement(By.xpath
                ("(//button[@class='button media-button button-primary button-large media-button-select'])[2]"));
        Thread.sleep(5000);
        executor.executeScript("arguments[0].click();", addgaleri2);
        WebElement closs_icon = Driver.getDriver().findElement(By.xpath("(//span[@class='media-modal-icon'])[3]"));
        executor.executeScript("arguments[0].click();", closs_icon);
        WebElement producttitlebox = Driver.getDriver().findElement(By.xpath
                ("//input[@class='wcfm-text wcfm_ele wcfm_product_title wcfm_full_ele simple variable external grouped booking']"));
        executor.executeScript("arguments[0].click();", producttitlebox);
        producttitlebox.sendKeys("kitchen");
        WebElement categoriesclick = Driver.getDriver().findElement(By.xpath("(//input[@class='wcfm-checkbox checklist_type_product_cat '])[11]"));
        executor.executeScript("arguments[0].click();", categoriesclick);
        WebElement shippingbutton = Driver.getDriver().findElement(By.xpath("(//div[@class='page_collapsible_content_holder'])[8]"));
        executor.executeScript("arguments[0].click();", shippingbutton);
        WebElement weightbox = Driver.getDriver().findElement(By.xpath("//input[@id='weight']"));
        executor.executeScript("arguments[0].click();", weightbox);
        weightbox.sendKeys("2");
        WebElement lengthbox = Driver.getDriver().findElement(By.xpath("(//input[@class='wcfm-text wcfm_ele simple variable booking'])[2]"));
        executor.executeScript("arguments[0].click();", lengthbox);
        lengthbox.sendKeys("2");
        WebElement weidthbox = Driver.getDriver().findElement(By.xpath("(//input[@class='wcfm-text wcfm_ele simple variable booking'])[3]"));
        executor.executeScript("arguments[0].click();", weidthbox);
        weidthbox.sendKeys("2");
        WebElement heightbox = Driver.getDriver().findElement(By.xpath("(//input[@class='wcfm-text wcfm_ele simple variable booking'])[4]"));
        executor.executeScript("arguments[0].click();", heightbox);
        heightbox.sendKeys("2");
        WebElement processingtime=Driver.getDriver().findElement(By.xpath("//select[@id='_wcfmmp_processing_time']"));
        Select select=new Select(processingtime);
        select.selectByIndex(2);
        WebElement submitbutton = Driver.getDriver().findElement(By.xpath("//input[@id='wcfm_products_simple_submit_button']"));
        executor.executeScript("arguments[0].click();", submitbutton);
        Thread.sleep(10);
        WebElement publishedtext = Driver.getDriver().findElement(By.xpath("//script[@id='wcfm_products_manage_js-js-extra']"));
        SoftAssert soft=new SoftAssert();
        String expectedresult="Product Successfully Published";
        soft.assertEquals(expectedresult, publishedtext);
        String ilksayfawindowhandle=Driver.getDriver().getWindowHandle();
        WebElement viewbutton = Driver.getDriver().findElement(By.xpath("(//input[@class='wcfm_submit_button'])[3]"));
        Thread.sleep(20000);
        executor.executeScript("arguments[0].click();", viewbutton);
        Thread.sleep(15);
        Set<String> windowhandles=Driver.getDriver().getWindowHandles();
        String ikincisayfawhandle="";
        for (String w :windowhandles) {
            if(!ilksayfawindowhandle.equals(w)){
                ikincisayfawhandle=w;
            }
        }
        Driver.getDriver().switchTo().window(ikincisayfawhandle);
        WebElement specification = Driver.getDriver().findElement(By.xpath("(//a[@class='nav-link'])[2]"));
        Thread.sleep(15000);
        executor.executeScript("arguments[0].click();", specification);
        WebElement urunvitrinagirlik=Driver.getDriver().findElement(By.xpath("//tr[@class='woocommerce-product-attributes-item woocommerce-product-attributes-item--weight']"));
        System.out.println(urunvitrinagirlik.getText());
        WebElement urunvitrinboyut=Driver.getDriver().findElement(By.xpath("//tr[@class='woocommerce-product-attributes-item woocommerce-product-attributes-item--dimensions']"));
        System.out.println(urunvitrinboyut.getText());
    }
}
