package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.pageObjects;
import utilities.PropertyReader;

import java.util.concurrent.TimeUnit;

public class testMWEB {

    private WebDriver webDriver;

    PropertyReader pr = new PropertyReader();
    public String URL = pr.readItem("url");
    private pageObjects objects;


    @BeforeTest
    public void setUp(){
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(URL);
        objects = new pageObjects(webDriver);

    }

    @Test(priority = 1, description = "Search for coverage by entering the following address in the coverage input box: 4 Jansen Street Aurora.")

    public void testMWEBQA(){


        objects.setAddress("4 Jansen street Aurora");

        //objects.setClosePopUp();

    }

    @Test(priority = 2, description = "Test that 2 fibre Infrastructure Providers are returned.")
public void checkInfrastructures  () {


        objects.isVumaTelVisible();
        objects.isOpenServeVisible();
    }

    @Test(priority = 3, description = "Click the first Openserve product in the list of products which was returned from the coverage search.")
public void clickFirstOpenserve () {

        objects.setFirstOption();
        objects.isPageOpened();


    }

    @Test(priority = 4, description = "Test that there are 2 router options available on the product page.")
    public void twoRouterOptions () {

        objects.isNoRouterVisible();
        objects.isRouterVisible();

    }

    @Test(priority = 5, description = "Test that the page title is set")
    public void pageTitle () {

        objects.title();


    }

    @Test(priority = 6, description = "Test that page description is set")
    public void pageDescription () {

        objects.isPageDescriptionVisible();

    }

    @AfterTest
    public void quit(){
        webDriver.quit();
    }

}
