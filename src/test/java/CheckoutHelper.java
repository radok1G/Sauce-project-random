import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutHelper {

    private static final By NUMELE_MIC = By.id("first-name");
    private static final By NUMELE_FAMILIE = By.id("last-name");
    private static final By COD_POSTAL = By.id("postal-code");
    private static final By CONTINUA_CHECKOUT = By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input");
    private static final By FINISH_CHECKOUT = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]");
    private static final By PAGINA_PRINCIPALA = By.id("//button[@id='back-to-products']");
    private static final By BACK_HOME = By.xpath("/html/body/div/div/div/div[2]/button");

    public static void scrieFirstName(WebDriver driver, String firstName) {
        driver.findElement(NUMELE_MIC).sendKeys(firstName);
    }

    public static void scrieLastName(WebDriver driver, String lastName) {
        driver.findElement(NUMELE_FAMILIE).sendKeys(lastName);
    }

    public static void scrieCodPostal(WebDriver driver, String postalCode) {
        driver.findElement(COD_POSTAL).sendKeys(postalCode);
    }

    public static void continuaCheckout(WebDriver driver){
        driver.findElement(CONTINUA_CHECKOUT).click();
    }

    public static void terminaCheckout(WebDriver driver){
        driver.findElement(FINISH_CHECKOUT).click();
    }

    public static void backHomeButton(WebDriver driver){
        driver.findElement(BACK_HOME).click();
    }
}