import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class DogCaseFlow {
    public WebDriver driver;

    @Test

    public void testMethodDogCaseTest() {
        driver = DriverHelper.createDriver();
        LoginHelper.login(driver, "problem_user", "secret_sauce");

        ActiuniHelper.clickPePozitieDinCart(driver, 3,4);
        ActiuniHelper.deschideCart(driver);

        ActiuniHelper.continueShoppingButton(driver);
        ActiuniHelper.clickPePozitieDinCart(driver, 1);

        ActiuniHelper.deschideCart(driver);
        ActiuniHelper.removeFromCartByPozitie(driver, 1);

        ActiuniHelper.logout(driver);

        driver.quit();

    }
}
