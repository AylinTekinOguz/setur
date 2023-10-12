
import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Setur extends ReusableMethods {
    public HomePageElements homePageElements;
    public SearchPageElements searchPageElements;
    public static String result;


    @BeforeEach
    public void gelAll(){
        homePageElements =new HomePageElements();
        searchPageElements = new SearchPageElements();
    }



    @Test
    @DisplayName("Anasayfayı temizle, çerezleri kabul et")
    @Order(1)
    public void test01(){
        try {
            click(homePageElements.closeButtonFirstPopUp);
        }catch (Exception e){

        }
        click(homePageElements.acceptCookies);
    }




    @Test
    @DisplayName("2. setur url’nin geldiği kontrol edilir.")
    @Order(2)
    public void test02() {
        String expectedUrl = "https://www.setur.com.tr/";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);

    }

    @Test
    @DisplayName("3. Ana sayfada Otel tabının default geldiği kontrol edilir,")
    @Order(3)
    public void test03() {
        boolean check = false;
       try { find(homePageElements.verifyChoosedHotel);
    }catch (Exception e) {
           Assertions.assertTrue(check,"3. Anasayfada otel tabı default gelmedi!");
       }

       }

    @Test
    @DisplayName("4. “Nereye Gideceksiniz?” alanına csv dosyasından “Antalya” yazılır ve en üsteki Antalya seçeneğine tıklanılır.")
    @Order(4)
    public void test04(){
        find(homePageElements.inputHotelNameOrLocation).sendKeys("Antalya");
        click(homePageElements.inputHotelNameOrLocation);
        click(homePageElements.dropdownAntalya);
       }

    @Test
    @DisplayName("5. Tarih alanında Nisan’ın ilk haftası için bir haftalık aralık seçilir.")
    @Order(5)
    public void test05(){
        click(homePageElements.inputTimeInterval);
        untilVisibleClick(homePageElements.timeApril, homePageElements.nextButtonMonth);
        click(homePageElements.intervalTimeFirst);
        click(homePageElements.intervalTimeSecond);
    }

    @Test
    @DisplayName("6. Yetişkin sayısı 1 artırılır ve Yetişkin sayısının değiştiği kontrol edilir.")
    @Order(6)
    public void test06(){
        click(homePageElements.guestInput);
        click(homePageElements.guestAdultIncrement);
        boolean check=false;
        try {
            find(homePageElements.verifyGuestInput);
        }catch (Exception e){
            Assertions.assertTrue(check, "Yetişkin sayısı değiştirilemedi!");
        }

    }

    @Test
    @DisplayName("7. “Ara” butonu’nun görünürlüğü kontrol edilir ve tıklanılır.")
    @Order(7)
    public void test07(){
        boolean check=false;
        try {
            find(homePageElements.searchButton);
            click(homePageElements.searchButton);
        }catch (Exception e){
            Assertions.assertTrue(check, "Ara butonu bulunamadı!");
        }

    }

    @Test
    @DisplayName("8. Açılan url içinde “antalya” kelimesini içerdiği kontrol edilir.")
    @Order(8)
    public void test08(){
     find(searchPageElements.getOtherLocationsCount);
     String actualUrl = driver.getCurrentUrl();
     Assertions.assertTrue(actualUrl.contains("antalya"), "Url ”antalya” kelimesini içermiyor");

    }

    @Test
    @DisplayName("9. “Diğer Bölgeleri Göster” alanında rastgele tıklama metotu kullanılarak bir seçim yapılır ve “()“ içerisinde bulunan sayı kaydedilir.")
    @Order(9)
    public void test09(){
        List<WebElement> elementOfOtherLocations = findAll(searchPageElements.otherLocations);
        int elementCount = elementOfOtherLocations.size()-1;
        Random random = new Random();
        int randomValueOfElements = random.nextInt(elementCount);

        List<WebElement> elementsOfOtherLocationsCount = findAll(searchPageElements.getOtherLocationsCount);
        String text = elementsOfOtherLocationsCount.get(randomValueOfElements).getText();
        result=text.replaceAll("[^0-9]", "");
        System.out.println(result);
        elementOfOtherLocations.get(randomValueOfElements).click();

    }

    @Test
    @DisplayName("10. Sayfanın altında bulunan “Antalya Otelleri ve En Uygun Antalya Otel Fiyatları “ " +
            "alanına kadar ekranda kaydırma yapılır, kaydedilen değerin " +
            "8. adımda kaydedilen değerle eşit olduğu kontrol edilir.")
    @Order(10)
    public void test10() throws InterruptedException {
        Thread.sleep(6000);
        scrollDownUntilFindElement(searchPageElements.searchListnumber);
        String textDownPage = find(searchPageElements.searchListnumber).getText();
        System.out.println(textDownPage);
        Assertions.assertTrue(textDownPage.contains(result), "Sayılar birbirine eşit değil!");

    }


































    }



