package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RaporlarPage {
    public RaporlarPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="(//span[@class='text'])[14]")
    public WebElement raporlar;

    @FindBy(xpath="//a[text()='Year']")
    public WebElement yearRapor;

    @FindBy(xpath="//div[@class='chart-placeholder main']")
    public WebElement chart;

    @FindBy(xpath="//a[text()='Last Month']")
    public WebElement lastMonthRapor;

    @FindBy(xpath="//a[text()='This Month']")
    public WebElement thisMonthRapor;

    @FindBy(xpath="//a[text()='Last 7 Days']")
    public WebElement last7DaysRapor;

    @FindBy(xpath="//input[@placeholder='Choose Date Range ...']")
    public WebElement customRapor;


}
