import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ActiuniHelper {

    private static final By ADAUGA_IN_CART_BUTTON = By.xpath("//button[contains(text(),'Add to cart')]");
    private static final By CARTPAGE = By.cssSelector("[data-test='shopping-cart-link']");
    private static final By BUTON_DE_REMOVE = By.xpath("//button[contains(text(),'Remove')]");
    private static final By CONTINUA_SHOPPINGUL = By.id("continue-shopping");
    private static final By MENIU_BURGER = By.id("react-burger-menu-btn");
    private static final By BUTON_LOGOUT = By.id("logout_sidebar_link");
    private static final By BUTON_CHECKOUT = By.cssSelector("button[data-test='checkout']");
    private static final By SIDEBAR_BUTTON = By.id("about_sidebar_link");
    private static final By SAUCE_LABS_BACKPACK = By.xpath("//*[text()='Sauce Labs Backpack']");

    private static WebDriverWait wait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public static void clickPePozitieDinCart(WebDriver driver, int... indexes) {
        List<WebElement> buttons = driver.findElements(ADAUGA_IN_CART_BUTTON);
        Arrays.stream(indexes).forEach(i -> buttons.get(i).click());
    }

    public static void deschideCart(WebDriver driver) {
        driver.findElement(CARTPAGE).click();
    }

    public static int removeButtonsCount(WebDriver driver) {
        return driver.findElements(BUTON_DE_REMOVE).size();
    }

    public static void assertRemoveCount(WebDriver driver, int expected, String msg) {
        Assert.assertEquals(removeButtonsCount(driver), expected, msg);
    }

    public static void removeFromCartByPozitie(WebDriver driver, int index) {
        List<WebElement> btns = driver.findElements(BUTON_DE_REMOVE);
        btns.get(index).click();
    }

    public static void continueShoppingButton(WebDriver driver) {
        driver.findElement(CONTINUA_SHOPPINGUL).click();
    }

    public static void logout(WebDriver driver) {
        driver.findElement(MENIU_BURGER).click();
        wait(driver).until(ExpectedConditions.elementToBeClickable(BUTON_LOGOUT)).click();
    }

    public static void checkoutButton(WebDriver driver) {
        driver.findElement(BUTON_CHECKOUT).click();
    }

    public static void clickOnAbout(WebDriver driver) {
        driver.findElement(MENIU_BURGER).click();
        wait(driver).until(ExpectedConditions.elementToBeClickable(SIDEBAR_BUTTON)).click();
    }

    public static void verificaGhiozdan(WebDriver driver) {
        List<WebElement> products = driver.findElements(SAUCE_LABS_BACKPACK);

        if (products.isEmpty()) {
            System.out.println("N-am gasit Ghiozdanul pe pagina unde am ajuns dupa click ❌");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        } else {
            System.out.println("Am gasit ghiozdanu ✅ deci useru selectat nu ii bun pt ca testu trebuia sa pice");
        }
    }

}


