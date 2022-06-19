package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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

   @FindBy(xpath = "//li[@id='menu-item-1074']")
   // @FindBy(xpath = "//a[text()='Hesabım']")
   // @FindBy(partialLinkText = "tradylinn.com")
   // @FindBy(id = "menu-item-1079")
    public WebElement hesabım;

    @FindBy(xpath = "//a[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "//a[@class='wcfm_menu_item active']")
    public WebElement urun;

    @FindBy(xpath = "//span[text()='Yeni ekle']")
    public WebElement yeniEkle;

}
