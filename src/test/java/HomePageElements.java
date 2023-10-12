import org.openqa.selenium.By;

public class HomePageElements {
    public By verifyChoosedHotel = By.xpath("//div[@class='SearchGuestStyle__SearchGuestItemTextWrapper-sc-txpuig-18 eWUbDl']");
    public By inputHotelNameOrLocation = By.xpath("//input[@class='SearchBarSearchInputStyle__SearchInput-sc-1ovz9w4-0 epQxRj']");
    public By dropdownAntalya = By.xpath("//strong[text()='Antalya']");
    public By acceptCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    public By closeButtonFirstPopUp = By.cssSelector("span.ins-close-button");
    public By inputTimeInterval = By.xpath("//div[text()='Giriş - Çıkış Tarihleri']");
    public By timeApril = By.xpath("//strong[contains(text(),'Nisan')]");
    public By nextButtonMonth = By.xpath("//button[@class='styled__StyledButton-sc-1i7jkmi-0 jBiEGt DatePickerStyle__NavNextButton-sc-1yq2271-2 ihrCIi']");
    public By intervalTimeFirst = By.xpath("//td[@aria-label=\"Choose Pazartesi, 1 Nisan 2024 as your check-in date. It’s available.\"]");
    public By intervalTimeSecond = By.xpath("//td[@aria-label=\"Choose Pazar, 7 Nisan 2024 as your check-out date. It’s available.\"]");
    public By guestInput = By.xpath("//span[contains(text(),'1 Oda, 2 Yetişkin')]");
    public By guestAdultIncrement = By.cssSelector("button[data-testid=\"increment-button\"]");
    public By verifyGuestInput = By.xpath("//span[contains(text(),'1 Oda, 3 Yetişkin')]");
    public By searchButton = By.xpath("//button[@class='styled__StyledButton-sc-1i7jkmi-0 iRHtqU']");
}
