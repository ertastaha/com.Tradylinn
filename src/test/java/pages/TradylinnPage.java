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

    //@FindBy(xpath= "//div[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
    @FindBy(xpath= "(//span[@class='text'])[4]")
    public WebElement urun;

    @FindBy(xpath= "//div[@class='wcfm_menu_items wcfm_menu_wcfm-orders']")
    public WebElement emir;

    @FindBy(xpath = "//a[@id='add_new_product_dashboard']")
    public WebElement yeniEkle;

    @FindBy(xpath = "//div[text()='Toptan Ürün Gösterme Ayarları']")
    public WebElement toptanUrunGosterme;

    @FindBy(xpath = "//select[@name='acf[piecetype]']")
    public WebElement pieceTypeDDM;

    @FindBy(xpath = "//img[@id='featured_img_display']")
    public WebElement buyukResimEkle;

    @FindBy(xpath = "//button[@id='menu-item-browse']")
    public WebElement ortamKutuphanesi;

    @FindBy(xpath = "//li[@aria-label='293ac7db-733d-4b43-b5d4-1d4f626d9435']")
    public WebElement ortamKutuphanesiUrunSec;

    @FindBy(xpath = "//button[@class='button media-button button-primary button-large media-button-select']")
    public WebElement ortamKutuphanesiSecButonu;

    @FindBy(xpath = "//img[@id='gallery_img_gimage_0_display']")
    public WebElement kucukResimEkle;

  //  @FindBy(xpath = "(//li[@data-id='4303'])[1]")
  //  @FindBy(xpath = "//div[@class='attachment-preview js--select-attachment type-image subtype-jpeg portrait']")
  //  @FindBy(xpath = "(//span[@class='media-modal-icon'])[3]")
  //  @FindBy(xpath = "(//div[@class='attachment-preview js--select-attachment type-image subtype-png portrait'])[2]")
  //  @FindBy(xpath = "//li[@aria-label='293ac7db-733d-4b43-b5d4-1d4f626d9435']//div[@class='thumbnail']//img")
  //  @FindBy(xpath = "(//li[@tabindex='0']//div[@class='attachment-preview js--select-attachment type-image subtype-jpeg portrait'])[1]")
    @FindBy(xpath = "//ul[@id='__attachments-view-214']//li[1]")
    public WebElement kucukResimUrunSec;

    @FindBy(xpath = "(//button[@class='button media-button button-primary button-large media-button-select'])[1]")
    public WebElement addToGallery;


    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement productTitleBox;

   // @FindBy(xpath = "//li[@class='product_cats_checklist_item checklist_item_235']")
    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_cat '])[2]")
    public WebElement categories;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[2]")
    public WebElement productBrands;

    @FindBy(xpath = "//input[@name='submit-data']")
    public WebElement urunSubmit;



}
