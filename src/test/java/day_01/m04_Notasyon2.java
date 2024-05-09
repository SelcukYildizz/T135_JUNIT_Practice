package day_01;

import org.junit.*;

public class m04_Notasyon2 {


    /*

    @BeforeClass ___>  Tüm testler calismadan once bir kez calıs,

    @AfterClass ----> Tum testler bittikten sonra bir kez calisir

    @Before ---> Her bir testten once bir kere calisir

    @After ---> Her bir testten sonra bir kere calisir



     */

    @BeforeClass
    public static void before(){
        System.out.println("Testler kosulmaya basladi");
    }

    @AfterClass
    public static void after(){
        System.out.println("Testlerin kosulmasi tamamlandi");
    }

    @Before
    public void setup(){
        System.out.println("Sıradaki test calistiriliyor");
    }

    @After
    public void tearDown(){
        System.out.println("Testin kosulmasi bitti. Sıradaki test varsa o calistirilacak");
    }

    @Test
    public void test01(){
        System.out.println("Test 01 calisti");
    }


}
