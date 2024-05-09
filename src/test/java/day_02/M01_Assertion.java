package day_02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M01_Assertion {
    //https://www.bestbuy.com/ Adresine gidin
//  farkli test method'lari olusturarak asagidaki testleri yapin



//  ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");


    }

    @AfterClass
    public static  void tearDown() throws InterruptedException {
        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void test01 (){
        //  ○ Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin

        String ecpectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(ecpectedUrl,actualUrl);

    }

    @Test
    public void titleTest(){

        //  ○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin

        String expectedTitle = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedTitle));



    }

    @Test
    public void logoTest(){

        //  ○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logo = driver
                .findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logo.isDisplayed());




    }

   // @Test



}
