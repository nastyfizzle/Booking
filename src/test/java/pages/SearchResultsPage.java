package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//input[contains(@type, 'search')]")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(@data-testid, 'title')]")
    private WebElement hotelName;

    @FindBy(xpath = "//div[contains(@aria-label, 'Scored 9.3 ')]")
    private WebElement hotelRating;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(String keyword) {
        searchField.sendKeys(keyword);
        searchField.submit();
    }

    public String getHotelName() {
        return hotelName.getText();
    }

    public String getHotelRating() {
        return hotelRating.getText();
    }
}
