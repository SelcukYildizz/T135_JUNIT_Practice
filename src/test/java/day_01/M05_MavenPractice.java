package day_01;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class M05_MavenPractice {

    static WebDriver driver;
    String film ;
    WebElement searchBox ;



    //    BeforeClass ile driver’i oluşturun ve class icinde static yapin
    //    Maximize edin ve 10 sn bekletin
    //    her biri için https://www.gooqle.com adresine gidin
    //    1-arama kutusuna “12 Angry Men” yazip, cikan sonuc sayisini yazdirin
    //    2-arama kutusuna “Vizontele” yazip, cikan sonuc sayisini yazdirin
    //    3-arama kutusuna “Saving Private Ryan” yazip, cikan sonuc sayisini yazdirin
    //    AfterClass ile kapatin.


    @BeforeClass
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Before
    public void before(){
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='APjFqb']"));
    }


    @After
    public void after(){

        System.out.println(film + " aramasinda bulunan sonuc sayisi : " + driver
                .findElement(By.id("result-stats")).getText());


    }

    @Test
    public void test01() throws InterruptedException {

        film = "12 Angry Men";
        Thread.sleep(3000);
        searchBox.sendKeys(film + Keys.ENTER);

    }


    @Test
    public void test02() throws InterruptedException {

        film = "Vizontele";
        Thread.sleep(3000);
        searchBox.sendKeys(film + Keys.ENTER);

    }

    @Test
    public void test03() throws InterruptedException {

        film = "Saving Private Ryan";
        Thread.sleep(3000);
        searchBox.sendKeys(film + Keys.ENTER);

    }



























}
