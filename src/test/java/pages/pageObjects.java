package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class pageObjects {

    private WebDriver webDriver;
    public pageObjects(WebDriver webDriver){
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }


    @FindBy(id = "coverage")
    private WebElement address;

    @FindBy(xpath = "//button[@class='w-[50%] h-[50px] text-center text-transparent mb-[47px] phone:mb-[75px] mx-auto']")
    private WebElement closePopUp;

    @FindBy(css = "[alt='Vumatel']")
    private WebElement vumaTel;

    @FindBy(css = "[alt='Openserve']")
    private WebElement openServe;

    @FindBy(xpath = "//div[@class='border-2 border-mwgray-l w-11/12 text-center m-2 laptop:w-4/12']//div[@class='flex flex-col justify-center content-center items-center  flex justify-center justify-items-center transition duration-200 hover:bg-mwblue hover:text-white py-3 px-4 h-full']")
    private WebElement firstFibreOption;

    //verify two routers
    @FindBy(xpath = "//div[@class='hidden laptop:grid laptop:grid-cols-3 laptop:gap-4']//div[@class='flex flex-1 flex-col px-3 pt-8']")
    private WebElement noRouter;

    @FindBy(xpath = "//div[@class='hidden laptop:grid laptop:grid-cols-3 laptop:gap-4']//div[@class='flex flex-1 flex-col px-3 pt-3']")
    private WebElement router;

    @FindBy(xpath = "//div[@class='hidden laptop:block']//h1[@class='text-center laptop:text-left mb-1 text-lg laptop:text-2xl font-bold text-mwgray']")
    private WebElement pageDesc;

    @FindBy(xpath = "//div[@class=' w-full max-w-xl md:max-w-6xl m-auto flex  flex-wrap px-2 py-4 md:px-0']//span[@class='cursor-pointer']/div[contains(.,'25/10Mbps Uncapped FibreUnthrottled25% off for the first 6 monthsDownload25MbpsU')]")
    private WebElement getFirstFibreOption;

    public void setAddress(String addresses){
        if(address.isDisplayed() == true){
            address.clear();
            address.sendKeys(addresses);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            address.sendKeys(Keys.ARROW_DOWN);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            address.sendKeys(Keys.ENTER);
        }else{
            System.err.println("Web Element address not found");
            assertTrue(false);
        }


    }

    public void setClosePopUp(){
        closePopUp.click();
    }

    public boolean isVumaTelVisible(){
        boolean val = false;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(vumaTel.isDisplayed()){
            val = true;
            System.out.println("Vuma visible is : "+val);
            assertTrue(val);
        }
        else{
            val = false;
            System.out.println("Vuma visible is : "+val);
            assertTrue(val);
        }
        return val;
    }

    public boolean isOpenServeVisible(){
        boolean val = false;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(openServe.isDisplayed()){
            val = true;
            System.out.println("Openserve visible is : "+val);
            assertTrue(val);
        }
        else{
            val = false;
            System.out.println("OpenServe visible is : "+val);
            assertTrue(val);
        }
        return val;
    }

    public void setFirstOption(){
        boolean val = false;
        if(getFirstFibreOption.isDisplayed()){
            val = true;
            getFirstFibreOption.click();
            assertTrue(val);
        }else{
            val = false;

            assertTrue(val);
        }


    }

    public boolean isPageOpened(){
        boolean val = false;

        if(pageDesc.getText().contains("25/10Mbps Uncapped Fibre")){
            val = true;

        }else
            assertTrue(val);

        return val;
    }

    public boolean title() {
        boolean val = false;

        if(webDriver.getTitle().contains("25Mbps Download 10Mbps Upload")){
            val = true;

        }else
            assertTrue(val);

        return val;
    }

    public boolean isNoRouterVisible(){
        boolean val = false;

        if(noRouter.isDisplayed()){
            val = true;

        }else
            assertTrue(val);

        return val;

    }

    public boolean isRouterVisible(){
        boolean val = false;

        if(router.isDisplayed()){
            val = true;

        }else
            assertTrue(val);

        return val;
    }

    public boolean isPageDescriptionVisible(){
        boolean val = false;

        if(pageDesc.isDisplayed()){
            val = true;

        }else
            assertTrue(val);

        return val;
    }



}