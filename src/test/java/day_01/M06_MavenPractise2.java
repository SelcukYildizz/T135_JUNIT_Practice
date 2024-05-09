package day_01;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class M06_MavenPractise2 {
    static WebDriver driver;

    //1-https://babayigit.net/test/ adresine gidin
    //2-Login butonuna tıklayın
    //3-Username kısmına “babayigit” yazdırın
    //4-Password kısmına baba123 yazdırın
    //5-Login butonuna tıklayın
    //6-Başarılı giriş yapılamadığını doğrulayın
    //7-Pasword kısmına “Mb3471&” yazdırın.
    //8-Login butonuna tıklayın
    //9-Başarılı giriş yapıldığını doğrulayın
    //10-Sayfayı kaptın


    @BeforeClass
    public static void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        //1-https://babayigit.net/test/ adresine gidin

        driver.get("https://babayigit.net/test/");

        //2-Login butonuna tıklayın

        driver.findElement(By.xpath("//img[@src='img/login.png']"))
                .click();

        //3-Username kısmına “babayigit” yazdırın

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys("babayigit");

        Thread.sleep(5000);


        //4-Password kısmına baba123 yazdırın

        driver.findElement(By.xpath("//input[@name='password']"))
                .sendKeys("baba123");
        Thread.sleep(5000);

        //5-Login butonuna tıklayın

        driver.findElement(By.xpath("//input[@type='button']"))
                .click();
        Thread.sleep(5000);


        //6-Başarılı giriş yapılamadığını doğrulayın

        String expectedText = "The username or password is incorrect.";
        String actualText = driver.findElement(By.xpath("//div[@id='result']"))
                .getText();

        Assert.assertEquals(actualText, expectedText);

        System.out.println("Username : babayigit Password : baba123 varyasyonu sonucu : Giris basarisiz.");

        Thread.sleep(5000);


        //7-Pasword kısmına “Mb3471&” yazdırın.

        driver.navigate().back();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@name='password']"))
                .clear();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@name='password']"))
                .sendKeys("Mb3471&");


        //8-Login butonuna tıklayın

        driver.findElement(By.xpath("//input[@type='button']"))
                .click();


        //9-Başarılı giriş yapıldığını doğrulayın

        String expectedText2 = "Successful entry!";
        String actualText2 = driver.findElement(By.xpath("//div[@id='result']"))
                .getText();
        Thread.sleep(5000);


        Assert.assertEquals(actualText2, expectedText2);
        System.out.println("Username : babayigit Password : Mb3471& varyasyonu sonucu : Giris BASARILI.");


        //10-Sayfayı kaptın


    }

    @Test
    public void test02() throws InterruptedException {

        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        driver.findElement(By.xpath("//*[@alt='Website for automation practice']")).isDisplayed();


        //4. Ürünleri sepete ekleyin

        WebElement urun = driver.findElement(By.xpath("(//*[@alt='ecommerce website products'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(urun).perform();

        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]"))
                .click();

        Thread.sleep(5000);

        //5.

        driver.findElement(By.xpath("//*[text()=' Cart']")).click();

        driver.findElement(By.xpath("//*[text()='Shopping Cart']")).isDisplayed();

        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();

        Thread.sleep(5000);




        //8. 'Kayıt Ol / Giriş Yap' butonuna tıklayın

        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();




    }
}
