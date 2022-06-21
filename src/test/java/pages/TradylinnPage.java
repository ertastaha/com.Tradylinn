package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TradylinnPage {
    public TradylinnPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[text()='Giriş Yap']")
    public WebElement girisYap;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement kullanıcıAdıBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement parolaBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement girisİkiButonu;


    @FindBy(xpath = "(//*[text()='Hesabım'])[1]")
    public WebElement hesabım;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath= "//div[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
    public WebElement urun;

    @FindBy(xpath = "//a[@id='add_new_product_dashboard']")
    public WebElement yeniEkle;

    @FindBy(xpath = "//div[text()='Toptan Ürün Gösterme Ayarları']")
    public WebElement toptanUrunGosterme;

    @FindBy(xpath = "//select[@name='acf[piecetype]']")
    public WebElement pieceTypeDDM;

}
