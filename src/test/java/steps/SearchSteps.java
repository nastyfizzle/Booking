package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.SearchResultsPage;

import java.util.List;

import static org.testng.Assert.assertFalse;

public class SearchSteps {
    private static final String BOOKING_SEARCH_RESULTS_URL = "https://www.booking.com/searchresults.en-gb.html?page_reload=1";
    private SearchResultsPage searchResultsPage;
    private WebDriver driver;
    private String searchString;
    private String hotelName;
    private String hotelRating;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("User is in the search page")
    public void userIsInTheSearchPage() {
        driver.get(BOOKING_SEARCH_RESULTS_URL);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @When("user is searching for the hotel with name {string}")
    public void usersIsSearchingForTheHotelWithName(String searchString) {
        searchResultsPage.searchByKeyword(searchString);
    }

    @Then("{string} exists in the result page")
    public void existsInTheResultPage(String hotelName) {
        String result = searchResultsPage.getHotelName();
        Assert.assertEquals(result, hotelName);
    }

    @And("hotel's rating is {string}")
    public void hotelSRatingIs(String hotelRating) {
        String result = searchResultsPage.getHotelRating();
        Assert.assertEquals(result, hotelRating);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
